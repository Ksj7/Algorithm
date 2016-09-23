import java.util.Scanner;
/*
 * Author: sujin Kim (Ksj7)
 * Date: 2016.09.17
 * email: sujin.kim1414@gmail.com
 *
 * https://github.com/Ksj7/Algorithm
 * https://www.acmicpc.net/problem/1707
 */

public class Main {
    
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n,l;
        int result = 0;
        int[][] puddle;
        n = sc.nextInt();
        l = sc.nextInt();
        puddle = new int[n][2];
        for (int i = 0; i < n; i++){
            puddle[i][0] = sc.nextInt();
            puddle[i][1] = sc.nextInt();
        }
        MergeSort(puddle,0,n-1);
        int start = 0;
        for (int i = 0; i < n; i++) {
            if(start<puddle[i][0]){
                start = puddle[i][0];
            }
            int share = (puddle[i][1]-start+l-1)/l;
            result = result + share;
            start = (start+ share*l);
        }

        System.out.println(result);
    }
        static void MergeSort(int[][] dest , int start , int end){

            if(end -start < 1) return;

            int mid = (end+start)/2;
            MergeSort(dest, start, mid);
            MergeSort(dest, mid+1 , end);

            Merge(dest,start, mid ,end);
        }

        static private void Merge(int[][] dest, int start, int mid, int end) {
            int left = start;
            int right = mid+1;
            int currentIndex = 0;
            int[][] temp = new int[end-start+1][2];

            while(left <= mid && right <= end){
                if(dest[left][0] < dest[right][0]){
                    temp[currentIndex][0] = dest[left][0];
                    temp[currentIndex][1] = dest[left][1];
                    left++;
                }else{
                    temp[currentIndex][0] = dest[right][0];
                    temp[currentIndex][1] = dest[right][1];
                    right++;
                }
                currentIndex++;
            }

            while(left <= mid){
                temp[currentIndex++] = dest[left++];
            }
            while(right <= end){
                temp[currentIndex++] = dest[right];
                right++;
            }

            currentIndex = 0;

            for(int i = start; i <= end; i++){
                dest[i] = temp[currentIndex++];
            }

        }
    }
