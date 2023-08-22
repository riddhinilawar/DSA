[1,2,3,4,5,] [6,7,8,9]
not possible/possible

while(left <= right){
    int mid = left + (right - left) / 2;
    if(canEatInTime(piles, mid, h)) right = mid - 1;
    else left = mid + 1;
}
return left;


---------------------------------------------------------------------------------------------------------------------------------------------------------------------








----------------------------------------------------------------------------------------------------------------------------------------------------------------------
Koko eating bananas                                                          LC-875
Koko loves to eat bananas. There are n piles of bananas, the ith pile has piles[i] bananas. The guards have gone and will come back in h hours.
Koko can decide her bananas-per-hour eating speed of k. Each hour, she chooses some pile of bananas and eats k bananas from that pile. If the pile has less than k bananas, she eats all of them instead and will not eat any more bananas during this hour.
Koko likes to eat slowly but still wants to finish eating all the bananas before the guards return.
Return the minimum integer k such that she can eat all the bananas within h hours.
 
Example 1:
Input: piles = [3,6,7,11], h = 8
Output: 4
Example 2:
Input: piles = [30,11,23,4,20], h = 5
Output: 30
Example 3:
Input: piles = [30,11,23,4,20], h = 6
Output: 23
 
Constraints:
•	1 <= piles.length <= 104
•	piles.length <= h <= 109
•	1 <= piles[i] <= 109
Expected Time Complexity: O(logn)
Expected Auxiliary Space: O(1)
class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1;
        int right = 1000000000;
        
        while(left <= right){
            int mid = left + (right - left) / 2;
            if(canEatInTime(piles, mid, h)) right = mid - 1;
            else left = mid + 1;
        }
        return left;
    }
    public boolean canEatInTime(int piles[], int k, int h){
        long hours = 0;
        for(int pile : piles){
            int div = pile / k;
            hours += (long)div;
            if(pile % k != 0) hours++;
        }
        System.out.println("hours-->"+hours);
        return hours <= (long)h;
    }
}
