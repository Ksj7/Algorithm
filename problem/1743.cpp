#include <iostream>
#define MAX(X,Y) ((X) > (Y) ? (X) : (Y))

using namespace std;

int dx[] = {0,0,-1,1};
int dy[] = {-1,1,0,0};
int v[101][101] = {0,};
int check[101][101] = {0,};
int N, M, K, cnt = 0;

void dfs(int y, int x){
	if(check[y][x] == true) return;
	check[y][x] = true; cnt++;
	for(int i=0; i<4; i++){
		int ny = dy[i] + y;
		int nx = dx[i] + x;
		if(1 <= ny && ny <= N && 1 <= nx && nx <= M)
			if(check[ny][nx] == false && v[ny][nx] == 1) {
				dfs(ny,nx);
			}
	}

}

int main(){
	int max_value = 0;
	cin >> N >> M >> K;
	for(int i=1; i<=K; i++){
		int y, x;
		cin >> y >> x;
		v[y][x] = 1; 
	}
	
	for(int y=1; y<=N; y++)
		for(int x=1; x<=M; x++)
			if(check[y][x] == false && v[y][x] == 1) {
				dfs(y,x);
				max_value = MAX(cnt, max_value);
				cnt = 0;
			}

	cout << max_value << endl;	

}

