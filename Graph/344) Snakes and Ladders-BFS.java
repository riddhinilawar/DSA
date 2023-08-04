909. Snakes and Ladders

You are given an n x n integer matrix board where the cells are labeled from 1 to n2 in a Boustrophedon style starting from the bottom left of the board (i.e. board[n - 1][0]) and alternating direction each row.
You start on square 1 of the board. In each move, starting from square curr, do the following:
Choose a destination square next with a label in the range [curr + 1, min(curr + 6, n2)].
This choice simulates the result of a standard 6-sided die roll: i.e., there are always at most 6 destinations, regardless of the size of the board.
If next has a snake or ladder, you must move to the destination of that snake or ladder. Otherwise, you move to next.
The game ends when you reach the square n2.
A board square on row r and column c has a snake or ladder if board[r][c] != -1. The destination of that snake or ladder is board[r][c]. Squares 1 and n2 do not have a snake or ladder.
Note that you only take a snake or ladder at most once per move. If the destination to a snake or ladder is the start of another snake or ladder, you do not follow the subsequent snake or ladder.
For example, suppose the board is [[-1,4],[-1,3]], and on the first move, your destination square is 2. You follow the ladder to square 3, but do not follow the subsequent ladder to 4.
Return the least number of moves required to reach the square n2. If it is not possible to reach the square, return -1.
 
Example 1:
 
Input: board = [[-1,-1,-1,-1,-1,-1],[-1,-1,-1,-1,-1,-1],[-1,-1,-1,-1,-1,-1],[-1,35,-1,-1,13,-1],[-1,-1,-1,-1,-1,-1],[-1,15,-1,-1,-1,-1]]
Output: 4
Explanation: 
In the beginning, you start at square 1 (at row 5, column 0).
You decide to move to square 2 and must take the ladder to square 15.
You then decide to move to square 17 and must take the snake to square 13.
You then decide to move to square 14 and must take the ladder to square 35.
You then decide to move to square 36, ending the game.
This is the lowest possible number of moves to reach the last square, so return 4.
Example 2:
Input: board = [[-1,-1],[-1,3]]
Output: 1
 
Constraints:
n == board.length == board[i].length
2 <= n <= 20
board[i][j] is either -1 or in the range [1, n2].
The squares labeled 1 and n2 do not have any ladders or snakes.


class Solution {
    public int snakesAndLadders(int[][] board) {
        HashMap<Integer,ArrayList<Integer>> map = new HashMap<>();
        int n=board.length,squares=n*n;
        int square=1;
        boolean flag=true;
        int count=0;
        boolean vis[]=new boolean[squares+1];

        //converting board to adjlist
        for(int i=n-1;i>=0;i--){
            if(flag==true){
                for(int j=0;j<n;j++){
                    map.put(square,new ArrayList<>());
                    if(board[i][j]!=-1)
                        map.get(square).add(board[i][j]);
                    square++;
                }
               
                flag=false;
            }
            else{
                for(int j=n-1;j>=0;j--){
                    map.put(square,new ArrayList<>());
                    if(board[i][j]!=-1)
                        map.get(square).add(board[i][j]);
                    square++;
                }
                
                flag=true;
            }
        }
        //System.out.println(map);

        //applying bfs
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        int level=1;

        while(!q.isEmpty()){
            int size=q.size();
            //System.out.println("size--> "+size);

            for(int i=0;i<size;i++){
                int curr = q.remove();
                if(vis[curr]==false)
                {
                    vis[curr]=true;
                //System.out.println(curr);

                for(int j=curr+1;j<curr+7;j++){

                    if(j<=squares){

                        if(j==squares || (map.get(j).size()!=0 && map.get(j).get(0)==squares))
                            return level;
                        if(map.get(j).size()==0){
                            q.add(j);
                            //System.out.print("add->"+j+" ");
                        }
                        else{
                            q.add(map.get(j).get(0));
                            //System.out.print("add->"+map.get(j).get(0)+" ");
                        }
                        count++;
                        if(count>((int)Math.pow(squares,6)))return -1;
                    }
                }
                }
            }
            level++;
        }
        return -1;
    }
}

