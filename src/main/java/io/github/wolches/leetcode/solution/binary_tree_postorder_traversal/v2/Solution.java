package io.github.wolches.leetcode.solution.binary_tree_postorder_traversal.v2;


import io.github.wolches.leetcode.solution.binary_tree_postorder_traversal.TreeNode;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

class Solution {

    public List<Integer> postorderTraversal(TreeNode root) {
        if (root == null) return Collections.emptyList();
        LinkedList<Integer> result = new LinkedList<>();
        Stack<TreeNode> path = new Stack<>();
        path.push(root);
        while (!path.isEmpty()) {
            TreeNode top = path.pop();
            result.addFirst(top.val);
            if (top.left != null) path.push(top.left);
            if (top.right != null) path.push(top.right);
        }
        return result;
    }
}