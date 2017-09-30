#include <iostream>
#include <queue>

#define PII pair<int,int>

using namespace std;

int dx[] = {0,1,0,-1};
int dy[] = {-1,0,1,0};
int v[1001][1001];
int check[1001][1001] = {0,};
int M, N, MAX = 0;
int cnt = 0;
queue<PII> q;

void bfs() {
	while(!q.empty()) {
		int x = q.front().first; 
		int y = q.front().second;
		q.pop();

		for(int i=0; i<4; i++) {
			int nx = dx[i] + x;
			int ny = dy[i] + y;
			if(0 <= nx && nx < N && 0 <= ny && ny < M){
				if(v[nx][ny] == 0 && check[nx][ny] == -1){	
				    check[nx][ny] = check[x][y] + 1; 
					if(check[nx][ny] > MAX) MAX = check[nx][ny];
					q.push(make_pair(nx,ny));
				}
			}

		}
	}
}

int main(){
	cin >> M >> N;
	for(int i=0; i<N; i++)
		for(int j=0; j<M; j++){
			cin >> v[i][j];
			check[i][j] = -1;
		}
	for(int i=0; i<N; i++)
		for(int j=0; j<M; j++)
			if(v[i][j] == 1 && check[i][j] == -1){
				check[i][j] = 0;
				q.push(make_pair(i, j));
			}
	bfs();
		
	for(int i = 0; i < N; i++){
		for(int j = 0 ; j < M; j++)
			if(check[i][j] == -1 && v[i][j] == 0)
				MAX = -1;
	}
	cout << MAX << endl;
}
