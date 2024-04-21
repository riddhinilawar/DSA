621. Task Scheduler

You are given an array of CPU tasks, each represented by letters A to Z, and a cooling time, n. Each cycle or interval allows the completion of one task. Tasks can be completed in any order, but there's a constraint: identical tasks must be separated by at least n intervals due to cooling time.

​Return the minimum number of intervals required to complete all tasks.

 

Example 1:

Input: tasks = ["A","A","A","B","B","B"], n = 2

Output: 8

Explanation: A possible sequence is: A -> B -> idle -> A -> B -> idle -> A -> B.

After completing task A, you must wait two cycles before doing A again. The same applies to task B. In the 3rd interval, neither A nor B can be done, so you idle. By the 4th cycle, you can do A again as 2 intervals have passed.

Example 2:

Input: tasks = ["A","C","A","B","D","B"], n = 1

Output: 6

Explanation: A possible sequence is: A -> B -> C -> D -> A -> B.

With a cooling interval of 1, you can repeat a task after just one other task.

Example 3:

Input: tasks = ["A","A","A", "B","B","B"], n = 3

Output: 10

Explanation: A possible sequence is: A -> B -> idle -> idle -> A -> B -> idle -> idle -> A -> B.

There are only two types of tasks, A and B, which need to be separated by 3 intervals. This leads to idling twice between repetitions of these tasks.

 

Constraints:

1 <= tasks.length <= 104
tasks[i] is an uppercase English letter.
0 <= n <= 100


public class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] counter = new int[26]; // Initialize an array to count occurrences of each task
        
        int max = 0; // Variable to store the maximum occurrence of a task
        int maxCount = 0; // Variable to store the count of tasks with maximum occurrence
        
        // Iterate through the tasks to count occurrences and find the maximum occurrence
        for (char task : tasks) {
            counter[task - 'A']++; // Increment the count for the current task
            if (max == counter[task - 'A']) {
                maxCount++; // If current task count matches max, increment maxCount
            } else if (max < counter[task - 'A']) {
                max = counter[task - 'A']; // Update max if a higher count is found
                maxCount = 1; // Reset maxCount to 1 for the new maximum count
            }
        }

        int partCount = max - 1; // Calculate the number of partitions between repetitions
        
        int partLength = n - (maxCount - 1); // Calculate the length of each partition respecting cooling time
        
        int emptySlots = partCount * partLength; // Calculate total empty slots in the partitions
        
        int availableTasks = tasks.length - max * maxCount; // Calculate tasks that can fill empty slots
        
        int idles = Math.max(0, emptySlots - availableTasks); // Calculate the number of idles needed
        
        return tasks.length + idles; // Return total intervals needed including idles
    }
}
