public class Sum {
	public static void main(String[] args) {
		int n=5;
		fun(n,0);
	}
	public static void fun(int num,int sum) {
		if(num==0) {
			System.out.println("sum--> "+sum);
			return;
		}
		fun(num-1,sum+num);
	}
}
