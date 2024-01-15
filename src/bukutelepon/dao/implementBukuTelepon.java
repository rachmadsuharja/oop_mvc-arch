/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package bukutelepon.dao;

import java.util.List;
import bukutelepon.model.*;

/**
 *
 * @author Harja
 */
public interface implementBukuTelepon {
    public void insert(bukutelepon b);
    public void update(bukutelepon b);
    public void delete(bukutelepon b);
    public List<bukutelepon> getALL();
    public List<bukutelepon> getCariNama(String nama);
}
