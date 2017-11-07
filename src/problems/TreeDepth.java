package problems;
public class TreeDepth {
	
	public static void main (String[] str) {
		BinaryTree tree = new BinaryTree();
       	tree.insert(50);
        tree.insert(30);
        tree.insert(20);
        tree.insert(40);
        tree.insert(70);
        tree.insert(60);
        tree.insert(80);

		tree.traverse(tree.root);
	}


}

class TreeNode {
	int value;
	TreeNode left, right;

	TreeNode(int value) {
		this.value = value;
	}
}

class BinaryTree {

	TreeNode root;

	public void insert(int value) {
		root = insert(root, value);
		// TreeNode current = root;
		// TreeNode parent = null;
		// while(current != null) {
		// 	if(value < current.value) {
		// 		if(current.left == null) {
		// 			current.left = new TreeNode(value);
		// 			break;
		// 		} else {
		// 			current = current.left;					
		// 		}
		// 	} else {
		// 		if(current.right == null) {
		// 			current.right = new TreeNode(value);	
		// 			break;
		// 		} else {
		// 			current = current.right;					
		// 		}
		// 	}
		// }
	}

	private TreeNode insert(TreeNode node, int value) {
		if(node == null) {
			node = new TreeNode(value);
			return node;
		}

		if(value < node.value) {
			node.left = insert(node.left, value);
		} else {
			node.right = insert(node.right, value);
		}

		return node;
	}

	public void traverse(TreeNode node) {

		if(node == null) {
			return;
		}


		System.out.println(node.value);		
		traverse(node.left);	
		traverse(node.right);
	}
}