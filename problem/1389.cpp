#include <iostream>
#include <queue>
#define MIN(X,Y)((X)>(Y)?(Y):(X))
using namespace std;

int v[101][101];
int check[101];
queue<pair<int,int> > q;
pair<int,int> res = make_pair(-1,1000001);
int N, M;

void bfs(){
	while(!q.empty()){
		int y = q.front().first;
		int n = q.front().second;
		q.pop();
		for(int i=1; i<=N; i++){
			if(v[y][i] == 1 && !check[i] && i != y){
				check[i] = n;
				q.push(make_pair(i, n + 1));
			}
		}
	}
}

int main(){
	cin >> N >> M;
	for(int i=1; i<=M; i++){
		int idx1, idx2;
		cin >> idx1 >> idx2;
		v[idx1][idx2] = 1;
		v[idx2][idx1] = 1;
	}
	for(int i=1; i<=N; i++){
		int ans = 0;
	 	q.push(make_pair(i,1));
		bfs();
		for(int j=1; j<=N; j++){
			if(j == i) ans += 0; 
			else ans += check[j];
			check[j] = 0;
		}
		if(res.second>ans){
			res = make_pair(i,ans);
		}
	}
	
	cout << res.first << endl;
}
