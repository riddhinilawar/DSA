Fibonacci Series:: 0,1,1,2,3,5,8,13,21,.....


==============================recursive========================================

f(n){
	if(n<=1){
		return n;
	}
	return f(n-1)+f(n-2);
}

============================memoization=====================================

declare the dp aaray if size n+1

f(n){
	if(n<=1){
		return n;
	}
	if(dp[n]!=-1){
		return dp[n];
	}
	return dp[n]=f(n-1)+f(n-2);
}

==========================tabulation=========================================

declare the dp aaray if size n+1

f(n){
	dp[0]=0;
	dp[1]=1;
	for(int idx=2;idx<=n;idx++){
		dp[idx]=dp[idx-1]+dp[idx-2];
	}
	return dp[n];
}
