import java.util.Scanner;

/*
 * Author: sujin Kim (Ksj7)
 * Date: 2016.09.18
 * email: sujin.kim1414@gmail.com
 *
 * https://github.com/Ksj7/Algorithm
 * https://www.acmicpc.net/problem/1707
 */
 
public class Main {
    public static void main(String[] args) {
        int n;
        int start = 0 , end = 0;
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int[][] str = new int[n][2];
        for (int i = 0; i < n; i++) {
            str[i][0] = sc.nextInt();
            str[i][1] = sc.nextInt();
        }
        MergeSort(str,0,n-1);
        int sum = str[0][0];
        end = str[0][1];
        start = end - sum;
        int i = 1;
        boolean isFinish = true;
        while (i!=n && start >=0) {
            if( start + sum + str[i][0] > str[i][1] ) {
                end = str[i][1];
                sum += str[i][0];
                start = end-sum;
                if(start < 0) {
                    isFinish = false;
                    break;
                }
            }
            else sum+= str[i][0];
            i++;
        }

        if(isFinish && start >= 0)
            System.out.println(start);
        else
            System.out.println("-1");
    }

    static void MergeSort(int[][] dest, int start, int end) {

        if (end - start < 1) return;

        int mid = (end + start) / 2;
        MergeSort(dest, start, mid);
        MergeSort(dest, mid + 1, end);

        Merge(dest, start, mid, end);
    }

    static private void Merge(int[][] dest, int start, int mid, int end) {
        int left = start;
        int right = mid + 1;
        int currentIndex = 0;
        int[][] temp = new int[end - start + 1][2];

        while (left <= mid && right <= end) {
            if (dest[left][1] < dest[right][1]) {
                temp[currentIndex][0] = dest[left][0];
                temp[currentIndex][1] = dest[left][1];
                left++;
            } else {
                temp[currentIndex][0] = dest[right][0];
                temp[currentIndex][1] = dest[right][1];
                right++;
            }
            currentIndex++;
        }

        while (left <= mid) {
            temp[currentIndex++] = dest[left++];
        }
        while (right <= end) {
            temp[currentIndex++] = dest[right];
            right++;
        }

        currentIndex = 0;

        for (int i = start; i <= end; i++) {
            dest[i] = temp[currentIndex++];
        }

    }

}
