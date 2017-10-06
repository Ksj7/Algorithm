#include <iostream>
#include <deque>

using namespace std;

int N, C;
deque<int> d;
string L;
int print_order;

int main(){
	string s;
	cin >> N;
	N++;
	while(N--){
		L = "";
		print_order = 1;
		getline(cin, s);
		for(int i=0; i<s.size(); i++){
			if(s[i] == ' ') {
				int temp = 0;
				for(int j=0; j<i; j++){
					L += s[j];
				}
				for(int j=i+1; j<s.size(); j++){
					temp *=10;
					temp += (s[j] - '0');
				}	
				C = temp;
				print_order = 0;
				break;
			}
		}
		if(print_order) L = s;
		if(L.compare("push_front") == 0)
			d.push_front(C);
		if(L.compare("push_back") == 0)
			d.push_back(C);
		if(L.compare("pop_front") == 0){
			if(d.empty()) cout << -1 << endl;
			else {
				cout << d.front() << endl;
				d.pop_front();
			}
		}
		if(L.compare("pop_back") == 0){
			if(d.empty()) cout << -1 << endl;
			else {
				cout << d.back() << endl;
				d.pop_back();
			}
		}
		if(L.compare("size") == 0)
			cout << d.size() << endl;
		if(L.compare("empty") == 0)
			cout << d.empty() << endl;
		if(L.compare("front") == 0){
			if(d.empty()) cout << -1 << endl;
			else cout << d.front() << endl;
		}
		if(L.compare("back") == 0){
			if(d.empty()) cout << -1 << endl;
			else cout << d.back() << endl;
		}
	}

}
