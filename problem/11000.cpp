#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int N;
int cnt = 0, num = 0;
vector<pair<int,int> > v;

int main(){
	int i1, i2;
	pair<int,int> temp;
	cin >> N;
	for(int i=0; i<N; i++){
		cin >> i1 >> i2;
		v.push_back(make_pair(i1,1));
		v.push_back(make_pair(i2,-1));
	}
	sort(v.begin(), v.end());
	for(int i=0; i< v.size(); i++){
		num += v[i].second;
		cnt = max(cnt, num);	 
	}
	cout << cnt << endl;
}
