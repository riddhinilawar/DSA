904. Fruit Into Baskets

You are visiting a farm that has a single row of fruit trees arranged from left to right. The trees are represented by an integer array fruits where fruits[i] is the type of fruit the ith tree produces.

You want to collect as much fruit as possible. However, the owner has some strict rules that you must follow:

You only have two baskets, and each basket can only hold a single type of fruit. There is no limit on the amount of fruit each basket can hold.
Starting from any tree of your choice, you must pick exactly one fruit from every tree (including the start tree) while moving to the right. The picked fruits must fit in one of your baskets.
Once you reach a tree with fruit that cannot fit in your baskets, you must stop.
Given the integer array fruits, return the maximum number of fruits you can pick.

 

Example 1:

Input: fruits = [1,2,1]
Output: 3
Explanation: We can pick from all 3 trees.
Example 2:

Input: fruits = [0,1,2,2]
Output: 3
Explanation: We can pick from trees [1,2,2].
If we had started at the first tree, we would only pick from trees [0,1].
Example 3:

Input: fruits = [1,2,3,2,2]
Output: 4
Explanation: We can pick from trees [2,3,2,2].
If we had started at the first tree, we would only pick from trees [1,2].
 

Constraints:

1 <= fruits.length <= 105
0 <= fruits[i] < fruits.length

class Solution {
    public int totalFruit(int[] fruits) {
        int max = 0;
        Map<Integer, Integer> baskets = new HashMap<>();

        for (int left = 0, right = 0; left < fruits.length && right < fruits.length; ++right) {
            baskets.put(fruits[right], baskets.getOrDefault(fruits[right], 0) + 1);

            if (baskets.size() > 2)
                moveLeftBorder(baskets, fruits[left++]);
            
            max = Math.max(right - left + 1, max);
        }

        return max;
    }

    private void moveLeftBorder(Map<Integer, Integer> baskets, int typeToDecrease) {
        baskets.put(typeToDecrease, baskets.get(typeToDecrease) - 1);
        if (baskets.get(typeToDecrease) == 0)
            baskets.remove(typeToDecrease);
    }
}
