1136. Parallel Courses
Playground link::https://leetcode.com/playground/2gpXeJkF
Note::Normal toposort
1)detect the cycle if exist return -1
2)check how many levels are required using khan's algorithm to complete the bfs.
  
There are N courses, labelled from 1 to N.

We are given relations[i] = [X, Y], representing a prerequisite relationship between course X and course Y: course X has to be studied before course Y.

In one semester you can study any number of courses as long as you have studied all the prerequisites for the course you are studying.

Return the minimum number of semesters needed to study all courses.  If there is no way to study all the courses, return -1.

 

Example 1:



Input: N = 3, relations = [[1,3],[2,3]]
Output: 2
Explanation: 
In the first semester, courses 1 and 2 are studied. In the second semester, course 3 is studied.
Example 2:



Input: N = 3, relations = [[1,2],[2,3],[3,1]]
Output: -1
Explanation: 
No course can be studied because they depend on each other.
 

Note:

1 <= N <= 5000
1 <= relations.length <= 5000
relations[i][0] != relations[i][1]
There are no repeated relations in the input..

  // "static void main" must be defined in a public class.
public class Main {
    public static void main(String[] args) {
       
        // int N = 3;
        // int[][] relations = {{1,3},{2,3}};
        
        int N = 3;
        int[][] relations = {{1,2},{2,3},{3,1}};
        
        int temp[]=noOfSemesters(N,relations);
        if(temp[0]==N){
            System.out.println(temp[1]);
            return;
        }
        System.out.println(-1);
    }
    public static int[] noOfSemesters(int n,int relations[][]){
        Queue<Integer> q = new LinkedList<>();
        int indegree[]=new int[n+1];
        HashMap<Integer,ArrayList<Integer>> adjList = new HashMap<>();
        
        
        for(int i=0;i<relations.length;i++){
            adjList.putIfAbsent(relations[i][0],new ArrayList<>());
            adjList.get(relations[i][0]).add(relations[i][1]);
            indegree[relations[i][1]]++;
        }
        
        
        for(int i=1;i<n;i++){
            if(indegree[i]==0){
                q.add(i);
            }
        }
        
        int level=0;
        int vis=0;
        
        while(!q.isEmpty()){
            int size=q.size();
            for(int i=0;i<size;i++){
                int curr=q.remove();
                vis++;
                if(adjList.get(curr)!=null){
                    for(int neg:adjList.get(curr)){
                        indegree[neg]--;
                        if(indegree[neg]==0){
                            q.add(neg);
                        }
                    }
                }
            }
            level++;
        }
        
        return new int[]{vis,level};
    }
}
