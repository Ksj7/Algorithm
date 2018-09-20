//
//  1509.cpp
//  codingtest
//

#include <iostream>
#include <string>
using namespace std;
#define INF 987654321
void calcPalindrom(int n);
bool isPalindrom(int s, int e);
int solve(int pos);
char arr[2500];
int d[2500];
int dp[2500][2500];
int mmin = INF;

void calcPalindrom(int n){
    for(int i = 0; i < n; i++){
        dp[i][i] = true;
        for(int j = 0; j < i; ++j){
            dp[i][j] = arr[i]==arr[j] && dp[i-1][j+1];
            if(i-j==1){
                dp[i][j] |= arr[i]==arr[i-1] ;
            }
        }
    }
}

int solve(int pos){
    if(pos < 0) return 0;
    int& r = d[pos];
    if(r != -1) return r;
    r = INF;
    for(int i=pos; i>=0; i--){
        if(dp[pos][i]){
            r = min(r, 1+solve(i-1));
        }
    }
    return r;
}

int main(){
    string s;
    cin >> s;
    int n = (int) s.size();
    for(int i = 0; i< s.size(); i++){
        arr[i] = s[i];
    }
    calcPalindrom(n);
    for(int i = 0; i < n; i++){
        d[i] = -1;
    }
    cout << solve(n-1);
    
    
}
