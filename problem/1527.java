import java.util.Scanner;

/*
 * Author: sujin Kim (Ksj7)
 * Date: 2016.09.23
 * email: sujin.kim1414@gmail.com
 *
 * https://github.com/Ksj7/Algorithm
 * https://www.acmicpc.net/problem/1707
 */
 
public class Main {
    public static void main(String[] args) {
        int[][] str = new int[9][512];
        int count = 0;
        int beforeIndex = 0;
        int p = 0;
        boolean isFinish = false;

        Scanner sc = new Scanner(System.in);

        int start = sc.nextInt();
        int end = sc.nextInt();
        str[0][0] = 4;
        str[0][1] = 7;
        p = 10;

        if (start <= 4 && end >= 7) count = 2;
        else if (start <= 4 && end < 7 && end >= 4) count = 1;
        else if (start > 4 && start <= 7 && end >= 7) count = 1;
        else count = 0;

        for (int i = 1; i < 9; i++) {
            int temp = p * 4;
            beforeIndex = (int) Math.pow(2, i);
            for (int j = 0; j < beforeIndex; j++) {
                str[i][j] = temp + str[i - 1][j];
                if (str[i][j] >= start && str[i][j] < end) {
                    count++;
                } else if (str[i][j] >= start && end == str[i][j]) {
                    count++;
                    isFinish = true;
                    break;
                }
            }
            if (isFinish) break;
            temp = p * 7;
            for (int j = beforeIndex; j < beforeIndex * 2; j++) {
                str[i][j] = temp + str[i - 1][j - beforeIndex];
                if (str[i][j] >= start && str[i][j] < end) {
                    count++;
                } else if (str[i][j] >= start && end == str[i][j]) {
                    count++;
                    isFinish = true;
                    break;
                }

            }
            if (isFinish) break;
            p *= 10;
        }
        System.out.println(count);
    }

}
