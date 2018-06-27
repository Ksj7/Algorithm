import java.util.Scanner;

public class Main {
    static int N, S, M;
    // 볼륨 -/+ , N, M
    static int V[] = new int[102];
    static int dp[][] = new int[102][1002];


    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        S = sc.nextInt();
        M = sc.nextInt();
        dp[0][S] = 1;
        for(int i= 0; i<=M; i++){
            dp[N][i] = -1;
        }

        for (int i = 1; i <= N; i++) {
            V[i] = sc.nextInt();
            for(int j = 0; j <= M; j++){
                if(dp[i - 1][j] != 0){
                    if(j + V[i] <= M){
                        dp[i][j + V[i]] = 1;
                    }
                    if(j - V[i] >= 0){
                        dp[i][j - V[i]] = 1;
                    }
                }
            }
        }
        int max = -1;
        for(int i= 0; i<=M; i++){
            if(dp[N][i] != -1){
                max = Math.max(max, i);
            }
        }


        System.out.println(max);
    }
}

