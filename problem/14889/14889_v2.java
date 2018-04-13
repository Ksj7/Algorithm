import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static int N;
    static long min = Integer.MAX_VALUE;
    static int[][] map;

    static void pick(ArrayList<Integer> al) {
        if (al.size() == N / 2) {
            sum(al);
        } else {
            int i = al.size() == 0 ? 1 : al.get(al.size() - 1) + 1;
            for (; i <= N; i++) {
                al.add(i);
                pick(al);
                al.remove(al.size() - 1);

            }
        }
    }

    static void sum(ArrayList<Integer> al) {
        //스타트 팀의 능력치와 링크 팀의 능력치의 차이를 최소로 하려고 한다
        // i번 사람과 j번 사람이 같은 팀에 속했을 때, 팀에 더해지는 능력치는 Sij와 Sji이다
        // N/2명으로 이루어진 스타트 팀과 링크 팀으로 사람들을 나눠야 한다.
        int test[] = new int[N + 1];
        ArrayList<Integer> al2 = new ArrayList<>();

        long sum = 0, sum2 = 0;
        for (int i = 0; i < al.size(); i++) {
            test[al.get(i)] = 1;
            for (int j = i + 1; j < al.size(); j++) {
                sum += map[al.get(i)][al.get(j)] + map[al.get(j)][al.get(i)];
                test[al.get(j)] = 1;
            }
        }
        for (int i = 1; i <= N; i++) {
            if (test[i] == 0) al2.add(i);
        }

        for (int i = 0; i < al2.size(); i++) {
            for (int j = i + 1; j < al2.size(); j++) {
                sum2 += map[al2.get(i)][al2.get(j)] + map[al2.get(j)][al2.get(i)];
            }
        }
        min = Math.min(min, Math.abs(sum - sum2));
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        map = new int[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++)
                map[i][j] = sc.nextInt();
        }

        ArrayList<Integer> arrayList = new ArrayList<>();
        pick(arrayList);


        System.out.println(min);
    }
}


