public class factorial {
		public static void main(String[] args) {
			int n=5;
			fun(n,1);
		}
		public static void fun(int num,int factorial) {
			if(num==1) {
				System.out.println("factorial--> "+factorial);
				return;
			}
			fun(num-1,factorial*num);
    }
}
