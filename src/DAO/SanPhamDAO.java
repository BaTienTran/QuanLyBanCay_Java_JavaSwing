/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.SanPhamDTO;
import config.MySQLConnection;
import java.util.ArrayList;
import java.sql.*;

/**
 *
 * @author PC
 */
public class SanPhamDAO {
    Connection con = MySQLConnection.openConnection();
    PreparedStatement pst;
    
    public ArrayList<SanPhamDTO> getAllSanPham(){
        ArrayList<SanPhamDTO> arr = new ArrayList<SanPhamDTO>();
        if(con!=null){
            try {
                String sql = "select * from sanpham where trangthai=1";
                pst = con.prepareStatement(sql);
                ResultSet rs = pst.executeQuery();
                while(rs.next()){
                    SanPhamDTO sanPhamDTO = new SanPhamDTO();
                    sanPhamDTO.setMaSP(rs.getInt("masp"));
                    sanPhamDTO.setTenSP(rs.getString("tensp"));
                    sanPhamDTO.setNhaCC(rs.getInt("nhacungcap"));
                    sanPhamDTO.setSoLuongTon(rs.getInt("soluongton"));
                    sanPhamDTO.setTrangThai(rs.getInt("trangthai"));
                    sanPhamDTO.setGiaXuat(rs.getInt("giaxuat"));
                    arr.add(sanPhamDTO);
                }
            } catch (Exception e) {
                System.out.println(e);
            }
        }
        return arr;
    }
    
    public boolean themSanPham(SanPhamDTO sanPhamDTO){
        boolean result = false;
        if(con!=null){
            try {
                String sql = "insert into sanpham (tensp, nhacungcap, soluongton, giaxuat) values (?,?,?,?)";
                pst = con.prepareStatement(sql);
                pst.setString(1, sanPhamDTO.getTenSP());
                pst.setInt(2, sanPhamDTO.getNhaCC());
                pst.setInt(3, sanPhamDTO.getSoLuongTon());
                pst.setInt(4, sanPhamDTO.getGiaXuat());
                if(pst.executeUpdate()>0){
                    result = true;
                }
            } catch (Exception e) {
                System.out.println(e);
            }
        }
        return result;
    }
    
    public boolean suaSanPham(SanPhamDTO sanPhamDTO){
        boolean result = false;
        if(con!=null){
            try {
                con = MySQLConnection.openConnection();
                String sql = "update sanpham set tensp=?, nhacungcap=?, soluongton=?, giaxuat=? where masp=?";
                pst = con.prepareStatement(sql);
                pst.setString(1, sanPhamDTO.getTenSP());
                pst.setInt(2, sanPhamDTO.getNhaCC());
                pst.setInt(3, sanPhamDTO.getSoLuongTon());
                pst.setInt(4, sanPhamDTO.getGiaXuat());
                pst.setInt(5, sanPhamDTO.getMaSP());
                if(pst.executeUpdate()>0){
                    result = true;
                }
            } catch (Exception e) {
                System.out.println(e);
            }
        }
        return result;
    }
    
    public boolean xoaSanPham(int masp){
        boolean result = false;
        if(con!=null){
            try {
                String sql = "update sanpham set trangthai=0 where masp=?";
                pst = con.prepareStatement(sql);
                pst.setInt(1, masp);
                if(pst.executeUpdate()>0){
                    result = true;
                }
            } catch (Exception e) {
                System.out.println(e);
            }
            
        }
        return result;
    }
    
    public SanPhamDTO getSanPham(int masp){
        SanPhamDTO sanPhamDTO = null;
        if(con!=null){
            try {
                String sql = "select * from sanpham where masp=?";
                pst = con.prepareStatement(sql);
                pst.setInt(1, masp);
                ResultSet rs = pst.executeQuery();
                while(rs.next()){
                    int maspham = rs.getInt("masp");
                    String ten = rs.getString("tensp");
                    int ncc = rs.getInt("nhacungcap");
                    int soluongton = rs.getInt("soluongton");
                    int giaxuat = rs.getInt("giaxuat");
                    int trangthai = rs.getInt("trangthai");
                    sanPhamDTO = new SanPhamDTO(maspham, ten, ncc, soluongton, trangthai, giaxuat);
                }
            } catch (Exception e) {
                System.out.println(e);
            }
        }
        return  sanPhamDTO;
    }

}
