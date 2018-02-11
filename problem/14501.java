import java.util.Scanner;

public class Main {

    static int N;
    static int puzz[][], dp[];

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        puzz = new int[N + 1][2];
        dp = new int[N + 1];


        for (int i = 1; i <= N; i++) {

            puzz[i][0] = sc.nextInt();
            puzz[i][1] = sc.nextInt();
            dp[i] = puzz[i][1];
        }

        for(int i = 2; i <= N; i++){
            for(int j = 1; j < i; j++){
                if(i - j >= puzz[j][0]) {
                    dp[i] = Math.max(puzz[i][1] + dp[j], dp[i]);
                }
            }
        }
        int max = 0;
        for(int i = 1; i <= N; i++){
            if(N - i + 1 >= puzz[i][0]){
                max = Math.max(max, dp[i]);
            }
        }
        System.out.println(max);

    }

}
