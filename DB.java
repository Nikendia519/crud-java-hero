import java.sql.Connection;
import java.sql.DriverManager;

public class DB {
    public static Connection getConnection() {
        Connection conn = null;
        try {
            String url = "jdbc:mysql://localhost:3306/hero_db";
            String user = "root";
            String pass = ""; // kalau pakai password MySQL, isi di sini

            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(url, user, pass);
            System.out.println("✅ Koneksi berhasil!");
        } catch (Exception e) {
            System.out.println("❌ Gagal koneksi: " + e.getMessage());
        }
        return conn;
    }
}
