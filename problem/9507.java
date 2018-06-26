import java.math.BigInteger;
import java.util.Scanner;

public class Main {
    static BigInteger[] koong = new BigInteger[68];
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        koong[0] = BigInteger.ONE;
        koong[1] = BigInteger.ONE;
        koong[2] = new BigInteger("2");
        koong[3] = new BigInteger("4");

        for(int i = 4; i < 68; i++){
            koong[i] = koong[i-1].add(koong[i-2]).add(koong[i-3]).add(koong[i-4]);
        }

        while(t>0){
            int idx = sc.nextInt();
            System.out.println(koong[idx]);
            t--;
        }
    }
}

