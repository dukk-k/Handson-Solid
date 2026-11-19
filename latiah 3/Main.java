// ISP: interface kecil sesuai kemampuan
interface Vehicle {
    void jalan();
}

interface EngineStartable {
    void startEngine();
}

interface Refuelable {
    void isiBahanBakar();
}

interface Chargeable {
    void isiBaterai();
}

// Mobil bensin: jalan, mesin, bahan bakar
class MobilBensin implements Vehicle, EngineStartable, Refuelable {
    @Override
    public void jalan() {
        System.out.println("Mobil bensin berjalan.");
    }

    @Override
    public void startEngine() {
        System.out.println("Menyalakan mesin mobil bensin...");
    }

    @Override
    public void isiBahanBakar() {
        System.out.println("Mengisi bahan bakar mobil bensin...");
    }
}

// Mobil listrik: jalan, mesin (motor), baterai
class MobilListrik implements Vehicle, EngineStartable, Chargeable {
    @Override
    public void jalan() {
        System.out.println("Mobil listrik berjalan.");
    }

    @Override
    public void startEngine() {
        System.out.println("Menyalakan motor mobil listrik...");
    }

    @Override
    public void isiBaterai() {
        System.out.println("Mengisi baterai mobil listrik...");
    }
}

// Sepeda: hanya bisa jalan, tanpa mesin/bahan bakar/baterai
class Sepeda implements Vehicle {
    @Override
    public void jalan() {
        System.out.println("Sepeda dikayuh.");
    }
}

// OCP + DIP: bergantung pada abstraksi, kendaraan baru tidak mengubah kelas ini
class VehicleController {
    private final Vehicle vehicle;

    public VehicleController(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public void operate() {
        if (vehicle instanceof EngineStartable) {
            ((EngineStartable) vehicle).startEngine();
        }
        vehicle.jalan();
    }
}

public class Main {
    public static void main(String[] args) {
        MobilListrik mobilListrik = new MobilListrik();
        mobilListrik.startEngine();
        mobilListrik.isiBaterai();

        MobilBensin mobilBensin = new MobilBensin();
        mobilBensin.startEngine();
        mobilBensin.isiBahanBakar();

        Sepeda sepeda = new Sepeda();
        sepeda.jalan(); // sepeda.startEngine() tidak ada, error terdeteksi saat compile

        new VehicleController(mobilListrik).operate();
        new VehicleController(sepeda).operate();
    }
}