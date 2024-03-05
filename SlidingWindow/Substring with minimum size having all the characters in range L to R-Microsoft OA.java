import java.util.*;

public class Solution {
	public static void main(String[] args) {
		int A[]= {2,1,4,3,2,1,1,4};
		int L=2;
		int R=4;
//		int A[]= {1000000000,1,1,1,1,1,999999999};
//		int L=999999999;
//		int R=1000000000;
//		int A[]= {1000000000,1,1,1,1,1,999999999};
//		int L=999999999;
//		int R=999999999;
//		int A[]= {999999999};
//		int L=999999999;
//		int R=999999999;
//		int A[]= {88888};
//		int L=999999999;
//		int R=999999999;
//		System.out.println(solution(A,L,R));
//		int A[]= {1,3,5,7};
//		int L=3;
//		int R=5;
		System.out.println(solution(A,L,R));
	}
	
	public static int solution(int A[],int L,int R){
	
		int totalElements=R-L+1;
		int subArrayInculdes=0;
		
		//to keep the track of count
		HashMap<Integer,Integer> map = new HashMap<>();
		
		int start=0;
		int end=-1;
		int n=A.length;
		
		int ans=Integer.MAX_VALUE;
		
		while(start<n){
			while(end+1<n && subArrayInculdes<totalElements){
				
				//System.out.println("In end:::"+start+" "+end+" "+subArrayInculdes+" "+totalElements);
				if(A[end+1]>=L && A[end+1]<=R && map.containsKey(A[end+1]) == false){
					subArrayInculdes++;	
				}
				if(A[end+1]>=L && A[end+1]<=R) {
					map.put(A[end+1],map.getOrDefault(A[end+1],0)+1);
				}
				end++;
				
			}
			
			
			//System.out.println(subArrayInculdes+" "+totalElements);
			if(subArrayInculdes==totalElements){
				ans=Math.min(ans,end-start+1);
			}
			
			if(A[start]>=L && A[start]<=R) {
				
				if(map.get(A[start])==1){
					map.remove(A[start]);
					subArrayInculdes--;
				}
				else{
					map.put(A[start],map.get(A[start])-1);
				}
				
			}
			//System.out.println("start:::"+start);
			start++;
		}
		
		
		if(ans==Integer.MAX_VALUE)return -1;
		return ans;
	
	}
}
