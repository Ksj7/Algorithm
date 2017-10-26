import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static ArrayList<int[]> op = new ArrayList<>();

    public static void perm(int[] arr, int depth, int n, int k) {
        if (depth == k) {
            op.add(arr.clone());
            return;
        }
        for (int i = depth; i < n; i++) {
            swap(arr, i, depth);
            perm(arr, depth + 1, n, k);
            swap(arr, i, depth);
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        ArrayList<Integer> ar = new ArrayList<>();
        int max = Integer.MIN_VALUE; int min = Integer.MAX_VALUE;
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Integer> tem = new ArrayList<>();
        for(int i=0; i < n; i++)
            ar.add(sc.nextInt());
        int temp;
        for(int i=0; i < 4; i++) {
            temp = sc.nextInt();
            if(temp != 0) {
                while(temp > 0){
                    tem.add(i);
                    temp--;
                }
            }
        }
        //덧셈(+)의 개수, 뺄셈(-)의 개수, 곱셈(×)의 개수, 나눗셈(÷)의 개수이다.
        int[] oper = tem.stream().mapToInt(i -> i).toArray();
        perm(oper, 0 , tem.size(), tem.size());
        for(int i=0 ;i <op.size(); i++){
            int[] t = op.get(i);
            int result = ar.get(0);
            for(int j=1; j<n; j++){
                if(t[j-1] == 0) result += ar.get(j);
                else if(t[j-1]==1) result -= ar.get(j);
                else if(t[j-1]==2) result *=  ar.get(j);
                else result /= ar.get(j);
            }
            if(result > max) max = result;
            if(result < min) min = result;
        }
        System.out.print(max +"\n" + min);


    }
}
