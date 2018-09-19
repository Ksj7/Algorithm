#include<iostream>
using namespace std;
int main(){
    while(true){
        int a;
        int b;
        cin >> a >> b;
        if(a == 0 && b == 0) return 0;
        cout << a + b << "\n";
    }
    
}
