1730)Shortest Path to Get Food

You are starving and you want to eat food as quickly as possible. You want to find the shortest path to arrive at any food cell.

You are given an m x n character matrix, grid, of these different types of cells:

'*' is your location. There is exactly one '*' cell.
'#' is a food cell. There may be multiple food cells.
'O' is free space, and you can travel through these cells.
'X' is an obstacle, and you cannot travel through these cells.
You can travel to any adjacent cell north, east, south, or west of your current location if there is not an obstacle.

Return the length of the shortest path for you to reach any food cell. If there is no path for you to reach food, return -1.

Link to the original problem

Example 1

img1

Input: grid = [["X","X","X","X","X","X"],["X","*","O","O","O","X"],["X","O","O","#","O","X"],["X","X","X","X","X","X"]]
Output: 3
Explanation: It takes 3 steps to reach the food.
Constraints:

m == grid.length
n == grid[i].length
1 <= m, n <= 200
grid[row][col] is '*', 'X', 'O', or '#'.
The grid contains exactly one '*'.

class Solution {
    // Directions represent movement as up, right, down, left (4-connected grid directions)
    private int[] directions = {-1, 0, 1, 0, -1};

    public int getFood(char[][] grid) {
        int rows = grid.length, cols = grid[0].length;
        Deque<int[]> queue = new ArrayDeque<>();
        // Search for the starting point represented by '*' and add it to the queue
        for (int i = 0; i < rows; ++i) {
            for (int j = 0; j < cols; ++j) {
                if (grid[i][j] == '*') {
                    queue.offer(new int[] {i, j});
                    break; // Exit the loop once the starting point is found
                }
            }
        }

        // Initialize number of steps taken to reach the food
        int steps = 0;
      
        // Perform BFS (Breadth-First Search) to find the shortest path to the food
        while (!queue.isEmpty()) {
            ++steps; // Increment steps at the start of each level of BFS
            for (int size = queue.size(); size > 0; --size) {
                // Poll the current position from the queue
                int[] position = queue.poll();
              
                // Explore all possible next positions using the predefined directions
                for (int k = 0; k < 4; ++k) {
                    int x = position[0] + directions[k];
                    int y = position[1] + directions[k + 1];
                    // Ensure the next position is within the grid boundaries
                    if (x >= 0 && x < rows && y >= 0 && y < cols) {
                        // Check if the food ('#') is found at the current position
                        if (grid[x][y] == '#') {
                            return steps; // Return the number of steps taken
                        }
                        // Mark visited paths as 'X' and add the new cell to the queue if it's open ('O')
                        if (grid[x][y] == 'O') {
                            grid[x][y] = 'X';
                            queue.offer(new int[] {x, y});
                        }
                    }
                }
            }
        }
        // Return -1 if the food cannot be reached
        return -1;
    }
}
