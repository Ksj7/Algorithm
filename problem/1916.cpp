//
//  1916.cpp
//  codingtest
//
//  Created by sujin.kim on 2018. 9. 25..
//  Copyright © 2018년 sujin.kim. All rights reserved.
//

#include <cstdio>
#include <queue>
#include <algorithm>
#include <vector>
using namespace std;
int N, M;
const int INF = 1e9+1;
typedef pair<int, int> P;
vector<P> adj[1001];
bool visited[1001] = {0,};
int dist[1001];
int S, E;
int main(){
    scanf("%d %d", &N, &M);
    for(int i = 0 ; i < M; i++){
        int u , v , w;
        scanf("%d %d %d", &u, &v, &w);
        adj[u].push_back(P(v,w));
    }
    scanf("%d %d", &S, &E);
    fill(dist, dist+1001, INF);
    priority_queue<P,vector<P>, greater<P>> pq;
    dist[S] = 0;
    pq.push(P(0,S));
    while(!pq.empty()){
        int curr;
        do{
            curr = pq.top().second;
            pq.pop();
        }while(!pq.empty() && visited[curr]);
        if(visited[curr]) break;
        visited[curr] = true;
        for(auto &p : adj[curr]){
            int next = p.first;
            int d = p.second;
            if(!visited[next] && dist[next] > dist[curr] + d){
                dist[next] = dist[curr] + d;
                pq.push(P(dist[next],next));
            }
        }
    }
    printf("%d",dist[E]);
    
}
