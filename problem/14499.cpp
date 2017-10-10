#include <iostream>

using namespace std;

int N, M, sx,sy, K;
int D[7] = {0,};
int map[21][21];

int main(){
	int temp;
	cin >> N >> M >> sy >> sx >> K;
	for(int i=0; i<N; i++){
		for(int j=0; j<M; j++){
			cin >> map[i][j];
		}
	}
	for(int j=1; j<=K; j++){
		cin >> temp;
		switch(temp){
			int t;
			case 1 :
				if(0 <= sy && sy < N && 0 <= sx + 1 && sx + 1 < M){
					sx += 1;
					t = D[3];
					D[3] = D[1];
					D[1] = D[4];
					D[4] = D[6];
					D[6] = t;
					if(map[sy][sx] == 0){
						map[sy][sx] = D[6];
					}else{
						D[6] = map[sy][sx];
						map[sy][sx] = 0;
					}
					cout << D[1] << endl;
				}
			break;
			case 2 :
				if(0 <= sy && sy < N && 0 <= sx - 1 && sx -1 < M){
					sx -= 1;
					t = D[4];
					D[4] = D[1];
					D[1] = D[3];
					D[3] = D[6];
					D[6] = t;
					if(map[sy][sx] == 0){
						map[sy][sx] = D[6];
					}else{
						D[6] = map[sy][sx];
						map[sy][sx] = 0;
					}
					cout << D[1] << endl;
				}
			break;
			case 3:
				if(0 <= sy -1 && sy -1 < N && 0 <= sx && sx < M){
					sy -= 1;
					t = D[2];
					D[2] = D[1];
					D[1] = D[5];
					D[5] = D[6];
					D[6] = t;
					if(map[sy][sx] == 0){
						map[sy][sx] = D[6];
					}else{
						D[6] = map[sy][sx];
						map[sy][sx] = 0;
					}
					cout << D[1] << endl;
				}
			break;
			case 4:
				if(0 <= sy + 1 && sy + 1 < N && 0 <= sx && sx < M){
					sy += 1;
					t = D[5];
					D[5] = D[1];
					D[1] = D[2];
					D[2] = D[6];
					D[6] = t;
					if(map[sy][sx] == 0){
						map[sy][sx] = D[6];
					}else{
						D[6] = map[sy][sx];
						map[sy][sx] = 0;
					}
					cout << D[1] << endl;
				}
			break;
		}
	}
}
