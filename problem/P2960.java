import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static int N, K;
    static int arr[];

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        K = sc.nextInt();
        arr = new int[N + 1];
        Arrays.fill(arr, 1);
        int cnt = 0;
        int i = 2;
        while (i <= N) {
            if (arr[i] == 1) {
                int n = i;
                for (; n <= N; n += i) {
                    if (arr[n] == 0) continue;
                    arr[n] = 0;
                    cnt++;
                    if (cnt == K) {
                        System.out.println(n);
                        break;
                    }
                }
                if (cnt > K) break;

            }
            i++;
        }

    }
}

