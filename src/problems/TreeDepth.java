package problems;

import tree.BinarySearchTree;

public class TreeDepth {

	public static void main(String[] str) {
		BinarySearchTree tree = new BinarySearchTree();
		tree.insert(25);
		tree.insert(15);
		tree.insert(50);
		tree.insert(10);
		tree.insert(22);
		tree.insert(35);
		tree.insert(70);
		tree.insert(4);
		tree.insert(12);
		tree.insert(18);
		tree.insert(24);
		tree.insert(31);
		tree.insert(44);
		tree.insert(66);
		tree.insert(90);


		System.out.println("Preorder");
		tree.traversePreOrder(tree.getRoot());
		System.out.println();
		System.out.println("Inorder");
		tree.traverseInOrder(tree.getRoot());
		System.out.println();
		System.out.println("Postorder");
		tree.traversePostOrder(tree.getRoot());
	}

}