import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(token.nextToken());
        int alpha[] = new int[26];
        for(int t = 0 ; t < T; t++){
            token = new StringTokenizer(br.readLine());
            alpha[token.nextToken().charAt(0) - 'a']++;

        }
        int num = 0;
        for(int al = 0; al < 26; al++){
            if(alpha[al] >= 5){
                num++;
                System.out.print( (char) (al + 'a') );
            }
        }
        if(num == 0){
            System.out.print("PREDAJA");
        }


    }
}

