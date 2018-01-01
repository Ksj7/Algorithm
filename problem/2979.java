import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int A, B, C;
        int min, max;
        A = sc.nextInt();
        B = sc.nextInt();
        C = sc.nextInt();
        int[][] s = new int[3][2];
        int[] time = new int[101];
        s[0][0] = sc.nextInt();
        s[0][1] = sc.nextInt();
        min = s[0][0];
        max = s[0][1];
        s[1][0] = sc.nextInt();
        s[1][1] = sc.nextInt();
        min = (min > s[1][0])? s[1][0] : min;
        max = (max < s[1][1])? s[1][1] : max;
        s[2][0] = sc.nextInt();
        s[2][1] = sc.nextInt();
        min = (min > s[2][0])? s[2][0] : min;
        max = (max < s[2][1])? s[2][1] : max;
        int cnt1 = 0, cnt2 = 0, cnt3= 0;
        for(int x = 0; x < 3; x++) {
            for (int i = s[x][0]; i < s[x][1]; i++) {
                time[i]++;
            }
        }
        for(int i=min; i<=max;i++){
            if(time[i] == 1) cnt1++;
            else if(time[i] == 2) cnt2++;
            else if(time[i]==3) cnt3++;
        }
        System.out.println(cnt1 * A + cnt2 * B * 2 + cnt3 * C * 3);

    }
}
