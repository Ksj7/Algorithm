#include <cstdio>
#include <vector>
#include <algorithm>
using namespace std;
int main() {
    int n , m , temp;
	scanf("%d", &n);
    vector<int> card(n);
	for (int i = 0; i < n; i++) {
		scanf("%d", &card[i]);
    }
	sort(card.begin(), card.end());
	scanf("%d", &m);
	for (int i = 0; i < m; i++) {
		scanf("%d", &temp);
		printf("%d ", binary_search(card.begin(), card.end(), temp));
	}
    return 0;
}