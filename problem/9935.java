import java.util.Scanner;
import java.util.Stack;


/*
 * Author: sujin Kim (Ksj7)
 * Date: 2016.09.16
 * email: sujin.kim1414@gmail.com
 *
 * https://github.com/Ksj7/Algorithm
 * https://www.acmicpc.net/problem/1707
 */

 
public class Main {

    static Stack s = new Stack();

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        String line = sc.next();
        String boom = sc.next();
        for (int i = line.length() - 1; i >= 0; i--) {
            s.push(line.charAt(i));
            if (s.size() >= boom.length() && s.peek().equals(boom.charAt(0))) {
                boolean isBoom = true;
                int j = 1;
                while (j < boom.length()) {
                    if (s.get(s.size() - j - 1).equals(boom.charAt(j))) {
                        j++;
                    } else {
                        isBoom = false;
                        break;
                    }
                }

                if (isBoom) for (int w = 0; w < boom.length(); w++) s.pop();

            }
        }

        if (s.empty()) System.out.println("FRULA");
        else

        {
            StringBuffer reverseresult = new StringBuffer();
            while (!s.empty()) reverseresult.append((char) s.pop());
            System.out.println(reverseresult.toString());
        }
    }

}
