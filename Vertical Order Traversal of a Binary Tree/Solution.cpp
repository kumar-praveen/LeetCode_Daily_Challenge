#include<vector>
#include<map>
#include<queue>
using namespace std;

// Question : https://leetcode.com/problems/vertical-order-traversal-of-a-binary-tree/



//  Definition for a binary tree node.
 struct TreeNode {
     int val;
     TreeNode *left;
     TreeNode *right;
     TreeNode() : val(0), left(nullptr), right(nullptr) {}
     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
     TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
};


class Solution {
public:
    vector<vector<int>> verticalTraversal(TreeNode* root) {
        vector<vector<int>> ans;
        if(root==NULL) return ans;
        
        queue<pair<TreeNode*,pair<int,int>>> q;
        q.push({root,{0,0}});
        
        map<pair<int,int>,vector<int>> values;
        
        while(!q.empty()){
            TreeNode* node = q.front().first;
            pair<int,int> pos = q.front().second;
            q.pop();
            
            values[pos].push_back(node->val);
            if(node->left){
                q.push({node->left,{pos.first-1,pos.second+1}});
            }
            if(node->right){
                q.push({node->right,{pos.first+1,pos.second+1}});
            }
        }
        map<int,vector<int>> mvalues;
        for(auto key:values){
            auto value = key.first;
            vector<int> arr = key.second;
            sort(arr.begin(),arr.end());
            
            for(auto v:arr) mvalues[value.first].push_back(v);
        }
        
    
        for(auto key:mvalues){
            ans.push_back(key.second);
        }
        
        return ans;
    }
};