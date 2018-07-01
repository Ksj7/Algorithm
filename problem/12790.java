import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(token.nextToken());
        int arr[] = new int[4];
        for (int i = 0; i < T; i++) {
            token = new StringTokenizer(br.readLine());
            for (int j = 0; j < 8; j++) {
                if (j < 4)
                    arr[j] = Integer.parseInt(token.nextToken());
                else {
                    int idx = j - 4;
                    arr[idx] += Integer.parseInt(token.nextToken());
                    if (idx == 0 || idx == 1)
                        arr[idx] = arr[idx] < 1 ? 1 : arr[idx];
                    else if (idx == 2)
                        arr[idx] = arr[idx] < 0 ? 0 : arr[idx];
                }
            }
            //1 * (HP) + 5 * (MP) + 2 * (공격력) + 2 * (방어력)
            System.out.println(arr[0] + (5 * arr[1]) + (2 * arr[2]) + (2 * arr[3]));
        }
    }

}

