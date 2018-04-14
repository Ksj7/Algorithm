import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class Main {
    static int N;
    static Pair A[];
    static int[][] dp = new int[501][501];

    static class Pair {
        int r, c;

        Pair(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    static int solution(int x, int y) {
        if (x == y) return 0;
        if (dp[x][y] != 0) return dp[x][y];
        int min = Integer.MAX_VALUE;
        for (int k = x; k < y; k++)
            min = Math.min(min, solution(x, k) + solution(k + 1, y) + A[x].r * A[k].c * A[y].c);
        dp[x][y] = min;
        return min;
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        //모든 행렬을 곱하는데 필요한 곱셈 연산 횟수의 최소값을 구하는 프로그램
        N = sc.nextInt();
        A = new Pair[N];
        for (int i = 0; i < N; i++) {
            A[i] = new Pair(sc.nextInt(), sc.nextInt());
        }
        System.out.println(solution(0, N - 1));
    }
}

