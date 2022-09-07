
// Question : https://leetcode.com/problems/add-two-numbers/

// Definition for singly-linked list.
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode prev = l1,head = l1;
        int carry=0;
        while(l1!=null && l2!=null){
            prev=l1;
            l1.val+=carry+l2.val;
            if(l1.val>9){
                l1.val=l1.val%10;
                carry=1;
            }else{
                carry=0;
            }
            l1=l1.next;
            l2=l2.next;
        }
        if(l1==null){
            prev.next=l2;
            l1=l2;
        }
        
        while(l1!=null){
            prev=l1;
            l1.val+=carry;
            if(l1.val>9){
                l1.val=l1.val%10;
                carry=1;
            }else{
                carry=0;
            }
            l1=l1.next;
        }
        
        if(carry==1){
            prev.next=new ListNode(1);
        }
        return head;
    }
}