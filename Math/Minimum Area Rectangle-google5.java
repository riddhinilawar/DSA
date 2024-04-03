939. Minimum Area Rectangle

You are given an array of points in the X-Y plane points where points[i] = [xi, yi].
Return the minimum area of a rectangle formed from these points, with sides parallel to the X and Y axes. If there is not any such rectangle, return 0.

Note:If no rectange formed
    just chceking a and c pint, the slant line
    need to skip if a and c lines on same plane(main trick) 

Example 1:


Input: points = [[1,1],[1,3],[3,1],[3,3],[2,2]]
Output: 4
Example 2:


Input: points = [[1,1],[1,3],[3,1],[3,3],[4,1],[4,3]]
Output: 2
 

Constraints:

1 <= points.length <= 500
points[i].length == 2
0 <= xi, yi <= 4 * 104
All the given points are unique.


class Solution {
    public int minAreaRect(int[][] points) {
        HashMap<Integer,HashSet<Integer>> adjList = new HashMap<>();
        int n=points.length;

        for(int point[]:points){
            adjList.putIfAbsent(point[0],new HashSet<>());
            adjList.get(point[0]).add(point[1]);
        }
        int area=Integer.MAX_VALUE;
        boolean rectangeFormed=false;

        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
               

                int ax=points[i][0];
                int ay=points[i][1];

                int cx=points[j][0];
                int cy=points[j][1];

                int bx=cx;
                int by=ay;

                int dx=ax;
                int dy=cy;
                //System.out.println(ax+" "+ay+" "+bx+" "+by+" "+cx+" "+cy+" "+dx+" "+dy);
                if(ax!=cx && ay!=cy && adjList.containsKey(bx) && adjList.containsKey(dx) && adjList.get(bx).contains(by) && adjList.get(dx).contains(dy)){
                    area=Math.min(area,(Math.abs(ay-dy)*Math.abs(ax-bx)));
                    rectangeFormed=true;
                    //System.out.println(Math.abs(ay-dy)*Math.abs(ax-bx));
                }
            }
        }
        if(rectangeFormed==false){
            return 0;
        }
        return area;
    }
}
