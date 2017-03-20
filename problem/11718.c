#include <stdio.h>

int main() {
	char words[101];
	while(scanf("%[^\n]%*c", &words) != EOF)
		printf("%s\n",words);
							
	return 0;
}
