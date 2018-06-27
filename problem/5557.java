import java.util.Scanner;

public class Main {
    static int N;
    static long dp[][] = new long[101][21];
    static int v[] = new int[101];

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();

        for (int i = 1; i <= N; i++) {
            v[i] = sc.nextInt();
        }

        dp[1][v[1]] = 1;
        for (int i = 2; i <= N; i++) {
            int tmp = v[i];
            for (int j = 0; j <= 20; j++) {
                if (dp[i - 1][j] != 0) {
                    if (j - tmp >= 0)
                        dp[i][j - tmp] += dp[i - 1][j];
                    if (j + tmp <= 20)
                        dp[i][j + tmp] += dp[i - 1][j];
                }
            }
        }
        System.out.println(dp[N - 1][v[N]]);

    }
}

