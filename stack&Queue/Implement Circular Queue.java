import java.util.*;
public class MyCircularQueue {

    int size=0;
    int currSize=0;

    class ListNode{
        int val;
        ListNode next=null;
        ListNode(int val){
            this.val=val;
        }
    }

    ListNode head;
    ListNode tail;

    public MyCircularQueue(int k) {
        size=k;
        head=null;
        tail=null;
    }
    
    public boolean enQueue(int value) {
        if(currSize==size)
            return false;
        
        ListNode newNode =new ListNode(value);
        currSize++;
        
        if(head==null){
            head=tail=newNode;
            return true;
        }

        tail.next=newNode;
        tail=newNode;
        return true;
    }
    
    public boolean deQueue() {
        if(head==null)
            return false;
        if(head==tail)
            tail=null;
        head=head.next;
        currSize--;
        return true;
    }
    
    public int Front() {
        if(head==null)
            return -1;
        return head.val;
    }
    
    public int Rear() {
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
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */
