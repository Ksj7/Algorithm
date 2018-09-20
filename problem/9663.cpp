//
//  9663.cpp
//
#include <iostream>
#include <vector>
using namespace std;
int n;
int* col;
int cnt = 0;
void dfs(int r);
bool isPossible(int c);
int nn = 0;

bool isPossible(int c) {
    for(int i = 1; i < c; i++){
        if(col[i] == col[c]) return false;
        
        if(abs(col[i] - col[c]) == abs(i-c)) return false;
    }
    return true;
    
}
void dfs(int r) {
    if(r == n) cnt++;
    else{
        for(int i = 1; i<=n; i++){
            col[r + 1] = i;
            if (isPossible(r + 1)) {
                dfs(r + 1);
            } else {
                col[r + 1] = 0;
            }
        }
    }
}

int main(){
    cin >> n;
    for (int i = 1; i <= n; i++) {
        col = new int[16];
        col[1] = i;
        dfs(1);
        delete col;
    }
    cout << cnt;
    
}


