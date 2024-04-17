1494. Parallel Courses II

You are given an integer n, which indicates that there are n courses labeled from 1 to n. You are also given an array relations where relations[i] = [prevCoursei, nextCoursei], representing a prerequisite relationship between course prevCoursei and course nextCoursei: course prevCoursei has to be taken before course nextCoursei. Also, you are given the integer k.

In one semester, you can take at most k courses as long as you have taken all the prerequisites in the previous semesters for the courses you are taking.

Return the minimum number of semesters needed to take all courses. The testcases will be generated such that it is possible to take every course.

 

Example 1:


Input: n = 4, relations = [[2,1],[3,1],[1,4]], k = 2
Output: 3
Explanation: The figure above represents the given graph.
In the first semester, you can take courses 2 and 3.
In the second semester, you can take course 1.
In the third semester, you can take course 4.
Example 2:


Input: n = 5, relations = [[2,1],[3,1],[4,1],[1,5]], k = 2
Output: 4
Explanation: The figure above represents the given graph.
In the first semester, you can only take courses 2 and 3 since you cannot take more than two per semester.
In the second semester, you can take course 4.
In the third semester, you can take course 1.
In the fourth semester, you can take course 5.
 

Constraints:

1 <= n <= 15
1 <= k <= n
0 <= relations.length <= n * (n-1) / 2
relations[i].length == 2
1 <= prevCoursei, nextCoursei <= n
prevCoursei != nextCoursei
All the pairs [prevCoursei, nextCoursei] are unique.
The given graph is a directed acyclic graph.


import java.util.ArrayList;
import java.util.List;

public class Solution {
    private List<List<Integer>> adj;  // Adjacency list for courses //
    private int[] dp;  
    private int n, k;  

    public int minNumberOfSemesters(int n, int[][] relations, int k) {
        this.n = n;
        this.k = k;

        adj = new ArrayList<>(n + 1);  
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());  
        }

        // Initialize dp array for memoization // 
        // 2 power 15 is possible so for that bit mask storing the result, each mask represents the course//

        dp = new int[(1 << n) + 1];  
        for (int i = 0; i <= (1 << n); i++) {
            dp[i] = -1;  
        }

        int[] indegree = new int[n + 1];  
        for (int[] rel : relations) {
            int u = rel[0], v = rel[1];
            adj.get(u).add(v);  
            indegree[v]++;  
        }
        
        return helper(0, indegree); //passing 0, as initially no course is selected//
    }

    private int helper(int coursesMask, int[] indegree) {
        if (coursesMask == (1 << n) - 1) {
            return 0;  // All courses completed, return 0 semesters //
        }  
        
        if (dp[coursesMask] != -1) {
            return dp[coursesMask];
        }
            
        List<Integer> validCourses = new ArrayList<>();
        for (int course = 1; course <= n; course++) {
            int courseBit = (coursesMask >> (course - 1)) & 1;
            if (courseBit == 0 && indegree[course] == 0) {
                validCourses.add(course);  // Add courses with indegree 0 and not taken yet //
            }
        }

        int sizeReq = Math.min(k, validCourses.size());  // Calculate courses that can be taken in current semester //
        int combinations = (1 << validCourses.size());  // Calculate total combinations of courses //
        int ans = Integer.MAX_VALUE;  // Initialize answer to maximum value //


        for (int combination = 0; combination < combinations; combination++) {
            
            int coursesSelected = Integer.bitCount(combination);  // Count number of courses selected //
            if (coursesSelected == sizeReq) {
                int[] newIndegree = indegree.clone();
                int newCoursesMask = coursesMask;
                for (int idx = 0; idx < validCourses.size(); idx++) {
                    int bit = (combination >> idx) & 1;
                    if (bit == 1) {
                        int course = validCourses.get(idx);
                        newCoursesMask |= (1 << (course - 1));  // Update courses taken bitmask //
                        for (int cc : adj.get(course)) {
                            newIndegree[cc]--;  // Decrement indegree of dependent courses //
                        }
                    }
                }
                ans = Math.min(ans, helper(newCoursesMask, newIndegree));  
            }
        }
         
    
        return dp[coursesMask] = ans + 1;   //adding 1 for current sem//
    }
}

// Putting it all together:
// The number of recursive calls is O(2^n) due to exploring all possible combinations of courses.
// Within each recursive call, there are loops iterating over valid courses (O(n)) and their combinations (O(2^k)).
// Therefore, the overall time complexity is O(2^n * n * k * 2^k).
 
