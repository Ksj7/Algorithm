#include <iostream>
#include <vector>

using namespace std;

int N, cnt = 0;
int s = -1, e = -1;
int idx1, idx2;

int main(){
	cin >> N;
	for(int i=0; i< N; i++){
		cin >> idx1 >> idx2;
		if(s  == -1 && e == -1) {
			s = idx1; e = idx2;
			cnt = e - s;
		}else if(s >= idx1 && e <= idx2){
			s = idx1; e = idx2;
			cnt = e - s;
		}else if(s >= idx1 && e >= idx2){
			s = idx1; cnt = e - s;
		}else if(s <= idx1 && e > idx1 && e <= idx2){
			e = idx2; cnt = e - s;
		}
		else if(e <= idx1){
			s = idx1 ; e = idx2;
			cnt += (e - s);
		}
	}
	cout << cnt << endl;
}
