import java.util.Scanner;

public class Main{
    static int N;
    static int data[][] = new int[16][2];
    static long max = -1;

    static void solution(int x, long sum) {
        if (x + 1 < N + 1) {
            solution(x + 1, sum);
        }else max = Math.max(sum, max);


        if (x + data[x][0] > N + 1) max = Math.max(sum,max);

        else if (x + data[x][0] == N + 1)
            max = Math.max(sum + data[x][1],max);
        else solution(data[x][0] + x, sum + data[x][1]);

    }

    public static void main(String args[]) {
        // 최대 수익을 구하는 프로그램을 작성
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        for (int i = 1; i <= N; i++) {
            data[i][0] = sc.nextInt();
            data[i][1] = sc.nextInt();
        }

        for (int i = 1; i <= N; i++) {
            solution(i, 0);
        }
        System.out.println(max);
    }
}

