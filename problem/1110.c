#include <stdio.h>
int main() {
	int input, num, i, len = 1;
	scanf("%d", &input);
	num = input;
	while (1) {
		num = (num % 10 * 10) + ((num / 10 + num % 10) % 10);
		if (num == input) {
			break;
		}
		len++;
	}
	printf("%d", len);
	return 0;
}