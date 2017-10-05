#include <iostream>
#include <queue>
using namespace std;

int v[1000001];
int check[1000001] = {0,};
int F, S, G, U, D;
queue<int> q;

void bfs(){
	while(!q.empty()){
		int s = q.front(); q.pop();
		if(s == G) return;
		if(s < G && 1 <= s + U && s + U <= F ){
			if(check[s+U] == false){
				check[s+U] = check[s] + 1;
				q.push(s+U);
			}
		}else if( (s < G && s + U > F && s - D >= 1) || s > G){
			if(check[s-D] == false){
				check[s-D] = check[s] + 1;
				q.push(s-D);
			}
		}
	}
}
int main(){
	//F : 총 빌딩 길이
	//S : 현재 있는 위치
	//G : 스타트 링크 위치
	//U : 위로 올라갈 수 있는 개수
	//D : 밑으로 내려갈 수 있는 개수
	cin >> F >> S >> G >> U >> D;
	if(S == G) cout << '0' << endl;
	else{
		q.push(S);
		bfs();
		if(check[G] == 0) cout << "use the stairs" << endl;
		else cout << check[G] << endl;
	}
}
