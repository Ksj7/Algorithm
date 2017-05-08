#include <stdio.h>
#include <string.h>

int main() {

	char str[1000001] = " ";
	int cnt = 1;
	scanf("%[^\n]s", str);
	int size = strlen(str);
	for (int i = 0; i < size; i++)
		if (str[i] == ' ')
			cnt++;

	if (str[0] == ' ')
		cnt--;
	if (str[size - 1] == ' ')
		cnt--;

	printf("%d", cnt);
}
