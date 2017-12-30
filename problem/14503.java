import java.util.Scanner;

public class Main {
    static int N, M, r, c, d;
    static int dy[] = { -1, 0, 1, 0 };
    static int dx[] = { 0, 1, 0, -1 };

    static int map[][];
    static int cleanCnt = 0;

    static void solve(int currY, int currX, int currD) {
        if (map[currY][currX] == 1) return;

        if (map[currY][currX] == 0) {
            cleanCnt++;
            map[currY][currX] = 2;
        }
        // 0(3)인 경우에는 북쪽을, 1(0)인 경우에는 동쪽을, 2(1)인 경우에는 남쪽을, 3(2)인 경우에는 서쪽
        for (int i = 0; i < 4; i++) {
            int nd = (currD + 3) % 4;
            int nx = currX + dx[nd];
            int ny = currY + dy[nd];
            if (map[ny][nx] == 0) {
                solve(ny, nx, nd);
                return;
            }else{
                currD = nd;
            }
        }
        if (currD == 0) {
            currY++;
        } else if (currD == 1) {
            currX--;
        } else if (currD == 2) {
            currY--;
        } else if (currD == 3) {
            currX++;
        }
        solve(currY, currX, currD);
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        r = sc.nextInt();
        c = sc.nextInt();
        d = sc.nextInt();
        map = new int[N][M];
        for (int y = 0; y < N; y++)
            for (int x = 0; x < M; x++)
                map[y][x] = sc.nextInt();


        solve(r, c, d);
        System.out.println(cleanCnt);
    }

}

