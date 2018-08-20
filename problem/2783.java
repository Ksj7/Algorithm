import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static int X, Y, N;
    static Pair[] p = new Pair[101];

    static class Pair implements Comparable<Pair> {
        int X, Y;

        Pair(int x, int y) {
            X = x;
            Y = y;
        }

        @Override
        public int compareTo(Pair o) {
            double x = (double) o.X;
            double y = (double) o.Y;
            double xx = (double) X;
            double yy = (double) Y;
            return Double.compare(y / x, yy / xx);
        }
    }


    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        Pair seven = new Pair(sc.nextInt(), sc.nextInt());
        N = sc.nextInt();
        p = new Pair[N + 1];
        p[0] = seven;
        for (int i = 1; i <= N; i++) {
            p[i] = new Pair(sc.nextInt(), sc.nextInt());
        }

        Arrays.sort(p);
        System.out.println(String.format("%.2f", (((double) p[0].X / (double) p[0].Y) * 1000.0)));
    }
}

