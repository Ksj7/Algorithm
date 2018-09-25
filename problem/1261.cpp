//
//  1261.cpp
//  codingtest
//
//  Created by sujin.kim on 2018. 9. 23..
//  Copyright © 2018년 sujin.kim. All rights reserved.
//

#include <cstdio>
#include <vector>
#include <queue>
#include <algorithm>
using namespace std;
const int INF = 1e9+1;
typedef pair<int, int> P;
unsigned int dist[101][101];
bool arr[101][101];
int dy[] = {-1,1,0,0};
int dx[] = {0,0,-1,1};
int n, m;


int main(){
    scanf("%d %d", &n, &m);
    for(int i=0; i<m; i++){
        getchar();
        for(int j=0; j<n; j++)
            arr[i][j] = (getchar()=='1');
    }
    
    for(int i = 0; i < m; i++)
        fill(dist[i], dist[i]+n, INF);
    bool visited[101][101] = {0};
    priority_queue<P, vector<P>, greater<P>> PQ;
    dist[0][0] = 0;
    PQ.push(P(0,0));
    
    while(!PQ.empty()){
        int y,x;
        do{
            y = PQ.top().second/100;
            x = PQ.top().second%100;
            PQ.pop();
        }while(!PQ.empty() && visited[y][x]);
        
        visited[y][x] = true;
        for(int u = 0; u < 4; u++){
            int ny = y + dy[u];
            int nx = x + dx[u];
            
            if( 0 <= nx && nx < n && 0 <= ny && ny < m && !visited[ny][nx]){
                if(dist[ny][nx] > dist[y][x] + arr[ny][nx]){
                    dist[ny][nx] = dist[y][x] + arr[ny][nx];
                    PQ.push(P(dist[ny][nx], ny*100+nx));
                }
            }
        }
    }
    
    printf("%d",dist[m-1][n-1]);
}

