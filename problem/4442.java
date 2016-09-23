import java.math.BigInteger;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

/*
 * Author: sujin Kim (Ksj7)
 * Date: 2016.09.10
 * email: sujin.kim1414@gmail.com
 *
 * https://github.com/Ksj7/Algorithm
 * https://www.acmicpc.net/problem/1707
 */
 
public class Main {

    static BigInteger answer;

    static void MergeSort(int[] dest , int start , int end){

        if(end -start < 1) return;

        int mid = (end+start)/2;
        MergeSort(dest, start, mid);
        MergeSort(dest, mid+1 , end);

        Merge(dest,start, mid ,end);
    }

    static private void Merge(int[] dest, int start, int mid, int end) {
        int left = start;
        int right = mid+1;
        int currentIndex = 0;
        int[] temp = new int[end-start+1];

        while(left <= mid && right <= end){
            if(dest[left] < dest[right]){
                temp[currentIndex] = dest[left];
                left++;
            }else{
                temp[currentIndex] = dest[right];
                BigInteger tempValue = BigInteger.valueOf(mid-left+1);
                answer = answer.add(tempValue);
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
            dest[i] = temp[currentIndex];
            currentIndex++;
        }
    }

    public static void main(String[] args) {

        int arrayNum;
        int[] dest;

        Scanner sc = new Scanner(System.in);

        while(true) {
            arrayNum = sc.nextInt();
            if(arrayNum == 0) break;

            dest = new int[arrayNum];
            answer = new BigInteger(String.valueOf(BigInteger.ZERO));

            HashMap<String,Integer> problem = new HashMap<>();
            for(int i = 0 ; i < arrayNum; i ++) {
                String temp = sc.next();
                problem.put(temp,i);
            }

            for(int i = 0 ; i < arrayNum; i ++) {
                String temp = sc.next();
                dest[i] = problem.get(temp);
            }

            MergeSort(dest,0,arrayNum-1);
            System.out.println(answer);
        }

    }
}
