#include <iostream>

using namespace std;

int v[51][51];
int check[51][51];
int dx[] = {0,1,0,-1};
int dy[] = {-1,0,1,0};
int T, N, M, K;

void dfs(int x, int y){
	if(check[x][y] == 1) return;
	check[x][y] = 1;
	for(int i=0; i<4; i++){
		int nx = dx[i] + x;
		int ny = dy[i] + y;
		if(0 <= nx && nx < M && 0 <= ny && ny < N)
			if(check[nx][ny] == 0 && v[nx][ny] == 1)
				dfs(nx,ny);
	}
	
}

int main(){
	cin >> T;
	while(T--){
		int cnt = 0;
		cin >> M; cin >> N; cin >> K;
		for(int i=0; i<M; i++)
            for(int j=0; j<N; j++){
                 v[i][j] = 0;
                 check[i][j] = 0;
		  	 }         

		for(int i=0; i<K; i++){
			int x ,y;
			cin >> x; cin >> y;
			v[x][y] = 1;
		}
		
		for(int i=0; i<M; i++)
			for(int j=0; j<N; j++) 
				if(check[i][j] == 0 && v[i][j] == 1){
					cnt++;
					dfs(i,j);
				}
		
		cout << cnt << endl;	
	}
}
