#include <stdio.h>
#include <stdlib.h>
#define MAX(X,Y) ((X) > (Y) ? (X) : (Y))
int main(){
   int arr[301] = {0,};
   int compare[301][3] = {0,};
   int i;
   int n;
   scanf("%d", &n);
   for( i = 1 ; i <= n; i++)
      scanf("%d",&arr[i]);
    compare[1][2] = arr[1];
   for( i = 2; i <= n; i++ ){
   	  compare[i][1] = compare[i-1][2] + arr[i];
	  compare[i][2] = MAX(compare[i-2][1] + arr[i], compare[i-2][2] + arr[i] );
   }
   printf("%d",MAX(compare[n][1],compare[n][2]));
}