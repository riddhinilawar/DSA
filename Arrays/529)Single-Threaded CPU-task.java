1834. Single-Threaded CPU

Note::
 Step1)create the task class.
 Step2)create task array of int[] size 3 to store id with tasks details.
 Step3)create priority queue to store the next task to be scheduled.
 Step4)while(priority queue is not empty)
 -->put all the available task at current tiem in pq.
 -->process the task
 -->increase the currentime
 -->put all the available task at current tiem in pq.
 -->still pq is empty set the currentime to next available start time

class Solution {
    public int[] getOrder(int[][] inputTasks) {
        int totalTasks=inputTasks.length;
        int[] taskProcessingOrder = new int[totalTasks];
        int taskProcessingOrderIdx=0;

        int tasks[][]=new int[totalTasks][3];
        for(int i=0;i<totalTasks;i++){
            tasks[i][0]=inputTasks[i][0];
            tasks[i][1]=inputTasks[i][1];
            tasks[i][2]=i;
        }
        Arrays.sort(tasks,(task1,task2)->task1[0]-task2[0]);

        PriorityQueue<Task> nextTask = new PriorityQueue<>
        ((task1,task2)->(task1.processingTime==task2.processingTime)?task1.taskId-task2.taskId:task1.processingTime-task2.processingTime);

        int taskIdx=1;
        int currentTime=tasks[0][0];
        nextTask.add(new Task(tasks[0][2],tasks[0][0],tasks[0][1]));

        while(!nextTask.isEmpty()){

            while(taskIdx<totalTasks && tasks[taskIdx][0]<=currentTime){
                nextTask.add(new Task(tasks[taskIdx][2],tasks[taskIdx][0],tasks[taskIdx][1]));
                taskIdx++;
            }
            
            Task task=nextTask.remove();
            int processingTaskId=task.taskId;
            int processingTaskTime=task.processingTime;

            taskProcessingOrder[taskProcessingOrderIdx++]=processingTaskId;
            currentTime+=processingTaskTime;

            if(taskIdx<totalTasks && nextTask.isEmpty() && currentTime<tasks[taskIdx][0]){
                currentTime=tasks[taskIdx][0];
            }

            while(taskIdx<totalTasks && tasks[taskIdx][0]<=currentTime){
                nextTask.add(new Task(tasks[taskIdx][2],tasks[taskIdx][0],tasks[taskIdx][1]));
                taskIdx++;
            }
        }

        return taskProcessingOrder;
    }
}
class Task{
    int taskId;
    int triggerAt;
    int processingTime;
    Task(int taskId,int triggerAt,int processingTime){
        this.taskId=taskId;
        this.triggerAt=triggerAt;
        this.processingTime=processingTime;
    }
}
 
You are given n​​​​​​ tasks labeled from 0 to n - 1 represented by a 2D integer array tasks, where tasks[i] = [enqueueTimei, processingTimei] means that the i​​​​​​th​​​​ task will be available to process at enqueueTimei and will take processingTimei to finish processing.

You have a single-threaded CPU that can process at most one task at a time and will act in the following way:

If the CPU is idle and there are no available tasks to process, the CPU remains idle.
If the CPU is idle and there are available tasks, the CPU will choose the one with the shortest processing time. If multiple tasks have the same shortest processing time, it will choose the task with the smallest index.
Once a task is started, the CPU will process the entire task without stopping.
The CPU can finish a task then start a new one instantly.
Return the order in which the CPU will process the tasks.

 

Example 1:

Input: tasks = [[1,2],[2,4],[3,2],[4,1]]
Output: [0,2,3,1]
Explanation: The events go as follows: 
- At time = 1, task 0 is available to process. Available tasks = {0}.
- Also at time = 1, the idle CPU starts processing task 0. Available tasks = {}.
- At time = 2, task 1 is available to process. Available tasks = {1}.
- At time = 3, task 2 is available to process. Available tasks = {1, 2}.
- Also at time = 3, the CPU finishes task 0 and starts processing task 2 as it is the shortest. Available tasks = {1}.
- At time = 4, task 3 is available to process. Available tasks = {1, 3}.
- At time = 5, the CPU finishes task 2 and starts processing task 3 as it is the shortest. Available tasks = {1}.
- At time = 6, the CPU finishes task 3 and starts processing task 1. Available tasks = {}.
- At time = 10, the CPU finishes task 1 and becomes idle.
Example 2:

Input: tasks = [[7,10],[7,12],[7,5],[7,4],[7,2]]
Output: [4,3,2,0,1]
Explanation: The events go as follows:
- At time = 7, all the tasks become available. Available tasks = {0,1,2,3,4}.
- Also at time = 7, the idle CPU starts processing task 4. Available tasks = {0,1,2,3}.
- At time = 9, the CPU finishes task 4 and starts processing task 3. Available tasks = {0,1,2}.
- At time = 13, the CPU finishes task 3 and starts processing task 2. Available tasks = {0,1}.
- At time = 18, the CPU finishes task 2 and starts processing task 0. Available tasks = {1}.
- At time = 28, the CPU finishes task 0 and starts processing task 1. Available tasks = {}.
- At time = 40, the CPU finishes task 1 and becomes idle.
 

Constraints:

tasks.length == n
1 <= n <= 105
1 <= enqueueTimei, processingTimei <= 109


class Solution {
    public int[] getOrder(int[][] task) {
        int n=task.length;
        int tasks[][]=new int[n][3];
        for(int i=0;i<n;i++){
            tasks[i][0]=task[i][0];
            tasks[i][1]=task[i][1];
            tasks[i][2]=i;
        }
        Arrays.sort(tasks,(a,b)->a[0]-b[0]);

        PriorityQueue<Task> pq = new PriorityQueue<>((a, b) -> a.processing == b.processing ? a.id - b.id : a.processing - b.processing);
        
        int vis[]=new int[n];
        int ans[]=new int[n];
        int ansidx=0;

        

        for(int tsk=0;tsk<n;tsk++){
            if(vis[tsk]==0){

                int currtime=tasks[tsk][0];
                int taskidx=tsk;

                for(int i=taskidx;i<n;i++){
                    if(currtime>=tasks[i][0]){
                        pq.add(new Task(tasks[i][1],tasks[i][0],tasks[i][2]));
                        vis[i]=1;
                        if(i==n-1)taskidx=i+1;
                    }
                    else{
                        taskidx=i;
                        break;
                    }
                }

            while(!pq.isEmpty()){

                if(pq.peek().trigger > currtime)
                    currtime = pq.peek().trigger;

                Task t=pq.remove();
                ans[ansidx]=t.id;
                ansidx++;
                currtime+=t.processing;

                for(int i=taskidx;i<n;i++){
                    if(currtime>=tasks[i][0]){
                        pq.add(new Task(tasks[i][1],tasks[i][0],tasks[i][2]));
                        vis[i]=1;
                        if(i==n-1)taskidx=i+1;
                    }
                    else{
                        taskidx=i;
                        break;
                    }
                }
            }   
            }
        }
        return ans;
    }
}
class Task{
    int processing;
    int trigger;
    int id;
    Task(int processing,int trigger, int id){
        this.processing=processing;
        this.trigger=trigger;
        this.id=id;
    }
}
