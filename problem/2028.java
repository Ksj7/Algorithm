import java.util.Scanner;

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        while (n-- > 0) {
            String m = sc.nextLine();
            String ret = String.format("%.0f",Math.pow(Integer.parseInt(m) * 1.0, 2));
            boolean suc = true;
            int j = m.length() - 1;
            int i= ret.length() - 1;
            while (true) {
                if(j < 0) break;
                if (ret.charAt(i) == m.charAt(j)) {
                    i --; j --;
                }else {
                    suc = false;
                    break;
                }
            }
            if(suc){
                System.out.println("YES");
            }else System.out.println("NO");
        }
    }
}

