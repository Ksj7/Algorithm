import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static int N, M;
    static char arr[][];
    static int v[][][][][];
    static int dy[] = {-1, 1, 0, 0};
    static int dx[] = {0, 0, -1, 1};

    static class Pair {
        int y, x, d, c, v;
    }
    static class Cover{
        Pair p;
        int cnt;
        Cover(Pair pp, int c){
            p = pp;
            cnt = c;
        }
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        arr = new char[N][M];
        v = new int[N][M][5][2][2];
        Queue<Cover> q = new ArrayDeque<>();
        Pair start = new Pair();
        sc.nextLine();
        boolean isFirst = true;
        for (int i = 0; i < N; i++) {
            String a = sc.nextLine();
            for (int j = 0; j < M; j++) {
                arr[i][j] = a.charAt(j);
                if (arr[i][j] == 'S') {
                    start.y = i;
                    start.x = j;
                    start.d = 4;
                    start.c = 0;
                    start.v = 0;
                    v[i][j][4][0][0]=1;
                    q.add(new Cover(start, 0));
                } else if (isFirst && arr[i][j] == 'C') {
                    isFirst = false;
                } else if (!isFirst && arr[i][j] == 'C') {
                    arr[i][j] = 'V';
                }
            }
        }
        while (q.size() > 0) {
            Cover c = q.poll();
            int cnt = c.cnt;
            Pair p = c.p;
            if (p.c == 1 && p.v == 1) {
                System.out.println(cnt);
                return;
            }

            for (int i = 0; i < 4; i++) {
                if(p.d == i) continue;
                int ny = p.y + dy[i];
                int nx = p.x + dx[i];
                Pair next = new Pair();
                next.c = p.c;
                next.v = p.v;
                if(ny >= 0 && ny < N && nx >= 0 && nx < M && v[ny][nx][i][next.c][next.v] == 0 && arr[ny][nx] != '#'){
                    if(arr[ny][nx] == 'C'){
                        next.c = 1;
                    }
                    else if(arr[ny][nx] == 'V'){
                        next.v = 1;
                    }
                    next.y = ny;
                    next.x = nx;
                    next.d = i;
                    v[ny][nx][i][next.c][next.v] = 1;
                    q.add(new Cover(next, cnt + 1));
                }
            }
        }
        System.out.println(-1);

    }
}

