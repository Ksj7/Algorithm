import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static int N, M, max = -1;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static void dfs(int[][] temp, int[][] check, int y, int x) {
        check[y][x] = 1;
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (0 <= nx && nx < M && 0 <= ny && ny < N && check[ny][nx] == 0 && temp[ny][nx] == 0) {
                temp[ny][nx] = 2;
                dfs(temp, check, ny, nx);
            }
        }
    }

    static void play(int[][] temp) {
        int[][] check = new int[N][M];
        for (int y = 0; y < N; y++) {
            for (int x = 0; x < M; x++) {
                if (temp[y][x] == 2) {
                    if (check[y][x] == 0)
                        dfs(temp, check, y, x);
                }
            }
        }
        int count = 0;
        for (int y = 0; y < N; y++) {
            for (int x = 0; x < M; x++) {
                if (temp[y][x] == 0)
                    count++;
            }
        }
        max = max < count ? count : max;

    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        int[][] puzz = new int[N][M];
        for (int y = 0; y < N; y++) {
            for (int x = 0; x < M; x++)
                puzz[y][x] = sc.nextInt();
        }
        for (int y = 0; y < N; y++) {
            for (int x = 0; x < M; x++) {
                if (puzz[y][x] != 0) continue;
                for (int yy = 0; yy < N; yy++) {
                    for (int xx = 0; xx < M; xx++) {
                        if (puzz[yy][xx] != 0) continue;
                        if (yy == y && xx == x) continue;
                        for (int yyy = 0; yyy < N; yyy++) {
                            for (int xxx = 0; xxx < M; xxx++) {
                                if (puzz[yyy][xxx] != 0) continue;
                                if ((yy == yyy && xx == xxx) || (yyy == y && xxx == x)) continue;
                                int temp[][] = new int[N][M];
                                for (int i = 0; i < N; i++)
                                    temp[i] = Arrays.copyOf(puzz[i], M);
                                temp[y][x] = 1;
                                temp[yy][xx] = 1;
                                temp[yyy][xxx] = 1;
                                play(temp);
                            }
                        }
                    }
                }
            }
        }

        System.out.println(max);
    }
}

