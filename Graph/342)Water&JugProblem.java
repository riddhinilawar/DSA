365. Water and Jug Problem

You are given two jugs with capacities jug1Capacity and jug2Capacity liters. There is an infinite amount of water supply available. Determine whether it is possible to measure exactly targetCapacity liters using these two jugs.
If targetCapacity liters of water are measurable, you must have targetCapacity liters of water contained within one or both buckets by the end.
Operations allowed:
Fill any of the jugs with water.
Empty any of the jugs.
Pour water from one jug into another till the other jug is completely full, or the first jug itself is empty.
 
Example 1:
Input: jug1Capacity = 3, jug2Capacity = 5, targetCapacity = 4
Output: true
Explanation: The famous Die Hard example 
Example 2:
Input: jug1Capacity = 2, jug2Capacity = 6, targetCapacity = 5
Output: false
Example 3:
Input: jug1Capacity = 1, jug2Capacity = 2, targetCapacity = 3
Output: true
 
Constraints:
1 <= jug1Capacity, jug2Capacity, targetCapacity <= 106

class Solution {
    public boolean canMeasureWater(int jug1Capacity, int jug2Capacity, int targetCapacity) {
        if(jug1Capacity+jug2Capacity<targetCapacity) return false;

        int direction[]={jug1Capacity,-jug1Capacity,jug2Capacity,-jug2Capacity};
        Set<Integer>visit=new HashSet<>();
        Queue<Integer>q=new LinkedList<>();
        q.add(0);
        visit.add(0);

        while(!q.isEmpty()){
            int cur=q.poll();

            for(int e:direction){
                int total=cur+e;
                if(total==targetCapacity){
                    return true;
                }

                if(total<0 || total>jug1Capacity+jug2Capacity || visit.contains(total)){
                    continue;
                }

                visit.add(total);
                q.add(total);
            }
        }
        return false;
    }
}

