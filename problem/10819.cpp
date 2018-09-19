//
//  10819.cpp
//  codingtest
//
//  Created by sujin.kim on 2018. 9. 18..
//  Copyright © 2018년 sujin.kim. All rights reserved.
//

#include <iostream>
#include <vector>
using namespace std;
int m = -94234439;
int n[9];
int t;

void solution(int* ch, int cnt, vector<int> v){
    if(cnt == t){
        int sum = 0;
        for(int i = 0; i < v.size() - 1; i++){
            sum += abs(v[i] - v[i + 1]);
        }
        if(m < sum) m = sum;
        return;
    }
    
    for(int i = 0; i < t; i++){
        if(ch[i] == 0){
            v.push_back(n[i]);
            ch[i] = 1;
            solution(ch, cnt + 1, v);
            ch[i] = 0;
            v.pop_back();
        }
    }
}

int main(){
    int ch[9];
    cin >> t;
    for(int i = 0; i < t; i++){
        cin >> n[i];
        ch[i] = 0;
    }
    vector<int> v;
    solution(ch, 0, v);
    cout << m ;
    
    
    
   
    return 0;
}


