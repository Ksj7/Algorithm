import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    //10 명 중 득점이 높은 사람에서 3 명의 점수를 합산하여 대학의 득점으로하기로 했다.

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token;
        int sum[] = new int[10];
        int sum2[] = new int[10];
        for (int i = 0; i < 10; i++) {
            token = new StringTokenizer(br.readLine());
            sum[i] += Integer.parseInt(token.nextToken());
        }
        Arrays.sort(sum);
        for (int i = 0; i < 10; i++) {
            token = new StringTokenizer(br.readLine());
            sum2[i] += Integer.parseInt(token.nextToken());
        }
        Arrays.sort(sum2);

        System.out.print((sum[9] + sum[8] + sum[7]) + " " + (sum2[9] + sum2[8] + sum2[7]));

    }
}

