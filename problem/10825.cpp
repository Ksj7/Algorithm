#include <iostream>
#include <vector>
#include <string>
#include <algorithm>
using namespace std;
struct Info {
	string name;
	int kor, eng, mat;
};
bool cmp(const Info &u, const Info &v) {
    if (u.kor > v.kor) {
        return true;
	}
	else if (u.kor == v.kor) {
		if (u.eng < v.eng) {
			return true;
		}
		else if (u.eng == v.eng) {
			if (u.mat > v.mat) {
				return true;
			}
			else if (u.mat == v.mat) {
				return u.name < v.name;
			}
		}
	}
	return false;
}
int main() {
    int n;
	cin >> n;
    vector<Info> arr(n);
    for (int i=0; i<n; i++) {
		cin >> arr[i].name >> arr[i].kor >> arr[i].eng >> arr[i].mat;
    }
    sort(arr.begin(), arr.end(),cmp);
    for (int i=0; i< n; i++) {
        cout << arr[i].name << '\n';
    }
    return 0;
}