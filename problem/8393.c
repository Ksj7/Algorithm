#include <stdio.h>
int main() {
	long result = 0;
	int n ,i;
	scanf("%d", &n);
	for (i = 1; i <= n; i++) {
		result += i;
	}
	printf("%ld", result);
		
	return 0;
}