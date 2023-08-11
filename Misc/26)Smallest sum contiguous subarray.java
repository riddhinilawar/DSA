Application of kadanes algo
static int smallestSumSubarray(int a[], int size)
    {
        int count=0;
        int posans=Integer.MAX_VALUE;
        int n=a.length;
        int sum=0;
        int minsum=Integer.MAX_VALUE;
        for(int i=0;i<n;i++)
        {
            sum=sum+a[i];
            if(sum>=0)
            {
                sum=0;
            }
            else
            {
                minsum=Math.min(minsum,sum);
            }
            
            //handling exception
            if(a[i]>=0)
            {
                count++;
                posans=Math.min(posans,a[i]);
            }
        }
        if(count==n)
        return posans;
        else
        return minsum;
    }
Expected Time Complexity: O(N)
Expected Auxiliary Space: O(1)
