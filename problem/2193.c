#include <stdio.h>

int main(){
	int n;
	long increment[100] = {0,};
	increment[1] = 1; increment[2] = 1;
	scanf("%d", &n);
	if(n == 1) printf("1");
	else if( n == 2 ) printf("1");
	else{
		for(int i = 3 ; i <= n; i++){
			increment[i] = increment[i-1] + increment[i-2];
		}
		printf("%ld", increment[n]);
	}

}