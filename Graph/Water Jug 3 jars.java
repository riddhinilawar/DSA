https://github.com/meetha44/Three-water-jug-problem/blob/master/Water%20Jug%20Problem%20eclipse%20project/src/Main.java

https://github.com/Sam-app/3-Water-Jugs-Problem-Using-DFS/blob/master/src/com/example/WaterJug/usingDFS.java

https://leetcode.com/discuss/interview-question/4773975/Google

========================================Without showing steps===============================
class Solution {
    static class State {
        int[] jugs;    
        State(int[] jugs) {
            this.jugs = jugs;
        }
    }

    public static void main(String[] args) {
        int[] capacities = {3,5};
        int target = 4;

        State state=findSolution(capacities, target);

        if (state != null) {
            printSolution(state);
        } else {
            System.out.println("No solution found.");
        }
    }

    public static State findSolution(int[] capacities, int target) {
        Set<String> visited = new HashSet<>();
        Queue<State> queue = new LinkedList<>();

        State initialState = new State(new int[]{0,0});
        queue.add(initialState);

        while (!queue.isEmpty()) {
            State currentState = queue.poll();
            
            if (containsWater(currentState, target)) {
                return currentState;
            }

            visited.add(Arrays.toString(currentState.jugs));

            for (int i = 0; i < capacities.length; i++) {
                for (int j = 0; j < capacities.length; j++) {
                    if (i != j) {
                        State nextState = pour(currentState, i, j, capacities);
                        if (!visited.contains(Arrays.toString(nextState.jugs))) {
                            queue.add(nextState);
                        }
                    }
                }
                
                State nextState = fill(currentState, i, capacities);
                if (!visited.contains(Arrays.toString(nextState.jugs))) {
                    queue.add(nextState);
                }

                nextState = empty(currentState, i);
                if (!visited.contains(Arrays.toString(nextState.jugs))) {
                    queue.add(nextState);
                }

            }
        }

        return null;
    }

    public static boolean containsWater(State state, int target) {
        int sum=0;
        for (int jug : state.jugs) {
            sum+=jug;
        }
        if(sum==target)return true;
        return false;
    }

    public static State pour(State state, int from, int to, int[] capacities) {
        int[] newJugs = Arrays.copyOf(state.jugs, state.jugs.length);
        int amount = Math.min(newJugs[from], capacities[to] - newJugs[to]);
        newJugs[from] -= amount;
        newJugs[to] += amount;
        return new State(newJugs);
    }

    public static State fill(State state, int jugIndex, int[] capacities) {
        int[] newJugs = Arrays.copyOf(state.jugs, state.jugs.length);
        newJugs[jugIndex] = capacities[jugIndex];
        return new State(newJugs);
    }

    public static State empty(State state, int jugIndex) {
        int[] newJugs = Arrays.copyOf(state.jugs, state.jugs.length);
        newJugs[jugIndex] = 0;
        return new State(newJugs);
    }

    public static void printSolution(State state) {
        for(int jug:state.jugs)
            System.out.print(jug+" ");
        System.out.println();
    }
}
