package com.ps;

public class LeaseContract extends Contract{
    double expectedEndingValue;
    double leaseFee;

    public LeaseContract(String date, String customerName, String customerEmail, Vehicle vehicleSold) {
        super(date, customerName, customerEmail, vehicleSold,0,0);
        this.expectedEndingValue = vehicleSold.getPrice() * 0.5;
        this.leaseFee = vehicleSold.getPrice() * .07;
        this.totalPrice = getTotalPrice();
        this.monthlyPayment = getMonthlyPayment();
    }

    @Override
    public double getTotalPrice(){
        double finalTotal;
        finalTotal = vehicleSold.getPrice() + getLeaseFee();
        return finalTotal;
    }

    @Override
    public double getMonthlyPayment(){
        double principal = getTotalPrice();
        double annualInterestRate = .04;
        int termMonths = 36;
        double monthlyInterestRate = annualInterestRate / 12;

        monthlyPayment = (principal * monthlyInterestRate) / (1 - Math.pow(1 + monthlyInterestRate, -termMonths));

        return monthlyPayment;
    }

    public double getExpectedEndingValue() {
        return expectedEndingValue;
    }

    public void setExpectedEndingValue(double expectedEndingValue) {
        this.expectedEndingValue = expectedEndingValue;
    }

    public double getLeaseFee() {
        return leaseFee;
    }

    public void setLeaseFee(double leaseFee) {
        this.leaseFee = leaseFee;
    }


    @Override
    public String toString() {
        return "LeaseContract{" +
                "date='" + date + '\'' +
                ", customerName='" + customerName + '\'' +
                ", customerEmail='" + customerEmail + '\'' +
                ", vehicleSold=" + vehicleSold +
                ", totalPrice=" + getTotalPrice() +
                ", monthlyPayment=" + getMonthlyPayment() +
                ", expectedEndingValue=" + expectedEndingValue +
                ", leaseFee=" + leaseFee +
                '}';
    }
}
