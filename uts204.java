import java.util.Scanner;

public class uts204 {
    static class Barang {
        String namaBarang;
        int jumlahStok;
        double hargaPerUnit;

        public Barang(String nama, int stok, double harga) {
            namaBarang = nama;
            jumlahStok = stok;
            hargaPerUnit = harga;
        }

        public double hitungTotalNilaiStok() {
            return jumlahStok * hargaPerUnit;
        }

        public void prosesPermintaan(int jumlahPermintaan) {
            if (jumlahPermintaan <= jumlahStok) {
                jumlahStok -= jumlahPermintaan;
                System.out.printf("Permintaan untuk %d unit %s dapat dipenuhi. Stok sekarang: %d\n",
                        jumlahPermintaan, namaBarang, jumlahStok);
            } else {
                System.out.printf("Stok tidak mencukupi untuk %s. Stok tersedia: %d\n", namaBarang, jumlahStok);
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("Masukkan nama barang (atau 'selesai' untuk keluar): ");
            String nama = scanner.nextLine();
            if (nama.equalsIgnoreCase("selesai")) break;

            System.out.print("Masukkan jumlah stok: ");
            int stok = Integer.parseInt(scanner.nextLine());

            System.out.print("Masukkan harga per unit: ");
            double harga = Double.parseDouble(scanner.nextLine());

            Barang barang = new Barang(nama, stok, harga);
            double totalNilaiStok = barang.hitungTotalNilaiStok();
            System.out.printf("Total nilai stok untuk %s: %.2f\n", barang.namaBarang, totalNilaiStok);

            System.out.print("Masukkan jumlah permintaan barang: ");
            int jumlahPermintaan = Integer.parseInt(scanner.nextLine());

            barang.prosesPermintaan(jumlahPermintaan);
        }
        scanner.close();
        System.out.println("Program selesai.");
    }
}