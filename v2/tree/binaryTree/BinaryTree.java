public class BinaryTree {
	
	public static void main(String[] args) {
		print("Hello Binary Tree");
		BinaryTreeNode root = makeMyTreeOne();

		print("In Order\n======");
		root.inOrderPrint();

		print("Pre Order\n======");
		root.preOrderPrint();

		print("Post Order\n======");
		root.postOrderPrint();

		print("Hello Binary Tree 2");
		root = makeMyTreeTwo();

		print("In Order\n======");
		root.inOrderPrint();

		print("Pre Order\n======");
		root.preOrderPrint();

		print("Post Order\n======");
		root.postOrderPrint();
	}

	static class BinaryTreeNode {
		private BinaryTreeNode left;
		private BinaryTreeNode right;
		private int val;

		BinaryTreeNode(int val) {
			this.val = val;
		}

		void preOrderPrint() {
			print(this.val);
			if (this.left != null) {
				this.left.preOrderPrint();
			}
			if (this.right != null) {
				this.right.preOrderPrint();
			}
		}

		void inOrderPrint() {
			if (this.left != null) {
				this.left.inOrderPrint();
			}
			print(this.val);
			if (this.right != null) {
				this.right.inOrderPrint();
			}
		}

		void postOrderPrint() {
			if (this.left != null) {
				this.left.postOrderPrint();
			}
			if (this.right != null) {
				this.right.postOrderPrint();
			}
			print(this.val);
		}

		void setChild(BinaryTreeNode left, BinaryTreeNode right) {
			this.left = left;
			this.right = right;
		}

		void setChild(int left, int right) {
			BinaryTreeNode leftChild = new BinaryTreeNode(left);
			BinaryTreeNode rightChild = new BinaryTreeNode(right);
			this.left = leftChild;
			this.right = rightChild;
		}
	}

	static void print(Object obj) {
		System.out.println(obj);
	}


	static BinaryTreeNode makeMyTreeOne() {
		BinaryTreeNode parent = new BinaryTreeNode(1);
		BinaryTreeNode child1 = new BinaryTreeNode(2);
		BinaryTreeNode child2 = new BinaryTreeNode(3);
		parent.setChild(child1, child2);
		return parent;
	}

	static BinaryTreeNode makeMyTreeTwo() {
		BinaryTreeNode root = new BinaryTreeNode(1);
		root.setChild(2, 3);
		root.left.setChild(4, 5);
		root.right.setChild(6, 7);
		return root;
	}



}