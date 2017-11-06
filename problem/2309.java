import java.util.*;

public class Main {
    public static void main(String arg[]) {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[9];
        int[] res = new int[7];
        int sum  = 0;
        for(int i=0; i<9; i++){
            arr[i] = sc.nextInt();
            sum += arr[i];
        }
        int diff = sum - 100;
        int d1 = 0, d2 = 0;
        Arrays.sort(arr);
        for(int i=0; i<9; i++){
            for(int j=0; j<9; j++){
                if(i==j) continue;
                if(diff == arr[i]+arr[j]) {
                    d1 = i;
                    d2 = j;
                }
            }
        }
        for(int i=0;i < 9;i++){
            if(i == d1 || i == d2) continue;
            System.out.println(arr[i]);
        }
    }
}

