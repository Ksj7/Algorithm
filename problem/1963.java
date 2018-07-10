import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int prime[] = new int[10000];

    static class Data {
        String str;
        int cnt;
        int prev;

        Data(String s, int c, int prev) {
            str = s;
            cnt = c;
            this.prev = prev;
        }
    }

    static int bfs(String a, String b) {
        Queue<Data> q = new ArrayDeque<>();
        q.add(new Data(a, 0, -1));
        while (!q.isEmpty()) {
            Data d = q.poll();
            String str = d.str;
            if (str.equals(b)) {
                return d.cnt;
            }
            for (int i = 0; i < 4; i++) {
                int j = 0;
                if (i == 0) j = 1;
                if (d.prev == i) continue;
                while (j < 10) {
                    if (str.charAt(i) - '0' == j) ;
                    else {
                        String cmp;
                        if (i == 0) {
                            cmp = j + "" + str.substring(1, 4);
                        } else {
                            cmp = str.substring(0, i) + "" + j + str.substring(i + 1, 4);
                        }
                        if (prime[Integer.parseInt(cmp)] == 1) {
                            q.add(new Data(cmp, d.cnt + 1, i));
                        }
                    }
                    j++;
                }
            }
        }
        return -1;
    }

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(token.nextToken());
        Arrays.fill(prime, 1);
        int idx = 2;
        while (idx <= 9999) {
            if (prime[idx] == 1) {
                int n = idx + idx;
                for (; n <= 9999; n += idx) {
                    prime[n] = 0;
                }
            }
            idx++;
        }
        for (int t = 0; t < T; t++) {
            token = new StringTokenizer(br.readLine());
            String a = token.nextToken();
            String b = token.nextToken();
            int ans = bfs(a, b);
            System.out.println(ans == -1 ? "Impossible" : ans);
        }

    }

}

