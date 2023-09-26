package org.example.View;;
import java.util.Scanner;
import java.text.DecimalFormat;
import org.example.Model.Kendaraan;
import org.example.Controller.CreditCalculatorController;
public class ConsoleView {
    private CreditCalculatorController controller = new CreditCalculatorController();
    private Scanner scanner = new Scanner(System.in);
    private int currentYear = 2023;
    private int batasTahun = currentYear-1;
    DecimalFormat decimalFormat = new DecimalFormat("#,##0.00");
    DecimalFormat decimalFormat2 = new DecimalFormat("#.###");
    public void displayTitle(){
        System.out.println("\nJumlah Cicilan Perbulan:");
    }

    public void displayMonthlyInstallment(int tahun, double installment, double sukuBunga) {
        String formattedPokokPinjaman = decimalFormat.format(installment);
        String formattedSukuBunga = decimalFormat2.format(sukuBunga*100);
        System.out.println("Tahun ke " + tahun + " : Rp. " + formattedPokokPinjaman + "/bln, Suku Bunga = " + formattedSukuBunga + "%");
    }

    public Kendaraan getInputFromUser() {
        System.out.println("Welcome to the Vehicle Loan Calculator!");

        System.out.println("Jenis Kendaraan (Motor/Mobil): ");
        String vehicleType = scanner.nextLine();

        System.out.println("Kondisi Kendaraan (Baru/Bekas): ");
        String vehicleCondition = scanner.nextLine();

        System.out.println("Tahun Kendaraan: ");
        int vehicleYear = Integer.parseInt(scanner.nextLine());
        if(vehicleCondition.equals("Baru")){
            while(vehicleYear < batasTahun || vehicleYear > currentYear){
                System.out.println("Masukkan kembali tahun kendaraan (batas kendaraan baru adalah " + batasTahun + " - " + currentYear + "): ");
                vehicleYear = Integer.parseInt(scanner.nextLine());
            }
        }

        System.out.print("Input Jumlah Pinjaman Total: ");
        double totalLoanAmount = Double.parseDouble(scanner.nextLine());

        System.out.print("Input Tenor Pinjaman (1-6 tahun): ");
        int tenor = Integer.parseInt(scanner.nextLine());
        while(tenor < 1 || tenor > 6){
            System.out.print("Nilai tenor harus berada diantara 1-6\nInput Kembali Tenor Pinjaman (1-6 tahun): ");
            tenor = Integer.parseInt(scanner.nextLine());
        }

        System.out.print("Input Jumlah DP: ");
        double downPayment = Double.parseDouble(scanner.nextLine());
        boolean checkDP = controller.validateDP(vehicleCondition, totalLoanAmount, downPayment);
        while(!checkDP){
            double percentageDP = ((vehicleCondition.equals("Baru")) ? controller.getNewVehicleDP() : controller.getUsedVehicleDP());
            String formattedPercentageDP = decimalFormat2.format(percentageDP*100);
            System.out.print("Kendaraan dengan kondisi " + vehicleCondition + " wajib membayarkan DP sebesar " + formattedPercentageDP + "%\nMasukkan kembali jumlah DP:");
            downPayment= Integer.parseInt(scanner.nextLine());
            checkDP = controller.validateDP(vehicleCondition, totalLoanAmount, downPayment);
        }


        return new Kendaraan(vehicleCondition, vehicleType, vehicleYear, downPayment, totalLoanAmount, tenor);
    }
}
