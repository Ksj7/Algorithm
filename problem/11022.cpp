
#include <iostream>
using namespace std;
int main(){
    int i = 1;
    int t;
    cin >> t;
    while(i <= t){
        int a;
        int b;
        cin >> a >> b;
        cout << "Case #" << i << ": " <<a <<" + "<< b<<" = "<< a+b << "\n";
        i++;
    }
}
