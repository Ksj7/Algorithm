import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {

    static class Pair {
        int idx, g = -1, s = -1, d = -1;
    }

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(token.nextToken());
        int K = Integer.parseInt(token.nextToken());
        Pair arr[] = new Pair[N];
        for (int i = 0; i < N; i++) {
            token = new StringTokenizer(br.readLine());
            arr[i] = new Pair();
            arr[i].idx = Integer.parseInt(token.nextToken());
            arr[i].g = Integer.parseInt(token.nextToken());
            arr[i].s = Integer.parseInt(token.nextToken());
            arr[i].d = Integer.parseInt(token.nextToken());
        }
        Arrays.sort(arr, (o1, o2) -> {
            if (o1.g < o2.g) return 1;
            else if (o1.g > o2.g) return -1;
            else {
                if (o1.s < o2.s) return 1;
                else if (o1.s > o2.s) return -1;
                else {
                    return Integer.compare(o2.d, o1.d);
                }
            }
        });

        int num = 1;
        Pair prev = null;
        int cnt = 0;
        for (int i = 0; i < N; i++) {

            if (prev != null) {
                if (prev.g != arr[i].g || prev.s != arr[i].s || prev.d != arr[i].d) {
                    num++;
                    if (cnt > 0) {
                        num += cnt;
                        cnt = 0;
                    }
                } else {
                    cnt++;
                }
            } else {
                prev = new Pair();
            }

            if (K == arr[i].idx) {
                System.out.println(num);
                return;
            }

            prev.g = arr[i].g;
            prev.s = arr[i].s;
            prev.d = arr[i].d;
        }
    }
}
