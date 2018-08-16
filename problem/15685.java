import java.util.*;

public class Main {
    static int N, x, y, d, g;
    static int arr[][] = new int[101][101];

    static class Pair {
        int y, x;

        Pair(int yy, int xx) {
            y = yy;
            x = xx;
        }
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();

        for (int i = 0; i <= 100; i++)
            Arrays.fill(arr[i], -1);

        for (int i = 0; i < N; i++) {
            Stack<Pair> s = new Stack<>();
            Stack<Pair> tmp = new Stack<>();
            Queue<Pair> nw = new ArrayDeque<>();
            x = sc.nextInt();
            y = sc.nextInt();
            d = sc.nextInt();
            g = sc.nextInt();
            /*
                0: x좌표가 증가하는 방향 (→)
                1: y좌표가 감소하는 방향 (↑)
                2: x좌표가 감소하는 방향 (←)
                3: y좌표가 증가하는 방향 (↓)
             */
            int cnt = 0;
            arr[y][x] = cnt;
            s.push(new Pair(y, x));
            if (d == 0) x++;
            else if (d == 1) y--;
            else if (d == 2) x--;
            else y++;
            arr[y][x] = cnt++;
            while (cnt <= g) {
                int tmpy = y, tmpx = x;
                while (!s.empty()) {
                    nw.add(new Pair(y,x));
                    Pair p = s.pop();
                    tmp.push(p);
                    if (p.y == tmpy) {
                        if (p.x + 1 == tmpx) {
                            y--;
                        } else {
                            y++;
                        }
                    } else if(p.x == tmpx){
                        if (p.y + 1 == tmpy) {
                            x++;
                        } else x--;
                    }
                    arr[y][x] = cnt;
                    tmpy = p.y;
                    tmpx = p.x;
                }
                while (!tmp.empty()) s.push(tmp.pop());
                while (!nw.isEmpty()) s.push(nw.poll());

                cnt++;
            }
        }

        int count = 0;
        for (int yy = 0; yy <= 99; yy++) {
            for (int xx = 0; xx <= 99; xx++) {
                if (arr[yy][xx] != -1 && arr[yy + 1][xx] != -1
                        && arr[yy][xx + 1] != -1 && arr[yy + 1][xx + 1] != -1)
                    count++;
            }
        }
        System.out.println(count);


    }


}
