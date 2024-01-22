/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bukutelepon.controller;

import bukutelepon.dao.daoBukuTelepon;
import bukutelepon.dao.implementBukuTelepon; 
import bukutelepon.model.bukutelepon;
import bukutelepon.model.tableModelBukuTelepon; 
import bukutelepon.view.FrameTelepon;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Harja
 */
public class controllerBukuTelepon {
    FrameTelepon frame;
    implementBukuTelepon implBukuTelepon; 
    List<bukutelepon> lb;
    public controllerBukuTelepon (FrameTelepon frame) { 
        this.frame = frame;
        implBukuTelepon = new daoBukuTelepon (); 
        lb = implBukuTelepon.getALL();
    }
    public void reset() {
        frame.getTxtID().setText(""); 
        frame.getTxtNoTelp().setText(""); 
        frame.getTxtNama().setText(""); 
        frame.getTxtAlamat().setText("");
        frame.getTxtHubungan().setText("");
    }
    public void isiTable () {
        lb = implBukuTelepon.getALL();
        tableModelBukuTelepon tmb = new tableModelBukuTelepon (lb); 
        frame.getTableData().setModel (tmb);
    }
    public void isiField(int row) {
        frame.getTxtID().setText(lb.get(row).getId().toString()); 
        frame.getTxtNoTelp().setText(lb.get (row).getNomer()); 
        frame.getTxtNama().setText(lb.get(row).getNama()); 
        frame.getTxtAlamat().setText(lb.get (row).getAlamat());
        frame.getTxtHubungan().setText(lb.get (row).getHubungan());
    }
    
    public void insert() {
        bukutelepon b = new bukutelepon ();
        b.setNomer(frame.getTxtNoTelp().getText());
        b.setNama(frame.getTxtNama().getText());
        b.setAlamat(frame.getTxtAlamat().getText());
        b.setHubungan(frame.getTxtHubungan().getText());
        implBukuTelepon.insert(b);
    }
    
    public void update () {
        bukutelepon b = new bukutelepon();
        b.setNomer(frame.getTxtNoTelp().getText());
        b.setNama(frame.getTxtNama().getText());
        b.setAlamat(frame.getTxtAlamat().getText());
        b.setHubungan(frame.getTxtHubungan().getText());
        b.setId(Integer.valueOf(frame.getTxtID().getText())); 
        implBukuTelepon.update(b);
    }
    
    public void delete() {
        if (!frame.getTxtID().getText().trim().isEmpty()) {
            int id = Integer.parseInt(frame.getTxtID().getText());
            implBukuTelepon.delete(id);
        } else {
            JOptionPane.showMessageDialog (frame, "Pilih data yang akan di hapus");
        }
    }
    public void isiTableCariNama() {
        lb = implBukuTelepon.getCariNama(frame.getTxtCariNama().getText()); 
        tableModelBukuTelepon tmb = new tableModelBukuTelepon(lb);
        frame.getTableData().setModel(tmb);
    }
    public void carinama() {
        if (!frame.getTxtCariNama().getText().trim().isEmpty()) { 
            implBukuTelepon.getCariNama(frame.getTxtCariNama().getText());
            isiTableCariNama();
        } else {
            JOptionPane.showMessageDialog (frame, "DATA TIDAK TERDAFTAR");
        }
    } 
}
