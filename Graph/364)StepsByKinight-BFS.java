Steps by Knight

Given a square chessboard, the initial position of Knight and position of a target. Find out the minimum steps a Knight will take to reach the target position.
Note:
The initial and the target position coordinates of Knight have been given according to 1-base indexing.
 
Example 1:
Input:
N=6
knightPos[ ] = {4, 5}
targetPos[ ] = {1, 1}
Output:
3
Explanation:
 
Knight takes 3 step to reach from 
(4, 5) to (1, 1):
(4, 5) -> (5, 3) -> (3, 2) -> (1, 1).
 
 
Your Task:
You don't need to read input or print anything. Your task is to complete the function minStepToReachTarget() which takes the initial position of Knight (KnightPos), the target position of Knight (TargetPos), and the size of the chessboard (N) as input parameters and returns the minimum number of steps required by the knight to reach from its current position to the given target position or return -1 if its not possible.
 
Expected Time Complexity: O(N2).
Expected Auxiliary Space: O(N2).
 
Constraints:
1 <= N <= 1000
1 <= Knight_pos(X, Y), Targer_pos(X, Y) <= N



class Solution
{
    //Function to find out minimum steps Knight needs to reach target position.
    public int minStepToReachTarget(int KnightPos[], int TargetPos[], int N)
    {
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(KnightPos[0],KnightPos[1],0));
        int vis[][]=new int[N+1][N+1];
        vis[KnightPos[0]][KnightPos[1]]=1;
        
        int ti=TargetPos[0];
        int tj=TargetPos[1];
        
        if(ti==KnightPos[0] && tj==KnightPos[1])return 0;
        
        int posibilities[][]=new int[][]{{-1,-2},{1,-2},{-1,2},{1,2},{2,-1},{2,1},{-2,-1},{-2,1}};
        
        while(!q.isEmpty()){
            Pair temp=q.poll();
            int i=temp.i;
            int j=temp.j;
            int size=temp.steps;
            
            for(int idx=0;idx<posibilities.length;idx++){
                
                int ni=i+posibilities[idx][0];
                int nj=j+posibilities[idx][1];
                int nSize=size+1;
                
                if(ni>0 && nj>0 && ni<=N &&nj<=N && vis[ni][nj]!=1){
                    vis[ni][nj]=1;
                    if(ni==ti && nj==tj)return nSize;
                    q.add(new Pair(ni,nj,nSize));
                }
                
            }
        }
        
        return -1;
    }
}
class Pair{
    int i;
    int j;
    int steps;
    Pair(int i,int j,int steps){
        this.i=i;
        this.j=j;
        this.steps=steps;
    }
}
