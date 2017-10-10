#include <iostream>

using namespace std;

int N, M, sx,sy, K;
int D[7] = {0,};
int map[21][21];

int main(){
	int temp;
	cin >> N >> M >> sx >> sy >> K;
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
				sx += 1;
				t = D[3];
				D[3] = D[1];
				D[1] = D[4];
				D[4] = D[6];
				D[6] = t;
				if(sx < M){
					if(map[sy][sx] == 0){
						map[sy][sx] = D[6];
					}else{
						D[6] = map[sy][sx];
						map[sy][sx] = 0;
					}
				}
			break;
			case 2 :
				sx -= 1;
				t = D[4];
				D[4] = D[1];
				D[1] = D[3];
				D[3] = D[6];
				D[6] = t;
				if(sx >= 0){
					if(map[sy][sx] == 0){
						map[sy][sx] = D[6];
					}else{
						D[6] = map[sy][sx];
						map[sy][sx] = 0;
					}
				}
			break;
			case 3:
				sy -= 1;
				t = D[2];
				D[2] = D[1];
				D[1] = D[5];
				D[5] = D[6];
				D[6] = t;
				if(sy >= 0){
					if(map[sy][sx] == 0){
						map[sy][sx] = D[6];
					}else{
						D[6] = map[sy][sx];
						map[sy][sx] = 0;
					}
				}
			break;
			case 4:
				sy += 1;
				t = D[5];
				D[5] = D[1];
				D[1] = D[2];
				D[2] = D[6];
				D[6] = t;
				if(sy < N){
					if(map[sy][sx] == 0){
						map[sy][sx] = D[6];
					}else{
						D[6] = map[sy][sx];
						map[sy][sx] = 0;
					}
				}
			break;
		}
		cout << D[1] << endl;
	}
}
