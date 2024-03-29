package com.rccode.mcStarter.service.impl;

import com.rccode.mcStarter.dao.ProductRepository;
import com.rccode.mcStarter.dto.request.ProductRequest;
import com.rccode.mcStarter.dto.response.ProductResponse;
import com.rccode.mcStarter.exception.ProcessException;
import com.rccode.mcStarter.model.Product;
import com.rccode.mcStarter.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductRepository productRepository;

    @Override
    public ProductResponse createProduct(ProductRequest productRequest, long clientId) {
        log.debug("Starting createProduct with request: {}, for clientId: {}", productRequest, clientId);
        Optional<Product> optionalProduct = Optional.empty();
        if (productRequest.getCategoryId() != null && productRequest.getBrandId() != null) {
            optionalProduct = productRepository.findByCategoryIdAndBrandIdAndNameAndClientId(
                    productRequest.getCategoryId(), productRequest.getBrandId(), productRequest.getName(), clientId);
        } else if (productRequest.getCategoryId() != null) {
            optionalProduct = productRepository.findByCategoryIdAndNameAndClientId(
                    productRequest.getCategoryId(), productRequest.getName(), clientId);
        } else if (productRequest.getBrandId() != null) {
            optionalProduct = productRepository.findByCategoryIdAndNameAndClientId(
                    productRequest.getBrandId(), productRequest.getName(), clientId);
        }
        if (optionalProduct.isPresent()) {
            log.error("Product already exists with name: {}, and categoryId: {} for clientId: {}",
                    productRequest.getName(), productRequest.getCategoryId(), clientId);
            throw new ProcessException("Product creation", "Product already exists in this category with same name");
        }
        Product product = productRequest.from(clientId);
        product = productRepository.save(product);
        log.debug("Returning from createProduct with response: {}, for clientId: {}", product, clientId);
        return ProductResponse.from(product);
    }

    @Override
    public ProductResponse updateProduct(ProductRequest productRequest, long id, long clientId) {
        log.debug("Updating product with request: {}, id: {}, for clientId: {}", productRequest, id, clientId);
        Optional<Product> optionalProduct = productRepository.findByIdAndClientId(id, clientId);
        if (!optionalProduct.isPresent()) {
            log.error("Product not present with id: {}, and clientId: {}", id, clientId);
            throw new ProcessException("Product updation", "Invalid product ID");
        }
        Product product = productRequest.from(clientId);
        product.setId(id);
        product = productRepository.save(product);
        log.debug("Updated product with id: {} and clientId: {}. Response: {}", id, clientId, product);
        return ProductResponse.from(product);
    }

    @Override
    public boolean deleteProduct(long id, long clientId) {
        log.debug("Deleting product with id: {}, for clientId: {}", id, clientId);
        Optional<Product> optionalProduct = productRepository.findByIdAndClientId(id, clientId);
        if (!optionalProduct.isPresent()) {
            log.error("Product not present with id: {}, and clientId: {}", id, clientId);
            throw new ProcessException("Product deletion", "Invalid product ID");
        }
        Product product = optionalProduct.get();
        productRepository.delete(product);
        log.debug("Deleted product with id: {} and clientId: {}", id, clientId);
        return true;
    }

    @Override
    public ProductResponse getProductById(long id, long clientId) {
        log.debug("Fetching product with id: {}, for clientId: {}", id, clientId);
        Optional<Product> optionalProduct = productRepository.findByIdAndClientId(id, clientId);
        if (!optionalProduct.isPresent()) {
            log.error("Product not present with id: {}, and clientId: {}", id, clientId);
            throw new ProcessException("Get product by id", "Invalid product ID");
        }
        Product product = optionalProduct.get();
        log.debug("Fetched product with id: {} and clientId: {}. Response: {}", id, clientId, product);
        return ProductResponse.from(product);
    }

    @Override
    public ResponseEntity<List<ProductResponse>> getAllProducts(long clientId, Long categoryId, Integer pageNumber,
                                                                Integer pageSize, String sortBy, String order) {
        log.debug("Starting getAllProducts with pageNumber: {}, pageSize: {}, sortBy: {}, order: {} " +
                        ", clientId: {} and categoryId: {}",
                pageNumber, pageSize, sortBy, order, clientId, categoryId);
        Sort.Direction direction = (order.equals("ASC")) ? Sort.Direction.ASC : Sort.Direction.DESC;
        Pageable pageable = PageRequest.of(pageNumber, pageSize, Sort.by(direction, sortBy));
        List<Product> products = (categoryId == null || categoryId == 0L) ?
                  productRepository.findAllByClientId(clientId, pageable)
                : productRepository.findAllByClientIdAndCategoryId(clientId, categoryId, pageable);
        log.debug("Returning from getAllProducts for clientId: {}, productCategoryId: {} with response: {}",
                clientId, categoryId, products);
        return ProductResponse.getResponseEntityFrom(products);
    }

}
