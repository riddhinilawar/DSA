1146. Snapshot Array

Implement a SnapshotArray that supports the following interface:

SnapshotArray(int length) initializes an array-like data structure with the given length. Initially, each element equals 0.
void set(index, val) sets the element at the given index to be equal to val.
int snap() takes a snapshot of the array and returns the snap_id: the total number of times we called snap() minus 1.
int get(index, snap_id) returns the value at the given index, at the time we took the snapshot with the given snap_id
 

Example 1:

Input: ["SnapshotArray","set","snap","set","get"]
[[3],[0,5],[],[0,6],[0,0]]
Output: [null,null,0,null,5]
Explanation: 
SnapshotArray snapshotArr = new SnapshotArray(3); // set the length to be 3
snapshotArr.set(0,5);  // Set array[0] = 5
snapshotArr.snap();  // Take a snapshot, return snap_id = 0
snapshotArr.set(0,6);
snapshotArr.get(0,0);  // Get the value of array[0] with snap_id = 0, return 5
 

Constraints:

1 <= length <= 5 * 104
0 <= index < length
0 <= val <= 109
0 <= snap_id < (the total number of times we call snap())
At most 5 * 104 calls will be made to set, snap, and get.

===========================================MLE=====Simple Approach===========================
class SnapshotArray {

    int arr[];
    HashMap<Integer,int[]> snapRecords = new HashMap<>();

    public SnapshotArray(int length) {
        this.arr=new int[length];
    }
    
    public void set(int index, int val) {
        arr[index]=val;
    }
    
    public int snap() {
        int snapId=snapRecords.size();
        snapRecords.put(snapId,arr.clone());
        return snapId;
    }
    
    public int get(int index, int snap_id) {
        return snapRecords.get(snap_id)[index];
    }
}

/**
 * Your SnapshotArray object will be instantiated and called as such:
 * SnapshotArray obj = new SnapshotArray(length);
 * obj.set(index,val);
 * int param_2 = obj.snap();
 * int param_3 = obj.get(index,snap_id);
 */
=======================================Some what better===Accepted=================

  class SnapshotArray {

    List<Map<Integer, Integer>> list;
    
    public SnapshotArray(int length) {
        list = new ArrayList();
        list.add(new HashMap());
    }
    
    public void set(int index, int val) {
        int snapId = list.size() - 1;
        list.get(snapId).put(index, val);
    }
    
    public int snap() {
        list.add(new HashMap());
        return list.size() - 2;
    }
    
    public int get(int index, int snap_id) {
        for (int snap = snap_id; snap >= 0; snap--) {
            if (list.get(snap).containsKey(index))
                return list.get(snap).get(index);
        }
        return 0;
    }
}

/**
 * Your SnapshotArray object will be instantiated and called as such:
 * SnapshotArray obj = new SnapshotArray(length);
 * obj.set(index,val);
 * int param_2 = obj.snap();
 * int param_3 = obj.get(index,snap_id);
 */
==========================BEST SOLUTION====================================

class SnapshotArray {
    TreeMap<Integer, Integer>[] snapShot;
    int snapShotId = 0;

    //TC::O(length)
    public SnapshotArray(int length) {
        snapShot = new TreeMap[length];
        for(int i = 0; i < length; i++) snapShot[i] = new TreeMap<Integer, Integer>();
    }

    //TC::O(1)
    public void set(int index, int val) {
        snapShot[index].put(snapShotId, val);
    }

    //TC::O(1)
    public int snap() {
        return snapShotId++;
    }

    // TC::O(1)
    public int get(int index, int snap_id) {
        Map.Entry<Integer, Integer> e = snapShot[index].floorEntry(snap_id);
        return e == null ? 0 : e.getValue();
    }
}

/**
 * Your SnapshotArray object will be instantiated and called as such:
 * SnapshotArray obj = new SnapshotArray(length);
 * obj.set(index,val);
 * int param_2 = obj.snap();
 * int param_3 = obj.get(index,snap_id);
 */
