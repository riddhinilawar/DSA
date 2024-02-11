class Solution {
	public int maxPalindromesAfterOperations(String[] words) {
		
		Arrays.sort(words,(a,b)->a.length()-b.length());
		
		int n=words.length;
		int freq[]=new int[26];
		
		for(int i=0;i<n;i++){
			for(int j=0;j<words[i].length();j++){
				freq[words[i].charAt(j)-'a']++;
			}
		}
		
		int ans=0;
		PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->b-a);
		for(int i=0;i<26;i++){
            //System.out.print(freq[i]+" ");
            pq.offer(freq[i]);
        }
		//System.out.println();
		
		for(int i=0;i<n;i++){
			
			int put=(words[i].length()%2==0)?words[i].length():words[i].length()-1;
			//System.out.println(i+" "+put+" "+words[i]);
			if(put==0){ans++;continue;}
			//System.out.println(pq.peek());
			
			while(put>0 && pq.peek()>=2){
				
				if(put==pq.peek()){
                    //System.out.println("In1"+" "+put+" "+pq.peek());
					pq.remove();
					put=0;
				}
				else if(put<pq.peek()){
                    //System.out.println("In2"+" "+put+" "+pq.peek());
                    int temp=pq.remove();
                    pq.add(temp-put);
					put=0;
				}
				else{
                    //System.out.println("In3"+" "+put+" "+pq.peek());
					if(pq.peek()%2==0){
                        put-=pq.peek();
					    pq.remove();
                    }
                    else{
                        put-=(pq.peek()-1);
					    pq.remove();
                        pq.add(1);
                    }
				}
			}
			if(put!=0)break;
			ans++;
		}
		
		return ans;
	}
}
