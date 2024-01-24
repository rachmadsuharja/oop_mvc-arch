/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bukutelepon.controller;

import bukutelepon.dao.daoMediaSosial;
import bukutelepon.dao.implementMediaSosial;
import bukutelepon.model.mediasosial;
import bukutelepon.model.tableModelMediaSosial;
import bukutelepon.view.FrameMedsos;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Kuro
 */
public class controllerMediaSosial {
    FrameMedsos frame;
    implementMediaSosial implMediaSosial; 
    List<mediasosial> lms;
    public controllerMediaSosial (FrameMedsos frame) { 
        this.frame = frame;
        implMediaSosial = new daoMediaSosial (); 
        lms = implMediaSosial.getALL();
    }
    public void reset() {
        frame.getTxtID().setText(""); 
        frame.getTxtNama().setText(""); 
        frame.getTxtInstagram().setText(""); 
        frame.getTxtFacebook().setText("");
        frame.getTxtTwitter().setText("");
    }
    public void isiTable () {
        lms = implMediaSosial.getALL();
        tableModelMediaSosial tmms = new tableModelMediaSosial (lms); 
        frame.getTableData().setModel(tmms);
    }
    public void isiField(int row) {
        frame.getTxtID().setText(lms.get(row).getId().toString()); 
        frame.getTxtNama().setText(lms.get(row).getNama()); 
        frame.getTxtInstagram().setText(lms.get (row).getInstagram()); 
        frame.getTxtFacebook().setText(lms.get (row).getFacebook());
        frame.getTxtTwitter().setText(lms.get (row).getTwitter());
    }
    
    public void insert() {
        mediasosial ms = new mediasosial ();
        ms.setNama(frame.getTxtNama().getText());
        ms.setInstagram(frame.getTxtInstagram().getText());
        ms.setFacebook(frame.getTxtFacebook().getText());
        ms.setTwitter(frame.getTxtTwitter().getText());
        implMediaSosial.insert(ms);
    }
    
    public void update () {
        mediasosial ms = new mediasosial ();
        ms.setNama(frame.getTxtNama().getText());
        ms.setInstagram(frame.getTxtInstagram().getText());
        ms.setFacebook(frame.getTxtFacebook().getText());
        ms.setTwitter(frame.getTxtTwitter().getText());
        ms.setId(Integer.valueOf(frame.getTxtID().getText()));
        implMediaSosial.update(ms);
    }
    
    public void delete() {
        if (!frame.getTxtID().getText().trim().isEmpty()) {
            int id = Integer.parseInt(frame.getTxtID().getText());
            implMediaSosial.delete(id);
        } else {
            JOptionPane.showMessageDialog (frame, "Pilih data yang akan di hapus");
        }
    }
    public void isiTableCariNama() {
        lms = implMediaSosial.getCariNama(frame.getTxtCariNama().getText()); 
        tableModelMediaSosial tmms = new tableModelMediaSosial(lms);
        frame.getTableData().setModel(tmms);
    }
    public void carinama() {
        if (!frame.getTxtCariNama().getText().trim().isEmpty()) { 
            implMediaSosial.getCariNama(frame.getTxtCariNama().getText());
            isiTableCariNama();
        } else {
            JOptionPane.showMessageDialog (frame, "DATA TIDAK TERDAFTAR");
        }
    } 
}
