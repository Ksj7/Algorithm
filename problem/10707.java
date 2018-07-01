import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token;
        token = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(token.nextToken());

        token = new StringTokenizer(br.readLine());
        int b = Integer.parseInt(token.nextToken());


        token = new StringTokenizer(br.readLine());
        int c = Integer.parseInt(token.nextToken());


        token = new StringTokenizer(br.readLine());
        int d = Integer.parseInt(token.nextToken());


        token = new StringTokenizer(br.readLine());
        int p = Integer.parseInt(token.nextToken());

        c = (c < p) ? (p - c) * d : 0;
        b += c;
        a *= p;

        System.out.println(a > b ? b : a);


    }
}
