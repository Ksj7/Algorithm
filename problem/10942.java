import java.util.Scanner;

//팰린드롬?이라는 문제
public class Main {
    static int N, M, arr[];
    static int dp[][];
    //쿠팡 개발자 코딩 테스트에서 출제된 문제

    static int solve(int i, int j) {
        if (dp[i][j] != -1) return dp[i][j];
        if (i == j) return 1;
        if (arr[i] == arr[j]) {
            if (j - i == 1) dp[i][j] = 1;
            else dp[i][j] = solve(i + 1, j - 1);

        } else {
            dp[i][j] = 0;
        }
        return dp[i][j];

    }


    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        arr = new int[N];
        for (int i = 0; i < N; i++)
            arr[i] = sc.nextInt();
        M = sc.nextInt();
        dp = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++)
                dp[i][j] = -1;
        }
        int S, E;
        for (int i = 0; i < M; i++) {
            S = sc.nextInt();
            E = sc.nextInt();
            System.out.println(solve(S - 1, E - 1));
        }
        //입력으로 주어진 순서에 따라서 출력한다. 팰린드롬인 경우에는 1, 아닌 경우에는 0을 출력한다.

    }

}

