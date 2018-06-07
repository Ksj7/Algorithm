import java.util.Scanner;

public class Main {
    static int max = 0;
    static int n, m = 0;
    static int[][] arr;

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        arr = new int[n][m];
        sc.nextLine();
        for (int i = 0; i < n; i++) {
            String ar = sc.nextLine();
            for (int j = 0; j < m; j++) {
                arr[i][j] = ar.charAt(j) - '0';
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (arr[i][j] != 0 && i - 1 >= 0 && j - 1 >= 0) {
                    arr[i][j] = Math.min(arr[i-1][j-1],Math.min(arr[i - 1][j], arr[i][j - 1])) + 1;
                }
                max = Math.max(max, arr[i][j]);
            }
        }
        System.out.println(max*max);
    }
}
