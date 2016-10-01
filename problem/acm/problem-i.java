import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

/*
 * Author: sujin Kim (Ksj7)
 * Date: 2016.10.01
 * email: sujin.kim1414@gmail.com
 *
 * https://github.com/Ksj7/Algorithm
 */
 
public class Main {

    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int test_case = sc.nextInt();
        int e[] = new int[test_case];

        boolean isOk = true;
        for (int i = 0; i < test_case; i++){
            e[i] = sc.nextInt();
            if(test_case > e[i]) isOk = false;
        }
        int answer = test_case;
        if(isOk) System.out.println(test_case);
        else {
            isOk = false;
            Arrays.sort(e);
            for(int w= 0 ; w < test_case ; w++) {
                for (int i = 0; i < test_case; i++) {
                    if (answer == test_case - i && i >= test_case - answer) {
                        if (e[i] >= answer) {
                            isOk = true;
                            break;
                        }
                    }
                }
                if(isOk) break;
                answer--;
            }
            System.out.println(answer);
        }

    }
}
