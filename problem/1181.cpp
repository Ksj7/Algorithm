#include <iostream>
#include <vector>
#include <string>
#include <algorithm>
using namespace std;
int main() {
	vector<string> dic;
	int n;
	cin >> n;
	dic.resize(n);
	for (int i = 0; i < n; i++) {
		cin >> dic[i];
	}
	sort(dic.begin(), dic.end());
	auto last = unique(dic.begin(), dic.end());
	dic.erase(last, dic.end());
	sort(dic.begin(), dic.end(), [](string u, string v) {
		if (u.size() == v.size()) {
			return u < v;
		}
		else {
			return u.size() < v.size();
		}
	});

	for (int i = 0; i < dic.size(); i++) {
		cout << dic[i] << endl;
	}
}