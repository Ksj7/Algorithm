import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int gcd(int a, int b) {

        if (b == 0) {
            return a;
        } else {
            return gcd(b, a % b);
        }
    }


    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());
        //현재 가지고 있는 빈 병의 수와 길에서 발견한 빈 병의 수, 새 병으로 바꾸는데 필요한 빈 병의 수
        int N = Integer.parseInt(token.nextToken());
        token = new StringTokenizer(br.readLine());
        if (N == 2) {
            int a = Integer.parseInt(token.nextToken());
            int b = Integer.parseInt(token.nextToken());
            int n = gcd(a, b);
            for (int i = 1; i <= n; i++) {
                if (a % i == 0 && b % i == 0) {
                    System.out.println(i);
                }
            }
        } else {
            int arr[] = new int[3];
            arr[0] = Integer.parseInt(token.nextToken());
            arr[1] = Integer.parseInt(token.nextToken());
            arr[2] = Integer.parseInt(token.nextToken());
            Arrays.sort(arr);
            int n = gcd(arr[0], arr[1]);
            for (int i = 1; i <= n; i++) {
                if (arr[0] % i == 0 && arr[1] % i == 0 && arr[2] % i == 0) {
                    System.out.println(i);
                }
            }
        }
    }

}

