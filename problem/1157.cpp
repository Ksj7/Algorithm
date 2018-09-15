//
//  1157.cpp
//  codingtest
//
//  Created by sujin.kim on 2018. 9. 16..
//  Copyright © 2018년 sujin.kim. All rights reserved.
//

#include <iostream>
#include <string.h>

using namespace std;

int main(){
    string s;
    cin >> s;
    int num['Z' + 1] = {0,};
    for(int j = 0; j < s.size(); j++){
        int i = s.at(j);
        if(i >= 'a'){
            i-=('a'-'A');
        }
        num[i]++;
    }
    int max = -132134;
    char ch;
    bool fail = false;
    for(int i = 'A' ; i <= 'Z'; i++){
        if(num[i] != 0 ){
            if(max < num[i]){
                ch = i;
                max = num[i];
                fail = false;
            }else if(max == num[i]){
                fail = true;
            }
        }
    }
    if(fail){
        cout << '?';
    }else{
        cout << (ch);
    }
    
    return 0;
}

