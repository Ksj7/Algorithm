//
//  main.cpp
//  codingtest
//
//  Created by sujin.kim on 2018. 9. 11..
//  Copyright © 2018년 sujin.kim. All rights reserved.
//
#include <cstdio>
#include <cstring>
#include <algorithm>
#include <queue>
#include <vector>

using namespace std;
static int N;
static int arr[101][101];
static int check[101][101];
static int dy[4] = {-1,1,0,0};
static int dx[4] = {0,0,-1,1};
static int ret= 9876543;


static int bfs(int cnt){
    queue<pair<int, int>> q;
    for(int i =0 ; i< N; i++){
        for(int j = 0; j< N;j++){
            if(arr[i][j] == cnt){
                check[i][j] = 1;
                q.push({ i,j });
            }
        }
    }
    int ret = 0;
    while(q.size()){
        int qs = q.size();
        while (qs--) {
            int y = q.front().first;
            int x = q.front().second;
            q.pop();
            for(int i =0; i < 4; i++){
                int ny = dy[i] + y;
                int nx = dx[i] + x;
                if(0 <= ny && ny < N && 0 <= nx && nx < N){
                    if(arr[ny][nx] != 0 && arr[ny][nx] != cnt){
                        return ret;
                    }
                    if (arr[ny][nx] == 0 && !check[ny][nx]) {
                        check[ny][nx] = 1;
                        q.push({ ny,nx });
                    }
                }
            }
        }
        ret++;
    }
    return 9876543;
}
static void fun_union(int y, int x, int sig){
    for(int i = 0; i < 4; i++){
        int ny = y + dy[i];
        int nx = x + dx[i];
        if(0 <= nx && nx < N && 0 <= ny && ny < N){
            if(arr[ny][nx] == 1 && check[ny][nx]==0){
                check[ny][nx] = 1;
                arr[ny][nx] = sig;
                fun_union(ny,nx,sig);
            }
        }
    }
}

int main(){
    scanf("%d", &N);
    for(int i = 0 ; i < N; i++){
        for(int j = 0; j < N; j++){
            scanf("%d", &arr[i][j]);
        }
    }
    int n = 1;
    for(int i = 0 ; i < N; i++){
        for(int j = 0; j < N; j++){
            if(arr[i][j] == 1 && check[i][j] == 0){
                check[i][j] = 1;
                arr[i][j] = n;
                fun_union(i,j,n);
                n++;
            }
        }
    }
    
    memset(check, 0, sizeof(check));
    for(int i = 1 ; i <= n; i++){
        ret = min(bfs(i), ret);
    }
    
    printf("%d", ret);
    
    return 0;
}


