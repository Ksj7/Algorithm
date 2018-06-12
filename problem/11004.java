import java.util.Scanner;

public class Main {
    static int N, K;
    static int arr[];

    static void quick(int le, int ri) {
        if(le == ri) return;
        int l = le;
        int r = ri;
        int p = arr[(le + ri) / 2];

        while(true) {
            while (arr[l] < p) {
                l++;
            }
            while (arr[r] > p) {
                r--;
            }
            if (l <= r) {
                swap(l++, r--);
            }
            if(l > r) break;
        }
        if(le < r) quick(le, r);
        if(l < ri) quick(l , ri);
    }

    static void swap(int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        K = sc.nextInt();
        arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }
        quick(0, N - 1);
        System.out.println(arr[K - 1]);
    }
}

