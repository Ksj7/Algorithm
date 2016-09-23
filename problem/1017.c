/*
 * Author: sujin Kim (Ksj7)
 * Date: 2016.01.27
 * email: sujin.kim1414@gmail.com
 *
 * https://github.com/Ksj7/Algorithm
 * https://www.acmicpc.net/problem/1707
 */

 #include <iostream>
#include <vector>
#include <algorithm>
#include <cstring>
#include <string>
#include <map>
#include <queue>

using namespace std;
struct MaximumFlow{
    int n ;
    vector<vector<int>> graph;
    vector<bool> check;
    vector<int> pred;
    
    MaximumFlow(int n): 
    n(n){
        graph.resize(n);
        check.resize(n);
        pred.resize(n,-1);
    };
    void AddEdge(int u, int v){
        graph[u].push_back(v);
    }
    
    bool dfs(int x){
        if(x == -1) return true;
        for(int next : graph[x]){
            if(check[next]) continue;
            check[next] = true;
            if(dfs(pred[next])){
                pred[next] = x;
                return true;
            }
        }
        return false;
    }
    
    int flow(){
        int ans = 0; 
        for(int i = 0 ; i < n; i++){
            fill(check.begin(), check.end(), false);
            if(dfs(i))
                ans++;
        }
        return ans;
    }
    
    
};

bool Isprime(int n){
    if(n < 2) return true;
    for(int i = 2; i*i <= n; i++){
        if(n%i == 0)
            return false;
    }
    return true;
}

int main(){
    int n;
    int m;
    scanf("%d",&n);
    vector<int> a(n);
    for(int i = 0;  i<n; i++){
        scanf("%d", &a[i]);
    }
    
    vector<int> ans;
    
    for(int k = 1; k < n; k++){
        if(!Isprime(a[0]+a[k])) continue;
        vector<int> even;
        vector<int> odd;
        
        for(int i = 1 ; i < n ; i++){
            if(i == k) continue;
            if(a[i]% 2 == 0) even.push_back(a[i]);
            else odd.push_back(a[i]);
        }
        
        if(even.size() != odd.size()) continue;
        int m = even.size();
        MaximumFlow mf(m);
        for(int i = 0; i< m; i++){
            for(int j = 0 ; j < m ; j++){
                if(Isprime(odd[i]+even[j]))
                    mf.AddEdge(i,j);
            }
        }
        
        if(mf.flow() == m){
            ans.push_back(a[k]);
        }
    }
    if(ans.empty()) printf("-1\n");
        else{
            sort(ans.begin(), ans.end());
            for(int x : ans){
                printf("%d ",x);
            }
            puts("");
        }
        return 0;
    }
