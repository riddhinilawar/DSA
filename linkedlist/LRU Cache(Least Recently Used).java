146. LRU Cache

Design a data structure that follows the constraints of a Least Recently Used (LRU) cache.

Implement the LRUCache class:

LRUCache(int capacity) Initialize the LRU cache with positive size capacity.
int get(int key) Return the value of the key if the key exists, otherwise return -1.
void put(int key, int value) Update the value of the key if the key exists. Otherwise, add the key-value pair to the cache. If the number of keys exceeds the capacity from this operation, evict the least recently used key.
The functions get and put must each run in O(1) average time complexity.

 

Example 1:

Input
["LRUCache", "put", "put", "get", "put", "get", "put", "get", "get", "get"]
[[2], [1, 1], [2, 2], [1], [3, 3], [2], [4, 4], [1], [3], [4]]
Output
[null, null, null, 1, null, -1, null, -1, 3, 4]

Explanation
LRUCache lRUCache = new LRUCache(2);
lRUCache.put(1, 1); // cache is {1=1}
lRUCache.put(2, 2); // cache is {1=1, 2=2}
lRUCache.get(1);    // return 1
lRUCache.put(3, 3); // LRU key was 2, evicts key 2, cache is {1=1, 3=3}
lRUCache.get(2);    // returns -1 (not found)
lRUCache.put(4, 4); // LRU key was 1, evicts key 1, cache is {4=4, 3=3}
lRUCache.get(1);    // return -1 (not found)
lRUCache.get(3);    // return 3
lRUCache.get(4);    // return 4
 

Constraints:

1 <= capacity <= 3000
0 <= key <= 104
0 <= value <= 105
At most 2 * 105 calls will be made to get and put.

class LRUCache {

    int size=0;
    int currSize=0;

    class ListNode{
        int key;
        int val;
        ListNode next=null;
        ListNode prev=null;
        ListNode(int key,int val){
            this.key=key;
            this.val=val;
        }
    }

    ListNode head=null;
    ListNode tail=null;

    HashMap<Integer,ListNode> map;

    public LRUCache(int capacity) {
        this.size=capacity;
        map = new HashMap<>();
    }
    
    public int get(int key) {
       
        int temp=-1;

        if(map.containsKey(key)==false)return temp;
        ListNode getNode=map.get(key);

        if(getNode == head){
            temp=head.val;
        }
        else if(getNode == tail){
            
            ListNode tailp=tail.prev;

            tail.prev.next=null;
            tail.prev=null;
            tail.next=null;

            tail.next=head;
            head.prev=tail;
            head=tail;

            temp=head.val;
            tail=tailp;
        }
        else{
            ListNode p=null;
            ListNode n=null;
            p=getNode.prev;
            n=getNode.next;

            p.next=n;
            n.prev=p;

            getNode.next=null;
            getNode.prev=null;

            getNode.next=head;
            head.prev=getNode;
            head=getNode;

            temp=head.val;
           
        }
        //System.out.print(temp+"-get->");
        //print(head);
        return temp;
    }
    
    public void put(int key, int value) {


        if(map.containsKey(key)==true){
            ListNode update = map.get(key);
            update.val=value;
            get(key);
            return;
        }

        ListNode newNode = new ListNode(key,value); 
        //System.out.println(size+" "+currSize+" "+key);
        if(currSize==0){
            head=tail=newNode;
            currSize++;
            map.put(key,newNode);
            //print(head);
        }
        else if(currSize>=size){

            if(currSize==1){
                head=tail=newNode;
                map.clear();
                map.put(key,newNode);
            }
            else{
                map.remove(tail.key);
                tail=tail.prev;
                tail.next=null;
                newNode.next=head;
                head.prev=newNode;
                head=newNode;
                map.put(key,newNode);
            }
            
        }
        else{
            newNode.next=head;
            head.prev=newNode;
            head=newNode;
            map.put(key,newNode);
            currSize++;
        }
        //System.out.print(key+"-put->");
        //print(head);
    }
    public void print(ListNode temp){
        while(temp!=null){
            System.out.print(temp.key+" ");
            temp=temp.next;
        }
        System.out.println();
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
