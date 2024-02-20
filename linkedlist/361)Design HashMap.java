706. Design HashMap

Design a HashMap without using any built-in hash table libraries.
Implement the MyHashMap class:

MyHashMap() initializes the object with an empty map.

void put(int key, int value) inserts a (key, value) pair into the HashMap. If the key already exists in the map, update the corresponding value.

int get(int key) returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key.

void remove(key) removes the key and its corresponding value if the map contains the mapping for the key.
 
Example 1:
Input
["MyHashMap", "put", "put", "get", "get", "put", "get", "remove", "get"]
[[], [1, 1], [2, 2], [1], [3], [2, 1], [2], [2], [2]]
Output
[null, null, null, 1, -1, null, 1, null, -1]

Explanation
MyHashMap myHashMap = new MyHashMap();
myHashMap.put(1, 1); // The map is now [[1,1]]
myHashMap.put(2, 2); // The map is now [[1,1], [2,2]]
myHashMap.get(1);    // return 1, The map is now [[1,1], [2,2]]
myHashMap.get(3);    // return -1 (i.e., not found), The map is now [[1,1], [2,2]]
myHashMap.put(2, 1); // The map is now [[1,1], [2,1]] (i.e., update the existing value)
myHashMap.get(2);    // return 1, The map is now [[1,1], [2,1]]
myHashMap.remove(2); // remove the mapping for 2, The map is now [[1,1]]
myHashMap.get(2);    // return -1 (i.e., not found), The map is now [[1,1]]
 
Constraints:
0 <= key, value <= 106
At most 104 calls will be made to put, get, and remove.





class MyHashMap {
    LinkedList<Entry>[] map;
    public final static int SIZE=769;
    public MyHashMap() {
        map=new LinkedList[SIZE];
    }
    
    public void put(int key, int value) {
        int bucket = key % SIZE;
        
        if(map[bucket]==null){
            map[bucket]=new LinkedList<>();
            map[bucket].add(new Entry(key,value));
        }
        else{
            for(Entry entry:map[bucket]){
                if(entry.key == key){
                    entry.value=value;
                    return;
                }
            }
            map[bucket].add(new Entry(key,value));
        }
    }
    
    public int get(int key) {
        int bucket = key % SIZE;
        LinkedList<Entry> ll = map[bucket];

        if(ll==null)
            return -1;

        for(Entry entry:ll){
            if(entry.key == key)
                return entry.value;
        }
        return -1;
    }
    
    public void remove(int key) {
        int bucket = key % SIZE;
        LinkedList<Entry> ll = map[bucket];

        if(ll==null)
            return;

        for(Entry entry:ll){
            if(entry.key == key){
                ll.remove(entry);
                return;
            }
        }

    }
    class Entry{
        int key;
        int value;
        Entry(int key,int value){
            this.key=key;
            this.value=value;
        }
    }
}








----------------------------------------------------------------------------------------------------------------------------
class MyHashMap {
    int map[]=new int[1000001];
    public MyHashMap() {
        Arrays.fill(map,-1);
    }
    
    public void put(int key, int value) {
        map[key]=value;
    }
    
    public int get(int key) {
        return map[key];
    }
    
    public void remove(int key) {
        map[key]=-1;
    }
}



class MyHashMap {
    int map[]=new int[1000001];
    public MyHashMap() {
        
    }
    
    public void put(int key, int value) {
        map[key]=value+1;
    }
    
    public int get(int key) {
        return map[key]-1;
    }
    
    public void remove(int key) {
        map[key]=0;
    }
}

HashMap is a specific implementation of a HashMap that stores the key-value pairs directly within an array. In an internal HashMap, the key-value pairs are stored in an array called a hash table. The array is indexed using a hash function that converts each key into an index in the array. When a new key-value pair is added to the HashMap, the key is hashed to determine its index in the array. If there is already a key stored at that index, HashMap uses a collision resolution strategy to find an empty index to store the new key-value pair.

Collision Resolution Strategy
Collision resolution is the process of handling situations where two or more data items are mapped to the same hash value. A common collision resolution strategy is to use one of the following methods:

Chaining: A collision resolution strategy in which each bucket in the hash table is a linked list, and collisions are resolved by adding the new item to the end of the list.
