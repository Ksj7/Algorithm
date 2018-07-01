import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int arr[] = new int[31];
        StringTokenizer token;
        for (int i = 0; i < 28; i++) {
            token = new StringTokenizer(br.readLine());
            arr[Integer.parseInt(token.nextToken())] = 1;
        }
        int cnt = 0;
        for (int i = 1; i <= 30; i++) {
            if (arr[i] == 0) {
                if (cnt == 0) {
                    System.out.println(i);
                    cnt++;
                } else if (cnt == 1) {
                    System.out.println(i);
                    return;
                }
            }
        }
    }
}

