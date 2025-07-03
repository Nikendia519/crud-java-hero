import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class HeroDAO {

    // Create
    public static void tambahHero(Hero hero) {
        try {
            Connection conn = DB.getConnection();
            String sql = "INSERT INTO tm_hero (nama_hero, kategori, gender) VALUES (?, ?, ?)";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, hero.getNama());
            pst.setString(2, hero.getKategori());
            pst.setString(3, hero.getGender());
            pst.executeUpdate();
            System.out.println("✅ Hero berhasil ditambahkan.");
        } catch (Exception e) {
            System.out.println("❌ Gagal tambah hero: " + e.getMessage());
        }
    }

    // Read
    public static List<Hero> getSemuaHero() {
        List<Hero> daftar = new ArrayList<>();
        try {
            Connection conn = DB.getConnection();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM tm_hero");
            while (rs.next()) {
                Hero h = new Hero(
                    rs.getInt("id_hero"),
                    rs.getString("nama_hero"),
                    rs.getString("kategori"),
                    rs.getString("gender")
                );
                daftar.add(h);
            }
        } catch (Exception e) {
            System.out.println("❌ Gagal ambil data: " + e.getMessage());
        }
        return daftar;
    }

    // Update
    public static void updateHero(Hero hero) {
        try {
            Connection conn = DB.getConnection();
            String sql = "UPDATE tm_hero SET nama_hero = ?, kategori = ?, gender = ? WHERE id_hero = ?";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, hero.getNama());
            pst.setString(2, hero.getKategori());
            pst.setString(3, hero.getGender());
            pst.setInt(4, hero.getId());
            pst.executeUpdate();
            System.out.println("✅ Hero berhasil diupdate.");
        } catch (Exception e) {
            System.out.println("❌ Gagal update hero: " + e.getMessage());
        }
    }

    // Delete
    public static void hapusHero(int id) {
        try {
            Connection conn = DB.getConnection();
            String sql = "DELETE FROM tm_hero WHERE id_hero = ?";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setInt(1, id);
            pst.executeUpdate();
            System.out.println("✅ Hero berhasil dihapus.");
        } catch (Exception e) {
            System.out.println("❌ Gagal hapus hero: " + e.getMessage());
        }
    }
}
