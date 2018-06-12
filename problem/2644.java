import java.util.Scanner;

public class Main {
    static int N, m;
    static int x, y;
    static boolean check[];
    static int C = -1;

    static class Pair {
        int x, y;

        Pair(int xx, int yy) {
            x = xx;
            y = yy;
        }
    }

    static Pair p[];

    static void bfs(int idx, int count) {
        if (idx == y) {
            C = count;
            return;
        }
        for (int i = 0; i < m; i++) {
            if (p[i].y == idx && !check[p[i].x]) {
                check[p[i].x] = true;
                bfs(p[i].x, count + 1);
            }

            if (p[i].x == idx && !check[p[i].y]) {
                check[p[i].y] = true;
                bfs(p[i].y, count + 1);
            }
        }
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        x = sc.nextInt();
        y = sc.nextInt();
        m = sc.nextInt();
        p = new Pair[m];
        check = new boolean[N + 1];
        for (int i = 0; i < m; i++) {
            p[i] = new Pair(sc.nextInt(), sc.nextInt());
        }
        check[x] = true;
        bfs(x, 0);
        System.out.println(C);

    }
}
