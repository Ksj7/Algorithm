import java.util.Scanner;

public class Main {
    static int N;
    static int[] A;
    static long max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;

    static void solution(int[] op, int cnt, long s) {
        // idx - 연산자
        //  0  - 덧셈(+)의 개수,
        //  1  - 뺄셈(-)의 개수,
        //  2  - 곱셈(×)의 개수,
        //  3  - 나눗셈(÷)의 개수

        if (cnt == N - 1) {
            max = Math.max(s, max);
            min = Math.min(s, min);
            return;
        }

        if (op[0] != 0) {
            op[0]--;
            s += A[cnt + 1];
            solution(op, cnt + 1, s);
            op[0]++;
            s -= A[cnt + 1];
        }

        if (op[1] != 0) {
            op[1]--;
            s -= A[cnt + 1];
            solution(op, cnt + 1, s);
            op[1]++;
            s += A[cnt + 1];
        }


        if (op[2] != 0) {
            op[2]--;
            s *= A[cnt + 1];
            solution(op, cnt + 1, s);
            op[2]++;
            s /= A[cnt + 1];
        }


        if (op[3] != 0) {
            op[3]--;
            s /= A[cnt + 1];
            solution(op, cnt + 1, s);
            op[3]++;
            s *= A[cnt + 1];
        }

    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        A = new int[N];
        int[] OP = new int[4];
        for (int i = 0; i < N; i++) {
            A[i] = sc.nextInt();
        }
        for (int i = 0; i < 4; i++) {
            OP[i] = sc.nextInt();
        }

        solution(OP, 0, A[0]);


        System.out.println(max);
        System.out.println(min);
    }
}

