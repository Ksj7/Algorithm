import java.util.Scanner;

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        long sum = 0;
        long num = 0;
        long i;
        for (i = 1; i < n; i++) {
            if (sum + i > n) break;
            sum += i;
            num++;

        }
         System.out.println(num);


    }
}

