#include <iostream>
#include <stack>
#define PIC pair<int,char>
using namespace std;

stack<PIC> result;
int priority;

int main(){
	string s;
	cin >> s;
	for(int i=0; i<s.size(); i++){
		char temp = s[i];
		if(temp == '*') priority = 2;
		else if(temp == '/') priority = 2;
		else if(temp == '+') priority = 1;
		else if(temp == '-') priority = 1;
		else if(temp == '('){
			result.push(make_pair(0,temp));
			continue;
		}
		else if(temp == ')'){
			while(result.top().second != '('){
				cout << result.top().second;
				result.pop();
			}
			result.pop();
			continue;
		}
		else {
			cout << temp;
			continue;
		}
		while( (!result.empty()) && result.top().first >= priority){
			cout << result.top().second;
			result.pop();
		}
		result.push(make_pair(priority,temp));
	}
	while(!result.empty()){
		cout << result.top().second;
		result.pop();
	}
}
