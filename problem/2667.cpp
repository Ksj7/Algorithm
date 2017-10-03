#include <iostream>
#include <vector>
#include <algorithm>
#include <string>

using namespace std;

int v[26][26] = {0,};
int check[26][26] = {0,};
int dx[] = {0,0,-1,1};
int dy[] = {-1,1,0,0};
int N, cnt = 0;
vector<int> result;

void dfs(int y, int x){
	if(check[y][x] == true) return;
	check[y][x] = true;
	cnt++;
	for(int i=0; i<4; i++){
		int nx = dx[i] + x;
		int ny = dy[i] + y;
		if(1 <= nx && nx <= N && 1<= ny && ny <= N)
			if(check[ny][nx] == false && v[ny][nx] == 1)
				dfs(ny,nx);
	}
}

int main(){
	cin >> N;
	string s;
	for(int i=1; i<=N; i++){
		cin >> s;
		for(int j=1; j<=N; j++)
			v[i][j] = s[j-1] - '0';
	}

	for(int i=1; i<=N; i++)
		for(int j=1; j<=N; j++)
			if(check[i][j] == false && v[i][j] == 1){
				dfs(i,j);
				result.push_back(cnt);
				cnt = 0;
			}
	sort(result.begin(), result.end());
	cout << result.size() << endl;
	for(int i=0; i<result.size(); i++)
		cout << result[i] << endl;

}	
