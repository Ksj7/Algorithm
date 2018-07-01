import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main {

    static class Pair {
        int y, x;

        Pair(int yy, int xx) {
            y = yy;
            x = xx;
        }

    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        Pair arr[] = new Pair[8];
        for (int i = 0; i < 8; i++) {
            arr[i] = new Pair(sc.nextInt(), i+1);
        }
        Arrays.sort(arr, Comparator.comparingInt(o -> o.y));
        int sum = 0;
        int res[] = new int[5];
        for(int i =3; i<8;i++){
            sum+= arr[i].y;
            res[i-3] = arr[i].x;
        }
        System.out.println(sum);
        Arrays.sort(res);
        for(int i =0; i<5;i++){
            System.out.print(res[i]+" ");
        }
    }
}

