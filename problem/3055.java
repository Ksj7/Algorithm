import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    // 비버 이동 , 물도 매 분마다 비어있는 칸으로 확장한다.
    //고슴도치는 물로 차있는 구역으로 이동할 수 없고, 물도 비버의 소굴로 이동할 수 없다.
    //최소 시간
    //다음 시간에 물이 찰 예정인 칸으로 고슴도치는 이동할 수 없다.
    static int R, C;
    static char arr[][];
    static int dy[] = {-1, 1, 0, 0};
    static int dx[] = {0, 0, -1, 1};
    static Queue<Pair> water = new ArrayDeque<>();
    static Queue<Pair> hall = new ArrayDeque<>();

    static class Pair {
        int y, x;

        Pair(int yy, int xx) {
            y = yy;
            x = xx;
        }
    }

    static boolean extend() {
        int size = hall.size();

        for (int i = 0; i < size; i++) {
            Pair p = hall.poll();

            for (int j = 0; j < 4; j++) {
                int nx = dx[j] + p.x;
                int ny = dy[j] + p.y;

                if (0 <= nx && nx < C && 0 <= ny && ny < R) {
                    if (arr[ny][nx] == 'D') {
                        return true;
                    }
                    if (arr[ny][nx] == '.') {
                        arr[ny][nx] = 'S';
                        hall.add(new Pair(ny, nx));
                    }
                }
            }
        }
        return false;
    }

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());
        R = Integer.parseInt(token.nextToken());
        C = Integer.parseInt(token.nextToken());
        arr = new char[R][C];
        for (int r = 0; r < R; r++) {
            token = new StringTokenizer(br.readLine());
            String tmp = token.nextToken();
            for (int c = 0; c < C; c++) {
                arr[r][c] = (tmp).charAt(c);
                if (arr[r][c] == 'S') {
                    hall.add(new Pair(r, c));
                } else if (arr[r][c] == '*') {
                    water.add(new Pair(r, c));
                }
            }
        }
        int ans = 0;
        while (true) {
            ++ans;
            if (hall.size() == 0) {
                System.out.println("KAKTUS");
                return;
            }


            int size = water.size();

            for (int i = 0; i < size; i++) {
                Pair p = water.poll();

                for (int j = 0; j < 4; j++) {
                    int nx = dx[j] + p.x;
                    int ny = dy[j] + p.y;

                    if (0 <= nx && nx < C && 0 <= ny && ny < R) {
                        if (arr[ny][nx] == '.') {
                            arr[ny][nx] = '*';
                            water.add(new Pair(ny, nx));
                        }
                    }
                }
            }

            if (extend()) {
                System.out.println(ans);
                return;
            }
        }
    }
}
