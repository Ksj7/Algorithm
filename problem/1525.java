import java.util.Scanner;

public class Main {
    static int dy[] = {0, 1, -1, 0};
    static int dx[] = {-1, 0, 0, 1};
    static int[][] check = new int[3][3];
    static int min = 1000;

    static boolean success(int[][] a, int num) {
        int cnt = 1;
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 3; j++) {
                if (cnt == a[i][j]) cnt++;
                else break;
            }
        }
        if(cnt == 7 && a[2][0] == 7 && a[2][1] == 8 && a[2][2] == 0){
            min = Math.min(min, num);
            return true;
        } else return false;
    }


    static void solve(int sy, int sx, int py, int px, int[][] a, int[][] check, int num) {
        if (success(a, num)) return;
        check[sy][sx]++;
        for (int i = 0; i < 4; i++) {
            int ny = dy[i] + sy;
            int nx = dx[i] + sx;
            if(ny == py && nx == px) continue;
            if (nx >= 0 && nx < 3 && ny >= 0 && ny < 3) {
                if(check[ny][nx] < 10) {
                    int temp = check[ny][nx];
                    check[ny][nx] = temp + 1;
                    a[sy][sx] = a[ny][nx];
                    a[ny][nx] = 0;
                    solve(ny, nx, sy, sx, a, check, num + 1);
                    check[ny][nx] = temp;
                    a[ny][nx] = a[sy][sx];
                    a[sy][sx] = 0;
                }
            }
        }
    }


    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int sy = 0, sx = 0;
        int[][] a = new int[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                a[i][j] = sc.nextInt();
                if (a[i][j] == 0) {
                    sy = i;
                    sx = j;
                }
            }
        }
        solve(sy, sx, -1, -1, a, check, 0);
        System.out.println(min == 1000 ? -1 : min);

    }
}


