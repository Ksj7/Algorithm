import java.util.Scanner;

public class Main {
    static String N;
    static int dp[] = new int[6000];
    static char arr[] = new char[6000];

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextLine();
        for (int i = 1; i <= N.length(); i++)
            arr[i] = N.charAt(i - 1);
        int idx = 2;
        if (N.length() == 1) {
            if (arr[1] == '0')
                System.out.println(0);
            else System.out.println(1);
        } else {
            dp[0] = 1;
            if (arr[1] == '0') {
                dp[N.length()] = 0;
            } else {
                dp[1] = 1;
                while (idx <= N.length()) {
                    if (arr[idx] == '0') {
                        if (arr[idx - 1] == '1' || arr[idx - 1] == '2') {
                            dp[idx] = dp[idx - 2] % 1000000;
                        } else {
                            dp[N.length()] = 0;
                            break;
                        }
                    } else {
                        if (arr[idx - 1] == '2') {
                            if (arr[idx] <= '6') {
                                dp[idx] = (dp[idx - 1] + dp[idx - 2]) % 1000000;
                            } else {
                                dp[idx] = dp[idx - 1] % 1000000;
                            }
                        } else if (arr[idx - 1] == '1') {
                            dp[idx] = (dp[idx - 1] + dp[idx - 2]) % 1000000;
                        } else if (arr[idx - 1] > '2') {
                            dp[idx] = (dp[idx - 1] % 1000000);
                        } else if (arr[idx - 1] == '0') {
                            dp[idx] = dp[idx - 1] % 1000000;
                        }
                    }
                    idx++;
                }
            }
            System.out.println(dp[N.length()] % 1000000);
        }
    }
}

