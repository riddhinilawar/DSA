2976. Minimum Cost to Convert String I

You are given two 0-indexed strings source and target, both of length n and consisting of lowercase English letters. You are also given two 0-indexed character arrays original and changed, and an integer array cost, where cost[i] represents the cost of changing the character original[i] to the character changed[i].

You start with the string source. In one operation, you can pick a character x from the string and change it to the character y at a cost of z if there exists any index j such that cost[j] == z, original[j] == x, and changed[j] == y.

Return the minimum cost to convert the string source to the string target using any number of operations. If it is impossible to convert source to target, return -1.

Note that there may exist indices i, j such that original[j] == original[i] and changed[j] == changed[i].

 

Example 1:

Input: source = "abcd", target = "acbe", original = ["a","b","c","c","e","d"], changed = ["b","c","b","e","b","e"], cost = [2,5,5,1,2,20]
Output: 28
Explanation: To convert the string "abcd" to string "acbe":
- Change value at index 1 from 'b' to 'c' at a cost of 5.
- Change value at index 2 from 'c' to 'e' at a cost of 1.
- Change value at index 2 from 'e' to 'b' at a cost of 2.
- Change value at index 3 from 'd' to 'e' at a cost of 20.
The total cost incurred is 5 + 1 + 2 + 20 = 28.
It can be shown that this is the minimum possible cost.
Example 2:

Input: source = "aaaa", target = "bbbb", original = ["a","c"], changed = ["c","b"], cost = [1,2]
Output: 12
Explanation: To change the character 'a' to 'b' change the character 'a' to 'c' at a cost of 1, followed by changing the character 'c' to 'b' at a cost of 2, for a total cost of 1 + 2 = 3. To change all occurrences of 'a' to 'b', a total cost of 3 * 4 = 12 is incurred.
Example 3:

Input: source = "abcd", target = "abce", original = ["a"], changed = ["e"], cost = [10000]
Output: -1
Explanation: It is impossible to convert source to target because the value at index 3 cannot be changed from 'd' to 'e'.
 

Constraints:

1 <= source.length == target.length <= 105
source, target consist of lowercase English letters.
1 <= cost.length == original.length == changed.length <= 2000
original[i], changed[i] are lowercase English letters.
1 <= cost[i] <= 106
original[i] != changed[i]

Floyd Warshall Algorithm
class Solution {
    public long minimumCost(String source, String target, char[] original, char[] changed, int[] cost) {
        int V = 26;
        long[][] matrix = new long[V][V];

        for(int i=0;i<original.length;i++){
            if(matrix[original[i]-'a'][changed[i]-'a']==0)
                matrix[original[i]-'a'][changed[i]-'a']=cost[i];
            else 
                matrix[original[i]-'a'][changed[i]-'a']=Math.min(matrix[original[i]-'a'][changed[i]-'a'],cost[i]);
        }

        shortestDistance(matrix);

        long ans=0;

        for(int i=0;i<source.length();i++){
            char orig=source.charAt(i);
            char targ=target.charAt(i);

            if(orig==targ)continue;

            if(matrix[orig-'a'][targ-'a']==(Long.MAX_VALUE/2))return -1;

            ans+=matrix[orig-'a'][targ-'a'];
        }

        return ans;
    }
     public void shortestDistance(long[][] matrix) {

        int n = matrix.length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][j] = (Long.MAX_VALUE/2);
                }
                if (i == j) matrix[i][j] = 0;
            }
        }

        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = Math.min(matrix[i][j],matrix[i][k] + matrix[k][j]);
                }
            }
        }
    }
}
===================================================================================================
Dijktras/Shortest path algo
class Solution {

    HashMap<Character,ArrayList<Pair>> map = new HashMap<>();
    HashMap<Character,HashMap<Character,Long>> dp = new HashMap<>();

    public long minimumCost(String source, String target, char[] original, char[] changed, int[] cost) {

        for(int i=0;i<original.length;i++){
            map.putIfAbsent(original[i],new ArrayList<>());
            map.get(original[i]).add(new Pair(changed[i],cost[i]));
        }

        long ans=0;

        for(int i=0;i<source.length();i++){
            char orig=source.charAt(i);
            char targ=target.charAt(i);

            if(orig==targ)continue;
            
            if(dp.containsKey(orig) && dp.get(orig).containsKey(targ)){
                ans+=(dp.get(orig).get(targ));
                continue;
            }

            long totalWeight=bfs(orig,targ);
            if(totalWeight==Long.MAX_VALUE){
                return -1l;
            }

            ans+=totalWeight;
            dp.putIfAbsent(orig,new HashMap<>());
            dp.get(orig).put(targ,totalWeight);
        }

        return ans;
    }

    public long bfs(char start,char target){
        Queue<Pair> q= new LinkedList<>();
        q.add(new Pair(start,0));

        long totalWeight=Long.MAX_VALUE;
        HashMap<Character,HashMap<Character,Long>> vis=new HashMap<>();

        while(!q.isEmpty()){

            Pair p=q.remove();
            char c=p.c;
            long weight=p.weight;

            if(map.get(c)!=null){
            for(Pair neg:map.get(c)){
                
                char negc=neg.c;
                long negweight=neg.weight;

                if(negc==target && totalWeight>(weight+negweight)){
                    totalWeight=(weight+negweight);
                }

                if(vis.containsKey(c) && vis.get(c).containsKey(negc)){
                    if(vis.get(c).get(negc)>weight+negweight){
                        q.add(new Pair(negc,weight+negweight));
                        vis.get(c).put(negc,weight+negweight);
                    }
                }
                else{
                    q.add(new Pair(negc,weight+negweight));
                    vis.putIfAbsent(c,new HashMap<>());
                    vis.get(c).put(negc,weight+negweight);
                }

            }
            }

        }

        return totalWeight;
    }
}
class Pair{
    char c;
    long weight;
    Pair(char c,long weight){
        this.c=c;
        this.weight=weight;
    }
}
