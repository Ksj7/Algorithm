#include <stdio.h>
int main() {
	int i, num, imp = 1;
	int fail = 0;
	int result = 0;
	scanf("%d", &num);
	while(1) {
		result += num / 5;
		if ((num % 5) % 3 == 0) {
			printf("%d", result + (num % 5) / 3);
			break;
		}
		num -= 3;
		result = imp++;
		if (num < 3) {
			fail = 1;
			break;
		}
	}
	if (fail == 1) printf("-1");
}