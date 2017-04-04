#include <stdio.h>
#include <stdlib.h>
#define MAX(X,Y) ((X) > (Y) ? (X) : (Y))
int main(void){ 
    int arr[10001][3] = {0,};
 	int j,n;
	scanf("%d",&n);
	for ( j = 1; j <= n; j++){
		scanf("%d", &arr[j][0]);
	}
	arr[1][2] = arr[1][0];
	for( j = 2; j<= n; j++){
		arr[j][1] = arr[j-1][2]+arr[j][0];
		if(arr[j-1][1] > arr[j][1] ) arr[j][1] = arr[j-1][1] ;
		arr[j][2] = arr[j][0] + MAX(arr[j-2][1], arr[j-2][2]);
		if(arr[j-1][2] > arr[j][2] ) arr[j][2] = arr[j-1][2];
	}
	printf("%d", MAX(arr[n][1],arr[n][2]));
}