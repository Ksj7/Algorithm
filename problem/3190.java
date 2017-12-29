import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {
    static class Pair {
        int x;
        int y;

        Pair(int y, int x) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        boolean crush = false;
        Deque<Pair> snake = new LinkedList<>();
        int N = sc.nextInt();
        int puzzle[][] = new int[N][N];
        int K = sc.nextInt();
        for (int i = 0; i < K; i++) {
            puzzle[sc.nextInt() - 1][sc.nextInt() - 1] = 1;
        }
        int L = sc.nextInt();
        int time[] = new int[L];
        char dir[] = new char[L];
        for (int i = 0; i < L; i++) {
            time[i] = sc.nextInt();
            dir[i] = sc.nextLine().charAt(1);
        }
        snake.add(new Pair(0, 0));
        puzzle[0][0] = 2;
        int sec = 0;
        char currDir = 'D';
        int currTimeIdx = 0;
        //왼쪽 : L, 오른쪽 D, 아래 :K , 위 : F
        while (true) {
            crush = false;
            int x = snake.getFirst().x;
            int y = snake.getFirst().y;
            //오른쪽
            if (currDir == 'D') x++;
                //위
            else if (currDir == 'F') y--;
                //왼쪽
            else if (currDir == 'L') x--;
                //아래
            else y++;
            if (!(0 <= x && x < N && 0 <= y && y < N)) break;
            for (Pair body : snake) {
                if (body.x == x && body.y == y) {
                    crush = true;
                    break;
                }
            }
            if(crush) break;
            snake.addFirst(new Pair(y, x));
            if (puzzle[y][x] == 0) {
                puzzle[snake.getLast().y][snake.getLast().x] = 0;
                snake.removeLast();
            }
            puzzle[y][x] = 2;

            sec++;
            if (currTimeIdx < L && sec == time[currTimeIdx]) {
                if (dir[currTimeIdx] == 'D') {
                    if (currDir == 'D') currDir = 'K';
                    else if (currDir == 'K') currDir = 'L';
                    else if (currDir == 'L') currDir = 'F';
                    else currDir = 'D';
                } else {
                    if (currDir == 'D') currDir = 'F';
                    else if (currDir == 'F') currDir = 'L';
                    else if (currDir == 'L') currDir = 'K';
                    else currDir = 'D';
                }
                currTimeIdx++;
            }

        }
        System.out.println(sec+1);


    }
}

