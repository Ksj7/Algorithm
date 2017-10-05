#include <iostream>
#include <queue>
#define PII pair<int,int>
using namespace std;

int dx[] = {2,1};
int dy[] = {1,2};
int dxx[] = {-1,-1,1,1};
int dyy[] = {-1,1,1,-1};
int T, N, Q, W, S, E;
int v[301][301];
int check[301][301];
queue<PII> q;

void bfs(){
	while(!q.empty()){
		int x = q.front().second;
		int y = q.front().first;
		q.pop();
		for(int i=0; i<4; i++){
			for(int j=0; j<2; j++){
				int xx = dx[j] * dxx[i] + x;
				int yy = dy[j] * dyy[i] + y;
				if(0<=xx && xx<N && 0<=yy && yy<N && check[yy][xx] == -1 ){
						check[yy][xx] = check[y][x] + 1;
						q.push(make_pair(yy,xx));
				}
			}
		}
	}
}

int main() {
	cin >> T;
	while(T--){
		cin >> N;
		cin >> S >> E;
		cin >> Q >> W;
	
		for(int i=0; i<=N; i++){
			for(int j=0; j<=N; j++){
				check[i][j] = -1;
			}
		}
		check[E][S]++;
		q.push(make_pair(E,S));
		bfs();
		cout << check[W][Q] << endl;
	}

}
