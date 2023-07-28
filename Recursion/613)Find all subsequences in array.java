import java.util.*;
public class PrintAllSubsequence {

	public static void main(String[] args) {
		int arr[]= {3,1,2};
		List<List<Integer>> list = new ArrayList<>();
		fun(0,arr,list,new ArrayList<>());
		System.out.println(list);
	}
	public static void fun(int idx,int arr[],List<List<Integer>> list,List<Integer> temp) {
		if(idx==arr.length) {
			list.add(new ArrayList<Integer>(temp));
			return;
		}

    //taken
		temp.add(arr[idx]);
		fun(idx+1,arr,list,temp);
		temp.remove(temp.size()-1);

    //not taken
		fun(idx+1,arr,list,temp);
	}
}
