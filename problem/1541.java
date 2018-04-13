import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        String a = sc.nextLine();
        long sum;
        ArrayList<Long> al = new ArrayList<>();
        ArrayList<Character> op = new ArrayList<>();
        for (int i = 0; i <= a.length(); i++) {
            if (i == a.length() || a.charAt(i) == '+' || a.charAt(i) == '-') {
                if(i != a.length()) op.add(a.charAt(i));
                long d = 1;
                int idx = i - 1;
                long s = 0;
                while (true) {
                    if (idx < 0) break;
                    if (a.charAt(idx) == '+' || a.charAt(idx) == '-') {
                        break;
                    } else {
                        s += ((a.charAt(idx) - '0') * d);
                    }
                    idx--;
                    d *= 10;
                }
                al.add(s);
            }
        }
        sum = al.get(0);
        for(int i = 0; i < op.size(); i++){
            if(op.get(i) == '-'){
                int idx = i + 1;
                long s = al.get(idx);
                while(op.size() > idx && op.get(idx) == '+'){
                    s += al.get(idx + 1);
                    idx++;
                }
                sum -= s;
                i = idx - 1;
            }else{
                sum += al.get(i + 1);
            }
        }
        System.out.println(sum);
}
}
