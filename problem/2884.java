import java.util.Scanner;

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int h = sc.nextInt();
        int m = sc.nextInt();
        if (m - 45 >= 0) {
            System.out.println(h + " " + (m - 45));
        } else {
            System.out.println(((h - 1) >= 0 ? h - 1 : 23) + " " + (m + 15));
        }

    }

}

