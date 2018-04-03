import java.util.Scanner;

public class Main {
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        int M = scanner.nextInt();
        scanner.nextLine();
        char puzz[][] = new char[N][M];
        for (int i = 0; i < N; i++) {
            puzz[i] = scanner.nextLine().toCharArray();
        }
        char w[][] = new char[8][8];
        char b[][] = new char[8][8];
        w[0][0] = 'W';
        w[1][0] = 'B';
        w[2][0] = 'W';
        w[3][0] = 'B';
        w[4][0] = 'W';
        w[5][0] = 'B';
        w[6][0] = 'W';
        w[7][0] = 'B';
        for (int i = 0; i < 8; i++) {
            for (int j = 1; j < 8; j++) {
                w[i][j] = (w[i][j - 1] == 'W') ? 'B' : 'W';
            }
        }

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                b[i][j] = (w[i][j] == 'W') ? 'B' : 'W';
            }
        }

        int yy = 0, xx;
        int cnt = Integer.MAX_VALUE;
        while (yy + 8 <= N) {
            xx = 0;
            while (xx + 8 <= M) {
                int temp = 0;
                for (int y = yy; y < yy + 8; y++) {
                    for (int x = xx; x < xx + 8; x++) {
                        if(w[y-yy][x-xx] != puzz[y][x]) temp++;
                    }
                }
                cnt = Math.min(temp, cnt);
                temp = 0;
                for (int y = yy; y < yy + 8; y++) {
                    for (int x = xx; x < xx + 8; x++) {
                        if(b[y-yy][x-xx] != puzz[y][x]) temp++;
                    }
                }
                cnt = Math.min(temp, cnt);
                xx++;
            }
            yy++;
        }
        System.out.println(cnt);
    }
}

