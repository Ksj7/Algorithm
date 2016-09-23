import java.util.Scanner;

/*
 * Author: sujin Kim (Ksj7)
 * Date: 2016.01.17
 * email: sujin.kim1414@gmail.com
 *
 * https://github.com/Ksj7/Algorithm
 * https://www.acmicpc.net/problem/1707
 */
 
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int j ;
        int num = sc.nextInt();
        int[] arr = new int[num];
        for(int i = 0 ; i < num ; i ++){
            arr[i] = sc.nextInt();
        }
        for(int i = 1; i < num ; i ++){
            j = i-1;
            int currentValue = arr[i];
            while(j >= 0) {
                if(arr[j] > currentValue)
                    arr[j+1] = arr[j];
                else {
                    arr[j+1] = currentValue;
                    break;
                }
                j--;
            }
            if(j<0) arr[0] = currentValue;
        }

        for(int i = 0 ; i < num ; i ++){
            System.out.println(arr[i]);
        }
    }
}
