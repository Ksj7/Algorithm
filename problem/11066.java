import java.util.Scanner;

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        while (T-- > 0) {
            int n = sc.nextInt();
            int dp[][] = new int[n + 1][n + 1];
            int sum[][] = new int[n + 1][n + 1];
            int arr[] = new int[n + 1];

            for (int i = 1; i <= n; i++) {
                arr[i] = sc.nextInt();
            }

            for (int i = 1; i <= n; i++) {
                sum[i][i] = arr[i];
                for (int j = i + 1; j <= n; j++) {
                    sum[i][j] = sum[i][j - 1] + arr[j];
                }

            }


            for (int j = 2; j <= n; j++) {
                int size = n - j + 1;
                int x = j;
                for (int i = 1; i <= size; i++) {
                    int min = Integer.MAX_VALUE;
                    for (int w = i; w < x; w++) {
                        min = Math.min(dp[i][w] + dp[w + 1][x] + sum[i][x], min);
                    }
                    dp[i][x] = min;
                    x++;
                }
            }

            System.out.println(dp[1][n]);
        }
    }
}

