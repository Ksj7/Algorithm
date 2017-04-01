#include <stdio.h>
#include <stdlib.h>
#define MAX(X,Y) ((X) > (Y) ? (X) : (Y))

int compare (void *first, void *second) { 
	if (*(int*)first > *(int*)second) return 1;
 	else if (*(int*)first < *(int*)second) return -1;
  	else return 0; 
}

int main(){
   int arr[100001] = {0,};
   int n, i;
   int max;
   scanf("%d",&n);
   scanf("%d",&arr[0]);
   max = arr[0];
   for( i = 1; i < n; i++ ){
   		scanf("%d",&arr[i]);
   		if(max < arr[i]) max = arr[i];
	   	arr[i] = MAX(arr[i-1]+arr[i] , arr[i]);
   }
   qsort(arr, n, sizeof(int), compare);
   printf("%d", MAX(arr[n-1],max));
}