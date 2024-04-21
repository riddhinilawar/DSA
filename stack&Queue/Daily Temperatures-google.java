739. Daily Temperatures

Given an array of integers temperatures represents the daily temperatures, return an array answer such that answer[i] is the number of days you have to wait after the ith day to get a warmer temperature. If there is no future day for which this is possible, keep answer[i] == 0 instead.

 

Example 1:

Input: temperatures = [73,74,75,71,69,72,76,73]
Output: [1,1,4,2,1,1,0,0]
Example 2:

Input: temperatures = [30,40,50,60]
Output: [1,1,1,0]
Example 3:

Input: temperatures = [30,60,90]
Output: [1,1,0]
 

Constraints:

1 <= temperatures.length <= 105
30 <= temperatures[i] <= 100

class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n=temperatures.length;
        int ans[]=new int[n];

        Stack<Pair> stack = new Stack<>();

        for(int i=n-1;i>=0;i--){
            if(stack.isEmpty()){
                ans[i]=0;
            }
            else{
                while(!stack.isEmpty() && stack.peek().temp<=temperatures[i]){
                    stack.pop();
                }
                if(stack.isEmpty())ans[i]=0;
                else ans[i]=stack.peek().day-i;
            }
            stack.push(new Pair(temperatures[i],i));
        }

        return ans;
    }
}
class Pair{
    int temp;
    int day;
    Pair(int temp,int day){
        this.temp=temp;
        this.day=day;
    }
}


// haven't checked yet, seems unnecessarily complicated

class Solution {
    public int[] dailyTemperatures(int[] temperatures) {

        int n = temperatures.length;
        
        int hottest = 0;
        
        int answer[] = new int[n];
        
        for (int currDay = n - 1; currDay >= 0; currDay--) {

            int currentTemp = temperatures[currDay];

            // hottest temp seen so far moving from the right
            if (currentTemp >= hottest) {
                hottest = currentTemp;
                continue;
            }
            
            int days = 1;

            while (temperatures[currDay + days] <= currentTemp) {
                // Use information from answer to search for the next warmer day
                days += answer[currDay + days];
            }

            answer[currDay] = days;
        }
        
        return answer;
    }
}
