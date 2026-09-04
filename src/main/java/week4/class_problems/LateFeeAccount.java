package week4.class_problems;

public class LateFeeAccount {
    String regNo;
    double totalFee;

    public LateFeeAccount(String regNo, double totalFee) {
        this.regNo = regNo;
        this.totalFee = totalFee;
    }

    final double calculateLateFee(int daysLate) {
        return totalFee * 0.01 * daysLate;
    }

    final void printSummary(int daysLate) {
        System.out.println(regNo + " | Total Fee: Rs " + totalFee + " | Late Fee: Rs " + calculateLateFee(daysLate));
    }

    public static void main(String[] args) {
        String[] regNos = {"RA001", "RA002", "RA003", "RA004"};
        double[] totalFees = {200000, 150000, 180000, 220000};
        int[] daysLate = {10, 0, -2, 5};

        LateFeeAccount[] accounts = new LateFeeAccount[regNos.length];
        for (int i = 0; i < regNos.length; i++) {
            accounts[i] = new LateFeeAccount(regNos[i], totalFees[i]);
        }

        for (int i = 0; i < accounts.length; i++) {
            if (daysLate[i] > 0) {
                accounts[i].printSummary(daysLate[i]);
            } else {
                System.out.println(accounts[i].regNo + " - On time, no late fee");
            }
        }
    }
}