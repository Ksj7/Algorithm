import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};
    static int N;
    static int max = -1;

    private static void dfs(int cnt, int temp[][], int direction) {
        if (cnt == 5) return;

        int[][] puzz = new int[N][N];
        for (int i = 0; i < N; i++) {
            puzz[i] = Arrays.copyOf(temp[i], N);
        }

        if (direction == 0) {
            int[][] check = new int[N][N];
            for (int x = 0; x < N; x++) {
                for (int y = 0; y < N; y++) {
                    int nx = x;
                    int ny = y;
                    int time = 1, tt;
                    int tx = x + dx[0];
                    int ty = y + dy[0];
                    if (puzz[ny][nx] != 0) tt = puzz[ny][nx];
                    else continue;
                    while (0 <= tx && tx < N && 0 <= ty && ty < N) {
                        if (puzz[ty][tx] == 0) {
                            puzz[ny][nx] = 0;
                            ny = ty;
                            nx = tx;
                            time++;
                            puzz[ny][nx] = tt;
                            tx = x + (dx[0] * time);
                            ty = y + (dy[0] * time);
                        } else if (puzz[ny][nx] == puzz[ty][tx] && check[ty][tx] == 0) {
                            puzz[ny][nx] = 0;
                            puzz[ty][tx] *= 2;
                            ny = ty;
                            nx = tx;
                            check[ny][nx] = 1;
                            break;
                        } else break;
                    }
                    max = max < puzz[ny][nx] ? puzz[ny][nx] : max;
                }
            }
            for (int i = 0; i < 4; i++) {
                dfs(cnt + 1, puzz, i);
            }
        } else if (direction == 1) {
            int[][] check = new int[N][N];
            for (int x = 0; x < N; x++) {
                for (int y = N - 1; y >= 0; y--) {
                    int nx = x;
                    int ny = y;
                    int time = 1, tt;
                    int tx = x + dx[1];
                    int ty = y + dy[1];
                    if (puzz[ny][nx] != 0) tt = puzz[ny][nx];
                    else continue;
                    while (0 <= tx && tx < N && 0 <= ty && ty < N) {
                        if (puzz[ty][tx] == 0) {
                            puzz[ny][nx] = 0;
                            ny = ty;
                            nx = tx;
                            time++;
                            puzz[ny][nx] = tt;
                            tx = x + (dx[1] * time);
                            ty = y + (dy[1] * time);
                        } else if (puzz[ny][nx] == puzz[ty][tx] && check[ty][tx] == 0) {
                            puzz[ny][nx] = 0;
                            puzz[ty][tx] *= 2;
                            ny = ty;
                            nx = tx;
                            check[ny][nx] = 1;
                            break;
                        } else break;
                    }
                    max = max < puzz[ny][nx] ? puzz[ny][nx] : max;
                }
            }
            for (int i = 0; i < 4; i++)
                dfs(cnt + 1, puzz, i);

        } else if (direction == 2) {
            int[][] check = new int[N][N];
            for (int y = 0; y < N; y++) {
                for (int x = 0; x < N; x++) {
                    int nx = x;
                    int ny = y;
                    int time = 1, tt;
                    int tx = x + dx[2];
                    int ty = y + dy[2];
                    if (puzz[ny][nx] != 0) tt = puzz[ny][nx];
                    else continue;
                    while (0 <= tx && tx < N && 0 <= ty && ty < N) {
                        if (puzz[ty][tx] == 0) {
                            puzz[ny][nx] = 0;
                            ny = ty;
                            nx = tx;
                            time++;
                            puzz[ny][nx] = tt;
                            tx = x + (dx[2] * time);
                            ty = y + (dy[2] * time);
                        } else if (puzz[ny][nx] == puzz[ty][tx] && check[ty][tx] == 0) {
                            puzz[ny][nx] = 0;
                            puzz[ty][tx] *= 2;
                            ny = ty;
                            nx = tx;
                            check[ny][nx] = 1;
                            break;
                        } else break;
                    }
                    max = max < puzz[ny][nx] ? puzz[ny][nx] : max;
                }
            }
            for (int i = 0; i < 4; i++)
                dfs(cnt + 1, puzz, i);
        } else {
            int[][] check = new int[N][N];
            for (int y = 0; y < N; y++) {
                for (int x = N - 1; x >= 0; x--) {
                    int nx = x;
                    int ny = y;
                    int time = 1, tt;
                    int tx = x + dx[3];
                    int ty = y + dy[3];
                    if (puzz[ny][nx] != 0) tt = puzz[ny][nx];
                    else continue;
                    while (0 <= tx && tx < N && 0 <= ty && ty < N) {
                        if (puzz[ty][tx] == 0) {
                            puzz[ny][nx] = 0;
                            ny = ty;
                            nx = tx;
                            puzz[ny][nx] = tt;
                            time++;
                            tx = x + (dx[3] * time);
                            ty = y + (dy[3] * time);
                        } else if (puzz[ny][nx] == puzz[ty][tx] && check[ty][tx] == 0) {
                            puzz[ny][nx] = 0;
                            puzz[ty][tx] *= 2;
                            ny = ty;
                            nx = tx;
                            check[ny][nx] = 1;
                            break;
                        } else break;
                    }
                    max = max < puzz[ny][nx] ? puzz[ny][nx] : max;
                }
            }
            for (int i = 0; i < 4; i++)
                dfs(cnt + 1, puzz, i);
        }
    }


    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        int[][] puzz = new int[N][N];
        for (int i = 0; i < N; i++)
            for (int j = 0; j < N; j++) {
                puzz[i][j] = sc.nextInt();
            }
        for (int d = 0; d < 4; d++) {
            dfs(0, puzz, d);
        }
        System.out.println(max);
    }
}


