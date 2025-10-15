/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.NhapKhoDTO;
import config.MySQLConnection;
import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author PC
 */
public class NhapKhoDAO {
    Connection con = MySQLConnection.openConnection();
    PreparedStatement pst;
    
    public ArrayList<NhapKhoDTO> getAllNhapKho(){
        ArrayList<NhapKhoDTO> arr = new ArrayList<>();
        if(con!=null){
            try {
                String sql = "select * from phieunhap";
                pst = con.prepareStatement(sql);
                ResultSet rs = pst.executeQuery();
                while(rs.next()){
                    NhapKhoDTO nhapKhoDTO = new NhapKhoDTO();
                    nhapKhoDTO.setMaphieunhap(rs.getInt("maphieunhap"));
                    nhapKhoDTO.setThoigian(rs.getDate("thoigian"));
                    nhapKhoDTO.setManhacungcap(rs.getInt("manhacungcap"));
                    nhapKhoDTO.setManv(rs.getInt("manv"));
                    nhapKhoDTO.setTongtien(rs.getInt("tongtien"));
                    arr.add(nhapKhoDTO);
                }
            } catch (Exception e) {
                System.out.println(e);
            }
        }
        return arr;
    }
    
    public NhapKhoDTO getNhapKho(int mapn){
        NhapKhoDTO nhapKhoDTO = null;
        if(con!=null){
            try {
                String sql = "select * from phieunhap where maphieunhap=?";
                pst = con.prepareStatement(sql);
                pst.setInt(1, mapn);
                ResultSet rs = pst.executeQuery();
                while (rs.next()){
                    int mapnhap = rs.getInt("maphieunhap");
                    Date thoigian = rs.getDate("thoigian");
                    int mancc = rs.getInt("manhacungcap");
                    int manv = rs.getInt("manv");
                    int tongtien = rs.getInt("tongtien");
                    nhapKhoDTO = new NhapKhoDTO(mapnhap, thoigian, mancc, manv, tongtien);
                }
            } catch (Exception e) {
                System.out.println(e);
            }
        }
        return nhapKhoDTO;
    }
    
    public boolean themNhapKho(NhapKhoDTO nhapKhoDTO){
        boolean resutl = false;
        if(con!=null){
            try {
                String sql = "insert into phieunhap (thoigian, manhacungcap, manv, tongtien) values(?,?,?,?)";
                pst = con.prepareStatement(sql);
                pst.setTimestamp(1, new java.sql.Timestamp(new java.util.Date().getTime()));
                pst.setInt(2, nhapKhoDTO.getManhacungcap());
                pst.setInt(3, nhapKhoDTO.getManv());
                pst.setInt(4, nhapKhoDTO.getTongtien());
                if(pst.executeUpdate()>0) resutl = true;
            } catch (Exception e) {
                System.out.println(e);
            }
        }
        return resutl;
    }
    
    public int getLastID() {
        int lastID = -1;
        String query = "SELECT MAX(maphieunhap) FROM phieunhap";
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
                String sql = "SELECT SUM(tongtien) FROM phieunhap";
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
