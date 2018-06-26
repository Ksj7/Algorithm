import java.util.Scanner;

public class Main {
    // 일반 : 자기 좌석에 앉아야 함, 자기의 바로 왼쪽 좌석 또는 바로 오른쪽 좌석으로는 자리를 옮길 수 있다
    // VIP: 반드시 자기 좌석에만 앉아야 하며 옆 좌석으로 자리를 옮길 수 없다.
    // 하나의 좌석을 기준으로 좌석을 옮기는 경우는 2가지다.
    // 1. 좌석을 옮기는 경우. - dp[n-2]
    // 2. 좌석을 옮기지 않는 경우. - dp[n-1]
    // 이를 활용하여 점화식 dp[n] = dp[n-1] + dp[n-2]  만들 수 있다.

    static int N, M;
    static long dp[] = new long[64];
    static long c = 1;

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        int idx = 1;
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i < 64; i++) {
            dp[i] = dp[i - 2] + dp[i - 1];
        }

        for (int i = 0; i < M; i++) {
            int t = sc.nextInt();
            if (t - idx > 0)
                c *= dp[(t - idx)];
            idx = t + 1;
        }
        if (N + 1 - idx > 0)
            c *= dp[(N + 1 - idx)];
        System.out.println(c);
    }
}

