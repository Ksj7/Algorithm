import java.util.Scanner;

/*
 * Author: sujin Kim (Ksj7)
 * Date: 2016.09.19
 * email: sujin.kim1414@gmail.com
 *
 * https://github.com/Ksj7/Algorithm
 * https://www.acmicpc.net/problem/1707
 */
 
public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String str = sc.nextLine();
        while (n > 0) {
            str = sc.nextLine();
            System.out.println(String.valueOf(str.charAt(0)).toUpperCase() + str.substring(1, str.length()));
            n--;
        }
    }
}