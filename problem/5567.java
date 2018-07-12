import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(token.nextToken());
        token = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(token.nextToken());
        int arr[][] = new int[n + 1][n + 1];
        for (int i = 0; i < m; i++) {
            token = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(token.nextToken());
            int b = Integer.parseInt(token.nextToken());
            arr[a][b] = 1;
            arr[b][a] = 1;
        }
        boolean visited[] = new boolean[n + 1];
        for(int i = 2; i <= n; i++){
            if(arr[1][i] == 1){
                visited[i] = true;
                for(int j = 2; j <= n; j++) {
                    if(arr[i][j] == 1 && !visited[j]){
                        visited[j] = true;
                    }
                }
            }
        }
        int cnt =0;
        for(int i = 2; i <= n; i++)
            if(visited[i])
                cnt++;
        System.out.print(cnt);

    }
}

