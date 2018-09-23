//
//  14594.cpp
//  codingtest
//
//  Created by sujin.kim on 2018. 9. 23..
//  Copyright © 2018년 sujin.kim. All rights reserved.
//
#include <cstdio>
#include <algorithm>
using namespace std;
const int INF = 1e9+1;

int main(){
    int N, M;
    scanf("%d %d", &N ,&M);
    pair<int, int> L[M];
    for(int i=0; i<M; i++){
        int s, e;
        scanf("%d %d", &s, &e);
        L[i] = make_pair(s, e);
    }
    sort(L, L+M);
    int result = 0, l = -INF, r = -INF;
    for(int i=0; i<M; i++){
        if(r < L[i].first){
            if(l == -INF && L[i].first > 1){
                result += (L[i].first - 1);
            }
            if(r != -INF && L[i].first - r > 1){
                result += (L[i].first - r - 1);
            }
            l = L[i].first;
            r = L[i].second;
            result++;
        }
        else r = max(r, L[i].second);
    }
    if(M == 0) result = N;
    else result += (N - r);
    printf("%d\n", result);
}

