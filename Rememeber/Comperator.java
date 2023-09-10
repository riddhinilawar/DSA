class itemComparator implements Comparator<Item>
{
    @Override
    public int compare(Item a, Item b) 
    {
        double r1 = (double)(a.value) / (double)(a.weight); 
        double r2 = (double)(b.value) / (double)(b.weight); 
        if(r1 < r2) return 1; 
        else if(r1 > r2) return -1; 
        else return 0; 
    }
}

Arrays.sort(arr, new itemComparator());
------------------------------------------------------------------------------------------------------------

class Pair{
    int value;
    int weight;
    double div;
    Pair(int value,int weight,double div){
        this.value=value;
        this.weight=weight;
        this.div=div;
    }
    double getDiv(){
        return div;
    }
    
}
class ItemComparator implements Comparator<Pair>{
    @Override
    public int compare(Pair s1, Pair s2) {
    if (s1.getDiv() < s2.getDiv())
        return 1;
    else if (s1.getDiv() > s2.getDiv())
        return -1;
    else
        return 0;
    }
}

 PriorityQueue<Pair> pq = new PriorityQueue<>(new ItemComparator());

-----------------------------------------------------------------------------------------------------------------------------------
With Collection.sort:


class Edge implements Comparable<Edge> {
    int src, dest, weight;
    Edge(int _src, int _dest, int _wt) {
        this.src = _src; this.dest = _dest; this.weight = _wt;
    }
    // Comparator function used for
    // sorting edgesbased on their weight
    public int compareTo(Edge compareEdge) {
        return this.weight - compareEdge.weight;
    }
};

 Collections.sort(edges);

class Edge implements Comparable<Edge> {
    int src, dest, weight;
    Edge(int _src, int _dest, int _wt) {
        this.src = _src; this.dest = _dest; this.weight = _wt;
    }
    // Comparator function used for
    // sorting edgesbased on their weight
    public int compareTo(Edge compareEdge) {
        return this.weight - compareEdge.weight;
    }
};
