import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N, M;
    static int arr[];
    static int answer = -1;
    static void solution(int idx, int sum, int cnt){
        if(idx >= N) {
            if(cnt == 3){
                answer = Math.max(sum, answer);
            }
            return;
        }
        if(cnt == 3){
            answer = Math.max(sum, answer);
            return;
        }
        if(sum + arr[idx] <= M){
            solution(idx + 1, sum + arr[idx], cnt + 1);
        }
        solution(idx + 1, sum, cnt);
    }

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());
        N = Integer.parseInt(token.nextToken());
        M = Integer.parseInt(token.nextToken());
        arr = new int[N];
        token = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(token.nextToken());
        }
        solution(0,0,0);
        System.out.print(answer);

    }
}

