
public class Print {
	public static void main(String[] args) {
		int n=3;
		fun(n);
	}
	public static void fun(int num) {
		if(num==0)return;
		System.out.println(num);
		fun(num-1);
	}
}
