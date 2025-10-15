/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.XuatKhoDTO;
import config.MySQLConnection;
import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author PC
 */
public class XuatKhoDAO {
    Connection con = MySQLConnection.openConnection();
    PreparedStatement pst;
    
    public ArrayList<XuatKhoDTO> getAllXuatKho(){
        ArrayList<XuatKhoDTO> arr = new ArrayList<>();
        if(con!=null){
            try {
                String sql = "select * from phieuxuat";
                pst = con.prepareStatement(sql);
                ResultSet rs = pst.executeQuery();
                while(rs.next()){
                    XuatKhoDTO xuatKhoDTO = new XuatKhoDTO();
                    xuatKhoDTO.setMaphieuxuat(rs.getInt("maphieuxuat"));
                    xuatKhoDTO.setThoigian(rs.getDate("thoigian"));                
                    xuatKhoDTO.setTongtien(rs.getInt("tongtien"));
                    xuatKhoDTO.setManv(rs.getInt("manv"));
                    xuatKhoDTO.setMakh(rs.getInt("makh"));
                    arr.add(xuatKhoDTO);
                }
            } catch (Exception e) {
                System.out.println(e);
            }
        }
        return arr;
    }
    
    public XuatKhoDTO getXuatKho(int mapx){
        XuatKhoDTO xuatKhoDTO = null;
        if(con!=null){
            try {
                String sql = "select * from phieuxuat where maphieuxuat=?";
                pst = con.prepareStatement(sql);
                pst.setInt(1, mapx);
                ResultSet rs = pst.executeQuery();
                while (rs.next()){
                    int mapxuat = rs.getInt("maphieuxuat");
                    Date thoigian = rs.getDate("thoigian");
                    int tongtien = rs.getInt("tongtien");
                    int manv = rs.getInt("manv");
                    int makh = rs.getInt("makh");
                    xuatKhoDTO = new XuatKhoDTO(mapxuat, thoigian, tongtien, manv, makh);
                }
            } catch (Exception e) {
                System.out.println(e);
            }
        }
        return xuatKhoDTO;
    }
    
    public boolean themXuatKho(XuatKhoDTO xuatKhoDTO){
        boolean resutl = false;
        if(con!=null){
            try {
                String sql = "insert into phieuxuat (thoigian, tongtien, manv, makh) values(?,?,?,?)";
                pst = con.prepareStatement(sql);
                pst.setTimestamp(1, new java.sql.Timestamp(new java.util.Date().getTime()));
                pst.setInt(2, xuatKhoDTO.getTongtien());
                pst.setInt(3, xuatKhoDTO.getManv());
                pst.setInt(4, xuatKhoDTO.getMakh());
                if(pst.executeUpdate()>0) resutl = true;
            } catch (Exception e) {
                System.out.println(e);
            }
        }
        return resutl;
    }
    
    public int getLastID() {
        int lastID = -1;
        String query = "SELECT MAX(maphieuxuat) FROM phieuxuat";
        try {
            con = MySQLConnection.openConnection();
            pst = con.prepareStatement(query);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                lastID = rs.getInt(1);
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lastID;
    }
    
    public long getTongTien() {
        long tongTien = 0;
        if (con != null) {
            try {
                String sql = "SELECT SUM(tongtien) FROM phieuxuat";
                pst = con.prepareStatement(sql);
                ResultSet rs = pst.executeQuery();
                if (rs.next()) {
                    tongTien = rs.getLong(1);
                }
            } catch (Exception e) {
                System.out.println(e);
            }
        }
        return tongTien;
    }
}
