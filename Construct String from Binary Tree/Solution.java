
// Question : https://leetcode.com/problems/construct-string-from-binary-tree/

// Definition for a binary tree node.
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Solution {
    private String helper(TreeNode root){
        if(root==null) return "";
        if(root.left==null && root.right==null) return "("+root.val+")";
        String left = helper(root.left);
        String right = helper(root.right);
        
        if(root.left==null){
            return "("+root.val+"()"+right+")";
        }
        return "("+root.val+left+right+")";
    }
    public String tree2str(TreeNode root) {
        String ans = helper(root);
        return ans.substring(1,ans.length()-1);
    }
}