import java.math.BigInteger;
import java.util.Scanner;

public class Main {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        BigInteger sum;
        long a = sc.nextLong();
        long b = sc.nextLong();
        long c = sc.nextLong();

        BigInteger aa = new BigInteger(String.valueOf(a));
        BigInteger bb = new BigInteger(String.valueOf(b));
        BigInteger cc = new BigInteger(String.valueOf(c));

        sum = aa.multiply(bb);
        sum = sum.multiply(cc);
        String size = sum.toString();
        int count[] = new int[10];
        for(int i=0; i< size.length(); i++){
            if(size.charAt(i) == '0') count[0]++;
            else if(size.charAt(i) =='1') count[1]++;
            else if(size.charAt(i) =='2') count[2]++;
            else if(size.charAt(i) =='3') count[3]++;
            else if(size.charAt(i) =='4') count[4]++;
            else if(size.charAt(i) =='5') count[5]++;
            else if(size.charAt(i) =='6') count[6]++;
            else if(size.charAt(i) =='7') count[7]++;
            else if(size.charAt(i) =='8') count[8]++;
            else if(size.charAt(i) =='9') count[9]++;
        }

        for(int i=0; i<=9; i++){
            System.out.println(count[i]);
        }

    }
}
