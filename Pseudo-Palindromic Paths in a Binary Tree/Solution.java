
// Question : https://leetcode.com/problems/pseudo-palindromic-paths-in-a-binary-tree/

import java.util.*;

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
    private int ans=0;
    private boolean isValidForPermutation(HashMap<Integer,Integer> count){
        int cnt=0;
        for(int key:count.keySet()){
            int val = count.get(key);
            if((val&1)==1) cnt++;
        }
        return cnt<=1;
    }
    private void exploreTree(TreeNode root,HashMap<Integer,Integer> count){
        if(root==null){
            return;
        }
        count.put(root.val,count.getOrDefault(root.val,0)+1);
        if(root.left==null && root.right==null){
            if(isValidForPermutation(count)) ans++;
            count.put(root.val,count.get(root.val)-1);
            if(count.get(root.val)==0) count.remove(root.val);
            return;
        }
        exploreTree(root.left,count);
        exploreTree(root.right,count);
        
        count.put(root.val,count.get(root.val)-1);
        if(count.get(root.val)==0) count.remove(root.val);
    }
    public int pseudoPalindromicPaths (TreeNode root) {
        HashMap<Integer,Integer> count = new HashMap<Integer,Integer>();
        exploreTree(root,count);
        return ans;
    }
}