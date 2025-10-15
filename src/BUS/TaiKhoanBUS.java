/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAO.TaiKhoanDAO;
import DTO.TaiKhoanDTO;
import java.util.ArrayList;

public class TaiKhoanBUS {
    TaiKhoanDAO taiKhoanDAO = new TaiKhoanDAO();
    public TaiKhoanBUS() {
    }
    
    public ArrayList<TaiKhoanDTO> getAllTaiKhoan(){
        return taiKhoanDAO.getAllTaiKhoan();
    }
    
    public boolean themTaiKhoan(TaiKhoanDTO taiKhoanDTO){
        return taiKhoanDAO.themTaiKhoan(taiKhoanDTO);
    }
    public boolean xoaTaiKhoan(int manv){
        return taiKhoanDAO.xoaTaiKhoan(manv);
    }
    
    public boolean suaTaiKhoan(TaiKhoanDTO taiKhoanDTO){
        return taiKhoanDAO.suaTaiKhoan(taiKhoanDTO);
    }
    public TaiKhoanDTO selectByID(int makh){
        return taiKhoanDAO.selectById(makh);
    }
    
    public TaiKhoanDTO dangnhap(String tk, String mk){
        return taiKhoanDAO.dangnhap(tk, mk);
    }
}
