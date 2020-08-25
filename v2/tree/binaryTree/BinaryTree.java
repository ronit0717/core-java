public class BinaryTree {
	
	public static void main(String[] args) {
		System.out.println("Hello Binary Tree");
		BinaryTreeNode parent = new BinaryTreeNode(1);
		BinaryTreeNode child1 = new BinaryTreeNode(2);
		BinaryTreeNode child2 = new BinaryTreeNode(3);
		parent.setChild(child1, child2);
		parent.printNode();
	}

	static class BinaryTreeNode {
		private BinaryTreeNode left;
		private BinaryTreeNode right;
		private int val;

		BinaryTreeNode(int val) {
			this.val = val;
		}

		void printNode() {
			System.out.println(this.val);
			if (this.left != null) {
				this.left.printNode();
			}
			if (this.right != null) {
				this.right.printNode();
			}
		}

		void setChild(BinaryTreeNode left, BinaryTreeNode right) {
			this.left = left;
			this.right = right;
		}
	}

}