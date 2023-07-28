public class PrintNameNTimes {
	
	
	public static void main(String[] args) {
		int n=5;
		System.out.println(fun(n));
	}
	public static int fun(int num) {
		if(num==1) {
			return 1;
		}
		return num*fun(num-1);
	}
}
