package org.example.Model;

public class Kendaraan {
    private String type;
    private String condition;
    private int year;
    private double totalLoanAmount;
    private int tenor;
    private double dp;
    public Kendaraan(String condition, String type,  int year, double dp, double totalLoanAmount, int tenor) {
        this.type = type;
        this.condition = condition;
        this.year = year;
        this.totalLoanAmount = totalLoanAmount;
        this.tenor = tenor;
        this.dp = dp;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public double getTotalLoanAmount() {
        return totalLoanAmount;
    }

    public void setTotalLoanAmount(double totalLoanAmount) {
        this.totalLoanAmount = totalLoanAmount;
    }

    public int getTenor() {
        return tenor;
    }

    public void setTenor(int tenor) {
        this.tenor = tenor;
    }

    public double getDp() {
        return dp;
    }

    public void setDp(double dp) {
        this.dp = dp;
    }
}
