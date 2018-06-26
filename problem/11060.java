import java.util.Scanner;

public class Main {
    static int N;
    static int arr[], dp[];

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        arr = new int[N + 1];
        dp = new int[N + 1];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }
        for(int i=0 ; i< N + 1; i++){
            dp[i] = 6000;
        }

        dp[0] = 0;
        for (int i = 0; i < N; i++) {
            if (dp[i] == 6000) continue;
            for (int j = 1; j <= arr[i]; j++) {
                if (i + j < N) {
                    dp[i + j] = Math.min(dp[i] + 1, dp[i + j]);
                }
            }
        }
        if (N == 1) System.out.println(0);
        else System.out.println(dp[N - 1] == 6000 ? -1 : dp[N - 1]);


    }
}

