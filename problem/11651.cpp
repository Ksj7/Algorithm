#include <cstdio>
#include <vector>
#include <algorithm>
using namespace std;

bool cmp(const vector<int> &u, const vector<int> &v) {
    if (u[1] < v[1]) {
        return true;
    } else if (u[1]== v[1]) {
        return u[0] < v[0];
    } else {
        return false;
    }
}
int main() {
    int n;
    scanf("%d",&n);
    vector<vector<int>> a(n);
    for (int i=0; i<n; i++) {
		a[i].resize(2);
        scanf("%d %d",&a[i][0],&a[i][1]);
    }
    sort(a.begin(),a.end(),cmp);
    for (int i=0; i< n; i++) {
        printf("%d %d\n",a[i][0], a[i][1]);
    }
    return 0;
}