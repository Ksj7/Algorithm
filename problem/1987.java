import java.util.Scanner;

public class Main {
    static int R, C;
    static int puzz[][];
    static int dy[] = {-1, 1, 0, 0};
    static int dx[] = {0, 0, -1, 1};
    static int check[] = new int[26];
    static int N;


    static void dfs(int y, int x, int n) {
        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];
            if (ny >= 0 && ny < R && nx >= 0 && nx < C) {
                if (check[puzz[ny][nx]] == 0) {
                    check[puzz[ny][nx]] = 1;
                    dfs(ny, nx, n + 1);
                    check[puzz[ny][nx]] = 0;
                }
            }
        }

        N = Math.max(N, n);
    }

    //새로 이동한 칸에 적혀 있는 알파벳은 지금까지 지나온 모든 칸에 적혀 있는 알파벳과는 달라야 한다
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        R = sc.nextInt();
        C = sc.nextInt();
        puzz = new int[R][C];
        sc.nextLine();
        for (int i = 0; i < R; i++) {
            String temp = sc.nextLine();
            for (int j = 0; j < C; j++) {
                puzz[i][j] = temp.charAt(j) - 'A';
            }
        }
        check[puzz[0][0]] = 1;
        dfs(0, 0, 1);
        System.out.println(N);


    }
}
