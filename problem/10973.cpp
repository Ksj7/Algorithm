//
//  10973.cpp
//  codingtest
//
//  Created by sujin.kim on 2018. 9. 18..
//  Copyright © 2018년 sujin.kim. All rights reserved.
//

#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;
int t;
vector<int> n;

int findOptNum(int idx){
    int optNum = -1;
    int optIdx = idx + 1;
    for(int i = idx + 1; i < t; i++){
        if(n[idx] > n[i] && optNum < n[i]){
            optNum = n[i];
            optIdx = i;
        }
    }
    return optIdx;
}

int main(){
    cin >> t;
    for(int i = t - 1; i >= 0; i--){
        int tmp;
        cin >> tmp;
        n.push_back(tmp);
    }
    bool isSucc = true;
    for(int i = t - 2; i >= 0; i--){
        if(n[i] <= n[i + 1]) continue;
        else{
            int idx = findOptNum(i);
            int tmp = n[i];
            n[i] = n[idx];
            n[idx] = tmp;
            sort(n.begin() + i + 1, n.end(), greater<int>() );
            isSucc = false;
            break;
        }
    }
    if(isSucc) cout << -1;
    else{
        for(int i = 0; i < t; i++){
            cout << n[i] << " ";
        }
    }
   
    return 0;
}


