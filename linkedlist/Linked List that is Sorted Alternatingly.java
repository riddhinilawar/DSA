You are given a Linked list of size n. The list is in alternating ascending and descending orders. Sort the given linked list in non-decreasing order.

Example 1:

Input:
n = 6
LinkedList = 1->9->2->8->3->7
Output: 1 2 3 7 8 9
Explanation: 
After sorting the given list will be 1->2->3->7->8->9.
Example 2:

Input:
n = 5
LinkedList = 13->99->21->80->50
Output: 13 21 50 80 99
Explanation:
After sorting the given list will be 13->21->50->80->99.
Your Task:
You do not need to read input or print anything. The task is to complete the function sort() which should sort the linked list of size n in non-decreasing order. 

Expected Time Complexity: O(n)
Expected Auxiliary Space: O(1)

Constraints:
1 <= Number of nodes <= 100
0 <= Values of the elements in linked list <= 103



class Solution {
    
   public Node sort(Node head){
        Node evenHead=null;
        Node oddHead=null;
        
        Node even=null;
        Node odd=null;
        boolean flag=true;
        
        
        while(head!=null){
            Node next=head.next;
            
            head.next=null;
            
            if(oddHead==null && flag==true){
                oddHead=head;
                odd=head;
                flag=false;
            }
            else if(flag==true){
                odd.next=head;
                odd=odd.next;
                flag=false;
            }
            
            else if(evenHead==null && flag==false){
                evenHead=head;
                even=head;
                flag=true;
            }
            else{
                even.next=head;
                even=even.next;
                flag=true;
            }
            
            head=next;
        }
        
        evenHead=reverse(evenHead);
        
        
        odd.next=evenHead;
        return oddHead;
   }
   public Node reverse(Node curr){
       Node prev=null;
       
       while(curr!=null){
           Node next=curr.next;
           curr.next=prev;
           prev=curr;
           curr=next;
       }
       
       return prev;
   }
}
