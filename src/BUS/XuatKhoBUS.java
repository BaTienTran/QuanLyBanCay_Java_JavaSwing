/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAO.XuatKhoDAO;
import DTO.XuatKhoDTO;
import java.util.ArrayList;

/**
 *
 * @author PC
 */
public class XuatKhoBUS {
    XuatKhoDAO xuatKhoDAO = new XuatKhoDAO();
    
    public ArrayList<XuatKhoDTO> getAllXuatKho(){
        return xuatKhoDAO.getAllXuatKho();
    }
    
    public XuatKhoDTO getXuatKho(int maxk){
        return xuatKhoDAO.getXuatKho(maxk);
    }
    
    public boolean themXuatKho(XuatKhoDTO xuatKhoDTO){
        return xuatKhoDAO.themXuatKho(xuatKhoDTO);
    }
    
    public int getLastID() {
        return xuatKhoDAO.getLastID();
    }
    
    public long getTongTien(){
        return xuatKhoDAO.getTongTien();
    }
}
