package config;
import java.sql.Connection;
import java.sql.DriverManager;

public class MySQLConnection {
    private static Connection con;
    private static final String URL = "jdbc:mysql://localhost:3306/quanlybancay"; // URL của cơ sở dữ liệu
    private static final String USER = "root"; // Tên người dùng MySQL
    private static final String PASSWORD = ""; // Mật khẩu MySQL
    public static Connection openConnection(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(URL, USER, PASSWORD);
            return con;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }

    public static void closeConnection(){      
        try {
            if(con!=null)   con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}