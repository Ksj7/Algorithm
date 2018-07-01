import java.util.Scanner;

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int arr[][] = new int[101][101];
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int nx = sc.nextInt();
            int ny = sc.nextInt();

            for (int y = ny; y < ny + 10; y++) {
                for (int x = nx; x < nx+ 10; x++)
                    arr[y][x] = 1;
            }
        }
        int cnt = 0;

        for (int i = 1; i < 100; i++) {
            for (int j = 1; j < 100; j++) {
                if (arr[i][j] == 1) cnt++;
            }
        }
        System.out.println(cnt);
    }
}

