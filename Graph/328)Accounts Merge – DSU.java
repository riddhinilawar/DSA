Accounts Merge – DSU: G-50
Problem Statement: Given a list of accounts where each element account [ i ] is a list of strings, where the first element account [ i ][ 0 ]  is a name, and the rest of the elements are emails representing emails of the account.

Now, we would like to merge these accounts. Two accounts definitely belong to the same person if there is some common email to both accounts. Note that even if two accounts have the same name, they may belong to different people as people could have the same name. A person can have any number of accounts initially, but all of their accounts definitely have the same name.

After merging the accounts, return the accounts in the following format: the first element of each account is the name, and the rest of the elements are emails in sorted order.

Note: Accounts themselves can be returned in any order.

Pre-requisite: Disjoint Set data structure

Examples:

Example 1:
Input: N = 4
accounts [ ] =
[["John","johnsmith@mail.com","john_newyork@mail.com"],
["John","johnsmith@mail.com","john00@mail.com"],
["Mary","mary@mail.com"],
["John","johnnybravo@mail.com"]]

Output: [["John","john00@mail.com","john_newyork@mail.com", "johnsmith@mail.com"],
["Mary","mary@mail.com"],
["John","johnnybravo@mail.com"]]

Explanation: The first and the second John are the same person as they have a common email. But the third Mary and fourth John are not the same as they do not have any common email.  The result can be in any order but the emails must be in sorted order. The following is also a valid result:
[['Mary', 'mary@mail.com'],
['John', 'johnnybravo@mail.com'],
['John', 'john00@mail.com' , 'john_newyork@mail.com', 'johnsmith@mail.com' ]]

Example 2:
Input: N = 6
accounts [ ] =
[["John","j1@com","j2@com","j3@com"],
["John","j4@com"],
["Raj",”r1@com”, “r2@com”],
["John","j1@com","j5@com"],
["Raj",”r2@com”, “r3@com”],
["Mary","m1@com"]]

Output: [["John","j1@com","j2@com","j3@com","j5@com"],
["John","j4@com"],
["Raj",”r1@com”, “r2@com”,  “r3@com”],
["Mary","m1@com"]]

Explanation: The first and the fourth John are the same person here as they have a common email. And the third and the fifth Raj are also the same person. So, the same accounts are merged.
Solution

Disclaimer: Don’t jump directly to the solution, try it out yourself first.

Problem link.

Solution:

Let’s quickly understand the question before moving on to the solution part. According to the question, we can only merge two accounts with the same name only if the accounts contain at least one common email. After merging the accounts accordingly, we should return the answer where for each account the emails must be in the sorted order. But the order of the accounts does not matter. In order to solve this problem we are going to use the Disjoint Set data structure. Now, let’s discuss the approach using the following example:

Given: N = 6
accounts [ ] =
[["John","j1@com","j2@com","j3@com"],
["John","j4@com"],
["Raj",”r1@com”, “r2@com”],
["John","j1@com","j5@com"],
["Raj",”r2@com”, “r3@com”],
["Mary","m1@com"]]
First, we will try to iterate over every single email and add them with their respective indices(i.e. Index of the accounts the email belongs to)  in a map data structure. While doing this, when we will reach out to “j1@com” in the fourth account, we will find that it is already mapped with index 0. This incident means that we are currently in an account that can be merged. So, we will perform the union operation between the current index i.e. 3, and index 0(As in this case, we are following 0-based indexing). It will mean that the ultimate parent of index 3 is index 0. Similarly, this incident will repeat in the case of the third and fifth Raj. So we will perform the union of index 2 and 4. 

After completing the above process, the situation will be like the following:


Now, it’s time to merge the emails. So, we will iterate over each email and will add them to the ultimate parent of the current account’s index. Like, while adding the emails of account 4, we will add them to index 2 as the ultimate parent of 4 is index 2.

Finally, we will sort the emails for each account individually to get our answers in the format specified in the question.

Approach: 
Note: 

Here we will perform the disjoint set operations on the indices of the accounts considering them as the nodes. 
As in each account, the first element is the name, we will start iterating from the second element in each account to visit only the emails sequentially.
The algorithm steps are the following:

First, we will create a map data structure. Then we will store each email with the respective index of the account(the email belongs to) in that map data structure.
While doing so, if we encounter an email again(i.e. If any index is previously assigned for the email), we will perform union(either unionBySize() or unionByRank()) of the current index and the previously assigned index.
After completing step 2, now it’s time to merge the accounts. For merging, we will iterate over all the emails individually and find the ultimate parent(using the findUPar() method) of the assigned index of every email. Then we will add the email of the current account to the index(account index) that is the ultimate parent. Thus the accounts will be merged.
Finally, we will sort the emails for every account separately and store the final results in the answer array accordingly.
Note: If you wish to see the dry run of the above approach, you can watch the video attached to this article.

Code:


import java.io.*;
import java.util.*;



//User function Template for Java
class DisjointSet {
    List<Integer> rank = new ArrayList<>();
    List<Integer> parent = new ArrayList<>();
    List<Integer> size = new ArrayList<>();
    public DisjointSet(int n) {
        for (int i = 0; i <= n; i++) {
            rank.add(0);
            parent.add(i);
            size.add(1);
        }
    }

    public int findUPar(int node) {
        if (node == parent.get(node)) {
            return node;
        }
        int ulp = findUPar(parent.get(node));
        parent.set(node, ulp);
        return parent.get(node);
    }

    public void unionByRank(int u, int v) {
        int ulp_u = findUPar(u);
        int ulp_v = findUPar(v);
        if (ulp_u == ulp_v) return;
        if (rank.get(ulp_u) < rank.get(ulp_v)) {
            parent.set(ulp_u, ulp_v);
        } else if (rank.get(ulp_v) < rank.get(ulp_u)) {
            parent.set(ulp_v, ulp_u);
        } else {
            parent.set(ulp_v, ulp_u);
            int rankU = rank.get(ulp_u);
            rank.set(ulp_u, rankU + 1);
        }
    }

    public void unionBySize(int u, int v) {
        int ulp_u = findUPar(u);
        int ulp_v = findUPar(v);
        if (ulp_u == ulp_v) return;
        if (size.get(ulp_u) < size.get(ulp_v)) {
            parent.set(ulp_u, ulp_v);
            size.set(ulp_v, size.get(ulp_v) + size.get(ulp_u));
        } else {
            parent.set(ulp_v, ulp_u);
            size.set(ulp_u, size.get(ulp_u) + size.get(ulp_v));
        }
    }
}
class Solution {
    static List<List<String>> accountsMerge(List<List<String>> details) {
        int n = details.size();
        DisjointSet ds = new DisjointSet(n);
        HashMap<String, Integer> mapMailNode = new HashMap<String, Integer>();

        for (int i = 0; i < n; i++) {
            for (int j = 1; j < details.get(i).size(); j++) {
                String mail = details.get(i).get(j);
                if (mapMailNode.containsKey(mail) == false) {
                    mapMailNode.put(mail, i);
                } else {
                    ds.unionBySize(i, mapMailNode.get(mail));
                }
            }
        }

        ArrayList<String>[] mergedMail = new ArrayList[n];
        for (int i = 0; i < n; i++) mergedMail[i] = new ArrayList<String>();
        for (Map.Entry<String, Integer> it : mapMailNode.entrySet()) {
            String mail = it.getKey();
            int node = ds.findUPar(it.getValue());
            mergedMail[node].add(mail);
        }

        List<List<String>> ans = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (mergedMail[i].size() == 0) continue;
            Collections.sort(mergedMail[i]);
            List<String> temp = new ArrayList<>();
            temp.add(details.get(i).get(0));
            for (String it : mergedMail[i]) {
                temp.add(it);
            }
            ans.add(temp);
        }
        return ans;

    }
}

class Main {
    public static void main (String[] args) {
        List<List<String>> accounts = new ArrayList() {
            {
                add(new ArrayList<String>(Arrays.asList("John", "j1@com", "j2@com", "j3@com")));
                add(new ArrayList<String>(Arrays.asList("John", "j4@com")));
                add(new ArrayList<String>(Arrays.asList("Raj", "r1@com", "r2@com")));
                add(new ArrayList<String>(Arrays.asList("John", "j1@com", "j5@com")));
                add(new ArrayList<String>(Arrays.asList("Raj", "r2@com", "r3@com")));
                add(new ArrayList<String>(Arrays.asList("Mary", "m1@com")));

            }
        };

        Solution obj = new Solution();
        List<List<String>> ans = obj.accountsMerge(accounts);

        int n = ans.size();
        for (int i = 0; i < n; i++) {
            System.out.print(ans.get(i).get(0) + ": ");
            int size = ans.get(i).size();
            for (int j = 1; j < size; j++) {
                System.out.print(ans.get(i).get(j) + " ");
            }

            System.out.println("");
        }

    }
}
