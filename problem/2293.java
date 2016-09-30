import java.util.Scanner;


/*
 * Author: sujin Kim (Ksj7)
 * Date: 2016.09.30
 * email: sujin.kim1414@gmail.com
 *
 * https://github.com/Ksj7/Algorithm
 * https://www.acmicpc.net/problem/1707
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
            number[0] = 1;
            for (int i = 0; i < testCase; i++) coin[i] = sc.nextInt();
            for (int i = 0; i < testCase; i++) {
                for (int j = coin[i]; j <= n; j++) {
                    number[j] += number[j - coin[i]];
                }
            }
            System.out.println(number[n]);
        }
    }
}