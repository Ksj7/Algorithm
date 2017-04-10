#include <stdio.h>
int main() {
	int x, y, i, j, num = -1, lastday;
	int month[13][32];
	char *week[] = {
		"MON","TUE","WED","THU","FRI","SAT","SUN" };
	scanf("%d %d", &x, &y);
	for (i = 1; i <= 12; i++) {
		if (i == 2) lastday = 28;
		else if (i == 4 || i == 6 || i == 9 || i == 11) lastday = 30;
		else lastday = 31;

		for (j = 1; j <= lastday; j++) {
			month[i][j] = (num + j) % 7;
		}

		num += lastday;
	}
	printf("%s", week[month[x][y]]);
		
	return 0;
}