import java.util.Scanner;

public class Main {
    //로봇 이동 : 오른, 아래
    //○로 표시된 칸 있으면 반드시 지남, K의 값이 0인 경우도 있는데, 이는 ○로 표시된 칸이 없음을 의미

    static int N, M, K;
    static int arr[][];
    static long dp[][];
    static int yy, xx;

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        K = sc.nextInt();
        dp = new long[N + 1][M + 1];
        arr = new int[N + 1][M + 1];
        int idx = 1;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                arr[i][j] = idx;
                if (idx == K) {
                    yy = i;
                    xx = j;
                }
                idx++;
            }
        }
        dp[0][0] = 1;
        if (K == 0) {
            yy = N;
            xx = M;
        }
        for (int i = 0; i <= yy; i++) {
            for (int j = 0; j <= xx; j++) {
                if (i - 1 >= 0) {
                    dp[i][j] += dp[i - 1][j];
                }
                if (j - 1 >= 0) {
                    dp[i][j] += dp[i][j - 1];
                }
            }
        }
        if (K != 0)
            for (int i = yy; i < N; i++) {
                for (int j = xx; j < M; j++) {
                    if (i == yy && j == xx) continue;
                    if (i - 1 >= 0) {
                        dp[i][j] += dp[i - 1][j];
                    }
                    if (j - 1 >= 0) {
                        dp[i][j] += dp[i][j - 1];
                    }
                }
            }

        System.out.println(dp[N - 1][M - 1]);
    }
}

