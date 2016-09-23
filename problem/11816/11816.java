import java.math.BigInteger;
import java.util.HashMap;
import java.util.Scanner;

/*
 * Author: sujin Kim (Ksj7)
 * Date: 2016.09.19
 * email: sujin.kim1414@gmail.com
 *
 * https://github.com/Ksj7/Algorithm
 * https://www.acmicpc.net/problem/1707
 */

public class Main {
    public static void main(String[] args) {

        HashMap<Character,Integer> alpha = new HashMap<>();
        alpha.put('0',0); alpha.put('1',1);alpha.put('2',2);alpha.put('3',3);
        alpha.put('4',4);alpha.put('5',5);alpha.put('6',6);
        alpha.put('7',7);alpha.put('8',8);alpha.put('9',9);
        alpha.put('a',10);alpha.put('b',11);alpha.put('c',12);
        alpha.put('d',13);alpha.put('e',14);alpha.put('f',15);

        Scanner sc = new Scanner(System.in);
        String value = sc.next();
        long currentValue ;
        BigInteger numbers = new BigInteger(String.valueOf(BigInteger.ONE));
        int int_numbers;
        BigInteger result = new BigInteger(String.valueOf(BigInteger.ZERO));
        if (value.length() == 1)
            System.out.println(value);

        else {
            if (value.charAt(0) =='0') {
                if (value.charAt(1)=='x') {
                    int_numbers = 16;
               } else {
                    int_numbers = 8;
                }
                int i = value.length()-1;
                int limit = (int_numbers == 16)? 2: 1;
                while (i>=limit) {
                    currentValue = alpha.get(value.charAt(i));
                    BigInteger temp = numbers.multiply(BigInteger.valueOf(currentValue));
                    result = result.add(temp);
                    numbers = numbers.multiply(BigInteger.valueOf(int_numbers));
                    i--;
                }
            } else {
                currentValue = Long.valueOf(value);
                result = BigInteger.valueOf(currentValue);
            }

            System.out.println(result);
        }

    }
}


