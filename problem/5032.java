import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());
        //현재 가지고 있는 빈 병의 수와 길에서 발견한 빈 병의 수, 새 병으로 바꾸는데 필요한 빈 병의 수
        int sum = Integer.parseInt(token.nextToken()) + Integer.parseInt(token.nextToken());
        int c = Integer.parseInt(token.nextToken());
        int cnt = 0;
        while(true) {
            int n = sum / c;
            if(n == 0) break;
            cnt += n;
            sum = sum % c + n;
        }
        System.out.print(cnt);



    }
}

