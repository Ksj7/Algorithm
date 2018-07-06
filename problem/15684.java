import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static int n, m, h;
    static int[][] arr;
    static int min = Integer.MAX_VALUE;

    static class Pair {
        int y, x;

        Pair(int yy, int xx) {
            y = yy;
            x = xx;
        }
    }

    static boolean solution2(Pair start, int idx, int[][] check) {
        while (start.y <= h && start.x <= n) {
            if (check[start.y][start.x] != 0) {
                start.x++;
            } else if (check[start.y][start.x - 1] != 0) {
                start.x--;
            }
            start.y++;
        }

        if (start.x == idx) return true;
        return false;
    }

    static int sum(int[][] check) {
        int ret = 0;
        for (int i = 1; i <= h; i++) {
            for (int j = 1; j <= n; j++)
                if (check[i][j] == 2)
                    ret++;
        }
        return ret;
    }

    static void solution(int idx, Pair p, int[][] check, int cnt) {
        if(cnt > 3) return;
        if (idx == n + 1) {
            min = Math.min(cnt, min);
            return;
        }
        if (p.x == n + 1) return;
        if (p.y == h + 1) {
            if (solution2(p, idx, check))
                solution(idx + 1, new Pair(1, p.x + 1), check, cnt);
            return;
        }
        if (check[p.y][p.x] == 0) {
            if (p.x + 1 <= n && check[p.y][p.x + 1] == 0) {
                if (p.x - 1 >= 1 && check[p.y][p.x - 1] != 0) ;
                else {
                    check[p.y][p.x] = 2;
                    solution(idx, new Pair(p.y + 1, p.x + 1), check, cnt + 1);
                    check[p.y][p.x] = 0;
                }
            }
            if (p.x - 1 >= 1) {
                if (check[p.y][p.x - 1] == 0) {
                    solution(idx, new Pair(p.y + 1, p.x), check, cnt);
                    if (p.x - 2 >= 1 && check[p.y][p.x - 2] != 0);
                    else{
                        check[p.y][p.x - 1] = 2;
                        solution(idx, new Pair(p.y + 1, p.x - 1), check, cnt+1);
                        check[p.y][p.x - 1] = 0;
                    }
                } else {
                    solution(idx, new Pair(p.y + 1, p.x - 1), check, cnt);
                }
            } else {
                solution(idx, new Pair(p.y + 1, p.x), check, cnt);
            }
        } else {
            solution(idx, new Pair(p.y + 1, p.x + 1), check, cnt);
        }
    }


    public static void main(String ars[]) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        h = sc.nextInt();
        arr = new int[h + 1][n + 1];

        for (int i = 0; i < m; i++) {
            int y = sc.nextInt();
            int x = sc.nextInt();
            arr[y][x] = 1;
        }

        solution(1, new Pair(1, 1), arr, 0);
        System.out.println(min == Integer.MAX_VALUE ? -1 : ((min > 3)?-1:min));
    }

}
