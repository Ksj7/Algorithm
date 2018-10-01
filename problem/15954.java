import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static double min = Double.MAX_VALUE;
    static double V;
    static int n, k;
    static int arr[];
    static double sum[];

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] tmp = br.readLine().split(" ");
        n = Integer.parseInt(tmp[0]);
        k = Integer.parseInt(tmp[1]);
        arr = new int[n + 1];
        sum = new double[n + 1];

        tmp = br.readLine().split(" ");
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(tmp[i - 1]);
        }
        for (int i = 1; i <= n; i++) {
            sum[i] = sum[i - 1] + arr[i];
        }
        for (int i = 1; i <= n - k + 1; i++) {
            int x = k;
            while (x + i - 1 <= n) {
                double m = (sum[x + i - 1] - sum[i - 1]) / (double) x;
                double v = 0;
                for (int k = i; k < i + x; k++)
                    v += (arr[k] - m) * (arr[k] - m);
                min = Math.min(min, Math.sqrt(v/x));
                x++;
            }
        }
        System.out.println(String.format("%.11f", min));
    }
}

