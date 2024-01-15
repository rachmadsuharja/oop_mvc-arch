/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bukutelepon.dao;

import koneksi.koneksi;
import bukutelepon.model.bukutelepon;
import java.sql.*;
import java.util.*;

/**
 *
 * @author Harja
 */
public class daoBukuTelepon implements implementBukuTelepon{
    Connection connection;
    final String insert = "INSERT INTO bukutelepon (nomer, nama, alamat) VALUES (?, ?, ?);";
    final String update = "UPDATE bukutelepon SET nomer=?, nama=?, alamat=? where id=?;";
    final String delete = "DELETE FROM bukutelepon where id=?;";
    final String select = "SELECT * FROM bukutelepon;";
    final String carinama = "SELECT * FROM bukutelepon where nama like ?;";
    
    public daoBukuTelepon() {
        connection = koneksi.connection();
    }

    @Override
    public void insert(bukutelepon b) {
        PreparedStatement stm = null;
        try {
            stm = connection.prepareStatement(insert);
            stm.setString(1, b.getNomer());
            stm.setString(2, b.getNama());
            stm.setString(3, b.getAlamat());
            stm.executeUpdate();
            ResultSet rs = stm.getGeneratedKeys();
            while (rs.next()) {
                b.setId(rs.getInt(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                stm.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void update(bukutelepon b) {
        PreparedStatement stm = null;
        try {
            stm = connection.prepareStatement(update);
            stm.setString(1, b.getNomer());
            stm.setString(2, b.getNama());
            stm.setString(3, b.getAlamat());
            stm.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                stm.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void delete(int id) {
        PreparedStatement stm = null;
        try {
            stm = connection.prepareStatement(delete);
            stm.setInt(1, id);
            stm.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                stm.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public List<bukutelepon> getALL() {
        List<bukutelepon> lb = null;
        try {
            lb = new ArrayList<bukutelepon>();
            Statement stm = connection.createStatement();
            ResultSet rs = stm.executeQuery(select);
            while (rs.next()) {
                bukutelepon b = new bukutelepon();
                b.setId(rs.getInt("id"));
                b.setNomer(rs.getString("nomer"));
                b.setNama(rs.getString("nama"));
                b.setAlamat(rs.getString("alamat"));
                lb.add(b);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return lb;
    }

    @Override
    public List<bukutelepon> getCariNama(String nama) {
        List<bukutelepon> lb = null;
        try {
            lb = new ArrayList<bukutelepon>();
            Statement stm = connection.createStatement();
            ResultSet rs = stm.executeQuery(carinama);
            while (rs.next()) {
                bukutelepon b = new bukutelepon();
                b.setId(rs.getInt("id"));
                b.setNomer(rs.getString("nomer"));
                b.setNama(rs.getString("nama"));
                b.setAlamat(rs.getString("alamat"));
                lb.add(b);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return lb;
    }

    @Override
    public void delete(bukutelepon b) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
