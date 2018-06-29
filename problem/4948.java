import java.util.Arrays;
import java.util.Scanner;

public class Main {

    static int prime[] = new int[250000];

    static void algorithm() {
        int i = 2;
        while (i < 250000) {
            if(prime[i] == 1) {
                int n = i + i;
                for (; n < 250000; n += i) {
                    prime[n] = 0;
                }
            }
            i++;
        }
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        Arrays.fill(prime, 1);
        prime[1] = 0;
        algorithm();
        while (true) {
            int x = sc.nextInt();
            if (x == 0) break;
            // n보다 크고, 2n보다 작거나 같은 소수
            long cnt = 0;
            for (int n = x + 1; n <= 2 * x; n++) {
                cnt += prime[n];
            }
            System.out.println(cnt);
        }
    }
}
 
