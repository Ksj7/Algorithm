//
//  2143.cpp
//  codingtest
//
#include <iostream>
#include <map>
using namespace std;
int main(){
    long long int m;
    int an, bn;
    cin >> m >> an;
    long long int a[an + 1];
    for(int i = 1; i <= an; i++)
        cin >> a[i];
    cin >> bn;
    long long int b[bn + 1];
    map<int,int> dp;
    for(int i = 1; i <= bn; i++){
        cin >> b[i];
    }
    for(int i = 1; i <= bn; i++){
        int sum = 0;
        for(int j = i; j <= bn; j++){
            sum += b[j];
            dp[sum]++;
        }
    }
    long long int ans = 0;
    for(int i = 1; i <= an; i++){
        int sum = 0;
        for(int j = i; j <= an; j++){
            sum += a[j];
            if(dp.find(m-sum) != dp.end()){
                ans += dp[m-sum];
            }
        }
    }
    cout << ans;
    
}


