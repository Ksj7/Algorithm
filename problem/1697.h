#include<cstdio>
#include<queue>
using namespace std;
queue<int> q;
int main(){
	int n, k;
	int num = 0;
	int visited[100001] = {0,};

	scanf("%d %d", &n, &k);
	q.push(n); 
	while (!q.empty()) {
		n = q.front(); q.pop();
		if( n == k ) {
			num = visited[n];
			break;
		}
		if( n + 1 > -1 && n + 1 < 100001 && visited[n+1] == 0 ){
			visited[n+1] = visited[n] + 1;
			q.push(n+1);
		}
		if ( n - 1 > -1 && n - 1 < 100001 && visited[n-1] == 0 ){
			visited[n-1] = visited[n] + 1;
			q.push(n-1);
		}
		if ( 2 * n > -1 && 2 * n < 100001 && visited[2*n] == 0 ){
			visited[2*n] = visited[n] + 1;
			q.push(2*n);
		}
	}
	printf("%d", num);
}