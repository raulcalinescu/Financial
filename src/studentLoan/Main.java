package studentLoan;

public class Main {

    public static void main(String[] args) {
        LoanAmortization myStudentLoan = new LoanAmortization(0.074, 105000,3300,
                0);
        myStudentLoan.displayMonthlyAdjustedPrincipal();
    }
}