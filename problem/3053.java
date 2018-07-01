import java.util.Scanner;

public class Main {
    static double pi = Math.PI;
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        double r = sc.nextDouble();

        //원의 넓이 :   파이 * (반지름)^2
        System.out.println(String.format("%.6f",r*r*pi));
        //정사각형 넓이 : 한변의길이 * 한변의 길이
        // 2r = 지름 = 대각선길이
        // 대각선길이 = 한변의 길이 * √2
        // 2r = 한변길이 *  √2
        // (2r)/√2 = 한변의 길이
        // (2r)^2/2 = 한변의 길이 ^ 2 = 넓이
        System.out.println(String.format("%.6f", r*r*2));

    }
}

