import java.util.Scanner;

/*
 * Author: sujin Kim (Ksj7)
 * Date: 2016.09.17
 * email: sujin.kim1414@gmail.com
 *
 * https://github.com/Ksj7/Algorithm
 * https://www.acmicpc.net/problem/1707
 */

public class Main {

    static int[] checked = new int[10000001];

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int currentValue = sc.nextInt();
        int repeatNumber = sc.nextInt();
        int result;

        for(int i = 1; ; i++){
           if(checked[currentValue] != 0){
               result = checked[currentValue]-1;
               break;
           }
            checked[currentValue] = i;
            int next = 0;
            while(currentValue > 0){
                next += pow(currentValue%10,repeatNumber);
                currentValue /= 10;
            }
            currentValue = next;
        }

        System.out.println(result);
    }
    public static int pow(int value, int repeatNumber) {
        int result = 1;
        for (int i = 0; i < repeatNumber; i++) {
            result *= value;
        }
        return result;
    }
}

