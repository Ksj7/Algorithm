import java.util.Scanner;

public class Main {
    public static class Pair {
        private int first;
        private int second;
        Pair(int f, int s){
            this.first = f;
            this.second = s;
        }
    }
    public static void sort(Pair[] data, int l, int r){
        int left = l;
        int right = r;
        Pair pivot = data[(l+r)/2];

        do{
            while(data[left].second < pivot.second || ( data[left].second == pivot.second && data[left].first < pivot.first) ) left++;
            while(data[right].second > pivot.second) right--;
            if(left <= right){
                Pair temp = data[left];
                data[left] = data[right];
                data[right] = temp;
                left++;
                right--;
            }
        }while (left <= right);

        if(l < right) sort(data, l, right);
        if(r > left) sort(data, left, r);
    }

    public static void main(String arg[]){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int cnt = 0;
        Pair list[] = new Pair[100001];
        for(int i=0; i<N; i++){
            list[i] = new Pair(sc.nextInt(),sc.nextInt());
        }
        sort(list, 0,N - 1);
        cnt++;
        int end = list[0].second;
        for(int i=1; i<N; i++){
            if(end <= list[i].first){
                end = list[i].second;
                cnt++;
            }
        }
        System.out.print(cnt);

    }
}

