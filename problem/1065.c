#include <stdio.h>
int main() {
	int input[1001];
	int num, test, hundred, ten, one , count = 0;
	scanf("%d", &test);
	if (test <= 99) {
		printf("%d", test);
	}
	else {
		for ( num = 100; num <= test; num++) {
			hundred = (num / 100) == num ? 0 : (num / 100);
			ten = ((num % 100) / 10) == num ? 0 : ((num % 100) / 10);
			one = (num % 100) % 10;
			if ((hundred - ten) == (ten - one))
				count++;
		}
		printf("%d", 99 + count);
	}
	return 0;
}