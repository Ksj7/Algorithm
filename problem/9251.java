import java.util.Scanner;

public class Main {


    private static int[][] LCS = new int[1001][1001];

    public static void main(String ars[]){
        Scanner sc = new Scanner(System.in);
        String A = sc.nextLine();
        String B = sc.nextLine();

        for(int i=1;i<=A.length();i++) {
            for(int j=1;j<=B.length();j++) {
                if (A.charAt(i-1) == B.charAt(j-1)) {
                    LCS[i][j] = LCS[i-1][j-1] + 1;
                } else {
                    LCS[i][j] = Math.max(LCS[i][j-1], LCS[i-1][j]);
                }
            }
        }
        System.out.println(LCS[A.length()][B.length()]);
    }

}
