#include <iostream>
#include <queue>
#define PIII pair<pair<int,int>,int>
#define PII pair<int,int>

using namespace std;

int dx[] = { -1, 1, 0, 0};
int dy[] = { 0 , 0, -1, 1};
int dz[] = { 1 , -1};
queue<PIII> q;
int M, N, H, MAX = 0;
int check[101][101][101];
int v[101][101][101];

void bfs(){
	while(!q.empty()){
		int x = (q.front().first).first;
		int y = (q.front().first).second;
		int z = q.front().second;
		q.pop();
		for(int i=0; i<4; i++) {
			int nx = dx[i] + x;
			int ny = dy[i] + y;
			if(0 <= nx && nx < N && 0 <= ny && ny < M) {
				if(check[nx][ny][z] == -1 && v[nx][ny][z] == 0) {
					check[nx][ny][z] = check[x][y][z] + 1;
					if(check[nx][ny][z] > MAX) MAX = check[nx][ny][z];	
					q.push(make_pair(make_pair(nx,ny),z));
				}
			}
		}
		for(int i=0; i<2; i++){
			int nz = dz[i] + z;
			if(0 <= nz && nz < H){
				if(check[x][y][nz] == -1 && v[x][y][nz] == 0){
					check[x][y][nz] = check[x][y][z] + 1;
					if(check[x][y][nz] > MAX) MAX = check[x][y][nz];
					q.push(make_pair(make_pair(x,y),nz));
				}

			}
		}
	}
}



int main() {
	cin >> M >> N >> H;
	for(int z=0; z<H; z++)
		for(int i=0; i<N; i++)
			for(int j=0; j<M; j++) {
				cin >> v[i][j][z];
				check[i][j][z] = -1;
			}
	
	for(int z=0; z<H; z++)
		for(int i=0; i<N; i++)
			for(int j=0; j<M; j++)
				if(v[i][j][z] == 1 && check[i][j][z] == -1){
					check[i][j][z] = 0;
					q.push(make_pair(make_pair(i, j), z));
				}
			

	bfs();
	for(int z=0; z<H; z++)
		for(int i=0; i<N; i++)
			for(int j=0; j<M; j++)
				if(check[i][j][z] == -1 && v[i][j][z] == 0)
					MAX = -1;
	
	cout << MAX << endl;


}
