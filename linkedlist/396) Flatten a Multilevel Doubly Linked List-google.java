BEST SOLUTION

class Solution {
    public Node flatten(Node head) {
        Node curr=head;
        while(curr!=null){

            if(curr.child!=null){

                Node childStart = curr.child;
                Node childEnd = getChildListEnd(childStart);
                
                curr.child=null;
                Node nextNode = curr.next;

                curr.next=childStart;
                childStart.prev=curr;

                childEnd.next=nextNode;
                if(nextNode!=null)nextNode.prev=childEnd;

            }

            curr=curr.next;
        }
        return head;
    }
    public Node getChildListEnd(Node curr){
        Node prev=curr;
        while(curr!=null){
            prev=curr;
            curr=curr.next;
        }
        return prev;
    }
}
==============================================================================================

class Solution {
    public Node flatten(Node head) {
        if(head == null)
            return null;

        Node temp=head;

        while(temp!=null){

            if(temp.child==null){
                temp=temp.next;
                continue;
            }

            Node childNode = temp.child;

            while(childNode.next!=null){
                childNode=childNode.next;
            }

            Node tempNext=temp.next;
            temp.next=temp.child;
            temp.child.prev=temp;

            childNode.next=tempNext;
            if(tempNext!=null)
                tempNext.prev=childNode;

            temp.child=null;
        }

        return head;
    }
}


=============================================using stack========================================

    /*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};
*/

class Solution {
    public Node flatten(Node head) {
        Stack<Node> stack=new Stack<>();

        Node curr=head;
        while(curr!=null){
            if(curr.child!=null){
                if(curr.next!=null){
                    stack.push(curr.next);
                }
                curr.next=curr.child;
                curr.child.prev=curr;
                curr.child=null;
            }

            if(curr.next==null && !stack.isEmpty()){
                Node temp=stack.pop();
                curr.next=temp;
                temp.prev=curr;
            }
            else{
                curr=curr.next;
            }
        }

        return head;
    }
}
