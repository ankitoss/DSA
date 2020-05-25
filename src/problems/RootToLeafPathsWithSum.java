package problems;

import pojo.BinaryTreeNode;

import java.util.ArrayList;

public class RootToLeafPathsWithSum {

    public ArrayList<ArrayList<Integer>> pathSum(BinaryTreeNode A, int B) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        dfs(A, new ArrayList<>(), res, B, 0);
        return res;
    }

    private void dfs(BinaryTreeNode root, ArrayList<Integer> path, ArrayList<ArrayList<Integer>> res, int sum, int sofar) {

        if (root == null) return;

        int tot = root.getValue() + sofar;
        ArrayList<Integer> temp = new ArrayList<>(path);
        temp.add(root.getValue());

        if (root.getLeft() == null && root.getRight() == null && tot == sum) {
            res.add(temp);
            return;
        }

        dfs(root.getLeft(), temp, res, sum, tot);
        dfs(root.getRight(), temp, res, sum, tot);
    }
}

