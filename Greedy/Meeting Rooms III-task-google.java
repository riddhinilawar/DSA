2402. Meeting Rooms III

Note:: sort the meeting by start time..traver over all the meetings..
  find the room at which meeting can be exceuted..update the end time of that meeting room.
  
You are given an integer n. There are n rooms numbered from 0 to n - 1.

You are given a 2D integer array meetings where meetings[i] = [starti, endi] means that a meeting will be held during the half-closed time interval [starti, endi). All the values of starti are unique.

Meetings are allocated to rooms in the following manner:

Each meeting will take place in the unused room with the lowest number.
If there are no available rooms, the meeting will be delayed until a room becomes free. The delayed meeting should have the same duration as the original meeting.
When a room becomes unused, meetings that have an earlier original start time should be given the room.
Return the number of the room that held the most meetings. If there are multiple rooms, return the room with the lowest number.

A half-closed interval [a, b) is the interval between a and b including a and not including b.

 

Example 1:

Input: n = 2, meetings = [[0,10],[1,5],[2,7],[3,4]]
Output: 0
Explanation:
- At time 0, both rooms are not being used. The first meeting starts in room 0.
- At time 1, only room 1 is not being used. The second meeting starts in room 1.
- At time 2, both rooms are being used. The third meeting is delayed.
- At time 3, both rooms are being used. The fourth meeting is delayed.
- At time 5, the meeting in room 1 finishes. The third meeting starts in room 1 for the time period [5,10).
- At time 10, the meetings in both rooms finish. The fourth meeting starts in room 0 for the time period [10,11).
Both rooms 0 and 1 held 2 meetings, so we return 0. 
Example 2:

Input: n = 3, meetings = [[1,20],[2,10],[3,5],[4,9],[6,8]]
Output: 1
Explanation:
- At time 1, all three rooms are not being used. The first meeting starts in room 0.
- At time 2, rooms 1 and 2 are not being used. The second meeting starts in room 1.
- At time 3, only room 2 is not being used. The third meeting starts in room 2.
- At time 4, all three rooms are being used. The fourth meeting is delayed.
- At time 5, the meeting in room 2 finishes. The fourth meeting starts in room 2 for the time period [5,10).
- At time 6, all three rooms are being used. The fifth meeting is delayed.
- At time 10, the meetings in rooms 1 and 2 finish. The fifth meeting starts in room 1 for the time period [10,12).
Room 0 held 1 meeting while rooms 1 and 2 each held 2 meetings, so we return 1. 
 

Constraints:

1 <= n <= 100
1 <= meetings.length <= 105
meetings[i].length == 2
0 <= starti < endi <= 5 * 105
All the values of starti are unique.

class Solution {
    public int mostBooked(int n, int[][] meetings) {
        int[] ans = new int[n];
        long[] times = new long[n];
        Arrays.sort(meetings, (a, b) -> Integer.compare(a[0], b[0]));

        for (int i = 0; i < meetings.length; i++) {
            int start = meetings[i][0], end = meetings[i][1];
            boolean flag = false;
            int minind = -1;
            long val = Long.MAX_VALUE;
            for (int j = 0; j < n; j++) {
                if (times[j] < val) {
                    val = times[j];
                    minind = j;
                }
                if (times[j] <= start) {
                    flag = true;
                    ans[j]++;
                    times[j] = end;
                    break;
                }
            }
            if (!flag) {
                ans[minind]++;
                times[minind] += (end - start);
            }
        }

        int maxi = -1, id = -1;
        for (int i = 0; i < n; i++) {
            if (ans[i] > maxi) {
                maxi = ans[i];
                id = i;
            }
        }
        return id;
    }
}




=====================================================tle=======================================
class Solution {
    public int mostBooked(int totalRooms, int[][] meetings) {
        
        int totalMeetings=meetings.length;
        int meetingIdx=0;

        //sort the meetings array with start time
        Arrays.sort(meetings,(a,b)->a[0]-b[0]);

        //Create priority queue to store the next available room
        PriorityQueue<Integer> nextAvailableRoom=new PriorityQueue<>((a,b)->(a-b));

        //put all the available rooms in priority queue
        for(int idx=0;idx<totalRooms;idx++){
            nextAvailableRoom.add(idx);
        }

        //create the priorityQueue to get the next task that should be executed
        PriorityQueue<int[]> nextMeeting=new PriorityQueue<>((a,b)->(a[0]-b[0]));

        //to store the count of meeting held in the room
        int meetingsHeld[]=new int[totalRooms];

        //create the priorityQueue to store the details of processing meetings according to end time
        PriorityQueue<int[]> processingMeetings=new PriorityQueue<>((a,b)->(a[1]-b[1]));

        int currTime=meetings[0][0];
        

        while(currTime<=meetings[totalMeetings-1][1] || !nextMeeting.isEmpty()){
            //System.out.println(currTime);
            while(!processingMeetings.isEmpty() && processingMeetings.peek()[1]<=currTime){
                int meetingDetails[]=processingMeetings.remove();
                nextAvailableRoom.add(meetingDetails[2]);
                //System.out.println("removing::"+meetingDetails[0]+" "+meetingDetails[1]+" "+meetingDetails[2]);
            }

            while(meetingIdx<totalMeetings && meetings[meetingIdx][0]<=currTime){
                //System.out.println("Adding::"+meetings[meetingIdx][0]+" "+meetings[meetingIdx][1]);
                nextMeeting.add(meetings[meetingIdx]);
                meetingIdx++;
            }

            while(!nextAvailableRoom.isEmpty() && !nextMeeting.isEmpty()){
                int getRoom=nextAvailableRoom.remove();
                int nextMeet[]=nextMeeting.remove();
                //System.out.println("processing::"+getRoom+" "+nextMeet[0]+" "+nextMeet[1]);
                meetingsHeld[getRoom]++;

                if(nextMeet[0]!=currTime){
                    int delay=currTime-nextMeet[0];
                    processingMeetings.add(new int[]{nextMeet[0]+delay,nextMeet[1]+delay,getRoom});
                }
                else
                    processingMeetings.add(new int[]{nextMeet[0],nextMeet[1],getRoom});
            }

            currTime++;
        }

        int maxMeetingsRoom=0;
        int maxMeetingsInSingleRoomCount=0;

        for(int i=0;i<totalRooms;i++){
            if(maxMeetingsInSingleRoomCount<meetingsHeld[i]){
                maxMeetingsInSingleRoomCount=meetingsHeld[i];
                maxMeetingsRoom=i;
            }
        }
        return maxMeetingsRoom;

    }
}
