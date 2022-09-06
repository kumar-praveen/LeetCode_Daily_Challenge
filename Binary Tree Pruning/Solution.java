
// Question : https://leetcode.com/problems/binary-tree-pruning/


// Defination of Pair...
class Pair <K,V>{
    public K node;
    public V haszero;
    public Pair(K node,V haszero){
        this.node=node;
        this.haszero=haszero;
    }
    public K getKey(){return this.node;}
    public V getValue(){return this.haszero;}

}

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

class  Soluti {
    public Pair<TreeNode,Integer> helper(TreeNode root){
        if(root==null){
            return new Pair<TreeNode,Integer>(null,0);
        }
        if(root.left==null && root.right==null){
            if(root.val==1) return new Pair<TreeNode,Integer>(root,1);
            else return new Pair<TreeNode,Integer>(root,0);
        }
        
        Pair<TreeNode,Integer>p1 = helper(root.left);
        Pair<TreeNode,Integer>p2 = helper(root.right);
        
        if(root.left!=null && p1.getValue()==0){
            root.left=null;
        }
        if(root.right!=null && p2.getValue()==0){
            root.right=null;
        }
        if(p1.getValue()+p2.getValue()+root.val==0) return new Pair<TreeNode,Integer>(null,0);
        return new Pair<TreeNode,Integer>(root,1);
    }
    public TreeNode pruneTree(TreeNode root) {
        return helper(root).getKey();
    }
}