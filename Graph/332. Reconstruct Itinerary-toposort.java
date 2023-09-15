You are given a list of airline tickets where tickets[i] = [fromi, toi] represent the departure and the arrival airports of one flight. Reconstruct the itinerary in order and return it.

All of the tickets belong to a man who departs from "JFK", thus, the itinerary must begin with "JFK". If there are multiple valid itineraries, you should return the itinerary that has the smallest lexical order when read as a single string.

For example, the itinerary ["JFK", "LGA"] has a smaller lexical order than ["JFK", "LGB"].
You may assume all tickets form at least one valid itinerary. You must use all the tickets once and only once.

 

Example 1:


Input: tickets = [["MUC","LHR"],["JFK","MUC"],["SFO","SJC"],["LHR","SFO"]]
Output: ["JFK","MUC","LHR","SFO","SJC"]
Example 2:


Input: tickets = [["JFK","SFO"],["JFK","ATL"],["SFO","ATL"],["ATL","JFK"],["ATL","SFO"]]
Output: ["JFK","ATL","JFK","SFO","ATL","SFO"]
Explanation: Another possible reconstruction is ["JFK","SFO","ATL","JFK","ATL","SFO"] but it is larger in lexical order.
 

Constraints:

1 <= tickets.length <= 300
tickets[i].length == 2
fromi.length == 3
toi.length == 3
fromi and toi consist of uppercase English letters.
fromi != toi


class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
        Map<String, PriorityQueue<String>> graph = new HashMap<>();
        
        for (List<String> ticket : tickets) {
            graph.putIfAbsent(ticket.get(0), new PriorityQueue<>());
            graph.get(ticket.get(0)).add(ticket.get(1));
        }
        
        LinkedList<String> itinerary = new LinkedList<>();
        
        dfs("JFK", graph, itinerary);
        
        return itinerary;
    }
    
    private void dfs(String airport, Map<String, PriorityQueue<String>> graph, LinkedList<String> itinerary) {
         System.out.println("start-->"+airport);
        PriorityQueue<String> nextAirports = graph.get(airport);
        while (nextAirports != null && !nextAirports.isEmpty()) {
            dfs(nextAirports.poll(), graph, itinerary);
        }
        System.out.println("end-->"+airport);
        itinerary.addFirst(airport);
    }
}


======================================================================================================================================

 class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
        Map<String, List<String>> graph = new HashMap<>();
        HashMap<String,HashMap<String,Integer>> vis = new HashMap<>();

        for (List<String> ticket : tickets) {
            graph.putIfAbsent(ticket.get(0), new ArrayList<>());
            graph.get(ticket.get(0)).add(ticket.get(1));
            
            
            vis.putIfAbsent(ticket.get(0),new HashMap<>());
            int temp=0;
            if(vis.get(ticket.get(0)).containsKey(ticket.get(1))){
                temp=vis.get(ticket.get(0)).get(ticket.get(1));
            }
            vis.get(ticket.get(0)).put(ticket.get(1),temp+1);

        }

        for(String airport:graph.keySet()){
            Collections.sort(graph.get(airport));
        }
        
        LinkedList<String> itinerary = new LinkedList<>();
        
        dfs("JFK", graph, itinerary,vis);
        
        return itinerary;
    }
    
    private void dfs(String airport, Map<String, List<String>> graph, LinkedList<String> itinerary, HashMap<String,HashMap<String,Integer>> vis) {

        
        if(graph.containsKey(airport)==true){
            for(String negAirports:graph.get(airport)){
                if(vis.containsKey(airport) && vis.get(airport).containsKey(negAirports) && vis.get(airport).get(negAirports)>0){

                    int temp=vis.get(airport).get(negAirports);
                    vis.get(airport).put(negAirports, temp-1);

                    dfs(negAirports, graph, itinerary,vis);
                }
            }
        }

        //System.out.println("end-->"+airport);
        itinerary.addFirst(airport);
    }
}
