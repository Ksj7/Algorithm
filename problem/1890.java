import java.util.Scanner;

public class Main {
    static int N;
    static int arr[][];
    static long dp[][];

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        arr = new int[N][N];
        dp = new long[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                arr[i][j] = scanner.nextInt();
            }
        }
        dp[0][0] = 1;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {

                if (i == N - 1 && j == N - 1) {
                    break;
                }
                if(i + arr[i][j] < N) {
                    dp[i + arr[i][j]][j] += dp[i][j];
                }
                if(j + arr[i][j] < N) {
                    dp[i][j + arr[i][j]] += dp[i][j];
                }

            }
        }

        System.out.println(dp[N-1][N-1]);
    }
}

