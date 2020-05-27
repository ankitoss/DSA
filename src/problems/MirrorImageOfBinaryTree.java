package problems;

import pojo.BinaryTreeNode;

/**
     Given a binary tree, invert the binary tree and return it.
     Look at the example for more details.

     Example :
     Given binary tree

              1
            /   \
           2     3
          / \   / \
         4   5 6   7

     invert and return

              1
            /   \
           3     2
          / \   / \
         7   6 5   4
 */
public class MirrorImageOfBinaryTree {

    public BinaryTreeNode invertTree(BinaryTreeNode A) {

        if(A == null) return null;

        BinaryTreeNode le = A.getLeft();
        BinaryTreeNode ri = A.getRight();

        A.setLeft(ri);
        A.setRight(le);

        invertTree(A.getLeft());
        invertTree(A.getRight());

        return A;
    }
}