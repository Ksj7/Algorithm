import java.util.Scanner;

public class Main {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        int cup[] = new int[4];
        cup[1] = 1;
        int idx = 1;

        for(int i = 0; i < T; i++){
            int x = sc.nextInt();
            int y = sc.nextInt();
            int temp = cup[x];
            cup[x] = cup[y];
            cup[y] = temp;
            if(cup[x] == 1) idx = x;
            if(cup[y] == 1) idx = y;
        }

        System.out.println(idx);

    }
}
