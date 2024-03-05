import java.util.*;

public class PrefixToInfix {
	public static void main(String[] args) {
		System.out.println(preToInfix("*-A/BC-/AKL"));
	}
	 static String preToInfix(String pre_exp) {
	        Stack<String> stack = new Stack<>();
			HashMap<Character,Integer> map = new HashMap<>();
			map.put('+',1);map.put('-',1);map.put('/',2);map.put('*',2);map.put('^',3);

			for(int i=pre_exp.length()-1;i>=0;i--){
	            char c=pre_exp.charAt(i);
				if(map.containsKey(c)){
					String s1=stack.pop();
					String s2=stack.pop();

					String temp="("+s1+c+s2+")";

					stack.push(temp);
				}
				else 
					stack.push(String.valueOf(c));
			}

			return stack.pop();
	    }
}
