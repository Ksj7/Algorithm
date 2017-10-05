#include <iostream>
#include <queue>
#include <string>
#define PII pair<int,int>

using namespace std;

int N, M;//N은 세로, M은 가로
int v[101][101];
int check[101][101];
int dx[] = {0,0,-1,1};
int dy[] = {-1,1,0,0};
queue<PII> q;

void bfs() {
   while(!q.empty()) {
		int x = q.front().second;
		int y = q.front().first;
		q.pop();
		for(int i=0; i<4; i++) {
			int nx = dx[i] + x;
			int ny = dy[i] + y;
			if(1 <= nx && nx <= M && 1 <= ny && ny <= N){
				if(v[ny][nx] == 1 && check[ny][nx] == -1){
					check[ny][nx] = check[y][x] + 1;
					q.push(make_pair(ny,nx));
				}
			}
		}
	}
}									 
int main(){
	string s;
	cin >> N >> M;
	for(int i=1; i<=N; i++){
		cin >> s;
		for(int j=0; j<M; j++){
			v[i][j+1] = s[j] - '0';
			check[i][j+1] = -1;
		}
	}

	for(int i=1; i<=N; i++)
		for(int j=1; j<=M; j++){
			if(check[i][j] == -1 && v[i][j] == 1){
				check[i][j] = 1;
				q.push(make_pair(i,j));
				bfs();
			}
		}


	cout << check[N][M]  << endl;
}
