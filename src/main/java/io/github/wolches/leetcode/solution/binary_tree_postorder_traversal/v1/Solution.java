package io.github.wolches.leetcode.solution.binary_tree_postorder_traversal.v1;


import io.github.wolches.leetcode.solution.binary_tree_postorder_traversal.TreeNode;

import java.util.LinkedList;
import java.util.List;

class Solution {

    public List<Integer> postorderTraversal(TreeNode root) {
        LinkedList<Integer> result = new LinkedList<>();
        addFromLeft(root, result);
        return result;
    }

    private void addFromRight(TreeNode root, LinkedList<Integer> result) {
        if (root != null) {
            if (root.right != null) {
                addFromRight(root.right, result);
            }
            if (root.left != null) {
                addFromRight(root.left, result);
            }
            result.add(root.val);
        }
    }

    private void addFromLeft(TreeNode root, LinkedList<Integer> result) {
        if (root != null) {
            if (root.left != null) {
                addFromLeft(root.left, result);
            }
            if (root.right != null) {
                addFromLeft(root.right, result);
            }
            result.add(root.val);
        }
    }
}