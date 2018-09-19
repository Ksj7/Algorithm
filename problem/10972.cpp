//
//  10972.cpp
//  codingtest
//
//  Created by sujin.kim on 2018. 9. 19..
//  Copyright © 2018년 sujin.kim. All rights reserved.
//

#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;
int n;
vector<int> v;

int findValue(int idx){
    int opt = 99999999;
    int res = idx + 1;
    for(int i = idx + 1; i < n; i++){
        if(v[idx] < v[i] && opt > v[i]){
            opt = v[i];
            res = i;
        }
    }
    return res;
}

int main(){
    cin >> n;
    for(int i = 0; i < n; i++){
        int t;
        cin >> t;
        v.push_back(t);
    }
    
    int i = n - 2;
    for(; i >= 0; i--){
        if(v[i] <= v[i + 1]){
            int findIdx = findValue(i);
            int tmp = v[findIdx];
            v[findIdx] = v[i];
            v[i] = tmp;
            sort(v.begin() + i + 1, v.end());
            break;
        }
    }
    if( i == -1 ) cout << -1;
    else {
        for(int i = 0; i < n; i ++){
            cout << v[i] << " ";
        }
    }
}

