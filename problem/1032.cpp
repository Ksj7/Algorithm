#include <cstdio>
#include <string.h>
using namespace std;
int main() {

	int cnt;
	char prev;
	char input[51][51];
	char result[51];
	scanf("%d", &cnt);
	for (int i = 0; i < cnt; i++)
		scanf("%s", &input[i]);
	int size = strlen(input[0]);
	for (int i = 0; i < size; i++) {
		int diff = 0;
		prev = input[0][i];
		for (int j = 1; j < cnt; j++) {
			if (prev != input[j][i]) {
				diff = 1;
				break;
			}
		}
		if (diff == 1) result[i] = '?';
		else result[i] = prev;
	}
	for (int i = 0; i < size; i++) {
		printf("%c", result[i]);
	}
}
