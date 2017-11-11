import java.util.Scanner;

public class Main {
    static int N ;
    static int M ;
    static int arr[] = new int[1000001];
    static int binarySearch(int start, int end){
        if(end-start == 1) return start;
        int mid = (end-start)/2 + start;
        long result = 0;
        for(int i=0; i<N; i++){
            result += ((arr[i]-mid > 0)?arr[i]-mid : 0);
        }
        if(result >= M ) return binarySearch(mid, end);
        return binarySearch(start , mid);
    }

    public static void main(String arg[]){
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        int maxLength = Integer.MIN_VALUE;

        for(int i= 0; i<N; i++){
            arr[i] = sc.nextInt();
            if(arr[i] > maxLength) maxLength = arr[i];
        }
        System.out.print(binarySearch(0,maxLength));
    }
}
