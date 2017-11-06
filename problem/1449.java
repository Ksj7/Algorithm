import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String arg[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int len = sc.nextInt();
        int cnt  = 1;
        List<Integer> list = new ArrayList<>();
        for(int i=0; i<n; i++){
            list.add(sc.nextInt());
        }
        Collections.sort(list);
        int ind1= list.get(0);
        int ind2;
        for(int i=1; i<n; i++){
            ind2 = list.get(i);
            if(len-1 < ind2 - ind1){
                cnt ++;
                ind1 = ind2;
            }
        }
        System.out.print(cnt);

    }
}
