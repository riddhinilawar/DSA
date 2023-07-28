import java.util.*;
public class OneSubsequenceWithSumK {
	
	
	public static void main(String[] args) {
		int arr[]= {0,1,2};
		int k=3;
		List<Integer> temp=new ArrayList<>();
		fun(0,arr,temp,k,0);
		System.out.println(temp);
	}
	public static boolean fun(int idx,int arr[],List<Integer> temp,int k,int sum) {
		if(idx==arr.length) {
			if(sum==k) 
				return true;
			return false;
		}
		
		temp.add(arr[idx]);
		if(fun(idx+1,arr,temp,k,sum+arr[idx])==true)
			return true;
		temp.remove(temp.size()-1);
		
		if(fun(idx+1,arr,temp,k,sum)==true)
			return true;
		
		return false;
	}
}
