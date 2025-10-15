/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.KhachHangDTO;
import config.MySQLConnection;
import java.util.ArrayList;
import java.sql.*;
import javax.swing.UIManager;

/**
 *
 * @author PC
 */
public class KhachHangDAO {
    
    Connection connection = MySQLConnection.openConnection();
    PreparedStatement pst;
    
    public ArrayList<KhachHangDTO> getAllKhachHang(){
        ArrayList<KhachHangDTO> arr = new ArrayList<KhachHangDTO>();
        if(connection!=null){
            try {
                String sql = "select * from khachhang where trangthai=1";
                pst = connection.prepareStatement(sql);
                ResultSet rs = pst.executeQuery();
                while (rs.next()){
                    KhachHangDTO khachHangDTO = new KhachHangDTO();
                    khachHangDTO.setMaKhachHang(rs.getInt("makh"));
                    khachHangDTO.setTenKhachHang(rs.getString("tenkhachhang"));
                    khachHangDTO.setDiachi(rs.getString("diachi"));
                    khachHangDTO.setsDT(rs.getString("sdt"));
                    khachHangDTO.setTrangThai(rs.getInt("trangthai"));
                    arr.add(khachHangDTO);
                }
            } catch (Exception e) {
                System.out.println(e);
            }
        }
        return arr;
    }
    
    public boolean themKhachHang(KhachHangDTO khachHangDTO){
        boolean result = false;
        if(connection!=null){
            try {
                String sql = "insert into khachhang (tenkhachhang, diachi, sdt) values (?,?,?)";
                pst = connection.prepareStatement(sql);
                pst.setString(1, khachHangDTO.getTenKhachHang());
                pst.setString(2, khachHangDTO.getDiachi());
                pst.setString(3, khachHangDTO.getsDT());
                if(pst.executeUpdate()>0){
                    result = true;
                }
            } catch (Exception e) {
                System.out.println(e);
            }
        }
        return result;
    }
    
    public boolean suaKhachHang(KhachHangDTO khachHangDTO){
        boolean result = false;
        if(connection!=null){
            try {
                String sql = "update khachhang set tenkhachhang=?, diachi=?, sdt=? where makh=?";
                pst=connection.prepareStatement(sql);
                pst.setString(1, khachHangDTO.getTenKhachHang());
                pst.setString(2, khachHangDTO.getDiachi());
                pst.setString(3, khachHangDTO.getsDT());
                pst.setInt(4, khachHangDTO.getMaKhachHang());
                if(pst.executeUpdate()>0){
                    result = true;
                }
            } catch (Exception e) {
                System.out.println(e);
            }
        }
        return result;
    }
    
    public boolean xoaKhachHang(int makh){
        boolean result = false;
        if(connection!=null){
            try {
                String sql = "update khachhang set trangthai=0 where makh=?";
                pst = connection.prepareStatement(sql);
                pst.setInt(1, makh);
                if(pst.executeUpdate()>0){
                    result = true;
                }
            } catch (Exception e) {
                System.out.println(e);
            }
        }
        return result;
    }
    
    public KhachHangDTO getKhachHangDTO(int makh){
        KhachHangDTO result = null;
        if(connection!=null){
            try {
                String sql = "select * from khachhang where makh=?";
                pst = connection.prepareStatement(sql);
                pst.setInt(1, makh);
                ResultSet rs = pst.executeQuery();
                while(rs.next()){
                    int makhang = rs.getInt("makh");
                    String ten = rs.getString("tenkhachhang");
                    String diachi = rs.getString("diachi");
                    String sdt = rs.getString("sdt");
                    result = new KhachHangDTO(makhang, ten, diachi, sdt);
                }
            } catch (Exception e) {
                System.out.println(e);
            }
        }
        return result;
    }
}
