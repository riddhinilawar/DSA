679. 24 Game

You are given an integer array cards of length 4. You have four cards, each containing a number in the range [1, 9]. You should arrange the numbers on these cards in a mathematical expression using the operators ['+', '-', '*', '/'] and the parentheses '(' and ')' to get the value 24.

You are restricted with the following rules:

The division operator '/' represents real division, not integer division.
For example, 4 / (1 - 2 / 3) = 4 / (1 / 3) = 12.
Every operation done is between two numbers. In particular, we cannot use '-' as a unary operator.
For example, if cards = [1, 1, 1, 1], the expression "-1 - 1 - 1 - 1" is not allowed.
You cannot concatenate numbers together
For example, if cards = [1, 2, 1, 2], the expression "12 + 12" is not valid.
Return true if you can get such expression that evaluates to 24, and false otherwise.

 

Example 1:

Input: cards = [4,1,8,7]
Output: true
Explanation: (8-4) * (7-1) = 24
Example 2:

Input: cards = [1,2,1,2]
Output: false
 

Constraints:

cards.length == 4
1 <= cards[i] <= 9


class Solution {
    public boolean judgePoint24(int[] inputCards) {
        ArrayList<String> list = new ArrayList<>();

        //possible expressions
        list.add("((A+A)+(A+A))");
        list.add("(A+(A+(A+A)))");
        list.add("(((A+A)+A)+A)");
        list.add("(A+((A+A)+A))");
        list.add("((A+(A+A))+A)");

        //all the possible operations
        char[] operations={'+','-','*','/'};

        //all the digits which can places, usingbvis array to keep the record of idx, so that same idex should not be used again
        char[] cards=new char[4];
        for(int i=0;i<4;i++){
            cards[i]=(char) (inputCards[i] + '0');
        }

        //calling recursive function on every possible expression to create all valid expressions
        for(String str:list){
            if(helper(0,str,operations,cards,new StringBuilder(),new int[4]))
                return true;
        }
    
        return false;
    }
    public boolean helper(int idx,String str,char operations[],char cards[],StringBuilder sb,int vis[]){
        
        if(idx==str.length()){
            //if any of the expression return true it means its a valid expression which results in 24
            //if(((int)((evaluate(sb.toString())*10))==240))System.out.println(sb.toString()+" "+evaluate(sb.toString()));

            //multiplying with 10 because , we need to consider the single precision.
            return ((int)((evaluate(sb.toString())*10))==240);
        }

        //if open or close pranthesis means consider as it is
        if(str.charAt(idx)==')' || str.charAt(idx)=='('){
            sb.append(str.charAt(idx));
            if(helper(idx+1,str,operations,cards,sb,vis))return true;
            sb.deleteCharAt(sb.length() - 1);
        }
        
        //if gets a character A, it means for all not vis indexes try combination
        else if(str.charAt(idx)=='A'){

            for(int i=0;i<4;i++){
                if(vis[i]==0){
                    char c=cards[i];
                    sb.append(c);
                    vis[i]=1;
                    if(helper(idx+1,str,operations,cards,sb,vis))return true;
                    sb.deleteCharAt(sb.length() - 1);
                    vis[i]=0;
                }
            }
        }

        //if gets a + operator try all possible operators, here duplicate operators can be used unlike card digits
        else{
            for(char c:operations){
                sb.append(c);
                if(helper(idx+1,str,operations,cards,sb,vis))return true;
                sb.deleteCharAt(sb.length() - 1);
            }
        }

        return false;
    }
    public float evaluate(String s){
        Stack<String> stack  = new Stack<>();
        for(char cc:s.toCharArray()){

            String c=String.valueOf(cc);
            //System.out.println("current char::"+c);
            

            //if empty push
            if(stack.isEmpty()){
                stack.push(c);
            }
            //if open parenthesis push
            else if(c.equals("(")){
                stack.push(c);
            }
            //if close parenthesis, means 2 options (a+b) or (a), if 1st case then resolve and return else just return.
            else if(c.equals(")")){
                float value=Float.parseFloat(stack.pop());
                
                if(!stack.isEmpty() && stack.peek().equals("(")==false){
                   
                    String operator=stack.pop();
                    if(operator.equals("+")){
                        value+=Float.parseFloat(stack.pop());
                        
                    }
                    else if(operator.equals("-")){
                        value=(Float.parseFloat(stack.pop()))-value;
                        
                    }
                    else if(operator.equals("*")){
                        value*=Float.parseFloat(stack.pop());
                        
                    }
                    else if(operator.equals("/")){
                        
                        value=(Float.parseFloat(stack.pop()))/value;
                        
                    }
                }
                //poping opening bracket for the current closing bracket
                stack.pop();
                //pushing the new value in stack
                stack.push(String.valueOf(value));

            }
            //id any operator just push
            else if(c.equals("+") || c.equals("-") || c.equals("*") || c.equals("/")){
                stack.push(c);
            }
            else{
                stack.push(c);
            }
        // System.out.print("stack elements::");
        // for (String element : stack) {
        //     System.out.print(element+" ");
        // }
        // System.out.println();
        }


        return Float.parseFloat(stack.peek());
    }
}

==========like eval function=================4 / (1 - 2 / 3) = 4 / (1 / 3)======this case will not come generally========================if parenthesis are not maintained will it below code will work===============
  class Solution {
    public boolean judgePoint24(int[] inputCards) {
        ArrayList<String> list = new ArrayList<>();

        //possible expressions
        list.add("((A+A)+(A+A))");
        list.add("(A+(A+(A+A)))");
        list.add("(((A+A)+A)+A)");
        list.add("(A+((A+A)+A))");
        list.add("((A+(A+A))+A)");

        //all the possible operations
        char[] operations={'+','-','*','/'};

        //all the digits which can places, usingbvis array to keep the record of idx, so that same idex should not be used again
        char[] cards=new char[4];
        for(int i=0;i<4;i++){
            cards[i]=(char) (inputCards[i] + '0');
        }

        //calling recursive function on every possible expression to create all valid expressions
        for(String str:list){
            if(helper(0,str,operations,cards,new StringBuilder(),new int[4]))
                return true;
        }
    
        return false;
    }
    public boolean helper(int idx,String str,char operations[],char cards[],StringBuilder sb,int vis[]){
        
        if(idx==str.length()){
            //if any of the expression return true it means its a valid expression which results in 24
            //if(((int)((evaluate(sb.toString())*10))==240))System.out.println(sb.toString()+" "+evaluate(sb.toString()));

            //multiplying with 10 because , we need to consider the single precision.
            return ((int)((evaluate(sb.toString())*10))==240);
        }

        //if open or close pranthesis means consider as it is
        if(str.charAt(idx)==')' || str.charAt(idx)=='('){
            sb.append(str.charAt(idx));
            if(helper(idx+1,str,operations,cards,sb,vis))return true;
            sb.deleteCharAt(sb.length() - 1);
        }
        
        //if gets a character A, it means for all not vis indexes try combination
        else if(str.charAt(idx)=='A'){

            for(int i=0;i<4;i++){
                if(vis[i]==0){
                    char c=cards[i];
                    sb.append(c);
                    vis[i]=1;
                    if(helper(idx+1,str,operations,cards,sb,vis))return true;
                    sb.deleteCharAt(sb.length() - 1);
                    vis[i]=0;
                }
            }
        }

        //if gets a + operator try all possible operators, here duplicate operators can be used unlike card digits
        else{
            for(char c:operations){
                sb.append(c);
                if(helper(idx+1,str,operations,cards,sb,vis))return true;
                sb.deleteCharAt(sb.length() - 1);
            }
        }

        return false;
    }
    public float evaluate(String s){
        Stack<String> stack  = new Stack<>();
        for(char cc:s.toCharArray()){

            String c=String.valueOf(cc);
            //System.out.println("current char::"+c);
            

            //if empty push
            if(stack.isEmpty()){
                stack.push(c);
            }
            //if open parenthesis push
            else if(c.equals("(")){
                stack.push(c);
            }
            //if close parenthesis, means 2 options (a+b) or (a), if 1st case then resolve and return else just return.
            else if(c.equals(")")){
                float value=Float.parseFloat(stack.pop());
                
                if(!stack.isEmpty() && stack.peek().equals("(")==false){
                   
                    String operator=stack.pop();
                    if(operator.equals("+")){
                        value+=Float.parseFloat(stack.pop());
                        
                    }
                    else if(operator.equals("-")){
                        value=(Float.parseFloat(stack.pop()))-value;
                        
                    }
                    else if(operator.equals("*")){
                        value*=Float.parseFloat(stack.pop());
                        
                    }
                    else if(operator.equals("/")){
                        
                        value=(Float.parseFloat(stack.pop()))/value;
                        
                    }
                }
                //poping opening bracket for the current closing bracket
                stack.pop();
                //pushing the new value in stack
                stack.push(String.valueOf(value));

            }
            //id any operator just push
            else if(c.equals("+") || c.equals("-") || c.equals("*") || c.equals("/")){
                stack.push(c);
            }
            else{
                //if divide operation comes then resolve and push
                if(stack.peek().equals("/")){
                    stack.pop();
                    stack.push(String.valueOf(Float.parseFloat(stack.pop())/Float.parseFloat(c)));
                }
                //if multiply operation comes then resolve and push
                else if(stack.peek().equals("*")){
                    stack.pop();
                    stack.push(String.valueOf(Float.parseFloat(stack.pop())*Float.parseFloat(c)));
                }
                else{
                    stack.push(c);
                }
            }
        // System.out.print("stack elements::");
        // for (String element : stack) {
        //     System.out.print(element+" ");
        // }
        // System.out.println();
        }


        return Float.parseFloat(stack.peek());
    }
}
