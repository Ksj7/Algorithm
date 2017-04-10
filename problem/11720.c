#include <stdio.h>
int main() {
	long result = 0;
	int n, i;
	char input[100];
	scanf("%d", &n);
	scanf("%s", input);
	for (i = 0; i < n; i++) {
		result += input[i] - 48;
	}
	printf("%ld", result);
		
	return 0;
}