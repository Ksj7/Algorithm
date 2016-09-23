import java.math.BigInteger;
import java.util.Scanner;
import java.util.Stack;

/*
 * Author: sujin Kim (Ksj7)
 * Date: 2016.09.17
 * email: sujin.kim1414@gmail.com
 *
 * https://github.com/Ksj7/Algorithm
 * https://www.acmicpc.net/problem/1707
 */
 
public class Main{

    static long fibonacci[] = new long[46];
    static Stack<Long> stack;
    static int index;

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        fibonacci[0] = 1;
        fibonacci[1] = 1;
        for(int i = 2; i<=45; i++)
            fibonacci[i] = fibonacci[i-1] + fibonacci[i-2];
        int n = sc.nextInt();
        int temp;
        while(n>0){
            stack = new Stack();
            index = 45;
            temp = sc.nextInt();
            search(temp);
            while(!stack.isEmpty()){
                System.out.print(stack.pop() + " ");
            }
            System.out.println();
            n--;
        }
    }
    public static Stack<Long> search(long n){

        if(n<=0) return stack;
        else{
            for(int i = index; i >= 0 ; i--){
                if(fibonacci[i]<=n){
                    stack.push(fibonacci[i]);
                    index = i;
                    return search(n-fibonacci[i]);
                }
            }
        }
        return stack;
    }
}