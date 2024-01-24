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
public interface implementMediaSosial {
    public void insert(mediasosial m);
    public void update(mediasosial m);
    public void delete(int id);
    public List<mediasosial> getALL();
    public List<mediasosial> getCariNama(String nama);
}
