
878. Nth Magical Number

A positive integer is magical if it is divisible by either a or b.

Given the three integers n, a, and b, return the nth magical number. Since the answer may be very large, return it modulo 109 + 7.

 

Example 1:

Input: n = 1, a = 2, b = 3
Output: 2
Example 2:

Input: n = 4, a = 2, b = 3
Output: 6
 

Constraints:

1 <= n <= 109
2 <= a, b <= 4 * 104


class Solution {
    public int nthMagicalNumber(int n, int a, int b) {
        long start=1l;
        long end=Long.MAX_VALUE/2l;
        long ans=0;
        if(a<b){
            int temp=a;
            a=b;
            b=temp;
        }
        while(start<=end){
            long mid= start+(end-start)/2;
            if(helper(mid,a,b)>=(long)n){
                ans=mid;
                end=mid-1;
            }
            else{
                start=mid+1;
            }
        }

        return (int)(ans%1000000007);
    }
    public long helper(long num,int a,int b){
        long sum=0;
        
        sum+=(num/(long)a);
        sum+=(num/(long)b);
        sum-=(num/(long)lcm(a,b));
        
        return sum;

    }
    public int gcd(int A, int B){
        if( B == 0)
            return A;
        else 
            return gcd(B, A % B);
    }
    public int lcm(int a, int b) {
        return (a * b) / gcd(a, b);
    }
}
