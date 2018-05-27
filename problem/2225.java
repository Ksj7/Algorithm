import java.util.Scanner;

public class Main {
    static int mod = 1000000000;
    static int n, k;
    static int d[][] = new int[201][201]; // d[k][n];

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();

        //1개로 i를 만들수 있는것은 그것 자신 하나밖에 없으므로 1로 초기화
        for(int i=0;i<=n;i++) {
            d[1][i] = 1;
        }
        //d[K][N] = Σ(d[K-1][N-L])
        //d[2][1] = Σ(d[1][1]) + Σ(d[1][0])
        //d[1][1] = 1
        //d[1][0] = 1

        //d[3][1] = Σ(d[2][1]) + Σ(d[2][0])
        //d[2][1] = Σ(d[1][1]) + Σ(d[1][0]) = 2
        //d[2][0] = Σ(d[1][0]) = 1
        //total = 3

        for(int i=2;i<=k;i++){
            for(int j=0;j<=n;j++){
                for(int l=0;l<=j;l++){
                    d[i][j] += d[i-1][j-l];
                    d[i][j] %= mod;
                }
            }
        }

        System.out.println(d[k][n]);
    }
}


