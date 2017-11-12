import java.util.Scanner;

public class Main {

    private static int arr[] = new int[100001];
    private static int N, M;

    private static int binarySearch(int start, int end){
        while(start <= end) {
            int mid = (start + end) / 2;
            int sum = 0, cnt = 1;
            for (int i = 0; i < N; i++) {
                if (sum + arr[i] > mid) {
                    sum = 0; cnt++;
                }
                sum += arr[i];
            }
            if(cnt > M){
                start = mid + 1;
            }else end = mid - 1;
        }
        return start;
    }

    public static void main(String arg[]){
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        int maxValue = 0;
        int sum = 0;
        for(int i = 0; i< N; i++){
            arr[i] = sc.nextInt();
            sum +=arr[i];
            maxValue = (arr[i] > maxValue)? arr[i] : maxValue;

        }
        System.out.print(binarySearch(maxValue,sum));
    }
}

