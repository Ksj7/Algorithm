import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(token.nextToken());
        for (int i = 0; i < T; i++) {
            token = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(token.nextToken());
            int cnt = 0;
            double sum = 0;
            for (int n = 0; n < N; n++) {
                token = new StringTokenizer(br.readLine());
                int c = Integer.parseInt(token.nextToken());
                double g = Double.parseDouble(token.nextToken());
                cnt += c;
                sum += (g * c);
                sum = Math.round((sum * 100) / 10.0);
                sum /= 10;
            }
            sum /= cnt;
            sum = Math.round((sum * 100) / 10.0);
            sum /= 10;
            System.out.println(cnt + " " + sum);

        }
    }

}

