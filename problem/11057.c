#include <stdio.h>

int dp[1002][10] = {0,};
int recursive(int n, int v){

    if(n==1) return 1;
    else if(dp[n][v]!=0) return dp[n][v];
	int sum= 0;
    for(int i = v; i >= 0; i--)
        sum += recursive(n-1, i);
    dp[n][v] = sum % 10007;
    return dp[n][v];
}
int main(){
    int s ;
    scanf("%d",&s);
    printf("%d", recursive(s+1, 9));
    return 0;
}