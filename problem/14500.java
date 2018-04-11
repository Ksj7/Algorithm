import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static int[] dy = {0, 0, 1, -1};
    static int[] dx = {1, -1, 0, 0};
    static int N, M;
    static int max = -1;
    static int map[][];

    static void dfs(int[][] check, int y, int x, int n, int sum) {
        if (n == 4) {
            max = Math.max(max, sum);
        } else {
            for (int k = 0; k < 4; k++) {
                int ny = y + dy[k];
                int nx = x + dx[k];
                if (ny >= 0 && ny < N && nx >= 0 && nx < M) {
                    if (check[ny][nx] == 0) {
                        check[ny][nx] = 1;
                        dfs(check, ny, nx, n + 1, sum + map[ny][nx]);
                        check[ny][nx] = 0;
                    }
                }
            }
        }
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        //테트로미노 하나를 적절히 놓아서 테트로미노가 놓인 칸에 쓰여 있는 수들의 합을 최대로 해야함
        // 회전이나 대칭을 시켜도 된다.
        N = sc.nextInt();//세로 크기 N과 가로 크기 M
        M = sc.nextInt();
        int check[][] = new int[N][M];
        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                map[i][j] = sc.nextInt();
            }
        }
        for (int i = 0; i < N; i++)
            for (int j = 0; j < M; j++) {
                int data[] = new int[4];
                check[i][j] = 1;
                dfs(check, i, j, 1, map[i][j]);
                for (int k = 0; k < 4; k++) {
                    int ny = i + dy[k];
                    int nx = j + dx[k];
                    if (ny >= 0 && ny < N && nx >= 0 && nx < M) {
                        data[k] = map[ny][nx];
                    }
                }
                Arrays.sort(data);
                max = Math.max(max, map[i][j] + data[3] + data[2] + data[1]);
                check[i][j] = 0;
            }

        System.out.println(max);

    }
}
