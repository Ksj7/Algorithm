import java.util.Scanner;

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        int aa[] = {0, 1, 3, 6, 10, 15, 21};
        int aab[] = {0, 500, 300, 200, 50, 30, 10};
        int bb[] = {0, 1, 3, 7, 15, 31};
        int bbb[] = {0, 512, 256, 128, 64, 32};
        while (T > 0) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int sum = 0;
            if(a != 0) {
                for (int i = 1; i <= 6; i++) {
                    if (aa[i] >= a) {
                        sum = aab[i];
                        break;
                    }
                }
            }
            if(b != 0) {
                for (int i = 1; i <= 5; i++) {
                    if (bb[i] >= b) {
                        sum += bbb[i];
                        break;
                    }
                }
            }
            System.out.println(sum * 10000);
            T--;
        }
    }
}

