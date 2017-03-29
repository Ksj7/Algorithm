#include <stdio.h>
int main(){
   int arr[100001] = {0,};
   int n, i , j;
   scanf("%d",&n);
   for( i = 1; i <= n; i++ ){
   		arr[i] = i;
	   	for(j = 1; j*j <= i ; j++ ){
	   		if( arr[i] > arr[i-j*j] + 1)
	   		arr[i] = arr[i-j*j] + 1;
		}
   }
   printf("%d",arr[n]);
}