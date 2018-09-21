//
//  11723.cpp
//  codingtest
//
//  Created by sujin.kim on 2018. 9. 22..
//  Copyright © 2018년 sujin.kim. All rights reserved.
//

#include <cstdio>
#include <string>
using namespace std;
int main(){
    int check[21] = {0,};
    int n, x;
    scanf("%d", &n);
    char* s;
    s = (char*)malloc(20);
    while(n--){
        scanf("%s", s);
        if(s[0] == 'a' && s[1] == 'l'){
            fill_n(check, 21, 1);
        }else if(s[0] == 'e'){
            fill_n(check, 21, 0);
        }else{
            scanf("%d", &x);
            if(s[0] == 'a'){
                check[x] = 1;
            }else if(s[0] == 'r'){
                check[x] = 0;
            }else if(s[0] == 'c'){
                if(check[x] == 1)
                    printf("1\n");
                else printf("0\n");
            }else{
                if(check[x] == 1){
                    check[x] = 0;
                }else{
                    check[x] = 1;
                }
            }
        }
    }
}
