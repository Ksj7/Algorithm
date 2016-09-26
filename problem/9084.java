import java.util.Scanner;

/*
 * Author: sujin Kim (Ksj7)
 * Date: 2016.09.24
 * email: sujin.kim1414@gmail.com
 *
 * https://github.com/Ksj7/Algorithm
 * https://www.acmicpc.net/problem/1707
 */
 
public class Main {


    public static void main(String[] args) {
        {
            int number[];
            int testCase, n;
            Scanner sc = new Scanner(System.in);
            testCase = sc.nextInt();
            while (testCase > 0) {
                n = sc.nextInt();
                int[] coin = new int[n];
                for (int i = 0; i < n; i++) coin[i] = sc.nextInt();
                int condition = sc.nextInt();
                number = new int[condition+1];
                number[0] = 1;
                for (int i = 0; i < n; i++) {
                    for (int j = coin[i]; j <= condition; j++) {
                        number[j] += number[j-coin[i]];
                    }
                }
                System.out.println(number[condition]);
                testCase--;
            }
        }
    }
}