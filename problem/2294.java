import java.util.Arrays;
import java.util.Scanner;

/*
 * Author: sujin Kim (Ksj7)
 * Date: 2016.09.30
 * email: sujin.kim1414@gmail.com
 *
 * https://github.com/Ksj7/Algorithm
 * https://www.acmicpc.net/problem/2294
 */
 
 
public class Main {


    public static void main(String[] args) {
        {
            long number[];
            int testCase, n;
            Scanner sc = new Scanner(System.in);
            testCase = sc.nextInt();
            n = sc.nextInt();
            int[] coin = new int[n];
            number = new long[n + 1];
            Arrays.fill(number,Integer.MAX_VALUE);
            for (int i = 0; i < testCase; i++) {
                coin[i] = sc.nextInt();
                for (int j = 1; j <= n / coin[i]; j++) {
                    int index = coin[i] * j;
                    if (number[index] != 0)
                        number[index] = (number[index] > j) ? j : number[index];
                    else number[index] = j;
                }
            }

            for (int i = 0; i < testCase; i++) {
                for (int j = coin[i]; j <= n; j++) {
                    number[j] = Math.min( number[j],1+(number[j - coin[i]]));
                }
            }

            if(number[n]==Integer.MAX_VALUE) System.out.println("-1");
            else System.out.println(number[n]);
        }
    }
}