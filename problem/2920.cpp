#include <iostream>
#include <string.h>

using namespace std;

int main(){
    int n;
    cin >> n;
    if( !(n == 8 || n == 1) ) cout << "mixed";
    else{
        int tmp;
        if(n == 8){
            bool fail = false;
            for(int i = 7; i>=1; i--){
                cin >> tmp;
                if(tmp == i) continue;
                else{
                    fail = true;
                    break;
                }
            }
            if(fail) cout << "mixed";
            else cout << "descending";
        }else{
            bool fail = false;
            for(int i = 2; i <= 8; i++){
                cin >> tmp;
                if(tmp == i) continue;
                else{
                    fail = true;
                    break;
                }
            }
            if(fail) cout << "mixed";
            else cout << "ascending";
        }
        
    }
    return 0;
}
