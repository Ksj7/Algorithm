import java.util.Scanner;

/*
 * Author: sujin Kim (Ksj7)
 * Date: 2016.09.22
 * email: sujin.kim1414@gmail.com
 *
 * https://github.com/Ksj7/Algorithm
 * https://www.acmicpc.net/problem/1707
 */
 
public class Main {
    static String str;
    static StringBuffer result = new StringBuffer("");

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        str = sc.nextLine();
        int next;

        for (int i = 0; i < str.length(); i++) {
            if (i + 1 != str.length()) next = str.charAt(i + 1) - '0';
            else next = 4;
            if (str.charAt(i) - '0' > 7) {
                calculation(result, i, 7);
                break;
            } else if (str.charAt(i) - '0' < 7 && str.charAt(i) - '0' > 4) {
                result.append("4");
                calculation(result, i+1, 7);
                break;
            } else if (str.charAt(i) - '0' == 4 && next < 4) {
                result = new StringBuffer("");
                if(str.charAt(0) > '4') result.append("4");
                calculation(result, 1, 7);
                break;

            } else if (str.charAt(i) - '0' == 7 && next < 4) {
                result.append("4");
                calculation(result, i+1, 7);
                break;
            } else {
                if (str.charAt(i) == '7' || str.charAt(i) == '4'){
                    result.append(str.charAt(i));
                }
                else {
                    calculation(result, i + 1, 7);
                    break;
                }
            }
        }
        System.out.println(result.toString());

    }

    private static void calculation(StringBuffer result, int start, int num) {
        for (int i = start; i < str.length(); i++) {
            result.append(num);
        }
    }

}