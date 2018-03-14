import java.util.Scanner;

public class Main {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        boolean res[] = new boolean[15001];
        boolean check[] = new boolean[15001];
        int a[] = new int[N];
        for(int i = 0 ; i < N; i++){
            a[i] = sc.nextInt();
        }
        check[0] = true;
        res[0] = true;
        for(int i = 0; i < N; i++){
            for(int j = 0; j < 15001; j++){
                if(res[j]) {
                    int left = Math.abs(a[i] - j);
                    int right = Math.abs(a[i] + j);
                    if(left >= 0 && left < 15001) check[left] = true;
                    if(right >= 0 && right < 15001) check[right] = true;
                    check[a[i]] = true;
                }

            }
            for(int j = 0; j < 15001; j++){
                res[j] = check[j];
            }
        }

        int M = sc.nextInt();
        for(int i = 0 ; i < M; i++){
            int temp = sc.nextInt();
            if(temp <= 15000 && res[temp]) System.out.print("Y ");
            else System.out.print("N ");
        }
    }
}

