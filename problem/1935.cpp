#include <iostream>
#include <stack>
#include <cstdio>

using namespace std;

stack<double> result;
int N;
int num[27];

int main(){
	string s;
	cin >> N >> s;
	for(int i=0; i<N; i++){
		cin >> num[i];	
	}
	for(int i=0; i<s.size(); i++){
		if(s[i] == '*' || s[i] == '-' || s[i] == '+' || s[i] == '/'){
			double B = result.top(); result.pop();
			double A = result.top(); result.pop();
			if(s[i] == '*') result.push((double) (A * B));
			else if(s[i] == '+') result.push((double) (A + B));
			else if(s[i] == '/') result.push((double) (A / B));
			else result.push((double) (A - B));
		}
		else result.push(num[s[i]-'A']);	
	}
	printf("%.2f",result.top());
}
