import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static int[][] t = new int[5][8];
    public static void rotate(int num, int dir){
        int temp;
        if(dir == 1){
            temp = t[num][7];
            t[num][7] = t[num][6];
            t[num][6] = t[num][5];
            t[num][5] = t[num][4];
            t[num][4] = t[num][3];
            t[num][3] = t[num][2];
            t[num][2] = t[num][1];
            t[num][1] = t[num][0];
            t[num][0] = temp;
        }else if(dir == -1){
            temp = t[num][0];
            t[num][0] = t[num][1];
            t[num][1] = t[num][2];
            t[num][2] = t[num][3];
            t[num][3] = t[num][4];
            t[num][4] = t[num][5];
            t[num][5] = t[num][6];
            t[num][6] = t[num][7];
            t[num][7] = temp;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] data = new String[5];
        data[1] = sc.nextLine();
        data[2] = sc.nextLine();
        data[3] = sc.nextLine();
        data[4] = sc.nextLine();
        for(int i=1; i<=4; i++){
            for(int j=0; j<8;j++) {
                t[i][j] = data[i].charAt(j) - 48;
            }
        }
        // 0 1 2 3 4 5 6 7
        // 7 0 1 2 3 4 5 6 시계->1
        // 1 2 3 4 5 6 7 0 반시계->-1
        int h = sc.nextInt();
        for(int i=0; i<h; i++){
            int n = sc.nextInt();
            int dir = sc.nextInt();
            if(n+1 <= 4 && t[n][2] != t[n+1][6]){
                int dir2= (dir==1)?-1:1;
                if(n+2 <= 4 && t[n+1][2] != t[n+2][6]){
                    int dir3= (dir2==1)?-1:1;
                    if(n+3 <= 4 && t[n+2][2] != t[n+3][6]){
                        int dir4= (dir3==1)?-1:1;
                        rotate(n+3, dir4);
                    }
                    rotate(n+2, dir3);
                }
                rotate(n+1,dir2);
            }
            if(n-1 >= 0 && t[n][6] != t[n-1][2]){
                int dir2= (dir==1)?-1:1;
                if(n-2 >= 0 && t[n-1][6] != t[n-2][2]){
                    int dir3= (dir2==1)?-1:1;
                    if(n-3 >= 0 && t[n-2][6] != t[n-3][2]){
                        int dir4= (dir3==1)?-1:1;
                        rotate(n-3, dir4);
                    }
                    rotate(n-2, dir3);
                }
                rotate(n-1,dir2);
            }
            rotate(n,dir);
        }
        int res = 0;
        res += (t[1][0] == 0)? 0:1;
        res += (t[2][0] == 0)? 0:2;
        res += (t[3][0] == 0)? 0:4;
        res += (t[4][0] == 0)? 0:8;
        System.out.print(res);
    }
}
