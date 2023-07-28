public class Fibonacci {
	public static void main(String[] args) {
		int n=5;
		System.out.println(fun(n));
	}
	public static int fun(int num) {
		if(num<=1)
			return num;
		int left=fun(num-1);
		int right=fun(num-2);
		return left+right;
	}
}
