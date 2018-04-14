import java.util.Scanner;

public class Main {
    static int A[];
    static int N, K;

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        A = new int[N];
        K = sc.nextInt();
        int idx = 0;
        for (int i = 0; i < N; i++) {
            A[i] = sc.nextInt();
            if(A[i] < K) idx = i;
        }
        int answer = K;
        int cnt = 0;
        while(idx >= 0){
            if(answer > A[idx]) {
                answer -= A[idx];
                cnt++;
                if (answer >= A[idx]) continue;
                else idx--;
            }else if(answer == A[idx]){
                cnt++;
                break;
            }else idx--;
        }
        System.out.println(cnt);

    }
}
