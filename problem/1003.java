import java.util.Scanner;

public class Main {

    static class Pair {
        int x = -1, y = -1;
        int value = 0;

        Pair(int x, int y, int v) {
            this.x = x;
            this.y = y;
            this.value = v;
        }

    }

    static Pair p[] = new Pair[1001];

    static int fibonacci(int n) {
        if (p[n] != null) {
            return p[n].value;
        } else {
            int value = fibonacci(n - 1) + fibonacci(n - 2);
            p[n] = new Pair(p[n-1].x + p[n-2].x , p[n-1].y + p[n-2].y, value);
            return p[n].value;
        }
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        p[0] = new Pair(1, 0, 0);
        p[1] = new Pair(0, 1, 1);
        while (T > 0) {
            int N = sc.nextInt();
            fibonacci(N);
            System.out.println(p[N].x + " " + p[N].y);
            T--;
        }
    }
}
