import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static int N, W[][], dp[][];

    static int shortestPath(int current, int visited) {

        if (visited == (1 << N) - 1) { //0111111 <- 요런식으로 됨
            return W[current][1];
        }

        if (dp[current][visited] >= 0) {
            return dp[current][visited];
        }

        int ret = 1000000000;
        for (int city = 1; city <= N; city++) {
            if ((visited & (1 << (city - 1))) != 0) { // 방문한적 있는지 확인
                continue;
            }
            if (W[current][city] == 0)
                continue;

            int tmp = W[current][city] + shortestPath(city, visited + (1 << (city - 1)));
            ret = Math.min(tmp, ret);
        }

        return dp[current][visited] = ret;


    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        W = new int[N + 1][N + 1];
        dp = new int[N + 1][1 << N + 1];
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                W[i][j] = sc.nextInt();
            }
        }
        for (int i = 1; i <= N; i++) {
            Arrays.fill(dp[i], -1);
        }
        int start = 1;
        System.out.println(shortestPath(start, 1));
    }
}

