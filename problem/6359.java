import java.util.Scanner;

public class Main {
    static int N;
    static int d[] = new int[101];
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        //(최종적으로 안 잠긴 방의 갯수) = (1부터 N 사이의 자연수 중 약수가 홀수인 수의 갯수)
        while(T>0){
            N = sc.nextInt();
            for(int i=0; i < 101; i++){
                d[i] = 1;
            }
            for(int i = 2; i <= N; i++) {
                for (int j = i; j <= N; j += i){
                    d[j]++;
                }
            }
            int num = 0;
            for(int i=1; i <= N; i++){
                if(d[i] % 2 != 0) num++;
            }
            System.out.println(num);
            T--;
        }
    }
}

