/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.koneksi to edit this template
 */
package koneksi;

import com.mysql.cj.jdbc.Driver;
import java.sql.*;

/**
 *
 * @author Harja
 */
public class koneksi {
    static Connection con;
    
    public static Connection connection() {
        if (con == null) {
            try {
                String url = "jdbc:mysql://localhost:3306/java_mvc";
                String username = "root";
                String password = "";
                Class.forName("com.mysql.cj.jdbc.Driver");
                con = DriverManager.getConnection(url, username, password);
                System.out.println("Koneksi sukses!");
            } catch (ClassNotFoundException | SQLException e) {
                System.out.println("Koneksi gagal! Error: " + e.getMessage());
            }
        }
        return con;
    }
    
}
