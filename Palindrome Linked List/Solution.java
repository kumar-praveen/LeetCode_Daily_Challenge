
//Question : https://leetcode.com/problems/palindrome-linked-list/

//  Definition for singly-linked list.
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
 
class Solution {
    ListNode node;
    public boolean helper(ListNode head){
        if(head==null) return true;
        boolean ans = helper(head.next);
        if(ans==false) return false;
        ans=node.val==head.val;
        node=node.next;
        return ans;
    }
    public boolean isPalindrome(ListNode head) {
        node=head;
        return helper(head);
    }
}