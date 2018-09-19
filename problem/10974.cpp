//
//  10974.cpp
//  codingtest
//
//  Created by sujin.kim on 2018. 9. 19..
//  Copyright © 2018년 sujin.kim. All rights reserved.
//

#include <iostream>
#include <vector>
#include <cmath>
using namespace std;
int n;
vector<vector<int>> v;

void dfs(vector<int> tmp, int cnt, vector<int> check){
    if(cnt == n){
        v.push_back(tmp);
        return;
    }else{
        for(int i = 1; i <= n; i++){
            if(check[i] == 0){
                tmp.push_back(i);
                check[i] = 1;
                dfs(tmp, cnt + 1, check);
                check[i] = 0;
                tmp.pop_back();
            }
        }
    }
}
int main(){
    cin >> n;
    vector<int> tmp;
    vector<int> check(n + 1);
    for(int i = 0; i < n + 1; i++){
        check[i] = 0;
    }
    dfs(tmp, 0, check);
    for(int i = 0; i < v.size(); i++){
        for(int j =0; j < v[i].size(); j++){
            cout << v[i][j] << " ";
        }
        cout << "\n";
    }
}
