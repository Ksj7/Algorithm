import java.util.Scanner;

public class Main {

    static int arr[] = new int[10001];
    static int N, M;

    static int binarySearch(int start, int end){
        if(end-start <= 1) {
            long result2 = 0;
            for(int i = 0; i<N; i++){
                result2 += ((arr[i] - end <= 0)? arr[i] : end);
            }
            if(result2 <= M) return end;
            else return start;
        }
        int mid = (end-start)/2 + start;
        long result = 0;
        for(int i = 0; i<N; i++){
            result += ((arr[i] - mid <= 0)? arr[i] : mid);
        }
        if(result <= M) {
            return binarySearch(mid, end);
        }
        else {
            return binarySearch(start, mid);
        }
    }

    public static void main(String arg[]){
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        int maxLength = Integer.MIN_VALUE;
        for(int i = 0; i< N; i++){
            arr[i] = sc.nextInt();
            if(arr[i] > maxLength) maxLength = arr[i];
        }
        M = sc.nextInt();
        System.out.print(binarySearch(0,maxLength));
    }
}

