/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAO.CTNhapKhoDAO;
import DTO.CTNhapKhoDTO;
import java.util.ArrayList;

/**
 *
 * @author PC
 */
public class CTNhapKhoBUS {
    CTNhapKhoDAO cTNhapKhoDAO = new CTNhapKhoDAO();
    
    public ArrayList<CTNhapKhoDTO> getAllCTNhapKhoDTO(){
        return cTNhapKhoDAO.getAllCTNhapKho();
    }
    
    public ArrayList<CTNhapKhoDTO> getCTNhapKho(int mactnk){
        return cTNhapKhoDAO.getCTNhapKho(mactnk);
    }
    
    public CTNhapKhoDTO getCTNhapKhompnmsp(int mapn, int masp){
        return cTNhapKhoDAO.getCTNhapKhompnmsp(mapn, masp);
    }
    
    public boolean themCTNhapKho(CTNhapKhoDTO cTNhapKhoDTO){
        return cTNhapKhoDAO.themCTNhapKho(cTNhapKhoDTO);
    }
}
