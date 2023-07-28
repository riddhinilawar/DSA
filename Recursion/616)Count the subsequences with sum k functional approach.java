import java.util.*;
public class CountSubsequuenceWithSumK {
	
	
	public static void main(String[] args) {
		int arr[]= {3,1,2};
		int k=3;
		System.out.println(fun(0,arr,k,0));

		
	}
	public static int fun(int idx,int arr[],int k,int sum) {
		if(idx==arr.length) {
			if(sum==k) 
				return 1;
			return 0;
		}
		
		int taken=fun(idx+1,arr,k,sum+arr[idx]);
		int notTaken=fun(idx+1,arr,k,sum);
			
		return taken+notTaken;
	}
}
