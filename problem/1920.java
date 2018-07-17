import java.util.Arrays;
import java.util.Scanner;

public class Main {

    static boolean binarySearch(int s, int e, int target, int arr[]) {
        int mid = (s + e) / 2;
        boolean ret;
        if(s > e) return false;
        if (arr[mid] > target) {
            ret = binarySearch(s, mid - 1, target, arr);
        } else if (arr[mid] < target) {
            ret = binarySearch(mid + 1, e, target, arr);
        } else {
            return true;
        }

        return ret;
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int arr[] = new int[N];
        for (int i = 0; i < N; i++)
            arr[i] = sc.nextInt();
        Arrays.sort(arr);
        int M = sc.nextInt();
        for (int i = 0; i < M; i++) {
            int t = sc.nextInt();
            if(binarySearch(0, N - 1, t, arr)){
                System.out.println(1);
            }else System.out.println(0);
        }

    }
}

