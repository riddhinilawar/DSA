https://github.com/meetha44/Three-water-jug-problem/blob/master/Water%20Jug%20Problem%20eclipse%20project/src/Main.java

https://github.com/Sam-app/3-Water-Jugs-Problem-Using-DFS/blob/master/src/com/example/WaterJug/usingDFS.java

https://leetcode.com/discuss/interview-question/4773975/Google

========================================With all steps===============================
import java.util.*;

public class Solution {

    static class State {
        int[] jugs;
        State parent;

        State(int[] jugs, State parent) {
            this.jugs = Arrays.copyOf(jugs, jugs.length);
            this.parent = parent;
        }
    }

    public static void main(String[] args) {
        int[] capacities = {2, 1, 3};
        int target = 4;

        State solution = findSolution(capacities, target);

        if (solution != null) {
            printSolution(solution);
        } else {
            System.out.println("No solution found.");
        }
    }

    public static State findSolution(int[] capacities, int target) {
        Set<String> visited = new HashSet<>();
        Queue<State> queue = new LinkedList<>();

        State initialState = new State(new int[capacities.length], null);
        queue.add(initialState);

        while (!queue.isEmpty()) {
            State current = queue.poll();
            if (containsWater(current.jugs, target)) {
                return current;
            }

            visited.add(Arrays.toString(current.jugs));

            for (int i = 0; i < capacities.length; i++) {
                for (int j = 0; j < capacities.length; j++) {
                    if (i != j) {
                        State nextState = pour(current, i, j, capacities);
                        if (!visited.contains(Arrays.toString(nextState.jugs))) {
                            queue.add(nextState);
                        }
                    }
                }
                State nextState = fill(current, i, capacities);
                if (!visited.contains(Arrays.toString(nextState.jugs))) {
                    queue.add(nextState);
                }

                nextState = empty(current, i);
                if (!visited.contains(Arrays.toString(nextState.jugs))) {
                    queue.add(nextState);
                }
            }
        }

        return null;
    }

    public static boolean containsWater(int[] jugs, int target) {
        int sum=0;
        for (int jug : jugs) {
            sum+=jug;
        }
        if (sum == target) {
            return true;
        }
        return false;
    }

    public static State pour(State state, int from, int to, int[] capacities) {
        int[] newJugs = Arrays.copyOf(state.jugs, state.jugs.length);
        int amount = Math.min(newJugs[from], capacities[to] - newJugs[to]);
        newJugs[from] -= amount;
        newJugs[to] += amount;
        return new State(newJugs, state);
    }

    public static State fill(State state, int jugIndex, int[] capacities) {
        int[] newJugs = Arrays.copyOf(state.jugs, state.jugs.length);
        newJugs[jugIndex] = capacities[jugIndex];
        return new State(newJugs, state);
    }

    public static State empty(State state, int jugIndex) {
        int[] newJugs = Arrays.copyOf(state.jugs, state.jugs.length);
        newJugs[jugIndex] = 0;
        return new State(newJugs, state);
    }

    public static void printSolution(State solution) {
        List<String> steps = new ArrayList<>();
        while (solution != null) {
            steps.add(Arrays.toString(solution.jugs));
            solution = solution.parent;
        }
        Collections.reverse(steps);
        for (String step : steps) {
            System.out.println(step);
        }
    }
}
