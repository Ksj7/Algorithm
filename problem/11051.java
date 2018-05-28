import java.util.Scanner;


public class Main {
    static long d[][] = new long[1001][1001];
    static int N, K;
    //이항계수는 이항정리에서 전개된 항의 계수를 의미한다
    //  nCk =  n! / (k!*(n-k)!)
    //  2C1 = 2!/(1!*(2-1)!)

    static long solve(int n, int k){
        if(k == n || k == 0) return 1;
        if(d[n][k] > 0) return d[n][k];
        d[n][k] = solve(n-1,k-1) + solve(n - 1, k);
        d[n][k] %= 10007;
        return d[n][k];
    }


    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        K = sc.nextInt();
        System.out.println(solve(N,K));


    }
}

