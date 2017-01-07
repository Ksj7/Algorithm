#include<cstdio>
#include<queue>
using namespace std;
int main(){
	int n;
	queue<int> q ;
	char str[6];
	scanf("%d",&n);
	for(int i = 0; i < n ; i++){
		int num;
		scanf("%s",str);
		if(str[0] == 'p' && str[1] == 'u'){
			scanf("%d", &num);
			q.push(num);
			continue;
		}
		else if (str[0]=='p' && str[1] == 'o'){
			if(q.empty()) printf("-1");
			else {
				printf("%d",q.front());
				q.pop();
			}
		}
		else {
			if(str[0] == 'f'){
				if(q.empty()) printf("-1");
				else printf("%d",q.front());
			}else if(str[0] == 'b'){
				if(q.empty()) printf("-1");
				else printf("%d",q.back());
			}else if(str[0] == 's'){
				printf("%d",q.size());
			}else if(str[0] == 'e'){
				printf("%d",q.empty());
			}
		}
		printf("\n");
	}
	return 0;
}