import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        String[] a = new String[m];
        String[] res = new String[500001];
        HashMap<String,Integer> h = new HashMap<>();
        sc.nextLine();
        for(int i =0; i < n; i++){
            h.put(sc.nextLine(),1);
        }
        int idx = 0;

        for(int i =0; i < m; i++){
            a[i] = sc.nextLine();
        }
        Arrays.sort(a);
        for(int i =0; i < m; i++){
            if(h.containsKey(a[i])){
                res[idx] = a[i];
                idx++;
            }
        }

        System.out.println(idx);
        for(int i =0 ; i < idx; i++)
            System.out.println(res[i]);
    }

}

