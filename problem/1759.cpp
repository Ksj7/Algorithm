//
//  1759.cpp
//  codingtest
//
//  Created by sujin.kim on 2018. 9. 20..
//  Copyright © 2018년 sujin.kim. All rights reserved.
//

#include <iostream>
#include <vector>
using namespace std;
vector<char> v;
vector<int > vv;
int l,c;
//A E I O U
void solution(int cnt, int idx){
    if(cnt == l){
        vector<char> tmp;
        bool isSuc = false;
        int noVowel = 0;
        for(int i = 0; i < c; i++){
            if(vv[i] == 1){
                if(v[i] == 'a' || v[i] == 'e' || v[i] == 'i' || v[i] == 'o' || v[i] == 'u')
                    isSuc = true;
                else noVowel++;
                tmp.push_back(v[i]);
            }
        }
        if(isSuc && noVowel >= 2){
            for(int i = 0; i < l; i++){
                cout<< tmp[i];
            }
            cout << "\n";
        }
        return ;
    }
    
    for(int i = idx; i < c; i++){
        if(vv[i] == 0){
            vv[i] = 1;
            solution(cnt + 1, i + 1);
            vv[i] = 0;
        }
    }
    
}
int main(){
    cin >> l >> c;
    v.resize(c);
    vv.resize(c,0);
    for(int i = 0; i < c; i++)
        cin >> v[i];
    
    int i, j;
    char remember;
    for ( i = 1; i < c; i++ )
    {
        remember = v[(j=i)];
        while ( --j >= 0 && remember < v[j] ){
            v[j+1] = v[j];
            v[j] = remember;
        }
    }
    solution(0,0);
    
}
