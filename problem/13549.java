import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static int N, K;
    static int MAX = 2 * 100000;
    static int[] visted = new int[MAX + 1];

    public static class Pair {
        int cnt, x;

        Pair(int cnt, int xx) {
            this.cnt = cnt;
            x = xx;
        }
    }

    static int bfs() {
        Queue<Pair> queue = new ArrayDeque<>();
        queue.add(new Pair(0, N));
        while (!queue.isEmpty()) {
            Pair p = queue.poll();
            int cnt = p.cnt;
            int x = p.x;
            visted[x] = 1;
            if (x == K) {
                return cnt;
            }
            if (x * 2 <= MAX && visted[x * 2] == 0)
                queue.add(new Pair(cnt, x * 2));
            if (x - 1 >= 0 && visted[x - 1] == 0)
                queue.add(new Pair(cnt + 1, x - 1));
            if (x + 1 <= MAX && visted[x + 1] == 0)
                queue.add(new Pair(cnt + 1, x + 1));
        }
        return 0;

    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        K = sc.nextInt();
        System.out.println(bfs());
    }
}

