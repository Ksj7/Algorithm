import java.util.Scanner;

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int L = sc.nextInt();
        int A = sc.nextInt();
        int B = sc.nextInt();
        int C = sc.nextInt();
        int D = sc.nextInt();

        int sumA = A / C + (A % C == 0 ? 0 : 1);
        int sumB = B / D + (B % D == 0 ? 0 : 1);
        System.out.println(L - (sumB > sumA? sumB : sumA));
    }
}
