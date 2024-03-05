import java.util.*;

public class InfixToPrefixConversion {

	public static void main(String[] args) {
		
		System.out.println(infixToPrefix("a+b*(c^d-e)^(f+g*h)-i"));
	}
	public static String infixToPrefix(String exp) {
        
		StringBuilder input = new StringBuilder();
		for(int i=exp.length()-1;i>=0;i--) {
			if(exp.charAt(i)=='(')
				input.append(')');
			else if(exp.charAt(i)==')')
				input.append('(');
			else input.append(exp.charAt(i));
		}
		exp=input.toString();
		
		System.out.println(exp);
		
        Stack<Character> stack = new Stack<>();
        HashMap<Character,Integer> map = new HashMap<>();
        map.put('+',1);map.put('-',1);map.put('/',2);map.put('*',2);map.put('^',3);map.put('(',0);map.put(')',0);
        
        StringBuilder prefix=new StringBuilder();
        
        for(char c:exp.toCharArray()){
            if(map.containsKey(c)){
                
                if(c=='(')
                    stack.push(c);
                
                else if(c==')'){
                    while(stack.peek()!='('){
                        prefix.append(stack.pop());
                    }
                    stack.pop();
                }
                
                else{
                    int value = map.get(c);
                    while(!stack.isEmpty() && map.get(stack.peek())>=value){
                        prefix.append(stack.pop());
                    }
                    stack.push(c);
                }
                
            }
            else{
                prefix.append(c);
            }
        }
        
        while(!stack.isEmpty()){
            prefix.append(stack.pop());
        }
        prefix.reverse();
        return prefix.toString();
    }
}
