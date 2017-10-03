#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int N;
int check[101] = {0,};
int result[101][101] = {0,};
vector<vector<int> > v;

void dfs(int i){
	if(check[i] == true){
		check[i]++;
		return;
	}
	check[i] = true;
	for(int j=0; j<v[i].size(); j++)
		if(check[v[i][j]] == false){
			dfs(v[i][j]);		
		}else check[v[i][j]]++;
	return;
}

int main(){
	cin >> N;
	v.resize(N+1);
	for(int i=0; i<N; i++)
		for(int j=0; j<N; j++){
			int temp;
			cin >> temp;
			if(temp == 1)
				v[i].push_back(j);
		}
	
	for(int i=0; i<N; i++){
		dfs(i);
		for(int j=0; j<N; j++){
			if(i == j)
				if(check[j] > 1) result[i][j] = 1;
				else result[i][j] = 0;
			else result[i][j] = (check[j]>=1)? 1 : 0;
			check[j] = 0;
		}
	}
	for(int i=0; i<N; i++){
		for(int j=0; j<N; j++)
			cout << result[i][j] << ' ';
		cout << endl;
	}
}

