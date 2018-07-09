import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());
        long N = Long.parseLong(token.nextToken());

        long i = 0;
        long sum = 0;
        if(N < 10){
            System.out.println(N);
        }else {
            while (true) {
                long target = (long) Math.pow(10, i);
                if (N >= (target * 10)) {
                    sum += ((target * 9) * (i + 1));
                } else {

                    sum += ((N-target+1) * (i + 1));
                    break;
                }

                i++;
            }
            System.out.println(sum);
        }
    }
}

