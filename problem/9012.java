import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        sc.nextLine();
        while(T-- > 0){
            String str = sc.nextLine();
            String answer = "YES";
            Stack<Character> st = new Stack<>();
            for(int i = 0; i<str.length(); i++){
                if(str.charAt(i) == '('){
                    st.push('(');
                }else{
                    if(st.empty()) {
                        answer = "NO";
                        break;
                    }else{
                        st.pop();
                    }

                }
            }
            if(!st.empty()) answer = "NO";
            System.out.println(answer);
        }
    }
}

