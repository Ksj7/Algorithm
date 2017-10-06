#include <iostream>
#include <queue>
#include <vector>
#define PII pair<int,int>
#define MIN(X,Y) ((X)>(Y)?(Y):(X))

using namespace std;

queue<PII> q;
queue<PII> q2;
int T, W, H;
int sx, sy;
vector<PII> f;
char v[1001][1001];
int check[1001][1001];
int check2[1001][1001];
int dx[] = {0,0,-1,1};
int dy[] = {-1,1,0,0};
int min_value;

void bfs(queue<PII> q,int c[1001][1001]){
	while(!q.empty()){
		int nx = q.front().second;
		int ny = q.front().first;
		q.pop();
		if( nx == -1 && ny == -1) return;	
		for(int i=0; i<4; i++){
			int x = dx[i] + nx;
			int y = dy[i] + ny;
			if(1 <= x && x <= W && 1 <= y && y <= H){
				if(v[y][x] == '.' && c[y][x] == 0){
					c[y][x] = c[ny][nx] + 1;
					q.push(make_pair(y,x));
				}
			}
		}
	}
}
int main(){
	string s;
	cin >> T;
	while(T--) {	
		min_value = 999999;
		cin >> W >> H;
		for(int i=1; i<= H; i++){
			cin >> s;
			for(int j=1; j<=W; j++){
				v[i][j] = s[j-1];
				if(v[i][j] == '@'){
					sx = j; sy = i;
				}else if(v[i][j] == '*'){
					f.push_back(make_pair(i,j));
				}
				check[i][j] = 0;
				check2[i][j] = 0;
			}
		}
		while(!q.empty()) q.pop();
		while(!q2.empty()) q2.pop();
		check[sy][sx]++;
		q.push(make_pair(sy,sx));
		bfs(q, check);
		while(!f.empty()){
			int fx = f.back().second;
			int fy = f.back().first;
			f.pop_back();
			check2[fy][fx]++;
			q2.push(make_pair(fy,fx));

		}
		bfs(q2, check2);
		for(int i=1; i<=H; i++){
			for(int j=1; j<=W; j++){
				if(check2[i][j] != 0 && check[i][j] >= check2[i][j])
					check[i][j] = 0;
				if(i == 1 || i == H || j == 1 || j == W){
					if(check[i][j] != 0) min_value = MIN(check[i][j], min_value);
				}
			}
		}
		if(min_value == 999999) cout << "IMPOSSIBLE" << endl;
		else cout << min_value << endl;
	}
}
