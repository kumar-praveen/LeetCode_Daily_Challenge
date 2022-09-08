
// Question : https://leetcode.com/problems/amount-of-time-for-binary-tree-to-be-infected/

import java.util.*;;

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
    TreeNode node = null;
    private void findNode(TreeNode root,HashMap<TreeNode,TreeNode> parent,int start){
        if(root==null) return;
        if(root.val==start){
            node=root;
        }
        if(root.left!=null) parent.put(root.left,root);
        if(root.right!=null) parent.put(root.right,root);
        
        findNode(root.left,parent,start);
        findNode(root.right,parent,start);
    }
    public int amountOfTime(TreeNode root, int start) {
        HashMap<TreeNode,TreeNode> parent = new HashMap<TreeNode,TreeNode>();
        findNode(root,parent,start);
        
        LinkedList<TreeNode> q = new LinkedList<TreeNode>();
        q.add(node);
        
        int t=-1;
        HashSet<TreeNode> burnt = new HashSet<TreeNode>();
        while(q.isEmpty()==false){
            int n=q.size();
            while(n--!=0){
                TreeNode temp = q.pollFirst();
                burnt.add(temp);
                if(temp.left!=null && burnt.contains(temp.left)==false) q.add(temp.left);
                if(temp.right!=null && burnt.contains(temp.right)==false) q.add(temp.right);
                if(parent.get(temp)!=null && burnt.contains(parent.get(temp))==false) q.add(parent.get(temp));
            }
            t++;
        }
        return t;
    }
}