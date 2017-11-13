import java.util.Scanner;

public class Main {

    private static long arr[] = new long[100001];
    private static long N;
    private static long K;

    private static long binarySearch(long start, long end) {
        while(start <= end) {
            long mid = (start + end) / 2;
            long cnt = 0;
            for (int i = 0; i < N; i++) {
                cnt += (arr[i] / mid);
            }
            if (cnt >= K) start = mid + 1;
            else end = mid-1;
        }
        return start-1;
    }

    public static void main(String arg[]) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextLong();
        K = sc.nextLong();
        long maxValue = Integer.MIN_VALUE;
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextLong();
            maxValue = (arr[i] > maxValue) ? arr[i] : maxValue;
        }
        System.out.print(binarySearch(0, maxValue));
    }
}

