public class PrintNameNTimes {
	public static void main(String[] args) {
		int n=3;
		fun(1,n);
	}
	public static void fun(int start,int end) {
		if(start>end)return;
		System.out.println("Riddhi");
		fun(start+1,end);
	}
}
