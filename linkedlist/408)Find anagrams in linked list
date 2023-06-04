Given a linked list of characters and a string S.Return all the anagrams of the string present in the given linked list.In case of overlapping anagrams choose the first anagram from left.

Example 1:

Input: a -> b -> c -> a -> d -> b -> c -> a
S = bac
Output: [a -> b -> c, b -> c -> a]
Explanation: In the given linked list,
there are three anagrams: 
1. a -> b -> c -> a -> d -> b -> c -> a
2. a -> b -> c -> a -> d -> b -> c -> a
3. a -> b -> c -> a -> d -> b -> c -> a
But in 1 and 2, a -> b -> c and b -> c-> a
are ovelapping.So we take a -> b -> c as it
comes first from left.So the output is:
[a->b->c,b->c->a]
Example 2:

Input: a -> b -> d -> c -> a
S = bac
Output: -1 
Explanation: There is no anagrams, so output is -1
Your Task:
You don't need to read input or print anything. Your task is to complete the function findAnagrams() which takes head node of the linked list and a string S as input parameters and returns an array of linked list which only stores starting point of the Anagram. If there is no anagram in the linked list, leave the Array empty.


Expected Time Complexity: O(N), where N is length of LinkedList
Expected Auxiliary Space: O(1)


Constraints:
1 <= N <= 105
1 <= |S| <= 105Given a linked list of characters and a string S.Return all the anagrams of the string present in the given linked list.In case of overlapping anagrams choose the first anagram from left.

Example 1:

Input: a -> b -> c -> a -> d -> b -> c -> a
S = bac
Output: [a -> b -> c, b -> c -> a]
Explanation: In the given linked list,
there are three anagrams: 
1. a -> b -> c -> a -> d -> b -> c -> a
2. a -> b -> c -> a -> d -> b -> c -> a
3. a -> b -> c -> a -> d -> b -> c -> a
But in 1 and 2, a -> b -> c and b -> c-> a
are ovelapping.So we take a -> b -> c as it
comes first from left.So the output is:
[a->b->c,b->c->a]
Example 2:

Input: a -> b -> d -> c -> a
S = bac
Output: -1 
Explanation: There is no anagrams, so output is -1
Your Task:
You don't need to read input or print anything. Your task is to complete the function findAnagrams() which takes head node of the linked list and a string S as input parameters and returns an array of linked list which only stores starting point of the Anagram. If there is no anagram in the linked list, leave the Array empty.


Expected Time Complexity: O(N), where N is length of LinkedList
Expected Auxiliary Space: O(1)


Constraints:
1 <= N <= 105
1 <= |S| <= 105

class Solution {
    public static Node createList(Node i , Node j){
        Node start = new Node(' ');
        Node curr = start;
        while(i != j){
            curr.next = new Node(i.data);
            curr = curr.next;
            i = i.next;
        }
        curr.next = new Node(i.data);
        return start.next;
    }
    static boolean isAnagram(int alp[],int temp[]){
        for(int i=0;i<26;i++){
            if(alp[i] != temp[i])
            return false;
        }
        return true;
    }
    public static ArrayList<Node> findAnagrams(Node head, String s) {
        int k=s.length();
        int freq[]=new int[26];
        int freqcurr[]=new int[26];
        ArrayList<Node> ans = new ArrayList<>();
        for(int i=0;i<k;i++)
            freq[s.charAt(i)-'a']++;
            
        Node start=head;
        Node end=head;
        int temp=k;
        
        while(temp>1){
            freqcurr[end.data - 'a']++;
            end=end.next;
            temp--;
        }
        freqcurr[end.data - 'a']++;
        
        if(end.next==null  && isAnagram(freq,freqcurr)==true)
            ans.add(createList(start,end));
        
        
        while(end.next!=null){
            
            if(isAnagram(freq,freqcurr)==true){
                //System.out.println("In-->"+start.data+" "+end.data);
                ans.add(createList(start,end));
                start=end.next;
                end=start;
                
                Arrays.fill(freqcurr,0);
                temp=k;
                while(temp>1 && end.next!=null){
                    freqcurr[end.data - 'a']++;
                    end=end.next;
                    temp--;
                }
                freqcurr[end.data - 'a']++;
                
                //System.out.println(start.data+" "+end.data);
            }
            else{
                freqcurr[start.data - 'a']--;
                start=start.next;
                end=end.next;
                freqcurr[end.data - 'a']++;
                
                //System.out.println(start.data+" "+end.data);
            
            }
        }
        if(end.next==null  && isAnagram(freq,freqcurr)==true){
            //System.out.println("last"+start.data+" "+end.data);
            ans.add(createList(start,end));
        }
        return ans;
    }
}
