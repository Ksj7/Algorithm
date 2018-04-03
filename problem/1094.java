import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int X = sc.nextInt();
        int sum = 64;
        ArrayList<Integer> al = new ArrayList<>();
        al.add(64);
        while (true) {
            if (sum == X) break;
            else if (sum > X) {
                //가지고 있는 막대 중 길이가 가장 짧은 것을 절반으로 자른다.
                int temp = al.get(al.size() - 1) / 2;
                al.remove(al.size() - 1);
                int tempSum = sum - temp;
                //만약, 위에서 자른 막대의 절반 중 하나를 버리고 남아있는 막대의 길이의 합이 X보다 크거나 같다면, 위에서 자른 막대의 절반 중 하나를 버린다.
                if(tempSum >= X){
                    al.add(al.size(), temp);
                    sum = tempSum;
                }else{
                    al.add(al.size(), temp);
                    al.add(al.size(), temp);
                }
            }

        }

        System.out.println(al.size());

    }
}

