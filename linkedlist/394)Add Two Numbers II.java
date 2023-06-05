You are given two non-empty linked lists representing two non-negative integers. The most significant digit comes first and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.

 

Example 1:


Input: l1 = [7,2,4,3], l2 = [5,6,4]
Output: [7,8,0,7]
Example 2:

Input: l1 = [2,4,3], l2 = [5,6,4]
Output: [8,0,7]
Example 3:

Input: l1 = [0], l2 = [0]
Output: [0]
 

Constraints:

The number of nodes in each linked list is in the range [1, 100].
0 <= Node.val <= 9
It is guaranteed that the list represents a number that does not have leading zeros.
 

Follow up: Could you solve it without reversing the input lists?
  
  /**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<ListNode> stack1 = new Stack<>();
        Stack<ListNode> stack2 = new Stack<>();
        Stack<ListNode> stack3 = new Stack<>();

        ListNode n1=l1;
        ListNode n2=l2;

        while(n1!=null){
            stack1.push(n1);
            n1=n1.next;
        }

        while(n2!=null){
            stack2.push(n2);
            n2=n2.next;
        }

        int carry=0;

        while(!stack1.isEmpty() || !stack2.isEmpty()){
            int sum=carry;

            if(!stack1.isEmpty()){
                n1=stack1.pop();
                sum+=n1.val;
                n1=n1.next;
            }

            if(!stack2.isEmpty()){
                n2=stack2.pop();
                sum+=n2.val;
                n2=n2.next;
            }

            if(sum>=10){
                sum=sum%10;
                carry=1;
            }
            else{
                carry=0;
            }
            //System.out.println(sum);
            stack3.push(new ListNode(sum));
        }
        if(carry==1)stack3.push(new ListNode(1));
        ListNode ans=new ListNode(-1);
        ListNode temp=ans;

        while(!stack3.isEmpty()){
            temp.next=stack3.pop();
            temp=temp.next;
        }
        
        return ans.next;
    }
}
