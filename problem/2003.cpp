//
//  2003.cpp
//  codingtest
//
//  Created by sujin.kim on 2018. 9. 19..
//  Copyright © 2018년 sujin.kim. All rights reserved.
//

#include <iostream>
#include <vector>
using namespace std;
int n, m;
int e = 1;
int s = 0;
int cnt = 0;
vector<int> v;
int main(){
    cin >> n >> m;
    for(int i = 0; i < n; i++){
        int tmp;
        cin >> tmp;
        v.push_back(tmp);
    }
    while(true){
        int sum = 0;
        if(e > n || s > n) break;
        for(int i = s; i < e; i++){
            sum += v[i];
        }
        if(m <= sum){
            if(m == sum) cnt++;
            s++;
        }else{
            e++;
        }
        
    }
    cout << cnt ;
}

