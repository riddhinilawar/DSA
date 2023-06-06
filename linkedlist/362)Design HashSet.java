705. Design HashSet

Design a HashSet without using any built-in hash table libraries.
Implement MyHashSet class:

void add(key) Inserts the value key into the HashSet.

bool contains(key) Returns whether the value key exists in the HashSet or not.

void remove(key) Removes the value key in the HashSet. If key does not exist in the HashSet, do nothing.
 
Example 1:
Input
["MyHashSet", "add", "add", "contains", "contains", "add", "contains", "remove", "contains"]
[[], [1], [2], [1], [3], [2], [2], [2], [2]]
Output
[null, null, null, true, false, null, true, null, false]

Explanation
MyHashSet myHashSet = new MyHashSet();
myHashSet.add(1);      // set = [1]
myHashSet.add(2);      // set = [1, 2]
myHashSet.contains(1); // return True
myHashSet.contains(3); // return False, (not found)
myHashSet.add(2);      // set = [1, 2]
myHashSet.contains(2); // return True
myHashSet.remove(2);   // set = [1]
myHashSet.contains(2); // return False, (already removed)
 
Constraints:
0 <= key <= 106
At most 104 calls will be made to add, remove, and contains.









class MyHashSet {
    int map[]=new int[1000001];
    public MyHashSet() {
        
    }
    
    public void add(int key) {
        map[key]=1;
    }
    
    public void remove(int key) {
        map[key]=0;
    }
    
    public boolean contains(int key) {
        return map[key]==1;
    }
}


class MyHashSet {
    LinkedList<Entry> set[];
    public static final int SIZE = 769;

    public MyHashSet() {
        set = new LinkedList[SIZE];            
    }
    
    public void add(int key) {
        int bucket = key % SIZE;
        if(set[bucket]==null){
            set[bucket]=new LinkedList<Entry>();
            set[bucket].add(new Entry(key));
        }
        else{
            for(Entry temp:set[bucket]){
                if(temp.value==key)
                    return;
            }
            set[bucket].add(new Entry(key));
        }
    }
    
    public void remove(int key) {
        int bucket = key % SIZE;
        if(set[bucket]==null)
            return;
        Entry toRemove=null;
        for(Entry temp:set[bucket]){
            if(temp.value==key){
                toRemove=temp;
            }
        }
        if(toRemove!=null)
            set[bucket].remove(toRemove);
    }
    
    public boolean contains(int key) {
        int bucket = key % SIZE;
        if(set[bucket]==null)
            return false;
        for(Entry temp:set[bucket]){
            if(temp.value==key)
                return true;
        }
        return false;
    }

    class Entry{
        int value;
        Entry(int value){
            this.value=value;
        }
    }
}





