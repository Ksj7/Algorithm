import java.util.Arrays;
import java.util.Scanner;

/*
 * Author: sujin Kim (Ksj7)
 * Date: 2016.01.20
 * email: sujin.kim1414@gmail.com
 *
 * https://github.com/Ksj7/Algorithm
 * https://www.acmicpc.net/problem/1707
 */

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String a = sc.next();
		String[] b = new String[a.length()];
		int[] x = new int[a.length()];
		for(int i = 0 ; i < a.length(); i++){
				b[i] = a.substring(i,a.length());
				x[i] = a.charAt(i);
		}
		Arrays.sort(b);
		for(int i = 0 ; i < a.length(); i++){
			System.out.println(b[i]);
		}

	}

}

