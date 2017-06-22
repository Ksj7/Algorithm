#include <stdio.h>

int main(void) {
	// your code goes here
	int c;
	int y = 0, n = 0; int ans = 0;
	char* nocute = "Junhee is not cute!";
	char* cute = "Junhee is cute!";
	scanf("%d", &c);
	for(int i = 0 ; i < c; i++){
		scanf("%d", &ans);
		if(ans) y++;
		else n++;
	}
	
	printf("%s",(y > n) ? cute : nocute );
	return 0;
}
