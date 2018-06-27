import java.util.Scanner;

public class Main {
    static int T, W;
    static int dp[][][];

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        T = sc.nextInt();
        W = sc.nextInt();
        dp = new int[2][T + 1][W + 2];

        for (int i = 1; i <= T; i++) {
            int n = sc.nextInt();
            for (int j = 1; j <= W + 1; j++) {
                if (n == 1) {
                    dp[0][i][j] = Math.max(dp[0][i - 1][j] + 1, dp[1][i - 1][j - 1] + 1);
                    dp[1][i][j] = Math.max(dp[0][i - 1][j - 1], dp[1][i - 1][j]);
                } else {
                    dp[0][i][j] = Math.max(dp[0][i - 1][j], dp[1][i - 1][j - 1]);
                    dp[1][i][j] = Math.max(dp[0][i - 1][j - 1] + 1, dp[1][i - 1][j] + 1);
                }
            }
        }
        System.out.println(Math.max(dp[0][T][W + 1],dp[1][T][W + 1]));
    }
}

