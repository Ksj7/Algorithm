#include <iostream>
#include <string.h>

using namespace std;

int main(){
    string s;
    cin >> s;
    for(char i = 'a'; i <= 'z'; i++){
        int answer = -1;
        for(int j = 0; j < s.size(); j++){
            if(s.at(j) == i){
                answer = j;
                break;
            }
        }
        cout << answer << ' ';
    }
    
    return 0;
}
