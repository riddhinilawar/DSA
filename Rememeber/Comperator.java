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


--------------------------------------------------------------------------------------------


class meetingComparator implements Comparator<meeting>
{
    @Override
    public int compare(meeting o1, meeting o2) 
    {
        if (o1.end < o2.end)
            return -1;
        else if (o1.end > o2.end)
            return 1;
        else if(o1.pos < o2.pos)
            return -1;
        return 1; 
    }
}

==================================================================================

long number = Long.parseLong(n);
List<Long> candidates = new ArrayList<>();
candidates.removeIf(candidate -> candidate == number);

Collections.sort(candidates, (a, b) -> {
    long diffA = Math.abs(a - number);
    long diffB = Math.abs(b - number);
    if (diffA != diffB) return Long.compare(diffA, diffB);
    return Long.compare(a, b);
});
