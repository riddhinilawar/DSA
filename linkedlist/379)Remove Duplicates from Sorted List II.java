class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode temp=new ListNode(-1);
        ListNode ans=temp;
        ListNode curr=head;

        while(curr!=null){
            if((curr.next!=null && curr.val!=curr.next.val) || curr.next==null){
                temp.next=curr;
                curr=curr.next;
                temp=temp.next;
                temp.next=null;
            }
            else{
                while(curr.next!=null && curr.val==curr.next.val)
                    curr=curr.next;
                curr=curr.next;
            }
        }

        return ans.next;
    }
}
===================================================================


class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode ans = new ListNode(-1);
        ListNode ansHead=ans;
        ListNode curr=head;
        int prev=-101;

        while(curr!=null){
            if(curr.val!=prev && (curr.next==null || (curr.next!=null && curr.val!=curr.next.val))){
                ans.next=curr;
                prev=curr.val;
                curr=curr.next;
                ans=ans.next;
                ans.next=null;
            }
            else{
                prev=curr.val;
                curr=curr.next;
            }
        }
        return ansHead.next;
    }
}
