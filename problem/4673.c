#include <stdio.h>
int main() {
	int input[10001];
	int test = 1;
	int num, hundred, thousand, ten, one;
	while (test < 10001) {
		num = test;
		while(1){
			thousand = ((num / 1000 == num) ? 0 : num / 1000);
			hundred = ((((num % 1000) / 100) == num) ? 0 : ((num % 1000) / 100));
			ten = ((((num % 1000) % 100) / 10) == num) ? 0 : (((num % 1000) % 100) / 10);
			one = ((num % 1000) % 100) % 10;
			num = num + thousand + hundred + ten + one;
			if (num > 10000 || input[num] == 1) break;
			input[num] = 1;
		}
		test++;
	}
	for (test = 1; test < 10001; test++) {
		if (input[test] != 1)
			printf("%d\n", test);
	}
	return 0;
}