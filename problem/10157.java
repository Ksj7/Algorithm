import java.util.Scanner;

public class Main {
    static int C, R;
    static int K;

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        C = sc.nextInt();
        R = sc.nextInt();
        K = sc.nextInt();
        int y = 1;
        int x = 1;
        int dir = 0;
        int cnt = 1;
        long u = R - 1, r = C - 1, d = R - 1, l = C - 2;
        boolean first = true;
        if (K > C * R) System.out.println("0");
        else {
            while (cnt <= C * R) {
                if (dir == 0) {
                    y += u;
                    cnt += u;
                    if (first) {
                        u--;
                        first = false;
                    } else {
                        u -= 2;
                    }
                } else if (dir == 1) {
                    x += r;
                    cnt += r;
                    r -= 2;
                } else if (dir == 2) {
                    y -= d;
                    cnt += d;
                    d -= 2;
                } else if (dir == 3) {
                    x -= l;
                    cnt += l;
                    l -= 2;
                }
                if (cnt >= K) break;
                dir = (dir + 1) % 4;
            }
            int diff = cnt - K;
            if (dir == 0) {
                y = y - diff;
            } else if (dir == 1) {
                x = x - diff;
            } else if (dir == 2) {
                y = y + diff;
            } else x = x + diff;

            System.out.println(x + " " + y);
        }

    }
}

