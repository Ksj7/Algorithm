import java.util.Scanner;

public class Main {
    static int N;
    static int arr[];

    static int solution(int data){
        if(arr[data] >= 1 ) return arr[data];
        else{
            arr[data] = (solution(data-1) % 15746 + solution(data-2) % 15746) % 15746;
        }
        return arr[data];
    }

    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        //1 하나만으로 이루어진 타일 또는 한 쌍의 00타일들만이 남게 되었다.
        //N이 주어졌을 때 지원이가 만들 수 있는 모든 가짓수를 세는 것이다.
        //N=1일 때 1만
        //N=2일 때는 00, 11을 만들 수 있다. (01, 10은 만들 수 없게 되었다.)-> 2
        //N=3일 때 001, 100, 111 -> 3  ->
        //N=4일 때는 0011, 0000, 1001, 1100, 1111 등 총 5개 -> 5
        //N=5일땐, 10011,00111, 00001,10000, 00100, 11001, 11100, 11111,- > 8
        //N=6일때 000011, 110000, 001100,
        N = sc.nextInt();
        arr= new int[N+1];
        arr[1] = 1;
        arr[2] = 2;
        System.out.println(solution(N));

        //길이가 N인 모든 2진 수열의 개수를 15746으로 나눈 나머지를 출력한다.
    }
}
