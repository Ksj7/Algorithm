import java.util.Arrays;
import java.util.Scanner;

public class Main {

    static int N, M;
    static Pair[] p;
    static int length;
    static int min = Integer.MAX_VALUE;

    static class Pair {
        int y, x, num;

        Pair(int yy, int xx, int n) {
            y = yy;
            x = xx;
            num = n;
        }
    }

    static int[][] copy(int[][] t) {
        int[][] tmp = new int[N][M];
        for (int i = 0; i < N; i++)
            tmp[i] = Arrays.copyOf(t[i], M);

        return tmp;
    }

    static int sum(int[][] obj) {
        int s = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (obj[i][j] == 0) {
                    s++;
                }
            }
        }
        return s;
    }

    static int[][] solution2(int dir, int y, int x, int[][] tmp) {
        // 1 : left
        // 2 : right
        // 3 : up
        // 4 : down
        int[][] arr = copy(tmp);
        if (dir == 1) {
            for (int i = x - 1; i >= 0; i--) {
                if (arr[y][i] == 6) break;
                else if (arr[y][i] >= 1 && arr[y][i] <= 5) continue;
                else arr[y][i] = 7;
            }
        } else if (dir == 2) {
            for (int i = x + 1; i < M; i++) {
                if (arr[y][i] == 6) break;
                else if (arr[y][i] >= 1 && arr[y][i] <= 5) continue;
                else arr[y][i] = 7;
            }
        } else if (dir == 3) {
            for (int i = y - 1; i >= 0; i--) {
                if (arr[i][x] == 6) break;
                else if (arr[i][x] >= 1 && arr[i][x] <= 5) continue;
                else arr[i][x] = 7;
            }
        } else {
            for (int i = y + 1; i < N; i++) {
                if (arr[i][x] == 6) break;
                else if (arr[i][x] >= 1 && arr[i][x] <= 5) continue;
                else arr[i][x] = 7;
            }
        }
        return arr;


    }

    static void solution(int idx, int[][] trans) {
        if (idx == length) {
            min = Math.min(sum(trans), min);
            return;
        }
        int tmp[][];
        switch (p[idx].num) {
            case 1:
                //left
                solution(idx+1, solution2(1,p[idx].y, p[idx].x, trans));
                //right
                solution(idx+1, solution2(2,p[idx].y, p[idx].x, trans));
                //up
                solution(idx+1, solution2(3,p[idx].y, p[idx].x, trans));
                //down
                solution(idx+1, solution2(4,p[idx].y, p[idx].x, trans));
                break;
            case 2:
                // l * r
                tmp = solution2(1,p[idx].y, p[idx].x, trans);
                solution(idx+1, solution2(2,p[idx].y, p[idx].x, tmp));
                // u * d
                tmp = solution2(3,p[idx].y, p[idx].x, trans);
                solution(idx+1, solution2(4,p[idx].y, p[idx].x, tmp));
                break;
            case 3:
                // l & d
                tmp = solution2(1, p[idx].y, p[idx].x, trans);
                solution(idx+1, solution2(4,p[idx].y, p[idx].x, tmp));
                // l & u
                tmp = solution2(1, p[idx].y, p[idx].x, trans);
                solution(idx+1, solution2(3,p[idx].y, p[idx].x, tmp));

                // r & d
                tmp = solution2(2, p[idx].y, p[idx].x, trans);
                solution(idx+1, solution2(4,p[idx].y, p[idx].x, tmp));
                // r & u
                tmp = solution2(2, p[idx].y, p[idx].x, trans);
                solution(idx+1, solution2(3,p[idx].y, p[idx].x, tmp));
                break;
            case 4:
                // l * r * u
                tmp = solution2(1, p[idx].y, p[idx].x, trans);
                tmp = solution2(2,p[idx].y, p[idx].x, tmp);
                solution(idx+1, solution2(3,p[idx].y, p[idx].x, tmp));
                // l * r * d
                tmp = solution2(1, p[idx].y, p[idx].x, trans);
                tmp = solution2(2,p[idx].y, p[idx].x, tmp);
                solution(idx+1, solution2(4,p[idx].y, p[idx].x, tmp));

                // u * d * l
                tmp = solution2(3, p[idx].y, p[idx].x, trans);
                tmp = solution2(4,p[idx].y, p[idx].x, tmp);
                solution(idx+1, solution2(1,p[idx].y, p[idx].x, tmp));

                // u * d * r
                tmp = solution2(3, p[idx].y, p[idx].x, trans);
                tmp = solution2(4,p[idx].y, p[idx].x, tmp);
                solution(idx+1, solution2(2,p[idx].y, p[idx].x, tmp));

                break;
            case 5:
                tmp = solution2(3, p[idx].y, p[idx].x, trans);
                tmp = solution2(1, p[idx].y, p[idx].x, tmp);
                tmp = solution2(2,p[idx].y, p[idx].x, tmp);
                solution(idx+1, solution2(4,p[idx].y, p[idx].x, tmp));
                break;
        }
    }


    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();
        int[][] arr = new int[N][M];
        p = new Pair[N * M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                arr[i][j] = sc.nextInt();
                if (arr[i][j] != 0 && arr[i][j] != 6) {
                    p[length++] = new Pair(i, j, arr[i][j]);
                }
            }
        }
        solution(0, arr);
        System.out.println(min);
    }
}

