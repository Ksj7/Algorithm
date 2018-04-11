import java.util.Scanner;

public class Main {
    static int N, M;
    static int dy[] = {0, 0, -1, 1};
    static int dx[] = {-1, 1, 0, 0};
    static int max = Integer.MIN_VALUE;


    static void infect(int[][] map, int[][] check, int i, int j) {
        check[i][j] = 1;
        for (int k = 0; k < 4; k++) {
            int ny = i + dy[k];
            int nx = j + dx[k];
            if (ny >= 0 && ny < N && nx >= 0 && nx < M
                    && map[ny][nx] == 0 && check[ny][nx] == 0) {
                map[ny][nx] = 2;
                infect(map, check, ny, nx);
            }
        }
    }

    static void solution(int[][] map, int n) {

        if (n == 3) {
            int[][] newMap = copy(map);
            int[][] check = new int[N][M];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (newMap[i][j] == 2 && check[i][j] == 0)
                        infect(newMap, check, i, j);
                }
            }

            int cnt = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (newMap[i][j] == 0) cnt++;
                }
            }
            max = Math.max(cnt, max);
        } else {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (map[i][j] == 1 || map[i][j] == 2) continue;
                    map[i][j] = 1;
                    solution(map, n + 1);
                    map[i][j] = 0;
                }
            }
        }
    }


    static int[][] copy(int[][] map) {
        int newMap[][] = new int[N][M];
        for (int i = 0; i < N; i++)
            for (int j = 0; j < M; j++)
                newMap[i][j] = map[i][j];

        return newMap;
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        //세로 크기 N과 가로 크기 M
        N = sc.nextInt(); // y size
        M = sc.nextInt(); // x size

        int map[][] = new int[9][9]; //(3 ≤ N, M ≤ 8)
        // 0은 빈 칸, 1은 벽, 2는 바이러스
        // 바이러스는 인접한 빈 칸으로 모두 퍼짐
        // 0의 개수 >= 3
        // 2의 개수 >= 2 && 2의 개수 <= 10
        // 1의 개수 = 3

        for (int y = 0; y < N; y++) {
            for (int x = 0; x < M; x++) {
                map[y][x] = sc.nextInt();
            }
        }

        //반복문 말고 재귀문으로 해결해보자!!

        solution(map, 0);

        System.out.println(max);
    }
}

