import java.util.Scanner;

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int A[] = new int[N];
        for (int i = 0; i < N; i++)
            A[i] = sc.nextInt();
        int B = sc.nextInt();
        int C = sc.nextInt();
        long cnt = 0;
        for (int i = 0; i < N; i++) {
            cnt += 1;
            if (B < A[i]) {
                int res = A[i] - B;
                cnt += (res / C);
                if (res % C != 0) cnt++;
            }
        }
        System.out.println(cnt);
    }
}

