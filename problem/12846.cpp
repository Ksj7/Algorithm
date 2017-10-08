#include <iostream>
#include <stack>
#include <algorithm>

using namespace std;

int n; stack<int> s;
int h[100001];

int main(){
	cin >> n;
	for(int i=1 ; i<=n; i++) cin >> h[i];
	int mx = -1;
	for(int i=1; i<=n; i++) {
		if(!(s.empty() || h[i] >= h[s.top()])) {
			while(!s.empty() && h[s.top()] >= h[i]){
				int curr = s.top(); s.pop();
				if(s.empty()) mx = max(mx, (i-1) * h[curr]);
				else mx = max(mx, ((i-1) - s.top()) * h[curr]);
			}
		}	
		s.push(i);
	}

	while(!s.empty()){
		int curr = s.top(); s.pop();
		if(s.empty()) mx = max(mx, n * h[curr]);
		else mx = max(mx, (n - s.top())  * h[curr]);
	}	
	cout << mx << '\n';
}
