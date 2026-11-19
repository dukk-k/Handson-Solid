// SRP: hanya bertanggung jawab menghitung nilai
class GradeCalculator {
    public double hitungNilaiAkhir(double tugas, double uts, double uas) {
        return (tugas * 0.3) + (uts * 0.3) + (uas * 0.4);
    }
}

// SRP: hanya bertanggung jawab mencetak laporan
class ReportPrinter {
    public void cetakLaporan(String nama, double nilai) {
        System.out.println("Laporan Nilai Mahasiswa: " + nama + " = " + nilai);
    }
}

// Abstraksi penyimpanan (DIP): mudah diganti (database, file, dll.)
interface GradeRepository {
    void simpan(String nama, double nilai);
}

// SRP: hanya bertanggung jawab menyimpan data
class DatabaseGradeRepository implements GradeRepository {
    @Override
    public void simpan(String nama, double nilai) {
        System.out.println("Menyimpan ke database: " + nama + " = " + nilai);
    }
}

public class Main {
    public static void main(String[] args) {
        GradeCalculator calculator = new GradeCalculator();
        ReportPrinter printer = new ReportPrinter();
        GradeRepository repository = new DatabaseGradeRepository();

        double nilai = calculator.hitungNilaiAkhir(80, 85, 90);
        printer.cetakLaporan("Andi", nilai);
        repository.simpan("Andi", nilai);
    }
}