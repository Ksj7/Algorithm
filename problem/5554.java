import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token;
        int sum = 0;
        token = new StringTokenizer(br.readLine());
        sum += Integer.parseInt(token.nextToken());

        token = new StringTokenizer(br.readLine());
        sum += Integer.parseInt(token.nextToken());

        token = new StringTokenizer(br.readLine());
        sum += Integer.parseInt(token.nextToken());

        token = new StringTokenizer(br.readLine());
        sum += Integer.parseInt(token.nextToken());

        System.out.println(sum / 60);
        System.out.print(sum % 60);
    }
}

