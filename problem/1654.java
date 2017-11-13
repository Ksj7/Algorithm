import java.util.Scanner;

public class Main {

    private static long arr[] = new long[100001];
    private static long N;
    private static long K;
    //N개를 만들 수 있는 랜선의 최대 길이
    private static long binarySearch(long start, long end) {
        while(start <= end) {
            long mid = (start + end) / 2;
            long cnt = 0;
            for (int i = 0; i < N; i++) {
                cnt += (arr[i] / mid);
            }
            //cnt == K가 되면 start가 그 값 + 1이 되고 그 값이후로 진행되는 모든 값들은 cnt < K임으로 결국 start 가 end 보다 커지게 되면 cnt == K 였던 값이 end가 됨
            if (cnt >= K) start = mid + 1;
            else end = mid - 1;
        }
        return end;
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


