package compoundInvestment;

import java.util.Scanner;

public class retirementInvestment {

    public static double sum = 0;
    public static int years = 0;

    public static void main(String[] args) {
        System.out.println("Enter the sum of money you'd like to start the investment with: ");
        Scanner sc = new Scanner(System.in);
        sum = sc.nextInt();
        System.out.println("Enter the amount you'd like to invest monthly: ");
        int monthlyAdd = sc.nextInt();
        System.out.println("Enter how many years you'd like to invest monthly: ");
        years = sc.nextInt();
        System.out.println("Enter by how much more you'd like to invest monthly each year: ");
        int increase = sc.nextInt();
        int count_increase = 0;
        System.out.println("With a starting sum of $" + sum + ": \n");

        for(int i = 1; i <= 45; i++) {
            if (i <= years) {
                sum = ((monthlyAdd + count_increase) * 12) + sum + sum * 0.20;
                count_increase += increase;
            }
            else
                sum = sum + sum * 0.10;
            if (i == 1) {
                System.out.println("After " + i + " year you'll have $" + sum + ", with $" + (sum * 0.20) + " from compound " +
                        "interest from previous year.");
                System.out.println("This year you invested $" + (monthlyAdd + count_increase - increase) + " per month.\n");
            } else {
                System.out.println("After " + i + " years you'll have $" + sum + ", with $" + (sum * 0.20) + " from compound " +
                        "interest from previous year.");
                System.out.println("This year you invested $" + (monthlyAdd + count_increase - increase) + " per month.\n");
            }
        }
    }
}
