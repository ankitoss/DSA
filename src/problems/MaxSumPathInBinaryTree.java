package problems;

import pojo.BinaryTreeNode;

/**
     Given a binary tree T, find the maximum path sum.

     The path may start and end at any node in the tree.

     Input Format:

     The first and the only argument contains a pointer to the root of T, A.

     Output Format:

     Return an integer representing the maximum sum path.

     Constraints:

     1 <= Number of Nodes <= 7e4
     -1000 <= Value of Node in T <= 1000

     Example :

     Input 1:

       1
      / \
     2   3

     Output 1:
     6

     Explanation 1:
     The path with maximum sum is: 2 -> 1 -> 3

     Input 2:

        -10
        /  \
     -20  -30

     Output 2:
     -10

     Explanation 2
     The path with maximum sum is: -10
 */
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
