/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bukutelepon.dao;

import bukutelepon.koneksi.koneksi;
import bukutelepon.model.mediasosial;
import java.sql.*;
import java.util.*;

/**
 *
 * @author Harja
 */
public class daoMediaSosial implements implementMediaSosial{
    Connection connection;
    final String insert = "INSERT INTO mediasosial (nama, instagram, facebook, twitter) VALUES (?, ?, ?, ?);";
    final String update = "UPDATE mediasosial SET nama=?, instagram=?, facebook=?, twitter=? where id=?;";
    final String delete = "DELETE FROM mediasosial where id=?;";
    final String select = "SELECT * FROM mediasosial;";
    final String carinama = "SELECT * FROM mediasosial where nama like ?;";
    
    public daoMediaSosial() {
        connection = koneksi.connection();
    }

    @Override
    public void insert(mediasosial m) {
        PreparedStatement stm = null;
        try {
            stm = connection.prepareStatement(insert, Statement.RETURN_GENERATED_KEYS);
          
            stm.setString(1, m.getNama());
            stm.setString(2, m.getInstagram());
            stm.setString(3, m.getFacebook());
            stm.setString(4, m.getTwitter());
            stm.executeUpdate();
            
            ResultSet rs = stm.getGeneratedKeys();
            while (rs.next()) {
                m.setId(rs.getInt(1));
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
    public void update(mediasosial m) {
        PreparedStatement stm = null;
        try {
            stm = connection.prepareStatement(update);
            stm.setString(1, m.getNama());
            stm.setString(2, m.getInstagram());
            stm.setString(3, m.getFacebook());
            stm.setString(4, m.getTwitter());
            stm.setInt(5, m.getId());
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

    /**
     *
     * @param id
     */
    @Override
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
    public List<mediasosial> getALL() {
        List<mediasosial> lms = null;
        try {
            lms = new ArrayList<mediasosial>();
            Statement stm = connection.createStatement();
            ResultSet rs = stm.executeQuery(select);
            while (rs.next()) {
                mediasosial m = new mediasosial();
                m.setId(rs.getInt("id"));
                m.setNama(rs.getString("nama"));
                m.setInstagram(rs.getString("instagram"));
                m.setFacebook(rs.getString("facebook"));
                m.setTwitter(rs.getString("twitter"));
                lms.add(m);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return lms;
    }

    @Override
    public List<mediasosial> getCariNama(String nama) {
        List<mediasosial> lms = null;
        try {
            lms = new ArrayList<mediasosial>();
            PreparedStatement st = connection.prepareStatement(carinama);
            st.setString(1, '%' + nama + '%');
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                mediasosial m = new mediasosial();
                m.setId(rs.getInt("id"));
                m.setNama(rs.getString("nama"));
                m.setInstagram(rs.getString("instagram"));
                m.setFacebook(rs.getString("facebook"));
                m.setTwitter(rs.getString("twitter"));
                lms.add(m);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return lms;
    }

}
