class Solution {
    ListNode head=null;
    public Solution(ListNode head) {
        this.head=head;
    }
    
    public int getRandom() {
        int scope=1, number=0;
        ListNode curr=this.head;
        while(curr!=null){
            if(Math.random() <= (1.0/scope))
                number=curr.val;
            scope++;
            curr=curr.next;
        }
        return number;
    }
}
