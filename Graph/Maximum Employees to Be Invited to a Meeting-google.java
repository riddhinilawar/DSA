2127. Maximum Employees to Be Invited to a Meeting


A company is organizing a meeting and has a list of n employees, waiting to be invited. They have arranged for a large circular table, capable of seating any number of employees.

The employees are numbered from 0 to n - 1. Each employee has a favorite person and they will attend the meeting only if they can sit next to their favorite person at the table. The favorite person of an employee is not themself.

Given a 0-indexed integer array favorite, where favorite[i] denotes the favorite person of the ith employee, return the maximum number of employees that can be invited to the meeting.

 

Example 1:


Input: favorite = [2,2,1,2]
Output: 3
Explanation:
The above figure shows how the company can invite employees 0, 1, and 2, and seat them at the round table.
All employees cannot be invited because employee 2 cannot sit beside employees 0, 1, and 3, simultaneously.
Note that the company can also invite employees 1, 2, and 3, and give them their desired seats.
The maximum number of employees that can be invited to the meeting is 3. 
Example 2:

Input: favorite = [1,2,0]
Output: 3
Explanation: 
Each employee is the favorite person of at least one other employee, and the only way the company can invite them is if they invite every employee.
The seating arrangement will be the same as that in the figure given in example 1:
- Employee 0 will sit between employees 2 and 1.
- Employee 1 will sit between employees 0 and 2.
- Employee 2 will sit between employees 1 and 0.
The maximum number of employees that can be invited to the meeting is 3.
Example 3:


Input: favorite = [3,0,1,4,1]
Output: 4
Explanation:
The above figure shows how the company will invite employees 0, 1, 3, and 4, and seat them at the round table.
Employee 2 cannot be invited because the two spots next to their favorite employee 1 are taken.
So the company leaves them out of the meeting.
The maximum number of employees that can be invited to the meeting is 4.
 

Constraints:

n == favorite.length
2 <= n <= 105
0 <= favorite[i] <= n - 1
favorite[i] != i



class Solution {
    public int maximumInvitations(int[] favorite) {
        HashMap<Integer,ArrayList<Integer>> adjList = new HashMap<>();
        HashMap<Integer,ArrayList<Integer>> revAdjList = new HashMap<>();

        int n=favorite.length;
        for(int i=0;i<n;i++){

            adjList.putIfAbsent(i,new ArrayList<>());
            revAdjList.putIfAbsent(favorite[i],new ArrayList<>());

            adjList.get(i).add(favorite[i]);
            revAdjList.get(favorite[i]).add(i);
        }

        int ans=0;
        int levelArr[]=new int[n];
        boolean visited[]=new boolean[n];
        int iteration[]=new int[n];


        int ansFromCycle=0;
        int ansFromInterdependent=0;

        Arrays.fill(iteration,-1);
        for(int node=0;node<n;node++){
            if(visited[node]==false){
                int count=dfs(node,adjList,levelArr,n,1,visited,node,iteration);
                //System.out.println("count:::"+count);
                if(count==Integer.MAX_VALUE){
                    continue;
                }

                if(count>0){
                    ansFromCycle=Math.max(count,ansFromCycle);
                    continue;
                }

                count=-count;

                int node1=count;
                int node2=adjList.get(count).get(0);
                //System.out.println("nodes:"+count+" "+node1+" "+node2);
                ansFromInterdependent+= 2+findMaxBranch(node1,node2,revAdjList,visited,node,iteration)+findMaxBranch(node2,node1,revAdjList,visited,node,iteration);
                //System.out.println("ans::"+ans+"========================");
            }
        }

        return Math.max(ansFromCycle,ansFromInterdependent);
    }
    public int dfs(int curr,HashMap<Integer,ArrayList<Integer>> adjList,int[] levelArr,int n,int level,boolean visited[],int start,int iteration[]){
       // System.out.println("In "+start+" "+iteration[curr]+" "+curr);
        if(iteration[curr]!=-1 && iteration[curr]!=start)return Integer.MAX_VALUE;
        iteration[curr]=start;
        visited[curr]=true;
        if(levelArr[curr]!=0){
            if(level-levelArr[curr]!=2)return level-levelArr[curr];//if no interdependent node found return cycle length
            else return -curr;//return -node if you found interdependent node
        }
        levelArr[curr]=level;

        int temp=dfs(adjList.get(curr).get(0),adjList,levelArr,n,level+1,visited,start,iteration);
        if(temp!=Integer.MAX_VALUE){
            return temp;
        }

        return Integer.MAX_VALUE;
    }
    public int findMaxBranch(int curr,int interdependent,HashMap<Integer,ArrayList<Integer>> revAdjList,boolean visited[],int start,int iteration[]){
        //System.out.println("vis::"+curr);
        visited[curr]=true;
        iteration[curr]=start;
        int total=0;
        if(revAdjList.get(curr)!=null){
        for(int neg:revAdjList.get(curr)){
            if(neg==interdependent){
                continue;
            }
            total=Math.max(total,1+findMaxBranch(neg,interdependent,revAdjList,visited,start,iteration));
        }
        }
        return total;
    }
}


/*


Some testcases to try before submitting :
[1,0,0,2,1,4,7,8,9,6,7,10,8]
[1,0,3,2,5,6,7,4,9,8,11,10,11,12,10]
*/
