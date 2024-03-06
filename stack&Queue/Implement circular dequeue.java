import java.util.*;
public class MyCircularDeque {

    int size=0;
    int currSize=0;

    class ListNode{
        int val;
        ListNode next=null;
        ListNode prev=null;
        ListNode(int val){
            this.val=val;
        }
    }

    ListNode head;
    ListNode tail;

    public MyCircularDeque(int k) {
        size=k;
        head=null;
        tail=null;
    }
    
    public boolean insertFront(int value) {
        if(currSize==size)
            return false;
        
        ListNode newNode =new ListNode(value);
        currSize++;
        
        if(head==null){
            head=tail=newNode;
            return true;
        }

        newNode.next=head;
        head.prev=newNode;
        head=newNode;
        return true;
    }
    
    public boolean insertLast(int value) {
        if(currSize==size)
            return false;
        
        ListNode newNode =new ListNode(value);
        currSize++;
        
        if(head==null){
            head=tail=newNode;
            return true;
        }

        tail.next=newNode;
        newNode.prev=tail;
        tail=newNode;
        return true;
    }
    
    public boolean deleteFront() {
        if(head==null)
            return false;
        currSize--;
        if(head==tail){
            head=tail=null;
            return true;
        }
        head=head.next;
        head.prev=null;
        return true;
    }
    
    public boolean deleteLast() {
        if(tail==null)
            return false;
        currSize--;
        if(head==tail){
            head=tail=null;
            return true;
        }
        tail=tail.prev;
        return true;
    }
    
    public int getFront() {
        if(head==null)
            return -1;
        return head.val;
    }
    
    public int getRear() {
        if(tail==null)
            return -1;
        return tail.val;
    }
    
    public boolean isEmpty() {
        if(head==null)return true;
        return false;
    }
    
    public boolean isFull() {
        if(currSize==size)
            return true;
        return false;
    }
}

/**
 * Your MyCircularDeque object will be instantiated and called as such:
 * MyCircularDeque obj = new MyCircularDeque(k);
 * boolean param_1 = obj.insertFront(value);
 * boolean param_2 = obj.insertLast(value);
 * boolean param_3 = obj.deleteFront();
 * boolean param_4 = obj.deleteLast();
 * int param_5 = obj.getFront();
 * int param_6 = obj.getRear();
 * boolean param_7 = obj.isEmpty();
 * boolean param_8 = obj.isFull();
 */
