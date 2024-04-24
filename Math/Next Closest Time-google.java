681.Next Closest Time
Given a time represented in the format "HH:MM", form the next closest time by reusing the current digits. There is no limit on how many times a digit can be reused.

You may assume the given input string is always valid. For example, "01:34", "12:09" are all valid. "1:34", "12:9" are all invalid.

Example 1:

Copy
Input: "19:34"
Output: "19:39"
Explanation: The next closest time choosing from digits 1, 9, 3, 4, is 19:39, 
    which occurs 5 minutes later.  It is not 19:33, because this occurs 23 hours and 59 minutes later.
Example 2:

Copy
Input: "23:59"
Output: "22:22"
Explanation: The next closest time choosing from digits 2, 3, 5, 9, is 22:22. 
    It may be assumed that the returned time is next day's time since it 
class Solution {
    public static void main(String args[]){
        System.out.println("19:34-->"+nextClosestTime("19:34"));
        System.out.println("15:39-->"+nextClosestTime("15:39"));
        System.out.println("19:39-->"+nextClosestTime("19:39"));
        System.out.println("15:56-->"+nextClosestTime("15:56"));
        System.out.println("04:39-->"+nextClosestTime("04:39"));
        System.out.println("01:34-->"+nextClosestTime("01:34"));
        System.out.println("12:58-->"+nextClosestTime("12:58"));
        System.out.println("01:58-->"+nextClosestTime("01:58"));
        System.out.println("11:11-->"+nextClosestTime("11:11"));
        System.out.println("22:03-->"+nextClosestTime("22:03"));
        System.out.println("12:22-->"+nextClosestTime("12:22"));
        System.out.println("21:22-->"+nextClosestTime("21:22"));
    }
    public static String nextClosestTime(String time) {
      char[] ans = time.toCharArray();
      Character[] digits = {ans[0], ans[1], ans[3], ans[4]};
      TreeSet<Character> allDigitsSet = new TreeSet<Character>(Arrays.asList(digits));

      ans[4] = nextPossible(allDigitsSet, ans[4], '9');
      if (time.charAt(4) < ans[4])
        return new String(ans);

      ans[3] = nextPossible(allDigitsSet, ans[3], '5');
      if (time.charAt(3) < ans[3])
        return new String(ans);

      ans[1] = nextPossible(allDigitsSet, ans[1], ans[0] == '2' ? '3' : '9');
      if (time.charAt(1) < ans[1])
        return new String(ans);

      ans[0] = nextPossible(allDigitsSet, ans[0], '2');
      return new String(ans);
    }

    private static char nextPossible(TreeSet<Character> allDigitsSet, char digit, char limit) {
      Character next = allDigitsSet.higher(digit);
      return next == null || next > limit ? allDigitsSet.first() : next;
    }
}
/*
19:34-->19:39
15:39-->15:51
19:39-->11:11
15:56-->16:11
04:39-->04:40
01:34-->01:40
12:58-->15:11
01:58-->05:00
11:11-->11:11
22:03-->22:20
12:22-->21:11
21:22-->22:11
*/
