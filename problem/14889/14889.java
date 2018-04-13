import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class Main {

    static List ar = new ArrayList<>();
    static List<Integer> gap = new ArrayList<>();
    static int[][] table = new int[21][21];
    static int[] arr;
    static int N;
    static int min = Integer.MAX_VALUE;

    static void pick(int n,Stack<Integer> st,int r){
        if(r==0)
            addPick(st);
        int smallest = st.isEmpty() ? 0 : st.lastElement() + 1;
        for(int next = smallest; next < n; next++){
            st.push(next);
            pick(n,st,r - 1);
            st.pop();
        }
    }
    static void addPick(Stack<Integer> st){
        ArrayList<Integer> temp = new ArrayList<>();
        ArrayList<Integer> temp2 = new ArrayList<>();
        int check[] = new int[N];
        int res = 0; int res2 = 0;
        for(int i:st) {
            temp.add(arr[i]);
            check[i] = 1;
        }
        for(int i = 0; i < temp.size(); i++){
            int x = temp.get(i);
            for(int j=i+1; j<temp.size();j++) {
                int y = temp.get(j);
                res += (table[x][y] + table[y][x]);
            }
        }
        for(int i=1; i<=N;i++){
            if(check[i-1] == 0) temp2.add(i);
        }
        for(int i = 0; i < temp2.size(); i++){
            int x = temp2.get(i);
            for(int j=i+1; j<temp2.size();j++) {
                int y = temp2.get(j);
                res2 += (table[x][y] + table[y][x]);
            }
        }
        gap.add( (res-res2 > 0)? (res-res2) : (res2-res));
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();

        for(int i=1; i<=N; i++){
            for(int j=1; j<=N; j++)
                table[i][j] = sc.nextInt();
        }
        arr = new int[N];
        for(int i=1;i<=N;i++)
            arr[i-1] = i;
        Stack<Integer> st = new Stack<>();
        pick(N, st, N/2);

        for(int i=0; i<gap.size(); i++){
            if(min > gap.get(i)) min = gap.get(i);
        }
        System.out.print(min);

    }
}

