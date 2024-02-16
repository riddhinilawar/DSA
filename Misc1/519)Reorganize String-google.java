767. Reorganize String
Node:- Need to find the max freq and check weather it can be kept in alternating way in a string and also others will be managed in the remaining positions.
Given a string s, rearrange the characters of s so that any two adjacent characters are not the same.

Return any possible rearrangement of s or return "" if not possible.

 

Example 1:

Input: s = "aab"
Output: "aba"
Example 2:

Input: s = "aaab"
Output: ""
 

Constraints:

1 <= s.length <= 500
s consists of lowercase English letters.
class Solution {
    public String reorganizeString(String s) {
        int n=s.length();
        int freq[]=new int[26];
        int maxFreq=0;
        char maxChar='-';
        for(char c:s.toCharArray()){
            freq[c-'a']++;
            if(freq[c-'a']>maxFreq){
                maxFreq=freq[c-'a'];
                maxChar=c;
            }
        }

        if(n%2==0 && maxFreq>(n/2))return "";
        if(n%2==1 && maxFreq>(n+1)/2)return "";

        char ans[]=new char[s.length()];
        
        int idx=0;
        while(idx<n && freq[maxChar-'a']>0){
            ans[idx]=maxChar;
            idx+=2;
            freq[maxChar-'a']--;
        }

        for(int i=0;i<26;i++){
            while(freq[i]>0){
                if(idx>=n){
                    idx=1;
                }
                ans[idx]=(char)(i+'a');
                idx+=2;
                freq[i]--;
            }
        }

        return String.valueOf(ans);
    }
}
=========================================================================================================
class Solution {
    public String reorganizeString(String s) {
        int freq[]=new int[26];
        int n=s.length();


        //count the frequency
        for(int i=0;i<n;i++){
            char c=s.charAt(i);
            freq[c-'a']++;
        }

        
        PriorityQueue<Pair> pq=new PriorityQueue<>((a,b)->b.count-a.count);
        StringBuilder sb=new StringBuilder();

        //put the non zero frequencies in priorityqueue
        for(int i=0;i<26;i++){
            if(freq[i]!=0)
                pq.add(new Pair((char)(i+97),freq[i]));
        }


        char prev='-';
        while(!pq.isEmpty()){
            Pair first=pq.remove();
            char firstChar=first.c;
            int firstCount=first.count;

            if(pq.isEmpty() && firstChar==prev)return "";
            else if(firstChar==prev){
                Pair second=pq.remove();
                char secondChar=second.c;
                int secondCount=second.count;
                prev=secondChar;
                sb.append(secondChar);
                if(secondCount>1)pq.add(new Pair(secondChar,secondCount-1));
                pq.add(first);
            }
            else{
                prev=firstChar;
                sb.append(firstChar);
                if(firstCount>1)pq.add(new Pair(firstChar,firstCount-1));
            }
        }

        return sb.toString();
    }
    
}
class Pair{
    char c;
    int count;
    Pair(char c,int count){
        this.c=c;
        this.count=count;
    }        
}
