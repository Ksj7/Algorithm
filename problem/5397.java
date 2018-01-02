import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();
        //백스페이스를 입력했다면, '-'가
        for (int i = 0; i < t; i++) {
            String str = sc.nextLine();
            Stack<Character> s1 = new Stack<>();
            Stack<Character> s2 = new Stack<>();
            int j = 0;
            while (j < str.length()) {
                if (str.charAt(j) == '<') {
                    if(!s1.empty())
                        s2.push(s1.pop());

                } else if (str.charAt(j) == '>') {
                    if(!s2.empty()){
                        s1.push(s2.pop());
                    }
                } else if (str.charAt(j) == '-') {
                    if(!s1.empty()) s1.pop();
                } else {
                    s1.push(str.charAt(j));
                }
                j++;
            }
            while(!s2.empty()) s1.push(s2.pop());
            for(char c : s1){
                System.out.print(c);
            }
            System.out.println();
        }
    }
}
