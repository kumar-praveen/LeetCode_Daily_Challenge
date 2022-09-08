// Question : https://leetcode.com/problems/average-of-levels-in-binary-tree/

import java.util.*;

//  Definition for a binary tree node.

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
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> ans = new ArrayList<Double>();
        
        LinkedList<TreeNode> q = new LinkedList<TreeNode>();
        q.add(root);
        
        while(!q.isEmpty()){
            int n=q.size(),cnt=q.size();
            double sum=0;
            while(n--!=0){
                TreeNode node = q.pollFirst();
                if(node.left!=null) q.add(node.left);
                if(node.right!=null) q.add(node.right);
                
                sum+=node.val;
            }
            
            ans.add(sum/cnt);
        }
        
        return ans;
    }
}