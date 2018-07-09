import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int arr[];
    static int answer = 0;

    static void dfs(int sum, int i, boolean pass){
        if(pass || i == 10){
            int c1 = Math.abs(100 - answer);
            int c2 = Math.abs(100 - sum);
            if( c1 > c2 ){
                answer = sum;
            }else if(c1 == c2){
                if((100 - answer) > (100 - sum)){
                    answer = sum;
                }
            }
            return;
        }

        dfs(sum + arr[i], i + 1, false);
        dfs(sum, i + 1, true);
    }

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token;
        arr = new int[10];

        for(int i = 0 ; i < 10; i++){
            token = new StringTokenizer(br.readLine());
            arr[i] = Integer.parseInt(token.nextToken());
        }
        dfs(0,0, false);
        System.out.print(answer);
    }
}

