//
//  1182.cpp
//  codingtest
//
//  Created by sujin.kim on 2018. 9. 21..
//  Copyright © 2018년 sujin.kim. All rights reserved.
//

#include <iostream>
using namespace std;
int cnt = 0;
int n,s;
int arr[21];
void dfs(int idx, int sum){
    if(sum == s) cnt++;
    if(idx >= n){
        return;
    }
    
    for(int i = idx; i < n; i++){
        dfs(i + 1, sum + arr[i]);
    }
}

int main(){
    cin >> n >> s;
    for(int i = 0; i < n; i++)
        cin >> arr[i];
    for(int i = 0; i < n; i++){
        dfs(i + 1, arr[i]);
    }
    cout << cnt;
}
