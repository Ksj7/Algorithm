import java.util.Scanner;

public class Main {

    private static long arr[] = new long[200001];
    private static int C;
    private static int N;

    private static void quickSort(long[] data, int l, int r){
        int left = l;
        int right = r;
        long pivot = data[(l+r)/2];

        do{
            while(data[left] < pivot) left++;
            while(data[right] > pivot) right--;
            if(left <= right){
                long temp = data[left];
                data[left] = data[right];
                data[right] = temp;
                left++;
                right--;
            }
        }while (left <= right);

        if(l < right) quickSort(data, l, right);
        if(r > left) quickSort(data, left, r);
    }


    //C개의 공유기를 N개의 집에 적당히 설치해서, 가장 인접한 두 공유기 사이의 거리를 최대로 하는 프로그램
    private static long binarySearch(long start, long end){
        while(start <= end) {
            long mid = (start + end) / 2;
            long prev = arr[0], cnt = 1;
            for (int i = 1; i < C; i++) {
                if (arr[i]-prev > mid) {
                    cnt++;
                    prev = arr[i];
                }
            }
            if(cnt >= N){
                start = mid + 1;
            }else end = mid - 1;
        }
        return start;
    }

    public static void main(String arg[]){
        Scanner sc = new Scanner(System.in);
        C = sc.nextInt();
        N = sc.nextInt();
        for(int i = 0; i< C; i++){
            arr[i] = sc.nextInt();
        }
        quickSort(arr,0,C-1);
        System.out.print(binarySearch(arr[0], arr[C-1]));
    }
}

