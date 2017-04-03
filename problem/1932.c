#include <stdio.h>
#include <stdlib.h>
#define MAX(X,Y) ((X) > (Y) ? (X) : (Y))
#define MAX_SIZE 501

int main(){
   	int n, i, j , max =-1;
   	int result[MAX_SIZE][MAX_SIZE] = {0,};
   	
   	scanf("%d",&n);
   	for( i = 0 ; i < n; i++ ){
		for(j = 0; j <= i; j++){
			scanf("%d",&result[i][j]);
		}
	}
	
	for( i = 1 ; i < n; i++ ){
		for(j = 0; j <= i; j++){
			if(j==0) result[i][j] = result[i][j] + result[i-1][j];
			else if(j==i) result[i][j] = result[i][j] + result[i-1][j-1];
			else result[i][j] = result[i][j] + MAX(result[i-1][j],result[i-1][j-1]);
		}
	}
	for(i = 0; i < n; i++){
		if(max < result[n-1][i]) max= result[n-1][i];
	}
	
	printf("%d",max);

}
