import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int T;
    static int arr[];

    static class Data{
        int idx; int cnt; ArrayList<Integer> al;
        Data(int i, int c, ArrayList<Integer> a){
            idx = i;
            cnt = c;
            al = a;
        }
    }

    static void bfs(Queue<Data> q) {
        while(!q.isEmpty()){
            Data d = q.poll();
            if(d.idx == T){
                if(d.cnt == 6) {
                    for (int i : d.al) {
                        System.out.print(i + " ");
                    }
                    System.out.println();
                }
                continue;
            }
            ArrayList<Integer> tmp = new ArrayList<>();
            tmp.addAll(d.al);
            tmp.add(arr[d.idx]);
            q.add(new Data(d.idx + 1, d.cnt, tmp ));

            if(d.cnt - 1 >= 6){
                q.add(new Data(d.idx + 1, d.cnt - 1, d.al ));
            }
        }
    }

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());
        boolean isFirst = true;
        while (true) {
            T = Integer.parseInt(token.nextToken());
            if (T == 0) break;
            if(!isFirst)
                System.out.println();
            else{
                isFirst = false;
            }
            arr = new int[T];
            for (int i = 0; i < T; i++)
                arr[i] = Integer.parseInt(token.nextToken());

            Queue<Data> q = new ArrayDeque<>();
            for(int i = 0; i < T; i++){
                if(T - i >= 6 ){
                    ArrayList<Integer> al = new ArrayList<>();
                    al.add(arr[i]);
                    q.add(new Data(i + 1, T - i, al));
                    bfs(q);
                }else break;
            }
            token = new StringTokenizer(br.readLine());
        }
    }
}
