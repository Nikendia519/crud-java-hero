import java.util.List;
import java.util.Scanner;

public class Main {
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n===== MENU HERO MOBILE LEGEND =====");
            System.out.println("1. Tambah Hero");
            System.out.println("2. Lihat Semua Hero");
            System.out.println("3. Edit Hero");
            System.out.println("4. Hapus Hero");
            System.out.println("5. Keluar");
            System.out.print("Pilih menu (1-5): ");
            int pilih = input.nextInt();
            input.nextLine(); // buang enter

            switch (pilih) {
                case 1:
                    tambahHero();
                    break;
                case 2:
                    lihatHero();
                    break;
                case 3:
                    editHero();
                    break;
                case 4:
                    hapusHero();
                    break;
                case 5:
                    System.out.println("Terima kasih, Mas Ganteng 👋");
                    return;
                default:
                    System.out.println("Pilihan tidak valid.");
            }
        }
    }

    static void tambahHero() {
        System.out.print("Nama Hero: ");
        String nama = input.nextLine();
        System.out.print("Kategori (MAGE, ASSASIN, FIGHTER, TANK, MARKSMAN, SUPPORT): ");
        String kategori = input.nextLine();
        System.out.print("Gender (MALE/FEMALE): ");
        String gender = input.nextLine();
        Hero h = new Hero(nama, kategori.toUpperCase(), gender.toUpperCase());
        HeroDAO.tambahHero(h);
    }

    static void lihatHero() {
        List<Hero> daftar = HeroDAO.getSemuaHero();
        System.out.println("\n=== DAFTAR HERO ===");
        for (Hero h : daftar) {
            System.out.println(h.getId() + ". " + h.getNama() + " | " + h.getKategori() + " | " + h.getGender());
        }
    }

    static void editHero() {
        lihatHero();
        System.out.print("Masukkan ID hero yang ingin diedit: ");
        int id = input.nextInt();
        input.nextLine();
        System.out.print("Nama Baru: ");
        String nama = input.nextLine();
        System.out.print("Kategori Baru: ");
        String kategori = input.nextLine();
        System.out.print("Gender Baru: ");
        String gender = input.nextLine();
        Hero h = new Hero(id, nama, kategori.toUpperCase(), gender.toUpperCase());
        HeroDAO.updateHero(h);
    }

    static void hapusHero() {
        lihatHero();
        System.out.print("Masukkan ID hero yang ingin dihapus: ");
        int id = input.nextInt();
        input.nextLine();
        HeroDAO.hapusHero(id);
    }
}
