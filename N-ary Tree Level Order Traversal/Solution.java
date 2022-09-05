
// Question : https://leetcode.com/problems/n-ary-tree-level-order-traversal/

import java.util.*;

class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
}

class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        if(root==null) return ans;
        
        LinkedList<Node> q = new LinkedList<Node>();
        q.add(root);
        
        while(!q.isEmpty()){
            int n=q.size();
            List<Integer> temp = new ArrayList<Integer>();
            
            while(n--!=0){
                Node node = q.poll();
                temp.add(node.val);
                
                int tchild = node.children.size();
                for(int i=0;i<tchild;i++){
                    if(node.children.get(i)!=null) q.add(node.children.get(i));
                }
            }
            ans.add(temp);
        }
        
        return ans;
    }
}