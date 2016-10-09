import java.util.Scanner;

/*
 * Author: sujin Kim (Ksj7)
 * Date: 2016.10.10
 * email: sujin.kim1414@gmail.com
 *
 * https://github.com/Ksj7/Algorithm
 * https://www.acmicpc.net/problem/1009
 */
 
public class Main {

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        int testCase = sc.nextInt();
        for (int i = 0; i < testCase; i++) {
            int A = sc.nextInt();
            int B = sc.nextInt();
            getSquare(A%10,B);
        }
    }

    private static void getSquare(int a, int b) {
        double result = 1.0;
        if(a == 1 || a == 5 || a == 6){
            System.out.println(a%10);
            return;
        }
        else if( a ==4 || a == 9){
            for(int i = 0 ; i < (b-1)%2+1; i++){
                result *= a;
            }
            result %= 10;
            if( result == 0) result = 10;
            System.out.printf("%.0f\n",result);
            return;
        }
        else {
            for (int i = 0; i < (b-1)%4+1; i++) {
                result *= a;
            }
            result %= 10;
            if( result == 0) result = 10;
            System.out.printf("%.0f\n", result);
        }
    }



}
