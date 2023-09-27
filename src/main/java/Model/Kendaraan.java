package Model;

public class Kendaraan {
    private String vehicleCondition;
    private String vehicleType;
    private int tahunMobil;
    private double jumlahDownPayment;
    private double jumlahPinjaman;
    private int tenorCicilan;

    public Kendaraan(String vehicleCondition, String vehicleType, int tahunMobil, double jumlahDownPayment, double jumlahPinjaman, int tenorCicilan) {
        this.vehicleCondition = vehicleCondition;
        this.vehicleType = vehicleType;
        this.tahunMobil = tahunMobil;
        this.jumlahDownPayment = jumlahDownPayment;
        this.jumlahPinjaman = jumlahPinjaman;
        this.tenorCicilan = tenorCicilan;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public double getJumlahDownPayment() {
        return jumlahDownPayment;
    }

    public double getJumlahPinjaman() {
        return jumlahPinjaman;
    }

    public int getTenorCicilan() {
        return tenorCicilan;
    }

}
