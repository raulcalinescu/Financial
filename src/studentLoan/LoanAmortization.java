package studentLoan;
import java.text.DecimalFormat;

public class LoanAmortization {

    private double totalSumm;
    private double intRate;
    private double monthlyPayment;
    private double additionalMonthlyPayment;
    private DecimalFormat df = new DecimalFormat("##.##");

    public LoanAmortization(double intRate, double totalSumm, double monthlyPayment, double additionalMonthlyPayment) {
        this.intRate = intRate;
        this.totalSumm = totalSumm;
        this.monthlyPayment = monthlyPayment;
        this.additionalMonthlyPayment = additionalMonthlyPayment;
    }

    public void displayMonthlyAdjustedPrincipal() {
        int payCount = 0;
        double newIntRate, newPrinPay, totalInt = 0;
        while(totalSumm > 0) {
            newIntRate = (totalSumm * intRate) / 12;
            totalInt+=newIntRate;
            newPrinPay = (monthlyPayment - newIntRate);
            totalSumm = totalSumm - newPrinPay;
            totalSumm = totalSumm - additionalMonthlyPayment;
            payCount++;
            System.out.println("On month " + df.format(payCount) + " you pay $ " +
                   df.format(newPrinPay + additionalMonthlyPayment) + " to principal and $ " +
                    df.format(newIntRate) + " interest, with remaining principal $ " +
                    df.format(totalSumm));
            if(totalSumm < monthlyPayment) {
                payCount++;
                System.out.println("On month " + payCount + " you have the last payment of $ "
                        + df.format(totalSumm));
                System.out.println("Total interest paid was $ " +
                        df.format(totalInt) + " in "+ payCount/12 + " year(s) and "
                        + payCount%12 + " month(s)");
                break;
            }
        }
    }
}