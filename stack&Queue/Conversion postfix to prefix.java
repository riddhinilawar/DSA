import java.util.*;
public class PostfixToPrefix {
	public static void main(String[] args) {
		System.out.println(postToPre("ABC/-AK/L-*"));
	}
	 static String postToPre(String post_exp) {
	        Stack<String> stack = new Stack<>();
			HashMap<Character,Integer> map = new HashMap<>();
			map.put('+',1);map.put('-',1);map.put('/',2);map.put('*',2);map.put('^',3);

			for(char c:post_exp.toCharArray()){
	            
				if(map.containsKey(c)){
					String s1=stack.pop();
					String s2=stack.pop();

					String temp=c+s2+s1;

					stack.push(temp);
				}
				else 
					stack.push(String.valueOf(c));
			}

			return stack.pop();
	    }
}
