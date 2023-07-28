public class Sum {
	public static void main(String[] args) {
		int n=5;
		System.out.println(fun(n));
	}
	public static int fun(int num) {
		if(num==0) {
			return 0;
		}
		return num+fun(num-1);
	}
}
