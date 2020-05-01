package tree;

import pojo.BinaryTreeNode;

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
	
	public BinaryTreeNode inOrderSuccessor(int data) {
		BinaryTreeNode current = findNode(data);
		if(current == null) {
			return null;
		}
		
		if(current.getRight() != null) {
			BinaryTreeNode n = current.getRight();
			while (n.getLeft() != null) {
				n = n.getLeft();
			}
			return n;
		}
		
		
		BinaryTreeNode successor = root;
		BinaryTreeNode ancestor = root;
		while (ancestor != current) {
			if(data < ancestor.getValue()) {
				successor = ancestor;
				ancestor = ancestor.getLeft();
			} else {
				ancestor = ancestor.getRight();
			}
		}
		return successor;
	}
	
	public BinaryTreeNode findNode(int data) {
		BinaryTreeNode current = root;
		while (current != null) {
			if(current.getValue() == data) {
				return current;
			} else if (data < current.getValue()) {
				current = current.getLeft();
			} else {
				current = current.getRight();
			}
		}
		return null;
	}
	
	public int getDepth() {
		
		return depth(root);
	}
	
	private int depth(BinaryTreeNode node) {
		if(node.getLeft() == null && node.getRight() == null) {
			return 0;
		}
		
		return 1 + Math.max(depth(node.getLeft()), depth(node.getRight()));
	}
}