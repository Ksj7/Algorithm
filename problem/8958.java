import java.util.Scanner;

public class Main {
    public static void main(String arg[]){
        Scanner sc = new Scanner(System.in);
        long sum ;
        String str;
        int N = sc.nextInt();
        sc.nextLine();
        int count[] = new int[81];
        for(int i = 0; i < N; i++){
            str = sc.nextLine();
            count[0] = str.charAt(0) == 'O' ? 1 : 0;
            sum = count[0];
            for(int j=1; j < str.length(); j++) {
                if (str.charAt(j) == 'O')
                    count[j] = count[j-1] + 1;
                else count[j] = 0;
                sum += count[j];
            }
            System.out.println(sum);
        }
    }
}

