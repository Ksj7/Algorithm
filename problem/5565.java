import java.util.Scanner;

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int arr[] = new int[10];
        int sum = sc.nextInt();
        for (int i = 1; i <= 9; i++)
            arr[i] = sc.nextInt();

        for (int i = 2; i <= 9; i++) {
            arr[i] += arr[i - 1];
        }
        System.out.println(sum - arr[9]);
    }
}

