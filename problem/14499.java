import java.util.Scanner;

public class Main{
    static int N, M, x, y, K;
    static int dice[] = new int[6]; //현재(0), 위(1), 아래(2), 왼쪽(3), 오른쪽(4), 반대편(5)
    static int map[][] = new int[21][21];
    static int ctr[] = new int[1001];

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        y = sc.nextInt();
        x = sc.nextInt();
        K = sc.nextInt();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                map[i][j] = sc.nextInt();
            }
        }
        for (int i = 0; i < K; i++)
            ctr[i] = sc.nextInt();

        int idx = 0;
        while (idx < K) {
            int l = ctr[idx];
            int tempY = y;
            int tempX = x;
            if (l == 4) tempY++;
            else if (l == 3) tempY--;
            else if (l == 2) tempX--;
            else tempX++;

            if (tempY >= 0 && tempY < N && tempX >= 0 && tempX < M) {
                int temp = 0;
                switch (l) {
                    ///이동한 칸에 써 있는 수가 0이면, 주사위의 바닥면에 써 있는 수가 칸에 복사된다.
                    // 0이 아닌 경우에는 칸에 써 있는 수가 주사위의 바닥면으로 복사되며, 칸에 써 있는 수는 0이 된다.
                    //dice 인덱스 위치 : 현재(0), 위(1), 아래(2), 왼쪽(3), 오른쪽(4), 반대편(5)
                    //동쪽은 1, 서쪽은 2, 북쪽은 3, 남쪽은 4
                    case 4:
                        y++;
                        temp = dice[2];
                        dice[2] = dice[5];
                        dice[5] = dice[1];
                        dice[1] = dice[0];
                        break;
                    case 3:
                        y--;
                        temp = dice[1];
                        dice[1] = dice[5];
                        dice[5] = dice[2];
                        dice[2] = dice[0];
                        break;
                    case 2:
                        x--;
                        temp = dice[3];
                        dice[3] = dice[5];
                        dice[5] = dice[4];
                        dice[4] = dice[0];
                        break;
                    case 1:
                        x++;
                        temp = dice[4];
                        dice[4] = dice[5];
                        dice[5] = dice[3];
                        dice[3] = dice[0];
                        break;
                }

                if (map[y][x] == 0) {
                    dice[0] = temp;
                    map[y][x] = dice[0];
                }
                else {
                    dice[0] = map[y][x];
                    map[y][x] = 0;
                }
                System.out.println(dice[5]);
            }
            idx++;
        }
    }
}

