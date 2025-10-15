/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAO.KhachHangDAO;
import DTO.KhachHangDTO;
import java.util.ArrayList;

/**
 *
 * @author PC
 */
public class KhachHangBUS {
    KhachHangDAO khachHangDAO = new KhachHangDAO();
    
    public ArrayList<KhachHangDTO> getAllKhachHang(){
        return khachHangDAO.getAllKhachHang();
    }
    
    public boolean themKhachHang(KhachHangDTO khachHangDTO){
        return khachHangDAO.themKhachHang(khachHangDTO);
    }
    
    public boolean suaKhachHang(KhachHangDTO khachHangDTO){
        return khachHangDAO.suaKhachHang(khachHangDTO);
    }
    
    public boolean xoaKhachHang(int makh){
        return khachHangDAO.xoaKhachHang(makh);
    }
    
    public KhachHangDTO getKhachHang(int makh){
        return khachHangDAO.getKhachHangDTO(makh);
    }
}
