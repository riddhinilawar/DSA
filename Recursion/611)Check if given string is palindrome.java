
public class Palindrome {
	
	
	public static void main(String[] args) {
		String s="MADaM";
		System.out.println(fun(0,s.length()-1,s));
	}
	public static boolean fun(int start,int end,String s) {
		if(start>=end)
			return true;
		
		if(s.charAt(start)!=s.charAt(end))
			return false;
		
		if(fun(start+1,end-1,s)==false)
			return false;
			
		return true;
	}
}
