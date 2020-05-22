package problems;

import pojo.BinaryTreeNode;

public class MaxSumPathInBinaryTree {

    private static int max = Integer.MIN_VALUE;

    public int maxPathSum(BinaryTreeNode A) {
        max = Integer.MIN_VALUE;
        calculate(A);
        return max;
    }

    private int calculate(BinaryTreeNode A) {
        if(A == null) {
            return 0;
        }

        int l = calculate(A.getLeft());
        int r = calculate(A.getRight());
        int max_route = Math.max(Math.max(l, r) + A.getValue(), A.getValue());

        int max_subtree = Math.max(max_route, l+r+A.getValue());
        max = Math.max(max_subtree, max);

        return max_route;
    }
}
