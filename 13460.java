import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    //N은 세로. M은 가로
    static int N, M;
    static Pair goal;
    static char puzzle[][];
    static int min = -1;
    //아래 오른 위 왼쪽
    static int dx[] = {0, 1, 0, -1};
    static int dy[] = {1, 0, -1, 0};

    static class Pair {
        int x = 0;
        int y = 0;

        Pair(int y, int x) {
            this.x = x;
            this.y = y;
        }
    }

    public static class Cover {
        Pair red;
        Pair blue;
        int cnt;

        Cover(Pair red, Pair blue, int cnt) {
            this.red = red;
            this.blue = blue;
            this.cnt = cnt;
        }
    }

    private static Pair move(int dx, int dy, Pair p, Pair e) {
        int gop = 1;
        while (0 <= p.x + (dx * gop) && p.x + (dx * gop) < M
                && 0 <= p.y + (dy * gop) && p.y + (dy * gop) < N
                && (puzzle[p.y + (dy * gop)][p.x + (dx * gop)] != '#')) {
            if (e != null && e.x == (p.x + (dx * gop)) && e.y == (p.y + (dy * gop))) break;
            if (puzzle[p.y + (dy * gop)][p.x + (dx * gop)] == 'O') {
                return null;
            } else {
                gop++;
            }
        }
        return new Pair(p.y + (dy * (gop-1)), p.x + (dx * (gop-1)));
    }

    static void bfs(Pair red, Pair blue) {
        Queue<Cover> q = new LinkedList<>();
        q.add(new Cover(red, blue, 0));
        while (!q.isEmpty()) {
            Cover c = q.poll();
            if (c.red.x == c.blue.x && c.red.y == c.blue.y) continue;
            Pair tempRed, tempBlue;
            int cnt = c.cnt;
            if (cnt > 9) continue;
            for (int i = 0; i < 4; i++) {
                tempRed = null;
                tempBlue = null;
                //아래 오른 위 왼쪽
                if (i == 0) {
                    if (c.red.x == c.blue.x && c.red.y > c.blue.y) {
                        tempRed = move(dx[i], dy[i], c.red, null);
                        tempBlue = move(dx[i], dy[i], c.blue, tempRed);
                    } else {
                        tempBlue = move(dx[i], dy[i], c.blue, null);
                        if (tempBlue == null) ;
                        else tempRed = move(dx[i], dy[i], c.red, tempBlue);
                    }
                }
                if (i == 1) {
                    if (c.red.y == c.blue.y && c.red.x > c.blue.x) {
                        tempRed = move(dx[i], dy[i], c.red, null);
                        tempBlue = move(dx[i], dy[i], c.blue, tempRed);
                    } else {
                        tempBlue = move(dx[i], dy[i], c.blue, null);
                        if (tempBlue == null) ;
                        else tempRed = move(dx[i], dy[i], c.red, tempBlue);
                    }
                }
                if (i == 2) {
                    if (c.red.x == c.blue.x && c.red.y < c.blue.y) {
                        tempRed = move(dx[i], dy[i], c.red, null);
                        tempBlue = move(dx[i], dy[i], c.blue, tempRed);
                    } else {
                        tempBlue = move(dx[i], dy[i], c.blue, null);
                        if (tempBlue == null) ;
                        else tempRed = move(dx[i], dy[i], c.red, tempBlue);
                    }
                }
                //왼쪽
                if (i == 3) {
                    if (c.red.y == c.blue.y && c.red.x < c.blue.x) {
                        tempRed = move(dx[i], dy[i], c.red, null);
                        tempBlue = move(dx[i], dy[i], c.blue, tempRed);
                    } else {
                        tempBlue = move(dx[i], dy[i], c.blue, null);
                        if (tempBlue == null) ;
                        else tempRed = move(dx[i], dy[i], c.red, tempBlue);
                    }
                }
                if (tempRed == null && tempBlue != null) {
                    if (min == -1) min = cnt + 1;
                    else min = min > cnt + 1 ? cnt + 1 : min;
                } else if (tempRed != null && tempBlue != null) {
                    if (tempRed.x == c.red.x && tempRed.y == c.red.y
                            && tempBlue.x == c.blue.x && tempBlue.y == c.blue.y) ;
                    else {
                        q.add(new Cover(tempRed, tempBlue, cnt + 1));
                    }
                }
            }

        }
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        sc.nextLine();
        String miro[] = new String[N];
        puzzle = new char[N][M];
        Pair red = null, blue = null;
        for (int i = 0; i < N; i++) {
            miro[i] = sc.nextLine();
            for (int j = 0; j < M; j++) {
                if (miro[i].charAt(j) == 'R')
                    red = new Pair(i, j);
                else if (miro[i].charAt(j) == 'B')
                    blue = new Pair(i, j);
                else if (miro[i].charAt(j) == 'O')
                    goal = new Pair(i, j);
            }
            puzzle[i] = miro[i].toCharArray();
        }
        bfs(red, blue);
        System.out.println(min);
    }
}



