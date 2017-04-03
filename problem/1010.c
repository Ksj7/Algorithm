#include <stdio.h>
#include <stdlib.h>
#define MAX(X,Y) ((X) > (Y) ? (X) : (Y))
int main(void){ 
    long c[31][31] = {1,};
 	int n,m,test, i , j;
    c[1][1] = 1;
    scanf("%d",&test);
    while(test--){
		scanf("%d %d", &n, &m);
	    for ( i = 2; i <= m; i++){
	    	c[i][1] = i;
			for ( j = 2; j <=n; j++){
	            c[i][j] = c[i - 1][j - 1] + c[i - 1][j];
			}
		}
		printf("%d\n",c[m][n]);
	}
    return 0;
}