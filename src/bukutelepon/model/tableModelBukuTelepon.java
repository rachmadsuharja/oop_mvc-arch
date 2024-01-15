/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bukutelepon.model;

import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Harja
 */
public class tableModelBukuTelepon extends AbstractTableModel {
    List<bukutelepon> lb;
    
    public tableModelBukuTelepon(List<bukutelepon> lb) {
        this.lb = lb;
    }

    @Override
    public int getColumnCount() {
        return 4;
    }
    
    @Override
    public int getRowCount() {
        return lb.size();
    }

    
    public String getColumnNama(int column) {
        switch (column) {
            case 0:
                return "ID";
            case 1:
                return "Nomer";
            case 2:
                return "Nama";
            case 3:
                return "Alamat";
            default:
                return null;
        }
    }

    @Override
    public Object getValueAt(int row, int column) {
        switch (column) {
            case 0:
                return lb.get(row).getId();
            case 1:
                return lb.get(row).getNomer();
            case 2:
                return lb.get(row).getNama();
            case 3:
                return lb.get(row).getAlamat();
            default:
                return null;
        }
    }
}
