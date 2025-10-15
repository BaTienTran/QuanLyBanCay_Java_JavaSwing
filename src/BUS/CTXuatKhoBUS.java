/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAO.CTXuatKhoDAO;
import DTO.CTXuatKhoDTO;
import java.util.ArrayList;

/**
 *
 * @author PC
 */
public class CTXuatKhoBUS {
    CTXuatKhoDAO cTXuatKhoDAO = new CTXuatKhoDAO();
    
    public ArrayList<CTXuatKhoDTO> getAllCTXuatKhoDTO(){
        return cTXuatKhoDAO.getAllCTXuatKho();
    }
    
    public ArrayList<CTXuatKhoDTO> getCTXuatKho(int mactnk){
        return cTXuatKhoDAO.getCTXuatKho(mactnk);
    }
    
    public CTXuatKhoDTO getCTXuatKhompnmsp(int mapn, int masp){
        return cTXuatKhoDAO.getCTXuatKhompnmsp(mapn, masp);
    }
    
    public boolean themCTXuatKho(CTXuatKhoDTO cTXuatKhoDTO){
        return cTXuatKhoDAO.themCTXuatKho(cTXuatKhoDTO);
    }
}
