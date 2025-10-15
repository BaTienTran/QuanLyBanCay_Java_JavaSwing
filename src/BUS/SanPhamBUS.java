/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAO.SanPhamDAO;
import DTO.SanPhamDTO;
import java.util.ArrayList;

/**
 *
 * @author PC
 */
public class SanPhamBUS {
    
    SanPhamDAO sanPhamDAO = new SanPhamDAO();
    
    public ArrayList<SanPhamDTO> getAllSanPham(){
        return sanPhamDAO.getAllSanPham();
    }
    
    public boolean themSanPham(SanPhamDTO sanPhamDTO){
        return sanPhamDAO.themSanPham(sanPhamDTO);
    }
    
    public boolean suaSanPham(SanPhamDTO sanPhamDTO){
        return sanPhamDAO.suaSanPham(sanPhamDTO);
    }
    
    public boolean xoaSanPham(int masp){
        return sanPhamDAO.xoaSanPham(masp);
    }
    
    public SanPhamDTO getSanPham(int masp){
        return sanPhamDAO.getSanPham(masp);
    }
}
