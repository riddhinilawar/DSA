public class Print {
	public static void main(String[] args) {
		int n=3;
		fun(n,1);
	}
	public static void fun(int num,int idx) {
		if(idx>num)return;
		fun(num,idx+1);
		System.out.println(idx);
	}
}
