/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bukutelepon.model;

import java.awt.List;
import javax.swing.table.*;

/**
 *
 * @author Harja
 */
public class tableModelBukuTelepon extends AbstractTableModel {
    List<bukutelepon> ib;
    
    public tableModelBukuTelepon(List<bukutelepon> ib) {
        this.ib = ib;
    }
}
