import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;
/*
 * Author: sujin Kim (Ksj7)
 * Date: 2016.09.17
 * email: sujin.kim1414@gmail.com
 *
 * https://github.com/Ksj7/Algorithm
 * https://www.acmicpc.net/problem/1707
 */
public class Main {

    public static void main(String[] args) {

        int n, k;
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();
        int[] a = new int[n];
        int lastIndex = n-1;
        for (int i = 0; i < n; i++)
            a[i] = sc.nextInt();
        Arrays.sort(a);
        int resultSum  = a[lastIndex] - a[0];
        for (int i = lastIndex; i > 0; i--)
            a[i] -= a[i - 1];
        Arrays.sort(a,1,n);
        for (int i = 0; i < k - 1 ; i++) {
            if(i >= lastIndex) break;
            resultSum -= a[lastIndex - i];
        }
        System.out.println(resultSum);
    }
}
