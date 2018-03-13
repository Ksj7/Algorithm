import java.util.Scanner;
import java.util.Stack;

public class Main {

    static class Pair {
        int idx;
        long num;

        Pair(int idx, long num) {
            this.idx = idx;
            this.num = num;
        }
    }

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        Stack<Pair> s = new Stack<>();
        long N = scanner.nextLong();
        for (int i = 1; i <= N; i++) {
            long tar = scanner.nextLong();
            if (s.empty()){
                System.out.print("0 ");
            }else{
                while(!s.empty()) {
                    if (tar > s.peek().num) {
                        s.pop();
                    } else {
                        System.out.print(s.peek().idx + " ");
                        break;
                    }
                }
                if(s.empty()) System.out.print("0 ");
            }
            s.add(new Pair(i,tar));
        }
    }
}

