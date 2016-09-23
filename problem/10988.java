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
	
		
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
        boolean a = false;
        if( str.length()>1 ){
            for(int i=0; i<(str.length()/2); i++){
                if( str.charAt(i)!=str.charAt((str.length()-1)-i) ){
                      System.out.println("0");
                      a = true;
                        break;
                    }
            }
            
        }
        if(a==false)
        System.out.println("1");
	}
}
