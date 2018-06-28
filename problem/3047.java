import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int arr[] = new int[3];
        for (int i = 0; i < 3; i++) {
            arr[i] = sc.nextInt();
        }
        sc.nextLine();
        String a = sc.nextLine();
        Arrays.sort(arr);
        System.out.print(arr[a.charAt(0)-'A'] + " " + arr[a.charAt(1)-'A'] + " " + arr[a.charAt(2)-'A']);


    }

}

