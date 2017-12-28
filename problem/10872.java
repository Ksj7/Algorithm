import java.util.Scanner;

public class Main {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        double factory = sc.nextInt() * 1.0;
        for(int i = (int) factory - 1; i >= 1; i--){
            factory *= i;
        }
        if(factory == 0.0) System.out.println("1");
        else System.out.printf("%.0f", factory);

    }
}

