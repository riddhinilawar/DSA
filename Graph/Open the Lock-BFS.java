class Solution {
    //Simple BFS Solution//
    //TC:: O(10*10*10*10)40000 different variations


    public int openLock(String[] deadends, String target) {


        HashSet<String> deadendSet = new HashSet<>();
        HashSet<String> vis = new HashSet<>();
        for(String deadend:deadends){
            deadendSet.add(deadend);
        }

        //edge cases//
        if(target.equals("0000"))return 0;
        if(deadendSet.contains("0000"))return -1;
        
        //get the neighbours for the every value//
        HashMap<Character,ArrayList<Character>> neighbours= new HashMap<>();
        getNeighbours(neighbours);

        Queue<Pair> q= new LinkedList<>();
        q.add(new Pair("0000",0));
        vis.add("0000");


        while(!q.isEmpty()){
            Pair p = q.remove();
            
            char currVal[] = p.value.toCharArray();
            int currCost = p.cost;

            //for every position try for every character after and before//
            for(int i=0;i<4;i++){

                char temp = currVal[i];

                for(char neg:neighbours.get(temp)){
                    
                    currVal[i]=neg;
                    String newString = String.valueOf(currVal);
                    
                    if(deadendSet.contains(newString)==false && vis.contains(newString)==false){
                        vis.add(newString);
                        
                        int newCost=1;
                        q.add(new Pair(newString,currCost+newCost));
                        if(newString.equals(target)){
                            return currCost+newCost;
                        }
                    }

                    currVal[i]=temp;
                }
                
            }
        }

        return -1;
    }
    public void getNeighbours(HashMap<Character,ArrayList<Character>> neighbours){
        neighbours.put('0',new ArrayList<>());
        neighbours.get('0').add('1');
        neighbours.get('0').add('9');

        neighbours.put('1',new ArrayList<>());
        neighbours.get('1').add('2');
        neighbours.get('1').add('0');

        neighbours.put('2',new ArrayList<>());
        neighbours.get('2').add('3');
        neighbours.get('2').add('1');

        neighbours.put('3',new ArrayList<>());
        neighbours.get('3').add('4');
        neighbours.get('3').add('2');

        neighbours.put('4',new ArrayList<>());
        neighbours.get('4').add('5');
        neighbours.get('4').add('3');

        neighbours.put('5',new ArrayList<>());
        neighbours.get('5').add('4');
        neighbours.get('5').add('6');

        neighbours.put('6',new ArrayList<>());
        neighbours.get('6').add('7');
        neighbours.get('6').add('5');

        neighbours.put('7',new ArrayList<>());
        neighbours.get('7').add('8');
        neighbours.get('7').add('6');

        neighbours.put('8',new ArrayList<>());
        neighbours.get('8').add('7');
        neighbours.get('8').add('9');

        neighbours.put('9',new ArrayList<>());
        neighbours.get('9').add('0');
        neighbours.get('9').add('8');
    }
}
class Pair{
    String value;
    int cost;
    Pair(String value,int cost){
        this.value=value;
        this.cost=cost;
    }
}

752. Open the Lock

You have a lock in front of you with 4 circular wheels. Each wheel has 10 slots: '0', '1', '2', '3', '4', '5', '6', '7', '8', '9'. The wheels can rotate freely and wrap around: for example we can turn '9' to be '0', or '0' to be '9'. Each move consists of turning one wheel one slot.

The lock initially starts at '0000', a string representing the state of the 4 wheels.

You are given a list of deadends dead ends, meaning if the lock displays any of these codes, the wheels of the lock will stop turning and you will be unable to open it.

Given a target representing the value of the wheels that will unlock the lock, return the minimum total number of turns required to open the lock, or -1 if it is impossible.

 

Example 1:

Input: deadends = ["0201","0101","0102","1212","2002"], target = "0202"
Output: 6
Explanation: 
A sequence of valid moves would be "0000" -> "1000" -> "1100" -> "1200" -> "1201" -> "1202" -> "0202".
Note that a sequence like "0000" -> "0001" -> "0002" -> "0102" -> "0202" would be invalid,
because the wheels of the lock become stuck after the display becomes the dead end "0102".
Example 2:

Input: deadends = ["8888"], target = "0009"
Output: 1
Explanation: We can turn the last wheel in reverse to move from "0000" -> "0009".
Example 3:

Input: deadends = ["8887","8889","8878","8898","8788","8988","7888","9888"], target = "8888"
Output: -1
Explanation: We cannot reach the target without getting stuck.
 

Constraints:

1 <= deadends.length <= 500
deadends[i].length == 4
target.length == 4
target will not be in the list deadends.
target and deadends[i] consist of digits only.
