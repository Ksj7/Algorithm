import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        //가격의 합계에서 50원을 뺀 가격이 세트 메뉴의 가격
        // 햄버거 3개 음료 2개
        //가장 싼 세트 메뉴의 가격을 출력
        int burger[] = new int[3];
        int drink[] = new int[2];
        for (int i = 0; i < 3; i++)
            burger[i] = sc.nextInt();

        for (int i = 0; i < 2; i++)
            drink[i] = sc.nextInt();

        Arrays.sort(burger);
        Arrays.sort(drink);
        System.out.println(burger[0] + drink[0] - 50);

    }
}

