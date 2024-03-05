import java.util.*;

public class InfixToPostfixConversion {

	public static void main(String[] args) {
		
		infixToPostfix("a+b*(c^d-e)^(f+g*h)-i");
	}
	public static String infixToPostfix(String exp) {
        
        Stack<Character> stack = new Stack<>();
        HashMap<Character,Integer> map = new HashMap<>();
        map.put('+',1);map.put('-',1);map.put('/',2);map.put('*',2);map.put('^',3);map.put('(',0);map.put(')',0);
        
        StringBuilder postfix=new StringBuilder();
        
        for(char c:exp.toCharArray()){
            if(map.containsKey(c)){
                
                if(c=='(')
                    stack.push(c);
                
                else if(c==')'){
                    while(stack.peek()!='('){
                        postfix.append(stack.pop());
                    }
                    stack.pop();
                }
                
                else{
                    int value = map.get(c);
                    while(!stack.isEmpty() && map.get(stack.peek())>=value){
                        postfix.append(stack.pop());
                    }
                    stack.push(c);
                }
                
            }
            else{
                postfix.append(c);
            }
        }
        
        while(!stack.isEmpty()){
            postfix.append(stack.pop());
        }
        
        return postfix.toString();
    }
}
