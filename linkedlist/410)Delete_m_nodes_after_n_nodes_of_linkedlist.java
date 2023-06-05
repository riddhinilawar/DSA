Given a linked list, delete N nodes after skipping M nodes of a linked list until the last of the linked list.

Example:
Input:
2
8
2 1
9 1 3 5 9 4 10 1
6
6 1
1 2 3 4 5 6 

Output: 
9 1 5 9 10 1
1 2 3 4 5 6

Explanation:
Deleting one node after skipping the M nodes each time, we have list as 9-> 1-> 5-> 9-> 10-> 1.
Input:
The first line of input contains the number of test cases T. For each test case, the first line of input contains a number of elements in the linked list, and the next M and N respectively space-separated. The last line contains the elements of the linked list.

Output:
The function should not print any output to the stdin/console.

Your Task:
The task is to complete the function linkdelete() which should modify the linked list as required.

Constraints:

size of linked list <= 1000
class Solution
{
    static void linkdelete(Node head, int M, int N)
    {   
        if(N==0)
            return;
        if(head==null)
            return;
            
        Node ans=new Node(-1);
        Node temp=ans;
        Node curr=head;
        
        int count=0;
        
        int x=M;
        int y=N;
        
        while(curr!=null){
            
            while(x>0 && curr!=null){
                //System.out.println(curr.data);
                temp.next=curr;
                temp=temp.next;
                curr=curr.next;
                x--;
            }
            
            while(y>0 && curr!=null){
                curr=curr.next;
                y--;
            }
            
            x=M;
            y=N;
        }
        temp.next=null;
        head = ans.next;
    }
}
