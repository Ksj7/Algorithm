import java.util.Scanner;

public class Main {

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        for (int i = 0; i < t; i++) {
            int r = sc.nextInt();
            int e = sc.nextInt();
            int c = sc.nextInt();
            System.out.println((r > (e - c)) ? "do not advertise" : ((r == (e - c)) ? "does not matter" : "advertise"));
        }
    }
}

