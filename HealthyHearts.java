package Assignment;

import java.util.Scanner;

public class HealthyHearts {
    public static void main (String [] args){
        Scanner temp = new Scanner(System.in);

        System.out.println("What is your age: ");
        int age = Integer.parseInt(temp.nextLine());
        int heart_rate = 220-age;

        System.out.println("Your maximum heart rate is " + heart_rate + " beats per minute");
        System.out.println("Your target HR zone is " + Math.round(0.5*heart_rate) + " - " + Math.round (0.85*heart_rate) + " beats per minute");
    }
}
