package problems;

import pojo.BinaryTreeNode;

/**
     Given two binary trees, write a function to check if they are equal or not.

     Two binary trees are considered equal if they are structurally identical and the nodes have the same value.

     Return false or true

     Example :

     Input :

         1       1
        / \     / \
       2   3   2   3

     Output :
     True
 */
public class IdenticalBinaryTrees {
    public boolean isSameTree(BinaryTreeNode A, BinaryTreeNode B) {
        if(A == null && B == null) {
            return true;
        }
        if(A == null || B == null) {
            return false;
        }
        if(A.getValue() != B.getValue()) {
            return false;
        }

        boolean l = isSameTree(A.getLeft(), B.getLeft());
        boolean r = isSameTree(A.getRight(), B.getRight());
        return l && r;
    }
}
