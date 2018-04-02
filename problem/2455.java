import java.util.Scanner;

public class Main {
    public static void main(String arg[]){
        Scanner sc = new Scanner(System.in);
        int sum = 0, max = 0;
        for(int i = 0; i < 4; i++) {
            int i1 = sc.nextInt();
            int i2 = sc.nextInt();
            sum = sum - i1 + i2;
            max = Math.max(max,sum);
        }

        System.out.print(max);

    }
}
