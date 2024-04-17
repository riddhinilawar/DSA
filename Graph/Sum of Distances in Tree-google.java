class Solution {

    //to store the cost of the node, and return it ans answer
    int[] cost;

    //to store that for particular node, 
    //how many nodes are present below it, including self.
    int[] count;
    
    //toalNodes in array
    int totalNodes;

    ArrayList<ArrayList<Integer>> adjList;
    public int[] sumOfDistancesInTree(int N, int[][] edges) {
        
        //normal initialization and creation of adjList
        cost = new int[N];
        count = new int[N];
        this.totalNodes=N;
        adjList = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i < N ; ++i)
            adjList.add(new ArrayList<Integer>());
        for (int[] e : edges) {
            adjList.get(e[0]).add(e[1]);
            adjList.get(e[1]).add(e[0]);
        }

        //In the dfs, we finds out the cost of root node i.e.,0. 
        //here we get the totaledges 0 node requires to go every other node.
        dfsToGetRootsCost(0, -1);

        //In this dfs, we have the cost of 0, it means parent node, 
        //from parent node we are trying to find the cost of its neighbours(or)child nodes.
        dfsToGetOtherNodesCost(0,-1);
       
        return cost;
    }

    public Pair dfsToGetRootsCost(int node, int pre) {
        Pair currentNode = new Pair(1,0);
        for (int neg : adjList.get(node)) {
            if (neg == pre) continue;
            Pair temp=dfsToGetRootsCost(neg, node);

            currentNode.value+=temp.nodes;
            currentNode.value+=temp.value;  
            currentNode.nodes+=temp.nodes;
        }
        //cost::cost of all the negibours + totalNumber no nodes below self
        cost[node]=currentNode.value;
        //count::total nodes which are decendent including self
        count[node]=currentNode.nodes;
        return currentNode;
    }


    public void dfsToGetOtherNodesCost(int node, int pre) {
        for (int neg : adjList.get(node)) {
            if (neg == pre) continue;
            //if you know the cost of the parent,
            //so how much you are adding to the parent just minus that 
            //reason::because now will from the edge with parents and its above elements
            //so remove below edges that is (nodes below u including you)
            //so add your value that would be 
            //(totalNodes-nodes under me==nodes conidering parent and its above nodes) 
            //here parent is node, child is neg

            int parentsCost=cost[node];
            int chlidAndBelowNodes=count[neg];
            int parentAndAboveNode=totalNodes - count[neg];
            //calculate cost for child node.
            cost[neg] = parentsCost - chlidAndBelowNodes + parentAndAboveNode;
            dfsToGetOtherNodesCost(neg, node);
        }
    }
}
class Pair{
    //node::totalnodes present below that node including self
    //value::from the particulat node to below nodes, what is the cost of moving
    int nodes;
    int value;
    Pair(int nodes,int value){
        this.nodes=nodes;
        this.value=value;
    }
}
