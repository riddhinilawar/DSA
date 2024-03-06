import java.util.*;
class MyCircularDequeUsingArray {
    int arr[];
    int idx=-1;
    public MyCircularDequeUsingArray(int k) {
        arr=new int[k];
        Arrays.fill(arr,-1);
    }
    
    public boolean insertFront(int value) {
        if(idx+1 ==arr.length)
            return false;
        for(int i=idx;i>=0;i--){
            arr[i+1]=arr[i];
        }
        arr[0]=value;
        idx++;
        return true;
    }
    
    public boolean insertLast(int value) {
        if(idx+1 == arr.length)
            return false;

        idx++;
        arr[idx]=value;
        return true;
    }
    
    public boolean deleteFront() {
        if(arr[0]==-1)
            return false;

        for(int i=0;i<idx;i++){
            arr[i]=arr[i+1];
        }
        arr[idx]=-1;
        idx--;
        return true;
    }
    
    public boolean deleteLast() {
        if(idx==-1)
            return false;
        arr[idx]=-1;
        idx--;
        return true;
    }
    
    public int getFront() {
        return arr[0];
    }
    
    public int getRear() {
        if(idx<0)return -1;
        if(idx==arr.length)return arr[idx-1];
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
