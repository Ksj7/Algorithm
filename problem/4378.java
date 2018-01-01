import java.util.Scanner;

public class Main {
    public static void main(String args[]){
        String answer = "1234567890-=QWERTYUIOP[]ASDFGHJKL;'ZXCVBNM,./";
        Scanner sc = new Scanner(System.in);
        while(sc.hasNextLine()) {
            String sq = sc.nextLine();
            for (int i = 0; i < sq.length(); i++) {
                if (sq.charAt(i) == ' ') System.out.print(' ');
                else {
                    for(int j=0; j<answer.length();j++){
                        if(answer.charAt(j) == sq.charAt(i)) {
                            System.out.print(answer.charAt(j-1));
                            break;
                        }
                    }
                }
            }
            System.out.println();
        }
    }
}

