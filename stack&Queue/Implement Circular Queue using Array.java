import java.util.*;
class MyCircularQueueUsingArray {
    int arr[];
    int idx=-1;
    public MyCircularQueueUsingArray(int k) {
        arr=new int[k];
        Arrays.fill(arr,-1);
    }
    
    public boolean enQueue(int value) {
        if(idx+1 == arr.length)
            return false;

        idx++;
        arr[idx]=value;
        return true;
    }
    
    public boolean deQueue() {
        if(arr[0]==-1)
            return false;

        for(int i=0;i<idx;i++){
            arr[i]=arr[i+1];
        }
        arr[idx]=-1;
        idx--;
        return true;
    }
    
    public int Front() {
        return arr[0];
    }
    
    public int Rear() {
        if(idx==arr.length || idx<0)return -1;
        return arr[idx];
    }
    
    public boolean isEmpty() {
        return (arr[0] == -1)?true:false;
    }
    
    public boolean isFull() {
        return (arr[arr.length-1] != -1)?true:false;
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
