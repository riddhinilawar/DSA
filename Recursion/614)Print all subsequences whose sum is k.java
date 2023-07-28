import java.util.*;
public class PrintAllSubsequesncesWithSumK {
	
	
	public static void main(String[] args) {
		int arr[]= {3,1,2};
		int k=3;
		List<List<Integer>> list = new ArrayList<>();
		fun(0,arr,list,new ArrayList<>(),k,0);
		System.out.println(list);
	}
	public static void fun(int idx,int arr[],List<List<Integer>> list,List<Integer> temp,int k,int sum) {
		if(idx==arr.length) {
			if(sum==k)
				list.add(new ArrayList<Integer>(temp));
			return;
		}
		
		temp.add(arr[idx]);
		fun(idx+1,arr,list,temp,k,sum+arr[idx]);
		temp.remove(temp.size()-1);
		fun(idx+1,arr,list,temp,k,sum);
	}
}
