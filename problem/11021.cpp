#include<iostream>
using namespace std;
int main(){
    int t;
    cin >> t;
    int i = 1;
    while(i <= t){
        int a,b;
        cin >> a >> b;
        cout << "Case #"<<i<<": "<< (a + b) << "\n";
        i++;
    }
}
