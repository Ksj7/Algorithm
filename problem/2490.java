import java.util.Scanner;

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int y;
        for (int i = 0; i < 3; i++) {
            y = 0;
            for (int j = 0; j < 4; j++) {
                y += sc.nextInt();
            }
            if (y == 4) System.out.println("E");
            else if (y == 3) System.out.println("A");
            else if (y == 2) System.out.println("B");
            else if (y == 1) System.out.println("C");
            else if (y == 0) System.out.println("D");
        }
    }
}

