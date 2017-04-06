#include <stdio.h>

int main() {
	char ch;
	while ((ch = getchar()) && ch != EOF) {
		putchar(ch);
	}

	return 0;
}