import java.util.Scanner;

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int rest = 1000 - n;
        int idx = 0;
        int c = 0;
        int donggen[] = {500, 100, 50, 10, 5, 1};
        while (idx < donggen.length && rest > 0) {
            if (rest - donggen[idx] < 0) {
                idx++;
            } else {
                rest -= donggen[idx];
                c++;
            }
        }
        System.out.println(c);
    }
}

