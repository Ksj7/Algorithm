import java.util.Scanner;

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int K = sc.nextInt();
        int N = sc.nextInt();
        int time[] = new int[N + 1];
        char answer[] = new char[N + 1];
        int cnt = 0;
        for (int i = 1; i <= N; i++) {
            time[i] = sc.nextInt();
            answer[i] = sc.nextLine().charAt(1);
        }
        int i = 1;
        int p = K;
        while (i <= N) {
            cnt += time[i];
            if (cnt >= 210) {
                break;
            }
            if (answer[i] == 'T') p++;
            if(p > 8) p %= 8;
            i++;
        }
        System.out.println(p);

    }
}
