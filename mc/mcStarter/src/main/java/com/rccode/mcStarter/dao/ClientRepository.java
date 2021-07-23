package com.rccode.mcStarter.dao;

import com.rccode.mcStarter.enumeration.ClientType;
import com.rccode.mcStarter.model.Client;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {
    Optional<Client> findBySlug(String slug);
    List<Client> findAllByName(String clientName, Pageable pageable);
    Optional<Client> findByNameAndAddressPincodeAndClientType(String name, String pincode, ClientType clientType);
}
