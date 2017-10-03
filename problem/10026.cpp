#include <iostream>

using namespace std;

char v[101][101];
char v2[101][101];
int check[101][101];
int check2[101][101];
int dx[] = {0,0,-1,1};
int dy[] = {-1,1,0,0};
int N, cnt = 0, cnt2 = 0;

void dfs(char v[101][101],int check[101][101], int y, int x){
	if(check[y][x] == true) return;
	check[y][x] = true;
	for(int i=0; i<4; i++){
		int nx = dx[i] + x;
		int ny = dy[i] + y;
		if(0 <= nx && nx < N && 0 <= ny && ny < N)
			if(check[ny][nx] == false && v[ny][nx] == v[y][x]) 
				dfs(v,check, ny,nx);
	}
}


int main(){
	cin >> N;
	for(int i=0; i<N; i++)
		for(int j=0; j<N; j++){
			cin >> v[i][j];
			if(v[i][j] == 'G') v2[i][j] = 'R';
			else v2[i][j] = v[i][j];
		}

	for(int i=0; i<N; i++)
		for(int j=0; j<N; j++)
			if(check[i][j] == false){
				cnt++;
				dfs(v,check,i,j);
			}
	
	for(int i=0; i<N; i++)
		for(int j=0; j<N; j++)
			if(check2[i][j] == false){
				cnt2++;
				dfs(v2,check2, i,j);
			}
	cout << cnt << ' ' << cnt2 << endl;
}

