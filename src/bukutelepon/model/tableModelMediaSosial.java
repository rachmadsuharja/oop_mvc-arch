/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bukutelepon.model;

import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Kuro
 */
public class tableModelMediaSosial extends AbstractTableModel {
    List<mediasosial> lms;
    
    public tableModelMediaSosial(List<mediasosial> lsm) {
        this.lms = lsm;
    }
    
    /**
     *
     * @return
     */
    @Override
    public int getRowCount() {
        return lms.size();
    }

    @Override
    public int getColumnCount() {
        return 5;
    }
    

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "ID";
            case 1:
                return "Nama";
            case 2:
                return "Instagram";
            case 3:
                return "Facebook";
            case 4:
                return "Twitter";
            default:
                return null;
        }
    }

    @Override
    public Object getValueAt(int row, int column) {
        switch (column) {
            case 0:
                return lms.get(row).getId();
            case 1:
                return lms.get(row).getNama();
            case 2:
                return lms.get(row).getInstagram();
            case 3:
                return lms.get(row).getFacebook();
            case 4:
                return lms.get(row).getTwitter();
            default:
                return null;
        }
    }
}
