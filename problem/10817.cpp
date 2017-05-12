#include <algorithm>
#include <iostream>
using namespace std;
int main() {
	int a, b, c, sum;
    cin >> a >> b >> c;
	sum = a + b + c;
	pair<int,int> ans = minmax({a, b, c});
	cout << sum - (ans.first + ans.second) << '\n';
    return 0;
}