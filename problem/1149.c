#include <stdio.h>

int cost[1001][3] = {0,};

int main(){
	int n ;
	scanf("%d", &n);
	scanf("%d %d %d", &cost[0][0] , &cost[0][1], &cost[0][2]);
		
	for(int i = 1 ; i < n; i++){
		scanf("%d %d %d", &cost[i][0] , &cost[i][1], &cost[i][2]);
		cost[i][0] += (cost[i-1][1] > cost[i-1][2])? cost[i-1][2] : cost[i-1][1];
		cost[i][1] += (cost[i-1][0] > cost[i-1][2])? cost[i-1][2] : cost[i-1][0];
		cost[i][2] += (cost[i-1][0] > cost[i-1][1])? cost[i-1][1] : cost[i-1][0];
		
	}
	int result =  (cost[n-1][0] > cost[n-1][1])? cost[n-1][1] : cost[n-1][0];
	result = (result > cost[n-1][2])? cost[n-1][2] : result;
	printf("%d", result);

}