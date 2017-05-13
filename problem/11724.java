/**
 * Created by sujin on 2017-05-14.
 */

import java.io.IOException;
        import java.util.Scanner;
        import java.util.Vector;

public class Main {

    private static boolean[] check;
    private static int num = 0;
    private static Vector[] adjacency_matrix;

    private static void dfs(int x) {
        if(check[x]) return;
        check[x] = true;
        for (int j = 0; j < adjacency_matrix[x].size(); j++) {
            int next = (int) adjacency_matrix[x].get(j);
            if (!check[next]) {
                dfs(next);
            }
        }
    }

    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        adjacency_matrix = new Vector[n+1];
        for (int i = 1; i <= n; i++) {
            adjacency_matrix[i] = new Vector();
        }
        check = new boolean[n+1];
        for(int k = 0 ; k < m; k++) {
            int i = sc.nextInt();
            int j = sc.nextInt();
            adjacency_matrix[i].add(j);
            adjacency_matrix[j].add(i);
        }
        for (int i = 1; i <= n; i++) {
            if(!check[i]) {
                dfs(i);
                num++;
            }
        }
        System.out.println(num);
    }
}
