import java.util.Scanner;

public class Main {
    public static void main(String args[]) {
        int R, C;
        Scanner sc = new Scanner(System.in);
        R = sc.nextInt();
        C = sc.nextInt();
        sc.nextLine();
        String original[] = new String[R];
        String reverseRight[] = new String[R];
        String reverseDownLeft[] = new String[R];
        String reverseDownRight[] = new String[R];

        for (int j = 0; j < R; j++) {
            original[j] = sc.nextLine();
            reverseRight[j] = reverse(original[j]);
        }
        for (int j = 0; j < R; j++) {
            reverseDownLeft[j] = original[R - j - 1];
            reverseDownRight[j] = reverseRight[R - j - 1];
        }
        int N = sc.nextInt() - 1;
        int M = sc.nextInt() - 1;
        if (N < R && M < C) {
            StringBuilder builder = new StringBuilder(original[N]);
            if (builder.charAt(M) == '#')
                builder.setCharAt(M, '.');
            else builder.setCharAt(M, '#');
            original[N] = builder.toString();
        } else if (N < R && M < 2 * C) {
            int MM = M - C;
            StringBuilder builder = new StringBuilder(reverseRight[N]);
            if (builder.charAt(MM) == '#')
                builder.setCharAt(MM, '.');
            else builder.setCharAt(MM, '#');
            reverseRight[N] = builder.toString();
        } else if (N < 2 * R && M < C) {
            int NN = N - R;
            StringBuilder builder = new StringBuilder(reverseDownLeft[NN]);
            if (builder.charAt(M) == '#')
                builder.setCharAt(M, '.');
            else builder.setCharAt(M, '#');
            reverseDownLeft[NN] = builder.toString();
        } else if (N < 2 * R && M < 2 * C) {
            int NN = N - R;
            int MM = M - C;
            StringBuilder builder = new StringBuilder(reverseDownRight[NN]);
            if (builder.charAt(MM) == '#')
                builder.setCharAt(MM, '.');
            else builder.setCharAt(MM, '#');
            reverseDownRight[NN] = builder.toString();
        }

        for (int j = 0; j < R; j++) {
            System.out.print(original[j]);
            System.out.println(reverseRight[j]);
        }
        for (int j = 0; j < R; j++) {
            System.out.print(reverseDownLeft[j]);
            System.out.println(reverseDownRight[j]);
        }


    }

    private static String reverse(String input) {
        char[] in = input.toCharArray();
        int begin = 0;
        int end = in.length - 1;
        char temp;
        while (end > begin) {
            temp = in[begin];
            in[begin] = in[end];
            in[end] = temp;
            end--;
            begin++;
        }
        return new String(in);
    }
}
