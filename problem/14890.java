import java.util.Scanner;

public class Main {
    static int N, L;
    static int[][] puzz;

    public static int isHPossible(int idx) {
        int s = 0, e = 0;
        for (int x = 0; x < N - 1; x++) {
            int now = puzz[idx][x];
            int next = puzz[idx][x + 1];

            if (now < next) { // 뒤에 같은 값이 연속으로 L개 나열되어 있는지 체크 , 나열된 숫자들은 모두 연속되는 수인 것이 보장됨
                e = x;
                if (e - s + 1 < L) return 0;
                else s = x + 1;
            }else if(now > next){// 앞에 같은 값이 연속으로 L개 나열되어 있는지 체크
                if(x + L < N && now - 1 == next) {
                    for (int i = x + 2; i < x + L + 1; i++) {
                        if (puzz[idx][i] != next) return 0;
                    }
                    s = x + L + 1;
                }else return 0;
            }
        }
        return 1;

    }

    public static int isVPossible(int idx) {
        int s = 0, e = 0;
        for (int y = 0; y < N - 1; y++) {
            int now = puzz[y][idx];
            int next = puzz[y + 1][idx];
            if (now < next) { // 뒤에 같은 값이 연속으로 L개 나열되어 있는지 체크
                e = y;
                if (e - s + 1 < L) return 0;
                else s = y + 1;
            }else if(now > next){// 앞에 같은 값이 연속으로 L개 나열되어 있는지 체크
                if(y + L < N && now - 1 == next) {
                    for (int i = y + 2; i < y + L + 1; i++) {
                        if (puzz[i][idx] != next) return 0;
                    }
                    s = y + L + 1;
                }else return 0;
            }
        }
        return 1;

    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        L = sc.nextInt();
        int res = 0;
        puzz = new int[N][N];
        for (int y = 0; y < N; y++) {
            for (int x = 0; x < N; x++) {
                puzz[y][x] = sc.nextInt();
            }
        }
        for (int x = 0; x < N; x++) {
            res += isHPossible(x);
            res += isVPossible(x);
        }
        System.out.println(res);
    }
}

