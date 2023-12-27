2975. Maximum Square Area by Removing Fences From a Field

There is a large (m - 1) x (n - 1) rectangular field with corners at (1, 1) and (m, n) containing some horizontal and vertical fences given in arrays hFences and vFences respectively.

Horizontal fences are from the coordinates (hFences[i], 1) to (hFences[i], n) and vertical fences are from the coordinates (1, vFences[i]) to (m, vFences[i]).

Return the maximum area of a square field that can be formed by removing some fences (possibly none) or -1 if it is impossible to make a square field.

Since the answer may be large, return it modulo 109 + 7.

Note: The field is surrounded by two horizontal fences from the coordinates (1, 1) to (1, n) and (m, 1) to (m, n) and two vertical fences from the coordinates (1, 1) to (m, 1) and (1, n) to (m, n). These fences cannot be removed.

 

Example 1:



Input: m = 4, n = 3, hFences = [2,3], vFences = [2]
Output: 4
Explanation: Removing the horizontal fence at 2 and the vertical fence at 2 will give a square field of area 4.
Example 2:



Input: m = 6, n = 7, hFences = [2], vFences = [4]
Output: -1
Explanation: It can be proved that there is no way to create a square field by removing fences.
 

Constraints:

3 <= m, n <= 109
1 <= hFences.length, vFences.length <= 600
1 < hFences[i] < m
1 < vFences[i] < n
hFences and vFences are unique.

class Solution {
    public int maximizeSquareArea(int m, int n, int[] hFen, int[] vFen) {

    long ans = 0, mod = 1000000007;
    HashSet<Integer> hs = new HashSet<>();
   
    Arrays.sort(hFen);
    Arrays.sort(vFen);

    for(int i = 0; i < hFen.length; ++i){
        for(int j = i+1; j < hFen.length; ++j){
            hs.add(Math.abs(hFen[i] - hFen[j]));
        }
        hs.add(Math.abs(hFen[i] - 1));
        hs.add(Math.abs(hFen[i] - m));
    }
    hs.add(Math.abs(1 - m));

    for(int i = 0; i < vFen.length; ++i){
        for(int j = i+1; j < vFen.length; ++j){
            if(hs.contains(Math.abs(vFen[i] - vFen[j])) == true) {
                ans = Math.max(ans, Math.abs(vFen[i] - vFen[j]));
            }
        }
        if(hs.contains(Math.abs(vFen[i] - 1)) == true) 
            ans = Math.max(ans, Math.abs(vFen[i] - 1));
        if(hs.contains(Math.abs(vFen[i] - n)) == true) 
            ans = Math.max(ans, Math.abs(vFen[i] - n));
    }
    if(hs.contains(Math.abs(n - 1)) == true) 
        ans = Math.max(ans, Math.abs(n - 1));
    return (ans == 0)?-1: (int)((ans * ans) % mod);
}
}
