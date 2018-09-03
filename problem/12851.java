import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static int N, K;
    static int visted[];
    static int min = Integer.MAX_VALUE;
    static int cnt = 0;
    static int MAX = 2 * 100000;

    static class Pair {
        int cnt, x;

        Pair(int cnt, int xx) {
            x = xx;
            this.cnt = cnt;
        }
    }

    static void bfs() {
        Queue<Pair> q = new ArrayDeque<>();
        q.add(new Pair(0, N));
        while (!q.isEmpty()) {
            Pair p = q.poll();
            int c = p.cnt;
            int x = p.x;
            visted[x] = 1;
            if (x == K) {
                min = Math.min(min, c);
                if(c == min) {
                    cnt++;
                }
                continue;
            }
            if (x + 1 <= MAX && visted[x + 1] == 0) {
                q.add(new Pair(c + 1, x + 1));
            }
            if (x - 1 >= 0 && visted[x - 1] == 0) {
                q.add(new Pair(c + 1, x - 1));

            }
            if (x * 2 <= MAX && visted[x * 2] == 0) {
                q.add(new Pair(c + 1, x * 2));

            }
        }


    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        K = sc.nextInt();
        visted = new int[MAX + 1];
        bfs();
        System.out.print(min + "\n" + cnt);

    }
}

