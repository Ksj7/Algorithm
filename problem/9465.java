import java.util.Scanner;

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        int dp[][] = new int[100001][2];
        while (T > 0) {
            int n = sc.nextInt();
            for (int j = 0; j < 2; j++) {
                for (int i = 0; i < n; i++) {
                    dp[i][j] = sc.nextInt();
                }
            }

            for (int i = 1; i < n; i++) {
                dp[i][0] = Math.max(dp[i][0] + dp[i - 1][1], dp[i - 1][0]);
                dp[i][1] = Math.max(dp[i][1] + dp[i - 1][0], dp[i - 1][1]);
            }

            if (dp[n - 1][0] > dp[n - 1][1])
                System.out.println(dp[n - 1][0]);
            else System.out.println(dp[n - 1][1]);

            T--;
        }

    }
}
