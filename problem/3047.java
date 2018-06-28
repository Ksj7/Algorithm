import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int arr[] = new int[3];
        int tt[] = new int[3];
        char str[] = new char[3];
        int max = 0;
        int min = 0;
        int mid = 0;
        for (int i = 0; i < 3; i++) {
            arr[i] = sc.nextInt();
            if (arr[max] < arr[i]) {
                max = i;
            }
            if (arr[min] > arr[i]) {
                min = i;
            }
        }

        mid = (max == 0) ? ((min == 2) ? 1 : 2) : ((max == 1) ? ((min == 2) ? 0 : 2) : (min == 1) ? 0 : 1);

        sc.nextLine();
        String tmp = sc.nextLine();
        for (int i = 0; i < 3; i++)
            str[i] = tmp.charAt(i);

        for (int i = 0; i < 3; i++) {
            if (str[i] == 'A') {
                tt[i] = arr[min];
            } else if (str[i] == 'B'){
                tt[i] = arr[mid];
            }else{
                tt[i] = arr[max];
            }
        }


        System.out.print(tt[0] + " " + tt[1] + " " + tt[2]);


    }

}

