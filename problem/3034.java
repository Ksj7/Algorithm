import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token;
        int N, W, H;
        int standard;
        token = new StringTokenizer(br.readLine());
        N = Integer.parseInt(token.nextToken());
        W = Integer.parseInt(token.nextToken());
        H = Integer.parseInt(token.nextToken());
        standard = (int) Math.sqrt((W * W + H * H));
        for (int i = 0; i < N; i++){
            token = new StringTokenizer(br.readLine());
            int testcase = Integer.parseInt(token.nextToken());
            System.out.println(standard >= testcase ? "DA" : "NE");
        }
    }
}

