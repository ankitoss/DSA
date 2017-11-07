package tree;

public class BinarySearchTree {

	private BinaryTreeNode root;

	public BinaryTreeNode getRoot() {
		return root;
	}

	public void insert(int value) {
		// root = insert(root, value);
		root = insertIterative(root, value);
	}

	private BinaryTreeNode insertIterative(BinaryTreeNode node, int value) {
		if (root == null) {
			return new BinaryTreeNode(value);
		}
		BinaryTreeNode current = root;
		while (current != null) {
			if (value < current.getValue()) {
				if (current.getLeft() == null) {
					current.setLeft(new BinaryTreeNode(value));
					break;
				} else {
					current = current.getLeft();
				}
			} else {
				if (current.getRight() == null) {
					current.setRight(new BinaryTreeNode(value));
					break;
				} else {
					current = current.getRight();
				}
			}
		}

		return root;
	}

	private BinaryTreeNode insertRecursive(BinaryTreeNode node, int value) {
		if (node == null) {
			node = new BinaryTreeNode(value);
			return node;
		}

		if (value < node.getValue()) {
			node.setLeft(insertRecursive(node.getLeft(), value));
		} else {
			node.setRight(insertRecursive(node.getRight(), value));
		}

		return node;
	}

	public void traversePreOrder(BinaryTreeNode node) {

		if (node == null) {
			return;
		}

		System.out.print(node.getValue() + " ");
		traversePreOrder(node.getLeft());
		traversePreOrder(node.getRight());
	}
	
	public void traverseInOrder(BinaryTreeNode node) {

		if (node == null) {
			return;
		}

		traverseInOrder(node.getLeft());
		System.out.print(node.getValue() + " ");
		traverseInOrder(node.getRight());
	}
	
	public void traversePostOrder(BinaryTreeNode node) {

		if (node == null) {
			return;
		}

		traversePostOrder(node.getLeft());
		traversePostOrder(node.getRight());
		System.out.print(node.getValue() + " ");
	}
}