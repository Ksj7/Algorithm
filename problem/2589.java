import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    static class Pair {
        int x, y;

        Pair(int y, int x) {
            this.x = x;
            this.y = y;
        }

    }
    static char arr[][] = new char[51][51];
    static int dy[] = {0, 0, -1, 1};
    static int dx[] = {-1, 1, 0, 0};
    static int N, M;
    
    static int bfs(int y, int x) {
        Queue<Pair> q = new ArrayDeque<>();
        q.add(new Pair(y, x));
        int check[][] = new int[N][M];
        int max = 0;
        while (!q.isEmpty()) {
            Pair p = q.poll();
            max = Math.max(check[p.y][p.x], max);
            for (int i = 0; i < 4; i++) {
                int ny = p.y + dy[i];
                int nx = p.x + dx[i];
                if (ny >= 0 && ny < N && nx >= 0 && nx < M) {
                    if (check[ny][nx] == 0 && arr[ny][nx] == 'L') {
                        check[ny][nx] = check[p.y][p.x] + 1;
                        q.add(new Pair(ny, nx));
                    }
                }
            }
        }
        return max;
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();//세로
        M = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextLine().toCharArray();
        }
        int[][] check = new int[N][M];
        int min[] = new int[2];
        int max = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++)
                if (arr[i][j] == 'L') {
                    max = Math.max(bfs(i, j),max);
                }
        }
        System.out.println(max);
    }
}

