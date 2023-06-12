class Solution {
    public int maxProfit(int[] prices) {

        if(prices.length<2)return 0;

        ArrayList<Integer> buy = new ArrayList<>();
        ArrayList<Integer> sell = new ArrayList<>();

        if(prices[0]<prices[1])
            buy.add(prices[0]);

        for(int i=1;i<buy.size()-1;i++){

            if(prices[i]<prices[i-1] && prices[i]<prices[i+1])
                buy.add(prices[i]);

            if(prices[i]>prices[i-1] && prices[i]>prices[i+1])
                sell.add(prices[i]);

        }

        if(prices[n-1]>prices[n-2])
            sell.add(prices[n-1]);
        
        int ans=0;
        if(buy.size()==sell.size()){
            for(int i=0;i<buy.size();i++)
                ans+=(sell.get(i)-buy.get(i));
        }
        
        return ans;
    }
}
