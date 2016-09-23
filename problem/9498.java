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
        switch (n/10){
            case 10:case 9:System.out.print("A");break;
            case 8:System.out.print("B");break;
            case 7:System.out.print("C");break;
            case 6:System.out.print("D");break;
            default:System.out.print("F");
        }
    }
}
