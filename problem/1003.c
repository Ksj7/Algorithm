#include <stdio.h>


int zero = 0, one = 0;
int fibonacci(int n) {
    if (n==0) {
		zero += 1;
        return 0;
    } else if (n==1) {
		one += 1;
        return 1;
    } else {
        return fibonacci(n-1) + fibonacci(n-2);
    }
}

int main(){
	int n , count ;
	scanf("%d", &count);
	while(count){
		scanf("%d", &n);
		fibonacci(n);
		printf("%d %d\n", zero, one);
		one = 0 ; zero = 0;
		count--;
	}

}