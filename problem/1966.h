#include<cstdio>
#include<queue>
using namespace std;
int priority_Arr[101] = {0,};

class Node{
public:
	bool target;
	int value;
public :
	Node(int v){
		value= v;
		target = false;
	}
};

void sort(int n){
	for(int i = 0 ; i < n-1 ; i++){
		int max = i;
		for(int j = i; j < n ; j++){
			if(priority_Arr[max] < priority_Arr[j])
				max = j;
		}
		if(max != i){
			int temp = priority_Arr[max];
			priority_Arr[max] = priority_Arr[i];
			priority_Arr[i] = temp;
		}
	}

}

int main(){
	int testcase;
	scanf("%d",&testcase);
	while(testcase){
		queue<Node> q;
		int n , m , priority, top = 0;
		scanf("%d %d", &n, &m);
		for(int i = 0; i < n; i++){
			scanf("%d", &priority);
			Node n(priority);
			priority_Arr[i] = priority;
			if(m == i) {
				n.target = true;
			}
			q.push(n);
		}
		sort(n);
		int count = 0;
		while(!q.empty() && top <= n){
			Node temp = q.front(); q.pop();
			if(temp.value ==  priority_Arr[top]){
				count++;
				if(temp.target) break;
				top++;
			}else{
				q.push(temp);
			}
		}
		printf("%d\n", count);
		testcase--;
	}
}