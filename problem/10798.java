import java.util.Scanner;

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        String str[] = new String[5];
        int maxLen = -1;
        for (int i = 0; i < 5; i++) {
            str[i] = sc.nextLine();
            maxLen = Math.max(maxLen, str[i].length());
        }

        for(int j = 0; j < maxLen; j++) {
            for (int i = 0; i < 5; i++) {
                if(str[i].length() > j){
                    System.out.print(str[i].charAt(j));
                }
            }
        }

    }
}

