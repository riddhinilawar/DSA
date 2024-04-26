import java.util.*;
public class Main
{
    static int dp[][];
	public static void main(String[] args) {
		System.out.println(helper("Hello.!.","HelloJun!Message"));
		System.out.println(helper("Hello.!.ge","HelloJun!July!Message!age"));
		//arguments-> pattern, message
	}
	public static  ArrayList<String> helper(String pattern,String message){
	    ArrayList<String> ans = new ArrayList<>();
	    dp=new int[pattern.length()+1][message.length()+1];
	    for(int d[]:dp)Arrays.fill(d,-1);
	    getSubstrings(0,0,pattern,message,ans);
	    return ans;
	}
	public static int getSubstrings(int pIdx,int mIdx,String pattern,String message,ArrayList<String> ans){
	    //System.out.println(pIdx+" "+mIdx);
	    
	    if(dp[pIdx][mIdx]!=-1){
	        return dp[pIdx][mIdx];
	    }
	    
	    while(pIdx<pattern.length() && mIdx<message.length() && pattern.charAt(pIdx) == message.charAt(mIdx)){
	        pIdx++;
	        mIdx++;
	    }
	    
	    if(pIdx==pattern.length() && mIdx==message.length()){
	        return dp[pIdx][mIdx]=1;
	    }
	    if(pIdx!=pattern.length() && mIdx==message.length()){
	        return dp[pIdx][mIdx]=0;
	    }
	    
	    if(pIdx==pattern.length() && mIdx!=message.length()){
	        return dp[pIdx][mIdx]=0;
	    }
	    
	    if(pattern.charAt(pIdx) == '.' && pIdx==pattern.length()-1){
	        ans.add(message.substring(mIdx));
	        return dp[pIdx][mIdx]=1;
	    }
	    
	    
	    
	    char nextAfterdot=pattern.charAt(pIdx+1);

	    for(int idx=mIdx;idx<message.length();idx++){
	        if(message.charAt(idx)==nextAfterdot){
	            ans.add(message.substring(mIdx,idx));
	            if(getSubstrings(pIdx+1,idx,pattern,message,ans)==1){
	                return dp[pIdx][mIdx]=1;
	            }
	            ans.remove(ans.size()-1);
	        }
	    }
	    
	    
	    return dp[pIdx][mIdx]=0;
	    
	}
}
