import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static int N, W[][], v[];
    static int ss = 1000000000;

    static void solution(int current, int start, int sum) {
        int i;
        for (i = start + 1; i <= N; i++) {
            if (v[i] == 0) break;
        }
        if(i == N + 1) {
            sum += W[current][start];
            ss = Math.min(ss, sum);
            return;
        }
        else{
            for (int next = 1; next <= N; next++) {
                if (W[current][next] == 0) // 경로 없음
                    continue;
                if (next == start) continue;
                if (v[next] == 0) {
                    v[next] = 1;
                    sum += W[current][next];
                    solution(next, start, sum);
                    v[next] = 0;
                    sum -= W[current][next];
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        W = new int[N + 1][N + 1];
        v = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                W[i][j] = sc.nextInt();
            }
        }
        int start = 1;
        solution(1, start, 0);
        System.out.println(ss);
    }
}

