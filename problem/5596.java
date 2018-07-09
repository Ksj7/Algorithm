import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token;
        int S = 0, T = 0;
        token = new StringTokenizer(br.readLine());
        for(int i = 0; i < 4; i++){
            S += Integer.parseInt(token.nextToken());
        }

        token = new StringTokenizer(br.readLine());
        for(int i = 0; i < 4; i++){
            T += Integer.parseInt(token.nextToken());
        }
        System.out.print(S >= T ? S : T);
    }
}
