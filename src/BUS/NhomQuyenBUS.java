/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAO.NhomQuyenDAO;
import DTO.NhomQuyenDTO;
import java.util.ArrayList;

/**
 *
 * @author PC
 */
public class NhomQuyenBUS {
    NhomQuyenDAO nhomQuyenDAO = new NhomQuyenDAO();
    
    public ArrayList<NhomQuyenDTO> getAllNhomQuyen(){
        return nhomQuyenDAO.getAllNhomQuyen();
    }
    
    public NhomQuyenDTO getNhomQuyen(int manq){
        return nhomQuyenDAO.getNhomQuyen(manq);
    }
}
