import java.util.Scanner;

/*
 * Author: sujin Kim (Ksj7)
 * Date: 2016.10.09
 * email: sujin.kim1414@gmail.com
 *
 * https://github.com/Ksj7/Algorithm
 * https://www.acmicpc.net/problem/10430
 */

public class Main {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);

        long A = sc.nextLong();
        long B = sc.nextLong();
        long C = sc.nextLong();
        System.out.println((A+B)%C);
        System.out.println((A%C + B%C)%C);
        System.out.println((A*B)%C);
        System.out.println((A%C * B%C)%C);
    }
}