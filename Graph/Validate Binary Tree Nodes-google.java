1361. Validate Binary Tree Nodes

You have n binary tree nodes numbered from 0 to n - 1 where node i has two children leftChild[i] and rightChild[i], return true if and only if all the given nodes form exactly one valid binary tree.

If node i has no left child then leftChild[i] will equal -1, similarly for the right child.

Note that the nodes have no values and that we only use the node numbers in this problem.

 

Example 1:


Input: n = 4, leftChild = [1,-1,3,-1], rightChild = [2,-1,-1,-1]
Output: true
Example 2:


Input: n = 4, leftChild = [1,-1,3,-1], rightChild = [2,3,-1,-1]
Output: false
Example 3:


Input: n = 2, leftChild = [1,0], rightChild = [-1,-1]
Output: false
 

Constraints:

n == leftChild.length == rightChild.length
1 <= n <= 104
-1 <= leftChild[i], rightChild[i] <= n - 1

class Solution {
    public boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {
        DisjointSet dsu = new DisjointSet(n);
        int inDegree[]=new int[n];

        for(int i=0;i<n;i++){
            int parent=i;
            int leftNode=leftChild[i];
            int rightNode=rightChild[i];

            if(leftNode!=-1){
                if(dsu.findUPar(leftNode) == dsu.findUPar(parent))
                    return false;
                
                //need to check for indegree, because 2 nodes can't be the parent on single node//
                //n=3,[-1,-1,1],[1,-1,-1] ->false (0->1<-2) indegree of 1 becomes 2 in such cases return false//

                if(inDegree[leftNode]==1)
                    return false;
                inDegree[leftNode]++;
                
                dsu.unionBySize(leftNode,parent);
            }
            if(rightNode!=-1){
                if(dsu.findUPar(rightNode) == dsu.findUPar(parent))
                    return false;
                
                //need to check for indegree, because 2 nodes can't be the parent on single node//
                if(inDegree[rightNode]==1)
                    return false;
                
                inDegree[rightNode]++;
                dsu.unionBySize(rightNode,parent);
            }
        }
        //the ultimate parent size at the end should be equal to n//
        if(dsu.size.get(dsu.findUPar(0))!=n)return false;
        return true;
    }
}
class DisjointSet {
    List<Integer> parent = new ArrayList<>();
    List<Integer> size = new ArrayList<>();
    public DisjointSet(int n) {
        for (int i = 0; i <= n; i++) {
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
