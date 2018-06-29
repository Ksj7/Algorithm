import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    static int N, prime[];
    static int  solution(int sum, ArrayList<Integer> l, int n){

        if(sum > N){
            return 0;
        }
        if(sum == N && n == 4 ) {
            for(int i : l) {
                System.out.print(i + " ");
            }
            return 1;
        }else if(sum == N && n < 4){
            return 0;
        }
        int ret = 0;
        for(int i = N - 1; i >= 2; i --){
            if(prime[i] == 1) {
                ArrayList<Integer> tmp = new ArrayList<>();
                tmp.addAll(l);
                tmp.add(i);
                ret = solution(sum + i, tmp, n + 1);
                if (ret == 1) break;
            }
        }
        return ret;
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        prime = new int[N + 1];
        Arrays.fill(prime, 1);
        int i = 2;
        while (i < N) {
            if (prime[i] == 1) {
                int n = i + i;
                for (; n < N; n += i) {
                    prime[n] = 0;
                }
            }
            i++;
        }
        int ret = solution(0, new ArrayList<>(), 0);
        if(ret == 0) System.out.print(-1);

    }
}

