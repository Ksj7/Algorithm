import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static int N, M;
    static int arr[][];
    static int cnt[][];
    static ArrayList<Pair> city = new ArrayList<>();
    static ArrayList<Pair> ch = new ArrayList<>();
    static int min = Integer.MAX_VALUE;
    static int cal[][];

    static class Pair {
        int x, y;

        Pair(int yy, int xx) {
            x = xx;
            y = yy;
        }
    }

    public static void calc() {
        cal = new int[city.size()][ch.size()];
        for (int i = 0; i < city.size(); i++) {
            for (int j = 0; j < ch.size(); j++) {
                cal[i][j] = Math.abs(city.get(i).y - ch.get(j).y) + Math.abs(city.get(i).x - ch.get(j).x);
            }
        }
    }


    public static void solution(int id, ArrayList<Integer> chChoice) {
        if (chChoice.size() == M) {
            int sum = 0;
            for (int i = 0; i < city.size(); i++) {
                int min = Integer.MAX_VALUE;
                for (int j : chChoice) {
                    min = Math.min(min, cal[i][j]);
                }
                sum += min;
            }
            min = Math.min(sum, min);


        } else {
            for (int i = id; i < ch.size(); i++) {
                ArrayList<Integer> tmp = new ArrayList<>();
                tmp.addAll(chChoice);
                tmp.add(i);
                solution(i + 1, tmp);
            }
        }

    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        arr = new int[N + 1][N + 1];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                arr[i][j] = sc.nextInt();
                if (arr[i][j] == 2) {
                    ch.add(new Pair(i, j));
                } else if (arr[i][j] == 1) {
                    city.add(new Pair(i, j));
                }
            }
        }
        calc();
        solution(0, new ArrayList<>());
        System.out.println(min);

    }
}


