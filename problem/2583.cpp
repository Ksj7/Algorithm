#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int N, M, K, cnt = 0;
int dx[] = {0,0,-1,1};
int dy[] = {-1,1,0,0};
int v[101][101];
int check[101][101];
vector<int> result;

void dfs(int y, int x){
	if(check[y][x] == true) return;
	check[y][x] = true;
	cnt++;
	for(int i=0; i<4; i++){
		int nx = dx[i] + x;
		int ny = dy[i] + y;
		if(0 <= nx && nx < M && 0 <= ny && ny < N)
			if(check[ny][nx] == false && v[ny][nx] == 0)
				dfs(ny,nx);
	}		
}

int main(){
	cin >> N >> M >> K;
	for(int i=0; i<K; i++){
		int u1, u2, v1, v2;
		cin >> u1 >> v1 >> u2 >> v2;
		for(int i=v1; i<v2; i++)
			for(int j=u1; j<u2; j++)
				v[i][j] = 1;
	}
	
	for(int i=0; i<N; i++){
		for(int j=0; j<M; j++)
			if(check[i][j] == false && v[i][j] == 0){
				dfs(i,j);
				result.push_back(cnt);
				cnt = 0;
			}
	}
	
	sort(result.begin(), result.end());
	cout << result.size() << endl;
	for(int i=0; i<result.size(); i++)
		cout << result[i] << ' ';
}

