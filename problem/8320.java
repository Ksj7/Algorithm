import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int solution(int target){
        boolean check[] = new boolean[10001];
        int num = 0;
        for(int i = 2; i <= (target / 2); i++){
            if(check[i]) continue;
            if(target % i == 0){
                check[i] = true;
                check[target/i] = true;
                num++;
            }
        }
        return num;
    }

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(token.nextToken());
        int dp[] = new int[10001];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 3;
        for(int i = 4; i <= N; i++ ){
            dp[i] = dp[i-1] + 1;
            dp[i] += solution(i);
        }

        System.out.println(dp[N]);
    }
}

