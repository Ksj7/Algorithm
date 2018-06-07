import java.util.Scanner;

public class Main {
    static int N, K;
    static int arr[][], dp[][];
    static int dy[] = {0, 0, -1, 1};
    static int dx[] = {-1, 1, 0, 0};

    static int solve(int i, int j) {
        if(dp[i][j] != 0) return dp[i][j];
        dp[i][j] = 1;
        for (int x = 0; x < 4; x++) {
            if (i + dy[x] >= 0 && i + dy[x] < N
                    && j + dx[x] >= 0 && j + dx[x] < N) {
                if (arr[i + dy[x]][j + dx[x]] > arr[i][j]) {
                    dp[i][j] = Math.max(dp[i][j], solve(i + dy[x], j + dx[x]) + 1);
                }
            }
        }
        return dp[i][j];
    }

    public static void main(String arg[]) {
        //n*n 크기의 대나무 숲이 주어져 있을 때, 이 판다가 최대한 오래 살려면 어떤 경로를 통하여 움직여야 하는지 구하여라.
        //대나무를 먹고 자리를 옮기면 그 옮긴 지역에 그 전 지역보다 대나무가 많이 있어야 한다
        //판다가 최대한 살 수 있는 일수(K)를 출력한다.

        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        arr = new int[N][N];
        dp = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                K = Math.max(K, solve(i,j));
            }
        }
        System.out.println(K);

    }
}

