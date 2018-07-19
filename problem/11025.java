import java.util.Scanner;

public class Main {
    static long solution(long n, long k) {
        int i = 1;
        long b = 1;
        while(i < n){
            b = ((b + k) % ++i);
            if(b == 0) b = i;
        }
        return b;
    }
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        System.out.print(solution(N, K));

    }

}

