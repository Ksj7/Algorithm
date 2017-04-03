#include <stdio.h>
#include <stdlib.h>
#define MAX(X,Y) ((X) > (Y) ? (X) : (Y))
int main(void){ 
    int c[301][301] = {0,};
    int arr[10001][4];
 	int n,m,test,i,j,k,x,y;
    int sum;
	scanf("%d %d",&n , &m);
	for ( i = 1; i <= n; i++){
	    for ( j = 1; j <= m; j++){
			scanf("%d", &c[i][j]);
		}
	}
	scanf("%d",&k);
	for( i = 1; i <= k; i++ ){
		scanf("%d %d %d %d" , &arr[i][0],&arr[i][1],&arr[i][2],&arr[i][3]);
		sum = 0;
		for( x=arr[i][0];x<=arr[i][2];x++){
			for( y = arr[i][1]; y <= arr[i][3]; y++)
				sum+=c[x][y];
		}
		printf("%d\n", sum);
	}
    return 0;
}