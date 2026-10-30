/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
List<List<Integer>> result = new ArrayList<>();
List<Integer> path = new ArrayList<>();

public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
    func(root, targetSum, 0);
    return result;
}

public void func(TreeNode node, int targetSum, int sum) {
    if (node == null)
        return;

    path.add(node.val);
    sum += node.val;

    if (node.left == null && node.right == null) {
        if (sum == targetSum)
            result.add(new ArrayList<>(path));
    }

    func(node.left, targetSum, sum);
    func(node.right, targetSum, sum);

    path.remove(path.size() - 1);
  }
 }