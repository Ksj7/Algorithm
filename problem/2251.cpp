//
//  2251.cpp
//  codingtest
//
//  Created by sujin.kim on 2018. 9. 19..
//  Copyright © 2018년 sujin.kim. All rights reserved.
//

#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;
bool ch[201][201][201];
int v[201];
int a,b,c;
void dfs(int ca , int cb, int cc){
    if(ch[ca][cb][cc]){
        return;
    }
    ch[ca][cb][cc] = true;
    if(ca == 0){
        v[cc] = 1;
    }
    if(a > 0){
        //a->b
        if(ca + cb <= b){
            dfs(0, ca+cb, cc);
        }else {
            dfs((ca+cb) - b, b, cc);
        }
        // a->c
        if(ca + cc <= c){
            dfs(0, cb, ca + cc);
        }else {
            dfs((ca+cc)-c,cb, c);
        }
    }
    
    if(b > 0){
        // b->a
        if(ca + cb <= a){
            dfs(ca+cb,0,cc);
        }else {
            dfs(a,(cb+ca)-a, cc);
        }
        //b->c
        if(cb + cc <= c){
            dfs(ca, 0, cb + cc);
        }else {
            dfs(ca,(cc+cb)-c, c);
        }
    }
    if(c > 0){
        // c->b
        if(cc + cb <= b){
            dfs(ca,cc+cb,0);
        }else {
            dfs(ca,b, (cb+cc)-b);
        }
        // c->a
        if(cc + ca <= a){
            dfs(ca+cc,cb,0);
        }else {
            dfs(a,cb, (ca+cc)-a);
        }
    }
    
   
    
    
}

int main(){
    cin >> a>>b>>c;
    for(int i = 0; i <= 200; i++){
        v[i] = 0;
    }
    dfs(0,0,c);
    
    for(int i = 0; i <= 200; i++){
        if(v[i] == 1)
            cout << i << " ";
    }
}
