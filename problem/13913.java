import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static int N, K;
    static int MAX = 2 * 100000;
    static int[] visted = new int[MAX + 1];

    public static class Pair {
        int cnt, x;
        ArrayList<Integer> al = new ArrayList<>();

        Pair(int cnt, int xx, ArrayList<Integer> al) {
            this.cnt = cnt;
            x = xx;
            this.al.clear();
            this.al.addAll(al);

        }
    }

    static void bfs() {
        Queue<Pair> queue = new ArrayDeque<>();
        ArrayList<Integer> al = new ArrayList<>();
        al.add(N);
        queue.add(new Pair(0, N, al));
        while (!queue.isEmpty()) {
            Pair p = queue.poll();
            int cnt = p.cnt;
            int x = p.x;
            visted[x] = 1;
            if (x == K) {
                System.out.println(cnt);
                for (int i = 0; i < p.al.size(); i++) {
                    System.out.print(p.al.get(i) + " ");
                }
                return;
            }
            if (x * 2 <= MAX && visted[x * 2] == 0) {
                ArrayList<Integer> tmp = new ArrayList<>();
                tmp.addAll(p.al);
                tmp.add(x * 2);
                queue.add(new Pair(cnt + 1, x * 2, tmp));
            }
            if (x - 1 >= 0 && visted[x - 1] == 0) {
                ArrayList<Integer> tmp = new ArrayList<>();
                tmp.addAll(p.al);
                tmp.add(x - 1);
                queue.add(new Pair(cnt + 1, x - 1, tmp));
            }

            if (x + 1 <= MAX && visted[x + 1] == 0) {
                ArrayList<Integer> tmp = new ArrayList<>();
                tmp.addAll(p.al);
                tmp.add(x + 1);
                queue.add(new Pair(cnt + 1, x + 1, tmp));
            }
        }

    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        K = sc.nextInt();
        if (N > K) {
            System.out.println(N - K);
            for (int i = N; i >= K; i--) {
                System.out.print(i + " ");
            }
        }else
        bfs();
    }
}

