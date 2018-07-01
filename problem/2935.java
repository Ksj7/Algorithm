import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());
        BigInteger a = new BigInteger(token.nextToken());
        token = new StringTokenizer(br.readLine());
        String oper = token.nextToken();
        token = new StringTokenizer(br.readLine());
        BigInteger b = new BigInteger(token.nextToken());
        if(oper.equals("+")){
            System.out.println(a.add(b));
        }
        else{
            System.out.println(a.multiply(b));
        }
    }
}

