package Assignment;

import java.util.ArrayList;
import java.util.List;

public class SummativeSum {
    public static void main (String [] args){
        List<Integer> all_Sums = new ArrayList<>();
        int sum1= SummativeSum.Sums(new int[] {1, 90, -33, -55, 67, -16, 28, -55, 15});
        all_Sums.add(sum1);
        int sum2= SummativeSum.Sums(new int[] { 999, -60, -77, 14, 160, 301});
        all_Sums.add(sum2);
        int sum3= SummativeSum.Sums(new int[] {10, 20, 30, 40, 50, 60, 70, 80, 90,
               100, 110, 120, 130, 140, 150, 160, 170, 180, 190, 200, -99});
        all_Sums.add(sum3);

        for (int num : all_Sums){
            System.out.println(num);
        }
    }
    public static int Sums (int [] numbers){
        int num = 0;
        for (int i = 0; i <numbers.length ; i++) {
            num+=numbers[i];
        }
        return num;
    }
}
