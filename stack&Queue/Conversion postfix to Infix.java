import java.util.*;

public class PostfixToInfix {
	public static void main(String[] args) {
		System.out.println(postToInfix("ab*c+"));
	}

	static String postToInfix(String exp) {

		Stack<String> stack = new Stack<>();
		HashMap<Character,Integer> map = new HashMap<>();
		map.put('+',1);map.put('-',1);map.put('/',2);map.put('*',2);map.put('^',3);

		for(char c:exp.toCharArray()){

			if(map.containsKey(c)){
				String s1=stack.pop();
				String s2=stack.pop();

				String temp="("+s2+c+s1+")";

				stack.push(temp);
			}
			else 
				stack.push(String.valueOf(c));
		}

		return stack.pop();
	}


}

