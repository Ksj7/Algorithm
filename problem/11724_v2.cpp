#include <iostream>
#include <algorithm>
#include <vector>

using namespace std;

int N, M, NUM;
vector<vector<int> > v;
int check[1001] = {0,};

void dfs(int i){
	if(check[i] == true) return;
	check[i] = true;
	for(int j=0; j<v[i].size(); j++){
		if(check[v[i][j]] == false) dfs(v[i][j]);
	}
}

int main(){
	cin >> N >> M;
	v.resize(N + 1);
	NUM = 0;
	for(int i=1; i<=M; i++){
		int temp, temp2;
		cin >> temp;
		cin >> temp2;
		v[temp].push_back(temp2);
		v[temp2].push_back(temp);
	}
	for(int i=1; i<=N; i++)
		sort(v[i].begin(), v[i].end());
	for(int i=1; i<=N; i++){
		if(check[i] == false && v[i].size() > 0) {
			NUM++;
			dfs(i);
		}
	}
	for(int i=1; i<=N; i++)
		if(check[i] == 0) NUM++;
	cout << NUM;
}
