
Meeting Rooms II
Medium

Given an array of meeting time intervals consisting of start and end times[[s1,e1],[s2,e2],...](si< ei), find the minimum number of conference rooms required.

Example 1:

Copy
Input:
[[0, 30],[5, 10],[15, 20]]
Output:
 2
Example 2:

Copy
Input:
 [[7,10],[2,4]]

Output:
 1  


public class Main {
    public static void main(String[] args) {
        //int [][] meetings={{0, 30},{5, 10},{15, 20}};
        int [][] meetings={{0, 30},{5, 5},{15, 20}};
        System.out.println(helper(meetings));
    }
    public static int helper(int meetings[][]){
        int n=meetings.length;
        int start[]=new int[n];
        int end[]=new int[n];
        
        for(int i=0;i<n;i++){
            start[i]=meetings[i][0];
            end[i]=meetings[i][1];
        }
        Arrays.sort(start);
        Arrays.sort(end);
        
        int startIdx=0;
        int endIdx=0;
        int roomReq=0;
        int maxRoomReq=0;
        
        while(startIdx<n){
            
            while(endIdx<n && end[endIdx]<=start[startIdx]){
                endIdx++;
                roomReq--;
            }
            roomReq++;
            startIdx++;
            maxRoomReq=Math.max(maxRoomReq,roomReq);
        }
        
        return maxRoomReq;
    }
    
}
