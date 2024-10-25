import java.util.Scanner;

public class uts104 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double totalNilai = 0;
        int jumlahSiswa = 0, siswaDiAtasRata = 0;

        while (true) {
            System.out.print("Masukkan nama siswa (atau 'selesai' untuk keluar): ");
            String nama = scanner.nextLine();
            if (nama.equalsIgnoreCase("selesai")) break;

            double nilai = -1;
            while (nilai < 0) {
                System.out.print("Masukkan nilai untuk " + nama + ": ");
                String input = scanner.nextLine();
                if (input.matches("-?\\d+(\\.\\d+)?")) {
                    nilai = Double.parseDouble(input);
                    if (nilai < 0) System.out.println("Nilai tidak boleh negatif.");
                } else {
                    System.out.println("Nilai harus berupa angka.");
                }
            }
            totalNilai += nilai;
            jumlahSiswa++;
        }

        if (jumlahSiswa == 0) {
            System.out.println("Tidak ada data siswa.");
            return;
        }

        double rataRata = totalNilai / jumlahSiswa;
        System.out.printf("Rata-rata nilai kelas: %.2f\n", rataRata);

        while (true) {
            System.out.print("Masukkan nama siswa untuk evaluasi (atau 'selesai' untuk keluar): ");
            String nama = scanner.nextLine();
            if (nama.equalsIgnoreCase("selesai")) break;

            double nilai = -1;
            while (nilai < 0) {
                System.out.print("Masukkan nilai untuk " + nama + ": ");
                String input = scanner.nextLine();
                if (input.matches("-?\\d+(\\.\\d+)?")) {
                    nilai = Double.parseDouble(input);
                    if (nilai < 0) System.out.println("Nilai tidak boleh negatif.");
                } else {
                    System.out.println("Nilai harus berupa angka.");
                }
            }

            if (nilai > rataRata) siswaDiAtasRata++;
        }

        System.out.println("Jumlah siswa di atas rata-rata: " + siswaDiAtasRata);
        System.out.println(siswaDiAtasRata > jumlahSiswa / 2 ?
                "Mayoritas siswa di atas rata-rata." : "Tidak ada mayoritas siswa di atas rata-rata.");
        
        scanner.close();
    }
}