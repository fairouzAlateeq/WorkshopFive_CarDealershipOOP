package com.ps;

public class SalesContract extends Contract {
    double salesTax;
    double recordingFee;
    double processingFee;
    boolean finance;

    public SalesContract(String date, String customerName, String customerEmail, Vehicle vehicleSold, boolean finance) {
        super(date, customerName, customerEmail, vehicleSold, 0, 0);
        this.salesTax = .05;
        this.recordingFee = 100;
        if(vehicleSold.getPrice() < 10000)
        this.processingFee = 295;
        else this.processingFee = 495;
        this.finance = finance;
    }
    @Override
    public double getTotalPrice(){
        double tax = vehicleSold.getPrice() * salesTax;
        double finalTotal = vehicleSold.getPrice() + tax + recordingFee + processingFee;

        return finalTotal;
    }

    @Override
    public double getMonthlyPayment(){

        double principal = getTotalPrice();
        double annualInterestRate;
        int termMonths;
        if(principal >= 10000) {
            annualInterestRate = 0.0425;
            termMonths = 48;
        } else {
            annualInterestRate = 0.0525;
            termMonths = 24;
        }
        double monthlyInterestRate = annualInterestRate / 12;

        monthlyPayment = (principal * monthlyInterestRate) / (1 - Math.pow(1 + monthlyInterestRate, -termMonths));

        return monthlyPayment;
    }
    public double getSalesTax() {
        return salesTax;
    }

    public void setSalesTax(double salesTax) {
        this.salesTax = salesTax;
    }

    public double getRecordingFee() {
        return recordingFee;
    }

    public void setRecordingFee(double recordingFee) {
        this.recordingFee = recordingFee;
    }

    public double getProcessingFee() {
        return processingFee;
    }

    public void setProcessingFee(double processingFee) {
        this.processingFee = processingFee;
    }

    public boolean isFinance() {
        return finance;
    }

    public void setFinance(boolean finance) {
        this.finance = finance;
    }

    @Override
    public String toString() {
        return "SalesContract{" +
                "date='" + date + '\'' +
                ", customerName='" + customerName + '\'' +
                ", customerEmail='" + customerEmail + '\'' +
                ", vehicleSold=" + vehicleSold +
                ", totalPrice=" + getTotalPrice() +
                ", monthlyPayment=" + getMonthlyPayment() +
                ", salesTax=" + salesTax +
                ", recordingFee=" + recordingFee +
                ", processingFee=" + processingFee +
                ", finance=" + finance +
                '}';
    }
}
