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
