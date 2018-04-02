import java.util.Scanner;

public class Main {
    public static void main(String arg[]) {
        Scanner sc = new Scanner(System.in);
        String str[] = sc.nextLine().split(" ");
        String str1 = str[0];
        String str2 = str[1];
        int idx = 0;
        int cnt = Integer.MAX_VALUE;
        while (idx + str1.length() <= str2.length()) {
            int temp = 0;
            for (int i = idx; i < idx + str1.length(); i++) {
                if (str2.charAt(i) != str1.charAt(i - idx)) {
                    temp++;
                }
            }
            if (cnt > temp) cnt = temp;
            idx++;
        }
        System.out.println(cnt);

    }
}
