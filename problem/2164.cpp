#include <iostream>
#include <queue>

using namespace std;

queue<int> q;
int N;

int main(){
	cin >> N;
	for(int i=1; i<=N; i++)
		q.push(i);
	
	while(!q.empty()){
		int temp = q.front(); q.pop();
		if(q.empty()){
			cout << temp << endl;	
			break;
		}
		q.push(q.front());
		q.pop();

	}

}

