//
//  main.c
//  codingtest
//
//  Created by sujin.kim on 2018. 9. 11..
//  Copyright © 2018년 sujin.kim. All rights reserved.
//

#include <stdio.h>

static int M;
static int N;
static int arr[301][301];
static int check[301][301];
static int dy[4];
static int dx[4];

static void dfs(int y, int x) {
    check[y][x] = 1;
    
    for (int i = 0; i < 4; i++) {
        int nx = dx[i] + x;
        int ny = dy[i] + y;
        
        if (0 <= ny && ny < N && 0 <= nx && nx < M) {
            if (check[ny][nx] == 0 && arr[ny][nx] > 0) {
                dfs(ny, nx);
            }
        }
    }
}

static int solve(){
    int n = 0;
    for(int i = 0 ; i < N; i++){
        for(int j = 0; j < M; j++){
            if(arr[i][j] > 0 && check[i][j] == 0){
                n++;
                dfs(i,j);
            }
        }
    }
    return n;
}


static int melting(int y, int x) {
    if(arr[y][x] <= 0) return 0;
    int cnt = 0;
    for (int i = 0; i < 4; i++) {
        int nx = dx[i] + x;
        int ny = dy[i] + y;
        if (0 <= ny && ny < N && 0 <= nx && nx < M) {
            if (arr[ny][nx] <= 0) {
                cnt++;
            }
        }
    }
    return cnt;
}


int main(int argc, const char * argv[]) {
    // insert code here...
    scanf("%d", &N);
    scanf("%d", &M);
    dy[0] = dx[3] = 0;
    dy[1] = dx[2] = 0;
    dy[2] = dx[1] = -1;
    dy[3] = dx[0] = 1;
    
    for(int i = 0; i < N; i++){
        for(int j =0 ; j < M; j++){
            scanf("%d", &arr[i][j]);
        }
    }
    int cnt = -1;
    while(1){
        int ret = solve();
        cnt++;
        if(ret == 0){
            cnt = 0;
            break;
        }
        if(ret >= 2){
            break;
        }
        int meltingCount[301][301] = {0,};
        for(int i = 1; i < N - 1; i++){
            for(int j = 1; j < M - 1; j++){
                meltingCount[i][j] = melting(i,j);
            }
        }
        for(int i = 1; i < N - 1; i++){
            for(int j = 1; j < M - 1; j++){
                arr[i][j] -= meltingCount[i][j];
            }
        }
        
        
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                check[i][j] = 0;
            }
        }
    }
    
    printf("%d", cnt);
    return 0;
}

