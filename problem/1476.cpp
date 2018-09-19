//
//  1476.cpp
//  codingtest
//
//  Created by sujin.kim on 2018. 9. 18..
//  Copyright © 2018년 sujin.kim. All rights reserved.
//

#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;
int e,s,m;
vector<int> n;

int main(){
    cin >> e >> s >> m;
    for(int i = 1; i <= 7980; i++){
        int ee, ss, mm;
        ee = ((i) % 15)==0? 15 : (i) % 15 ;
        ss = ((i) % 28)==0? 28 : (i) % 28 ;
        mm = ((i) % 19)==0? 19 : (i) % 19 ;
        if(ee == e && ss == s && mm == m){
            cout << i;
            break;
        }
    }
   
    return 0;
}


