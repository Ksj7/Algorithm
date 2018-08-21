import java.util.Scanner;

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        char A[] = sc.nextLine().toCharArray();
        char B[] = sc.nextLine().toCharArray();
        int LCS[][] = new int[A.length + 1][B.length + 1];
        int max = Integer.MIN_VALUE;
        //ABRACADABRA
        //ECADADABRBCRDARA
        for (int i = 1; i <= A.length; i++) {
            for (int j = 1; j <= B.length; j++) {
                if (A[i - 1] == B[j - 1]) {
                    LCS[i][j] = LCS[i - 1][j - 1] + 1;
                    max = Math.max(LCS[i][j], max);
                }
            }
        }
        if(max == Integer.MIN_VALUE)
            System.out.println(0);
        else System.out.println(max);

    }
}

