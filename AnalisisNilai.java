public class AnalisisNilai {
    public static int cariNilaiUTSTertinggi(Mahasiswa[] mahasiswa, int awal, int akhir) {
        if (awal == akhir) {
            return mahasiswa[awal].getNilaiUTS();
        }
        
        int tengah = (awal + akhir) / 2;
        int maksKiri = cariNilaiUTSTertinggi(mahasiswa, awal, tengah);
        int maksKanan = cariNilaiUTSTertinggi(mahasiswa, tengah + 1, akhir);
        
        return Math.max(maksKiri, maksKanan);
    }

    public static int cariNilaiUTSTerendah(Mahasiswa[] mahasiswa, int awal, int akhir) {
        if (awal == akhir) {
            return mahasiswa[awal].getNilaiUTS();
        }
        
        int tengah = (awal + akhir) / 2;
        int minKiri = cariNilaiUTSTerendah(mahasiswa, awal, tengah);
        int minKanan = cariNilaiUTSTerendah(mahasiswa, tengah + 1, akhir);
        
        return Math.min(minKiri, minKanan);
    }

    public static double hitungRataRataUAS(Mahasiswa[] mahasiswa) {
        int total = 0;
        for (Mahasiswa mhs : mahasiswa) {
            total += mhs.getNilaiUAS();
        }
        return (double) total / mahasiswa.length;
    }

    public static void main(String[] args) {
        Mahasiswa[] mahasiswa = {
            new Mahasiswa("Ahmad", "220101001", 2022, 78, 82),
            new Mahasiswa("Budi", "220101002", 2022, 85, 88),
            new Mahasiswa("Cindy", "220101003", 2021, 90, 87),
            new Mahasiswa("Dian", "220101004", 2021, 76, 79),
            new Mahasiswa("Eko", "220101005", 2023, 92, 95),
            new Mahasiswa("Fajar", "220101006", 2020, 88, 85),
            new Mahasiswa("Gina", "220101007", 2023, 80, 83),
            new Mahasiswa("Hadi", "220101008", 2020, 82, 84)
        };

        int nilaiUTSTertinggi = cariNilaiUTSTertinggi(mahasiswa, 0, mahasiswa.length - 1);
        System.out.println("Nilai UTS tertinggi: " + nilaiUTSTertinggi);

        int nilaiUTSTerendah = cariNilaiUTSTerendah(mahasiswa, 0, mahasiswa.length - 1);
        System.out.println("Nilai UTS terendah: " + nilaiUTSTerendah);

        double rataRataUAS = hitungRataRataUAS(mahasiswa);
        System.out.println("Rata-rata nilai UAS: " + rataRataUAS);
    }
}