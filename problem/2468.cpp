#include <iostream>
#include <vector>
#define MAX(X,Y) ((X) > (Y) ? (X) : (Y)) 
#define MIN(X,Y) ((X) > (Y) ? (Y) : (X))

using namespace std;

int v[101][101];
int test[101][101];
int check[101][101];
int N, cnt = 0;
int dx[] = {0,0,-1,1};
int dy[] = {-1,1,0,0};

void dfs(int v[101][101], int y, int x){
	if(check[y][x] == true) return;
	check[y][x] = true;
	for(int i=0; i<4; i++){
		int nx = dx[i] + x;
		int ny = dy[i] + y;
		if(0 <= nx && nx < N && 0 <= ny && ny < N)
			if(check[ny][nx] == false && v[ny][nx] == 1)
				dfs(v,ny,nx);
	}
}

int main(){
	cin >> N;
	int max_value = 0, min_value = 101;
	int num;
	for(int i=0; i<N; i++)
		for(int j=0; j<N; j++){
			cin >> v[i][j];
			max_value = MAX(max_value, v[i][j]);
			min_value = MIN(min_value ,v[i][j]);
		}
	for(int k=min_value; k<=max_value; k++) {
		num = 0;
		for(int i=0; i<N; i++)
			for(int j=0; j<N; j++){
				if(k > v[i][j]) test[i][j] = 0;
				else test[i][j] = 1;
				check[i][j] = false;
			}
		for(int i=0; i<N; i++)
			for(int j=0; j<N; j++)
				if(check[i][j] == false && test[i][j] == 1){
					num++;
					dfs(test,i,j);	
				}

		cnt = MAX(cnt,num);
	}
	cout << cnt << endl; 
}		

