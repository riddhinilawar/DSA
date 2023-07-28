public class ReverseArray {
	
	
	public static void main(String[] args) {
		int arr[]= {1,2,3,4,2};
		fun(0,arr.length-1,arr);
		for(int i:arr)
			System.out.println(i);
	}
	public static void fun(int start,int end,int arr[]) {
		if(start>=end) {
			return;
		}
		
		int temp=arr[start];
		arr[start]=arr[end];
		arr[end]=temp;
		
		fun(start+1,end-1,arr);
	}
}
