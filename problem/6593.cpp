#include <iostream>
#include <queue>
#define PII pair<int,int>
#define PIP pair<int,pair<int,int> >
using namespace std;

int L, R, C;
char v[31][31][31];
int check[31][31][31];
int sx, sy, sz, ex, ey, ez;
int dy[] = {0,0,-1,1};
int dx[] = {-1,1,0,0};
int dz[] = {1,-1};

queue<PIP> q;

void bfs(){
	while(!q.empty()){
		int z = q.front().first;
		int x = (q.front().second).second;
		int y = (q.front().second).first;
		q.pop();
		for(int i=0; i<4; i++){
			int nx = dx[i] + x;
			int ny = dy[i] + y;
			if(0 <= nx && nx < R && 0 <= ny && ny < C ){
				if(check[z][ny][nx] == -1 ) {
					if( v[z][ny][nx] == '.') {
						check[z][ny][nx] = check[z][y][x] + 1;
						q.push(make_pair(z,make_pair(ny,nx)));
					}
					else if( v[z][ny][nx] == 'E') {
						check[z][ny][nx] = check[z][y][x] + 1;
						return;
					}
				}
			}
		}
		for(int i=0; i<2; i++){
			int nz = dz[i] + z;
			if(0 <= nz && nz < L){
				if(check[nz][y][x] == -1) {
					if(v[nz][y][x] == '.'){
						check[nz][y][x] = check[z][y][x] + 1;
						q.push(make_pair(nz,make_pair(y,x)));
					}
					else if(v[nz][y][x] == 'E'){
						check[nz][y][x] = check[z][y][x] + 1;
						return;
					}
				}
			}
		}
	}
}

int main(){
	//L은 층
	//R은 행(가로)
	//C는 열(세로)
	while(true){
		while( !q.empty() ) q.pop();
		cin >> L >> C >> R;
		if(L == 0 && R == 0 && C == 0) break;
		for(int l=0; l<L; l++)
			for(int c=0; c<C; c++)
				for(int r=0; r<R; r++){
					cin >> v[l][c][r];
					check[l][c][r] = -1;
					if(v[l][c][r] == 'S'){
						sz = l; sx = r; sy = c; 
					}else if(v[l][c][r] == 'E'){
						ez = l; ex = r; ey = c;
					}
				}
		check[sz][sy][sx]++;
		q.push(make_pair(sz,make_pair(sy,sx)));
		bfs();
		
		if(check[ez][ey][ex] == -1) cout << "Trapped!" << endl;
		else cout << "Escaped in "<< check[ez][ey][ex] << " minute(s)."<< endl;
	}


}
