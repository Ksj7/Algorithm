//
//  1753.cpp
//  codingtest
//

#include <cstdio>
#include <vector>
#include <queue>
#include <algorithm>
using namespace std;
const int INF = 1e9+1;
int V, E, K;
int u, v, w;
typedef pair<int,int> P;
vector<P> adj[20001];
int dist[20001];
int main(){
    scanf("%d %d %d", &V, &E, &K);
    for(int i = 0; i < E; i++){
        scanf("%d %d %d", &u, &v, &w);
        adj[u].push_back(P(v,w));
    }
    
    fill(dist, dist+20001, INF);
    dist[K] = 0;
    bool visited[20001] = {0};
    priority_queue<P,vector<P>,greater<P>> PQ;
    PQ.push(P(0,K));
    while(!PQ.empty()){
        int curr;
        do{
            curr = PQ.top().second;
            PQ.pop();
        }while(!PQ.empty() && visited[curr]);
        if(visited[curr]) break;
        visited[curr] = true;
        for(auto &p : adj[curr]){
            int next = p.first;
            int d = p.second;
            if(dist[next] > dist[curr] + d){
                dist[next] = dist[curr] + d;
                PQ.push(P(dist[next], next));
            }
        }
    }
    for(int i = 1; i <= V; i++){
        if(i == K) printf("0\n");
        else if(dist[i] == INF) printf("INF\n");
        else printf("%d\n",dist[i]);
    }
}
