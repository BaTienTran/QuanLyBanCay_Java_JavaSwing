/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAO.NhapKhoDAO;
import DTO.NhapKhoDTO;
import java.util.ArrayList;

/**
 *
 * @author PC
 */
public class NhapKhoBUS {
    NhapKhoDAO nhapKhoDAO = new NhapKhoDAO();
    
    public ArrayList<NhapKhoDTO> getAllNhapKho(){
        return nhapKhoDAO.getAllNhapKho();
    }
    
    public NhapKhoDTO getNhapKho(int mapn){
        return nhapKhoDAO.getNhapKho(mapn);
    }
    
    public boolean themNhapKho(NhapKhoDTO nhapKhoDTO){
        return nhapKhoDAO.themNhapKho(nhapKhoDTO);
    }
    
    public int getLastID() {
        return nhapKhoDAO.getLastID();
    }
    
    public long getTongTien(){
        return nhapKhoDAO.getTongTien();
    }
}
