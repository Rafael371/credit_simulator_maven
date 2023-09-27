package Controller;

import View.ConsoleView;
import Model.Kendaraan;

public class CreditCalculatorController {
    private ConsoleView view;
    private final double newVehicleDP = 0.25 ;
    private final double usedVehicleDP = 0.25 ;


    public CreditCalculatorController(ConsoleView view) {
        this.view = view;
    }

    public CreditCalculatorController() {
    }

    public double getNewVehicleDP() {
        return newVehicleDP;
    }

    public double getUsedVehicleDP() {
        return usedVehicleDP;
    }



    public boolean validateDP(String condition, double pinjamanTotal, double dp){
        double percentageDP = dp/pinjamanTotal;
        boolean status = true;
        if(condition.equals("Baru")){
            if(percentageDP<newVehicleDP){
                status = false;
            }
        } else if (condition.equals("Bekas")) {
            if(percentageDP<usedVehicleDP){
                status = false;
            }
        }
        return status;
    }

    public void calculateMonthlyInstallment(Kendaraan kendaraan){
        final double motor_IR=0.09;
        final double mobil_IR=0.08;
        int currentYear = 2023;
        double monthlyInstallment;
        double yearlyInstallment=0;

        double basePokokPinjaman = kendaraan.getJumlahPinjaman()- kendaraan.getJumlahDownPayment();
        double interestRate = (kendaraan.getVehicleType().equalsIgnoreCase("Motor")) ? motor_IR : mobil_IR;
        double totalPinjaman = (basePokokPinjaman*interestRate)+basePokokPinjaman;

        double pokokPinjaman;

        view.displayTitle();
        for (int year = 0; year < kendaraan.getTenorCicilan(); year++) {
            if(year == 0) {
                pokokPinjaman = basePokokPinjaman;
            }else{
                pokokPinjaman = totalPinjaman - yearlyInstallment;
            }

            totalPinjaman = (pokokPinjaman*interestRate)+pokokPinjaman;

            monthlyInstallment = totalPinjaman / ((12*kendaraan.getTenorCicilan()) - year*12 );

            view.displayMonthlyInstallment((year+1), monthlyInstallment,interestRate);

            yearlyInstallment = monthlyInstallment * 12;

            // Apply interest rate adjustments, karena bermula dari index 0 maka conditional akan dibalik, genap kan menerapkan sebagai tahun ganjil, dan sebaliknya
            if (year % 2 == 0) {
                // Increment interest rate by 0.1% every 1 year
                interestRate = interestRate + 0.001;
            } else {
                // Increment interest rate by 0.5% every 2 years
                interestRate = interestRate + 0.005;
            }

        }

    }

    public void start(){
        Kendaraan kendaraan = view.getInputFromUser();
        calculateMonthlyInstallment(kendaraan);
    }
}
