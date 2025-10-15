/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAO.NhanVienDAO;
import DTO.NhanVienDTO;
import java.util.ArrayList;
 
public class NhanVienBUS {
    NhanVienDAO nhanVienDAO = new NhanVienDAO();
    public NhanVienBUS() {
    }
    
    public ArrayList<NhanVienDTO> getAllNhanVien(){
        return nhanVienDAO.getAllNhanVien();
    }
    
    public boolean themNhanVien(NhanVienDTO nhanVienDTO){
        return nhanVienDAO.themNhanVien(nhanVienDTO);
    }
    public boolean xoaNhanVien(int manv){
        return nhanVienDAO.xoaNhanVien(manv);
    }
    
    public boolean suaNhanVien(NhanVienDTO nhanVienDTO){
        return nhanVienDAO.suaNhanVien(nhanVienDTO);
    }
    public NhanVienDTO selectByID(int manv){
        return nhanVienDAO.selectById(manv);
    }
}
