/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.CTXuatKhoDTO;
import config.MySQLConnection;
import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author PC
 */
public class CTXuatKhoDAO {
    Connection con = MySQLConnection.openConnection();
    PreparedStatement pst;
    
    public ArrayList<CTXuatKhoDTO> getAllCTXuatKho(){
        ArrayList<CTXuatKhoDTO> arr = new ArrayList<>();
        if(con!=null){
            try {
                String sql = "select * from ctphieuxuat";
                pst = con.prepareStatement(sql);
                ResultSet rs = pst.executeQuery();
                while(rs.next()){
                    CTXuatKhoDTO cTXuatKhoDTO = new CTXuatKhoDTO();
                    cTXuatKhoDTO.setMaphieuxuat(rs.getInt("maphieuxuat"));
                    cTXuatKhoDTO.setMasp(rs.getInt("masp"));
                    cTXuatKhoDTO.setSoluong(rs.getInt("soluong"));
                    cTXuatKhoDTO.setDongia(rs.getInt("dongia"));
                    cTXuatKhoDTO.setThanhtien(rs.getInt("thanhtien"));
                    arr.add(cTXuatKhoDTO);
                }
            } catch (Exception e) {
                System.out.println(e);
            }
        }return arr;
    }
    
    public ArrayList<CTXuatKhoDTO> getCTXuatKho(int mapn){
        ArrayList<CTXuatKhoDTO> arr = new ArrayList<>();
        if(con!=null){
            try {
                String sql = "select * from ctphieuxuat where maphieuxuat=?";
                pst = con.prepareStatement(sql);
                pst.setInt(1, mapn);
                ResultSet rs = pst.executeQuery();
                while(rs.next()){
                    CTXuatKhoDTO cTXuatKhoDTO = new CTXuatKhoDTO();
                    cTXuatKhoDTO.setMaphieuxuat(rs.getInt("maphieuxuat"));
                    cTXuatKhoDTO.setMasp(rs.getInt("masp"));
                    cTXuatKhoDTO.setSoluong(rs.getInt("soluong"));
                    cTXuatKhoDTO.setDongia(rs.getInt("dongia"));
                    cTXuatKhoDTO.setThanhtien(rs.getInt("thanhtien"));
                    arr.add(cTXuatKhoDTO);
                }
            } catch (Exception e) {
            }
        }
        return arr;
    }
    
    public CTXuatKhoDTO getCTXuatKhompnmsp(int mapn, int masp){
        CTXuatKhoDTO cTXuatKhoDTO = null;
        if(con!=null){
            try {
                String sql = "select * from ctphieuxuat where maphieuxuat=? and masp=?";
                pst = con.prepareStatement(sql);
                pst.setInt(1, mapn);
                pst.setInt(2, masp);
                ResultSet rs = pst.executeQuery();
                while (rs.next()){
                    cTXuatKhoDTO = new CTXuatKhoDTO();
                    cTXuatKhoDTO.setMaphieuxuat(rs.getInt("maphieuxuat"));
                    cTXuatKhoDTO.setMasp(rs.getInt("masp"));
                    cTXuatKhoDTO.setSoluong(rs.getInt("soluong"));
                    cTXuatKhoDTO.setDongia(rs.getInt("dongia"));
                    cTXuatKhoDTO.setThanhtien(rs.getInt("thanhtien"));
                }
            } catch (Exception e) {
                System.out.println(e);
            }
        }
        return cTXuatKhoDTO;
    }
    
    public boolean themCTXuatKho(CTXuatKhoDTO cTXuatKhoDTO){
        PreparedStatement pstUpSoLuong, pstThem;
        boolean result = false;
        if(con!=null){
            try {
                String sqlUp = "update sanpham set soluongton = soluongton-? where masp=?";
                pstUpSoLuong = con.prepareStatement(sqlUp);
                pstUpSoLuong.setInt(1, cTXuatKhoDTO.getSoluong());
                pstUpSoLuong.setInt(2, cTXuatKhoDTO.getMasp());
                pstUpSoLuong.executeUpdate();
                
                String sqlthem = "insert into ctphieuxuat(maphieuxuat, masp, soluong, dongia, thanhtien) values (?,?,?,?,?)";
                pstThem = con.prepareStatement(sqlthem);
                pstThem.setInt(1, cTXuatKhoDTO.getMaphieuxuat());
                pstThem.setInt(2, cTXuatKhoDTO.getMasp());
                pstThem.setInt(3, cTXuatKhoDTO.getSoluong());
                pstThem.setInt(4, cTXuatKhoDTO.getDongia());
                pstThem.setInt(5, cTXuatKhoDTO.getThanhtien());
                if(pstThem.executeUpdate()>0) result = true;
            } catch (Exception e) {
                System.out.println(e);
            }
        }
        return result;
    }
}
