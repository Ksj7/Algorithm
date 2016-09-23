import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

/*
 * Author: sujin Kim (Ksj7)
 * Date: 2016.07.20
 * email: sujin.kim1414@gmail.com
 *
 * https://github.com/Ksj7/Algorithm
 * https://www.acmicpc.net/problem/1707
 */
 
public class Main {

    private static boolean[] check;
    private static int array_num;
    private static int[][] adjacency_matrix;
    private static Queue<Integer> q =  new LinkedList<Integer>();
    private static void dfs(int x){
        check[x] = true;
        System.out.print(x+1 +" ");
        for(int i = 0; i < adjacency_matrix[x].length ; i++){
            if(adjacency_matrix[x][i]== 1 && check[i]==false){
                dfs(i);
            }
        }
    }

    private static void bfs(int x){
        check = new boolean[array_num];
        check[x] = true; q.add(x);
        while(!q.isEmpty()) {
            int temp = q.remove();
            System.out.print(temp+1+" ");
            for (int i = 0; i < adjacency_matrix[temp].length; i++) {
                if(check[i] == false && adjacency_matrix[temp][i] ==1){
                    q.add(i);
                    check[i]= true;
                }
            }
        }
    }
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");
        array_num = Integer.valueOf(line[0]);
        adjacency_matrix = new int[array_num][array_num];
        check = new boolean[array_num];
        int test_case = Integer.valueOf(line[1]);
        while (test_case > 0) {
            {
                String[] temp = br.readLine().split(" ");
                int i = Integer.valueOf(temp[0]);
                int j = Integer.valueOf(temp[1]);
                adjacency_matrix[i-1][j-1] = 1;
                adjacency_matrix[j-1][i-1] = 1;
            }
            test_case--;
        }
        dfs(Integer.valueOf(line[2])-1);
        System.out.println();
        bfs(Integer.valueOf(line[2])-1);

    }
}
