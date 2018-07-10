import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int N, M;
    static int arr[][];
    static int visited[][][];
    static int dy[] = {1, -1, 0, 0};
    static int dx[] = {0, 0, -1, 1};

    static class Pair {
        int y, x, cnt, num, prev;

        Pair(int yy, int xx, int cnt, int num, int prev) {
            y = yy;
            x = xx;
            this.cnt = cnt;
            this.num = num;
            this.prev = prev;
        }
    }

    static int bfs(Pair s) {
        Queue<Pair> q = new ArrayDeque<>();
        q.add(s);
        while (!q.isEmpty()) {
            Pair p = q.poll();
            if (p.y == N - 1 && p.x == M - 1) {
                return p.num + 1;
            }

            for (int i = 0; i < 4; i++) {
                if (p.prev == i) continue;
                int ny = p.y + dy[i];
                int nx = p.x + dx[i];
                int dir = 0;
                switch (i) {
                    case 0:
                        dir = 1;
                        break;
                    case 1:
                        dir = 0;
                        break;
                    case 2:
                        dir = 3;
                        break;
                    case 3:
                        dir = 2;
                        break;
                }
                if (ny >= 0 && ny < N && nx >= 0 && nx < M) {
                    if (p.cnt == 0 && arr[ny][nx] == 1 && visited[ny][nx][1] == 0) {
                        visited[ny][nx][1]++;
                        q.add(new Pair(ny, nx, 1, p.num + 1, dir));
                    } else if (arr[ny][nx] == 0 && visited[ny][nx][0] == 0) {
                        visited[ny][nx][p.cnt]++;
                        q.add(new Pair(ny, nx, p.cnt, p.num + 1, dir));
                    }
                }
            }
        }
        return -1;
    }

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());
        N = Integer.parseInt(token.nextToken());
        M = Integer.parseInt(token.nextToken());
        arr = new int[N][M];
        visited = new int[N][M][2];
        visited[0][0][0] = 1;
        for (int i = 0; i < N; i++) {
            token = new StringTokenizer(br.readLine());
            String tmp = token.nextToken();
            for (int j = 0; j < M; j++) {
                arr[i][j] = tmp.charAt(j) - '0';
            }
        }
        System.out.println(bfs(new Pair(0, 0, 0, 0, -1)));

    }
}

