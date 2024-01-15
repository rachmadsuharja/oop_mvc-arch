/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bukutelepon.model;

/**
 *
 * @author Harja
 */
public class bukutelepon {
    private Integer id;
    private String nomer;
    private String nama;
    private String alamat;
    
    public String getAlamat() {
        return alamat;
    }
    
    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }
    
    public Integer getId() {
        return id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    
    public String getNama() {
        return nama;
    }
    
    public void setNama(String nama) {
        this.nama = nama;
    }
    
    public String getNomer() {
        return nomer;
    }
    
    public void setNomer(String nomer) {
        this.nomer = nomer;
    }
}
