/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.CTNhapKhoDTO;
import java.sql.*;
import config.MySQLConnection;
import java.util.ArrayList;

/**
 *
 * @author PC
 */
public class CTNhapKhoDAO {
    Connection con = MySQLConnection.openConnection();
    PreparedStatement pst;
    
    public ArrayList<CTNhapKhoDTO> getAllCTNhapKho(){
        ArrayList<CTNhapKhoDTO> arr = new ArrayList<>();
        if(con!=null){
            try {
                String sql = "select * from ctphieunhap";
                pst = con.prepareStatement(sql);
                ResultSet rs = pst.executeQuery();
                while(rs.next()){
                    CTNhapKhoDTO cTNhapKhoDTO = new CTNhapKhoDTO();
                    cTNhapKhoDTO.setMaphieunhap(rs.getInt("maphieunhap"));
                    cTNhapKhoDTO.setMasp(rs.getInt("masp"));
                    cTNhapKhoDTO.setSoluong(rs.getInt("soluong"));
                    cTNhapKhoDTO.setDongia(rs.getInt("dongia"));
                    cTNhapKhoDTO.setThanhtien(rs.getInt("thanhtien"));
                    arr.add(cTNhapKhoDTO);
                }
            } catch (Exception e) {
                System.out.println(e);
            }
        }return arr;
    }
    
    public ArrayList<CTNhapKhoDTO> getCTNhapKho(int mapn){
        ArrayList<CTNhapKhoDTO> arr = new ArrayList<>();
        if(con!=null){
            try {
                String sql = "select * from ctphieunhap where maphieunhap=?";
                pst = con.prepareStatement(sql);
                pst.setInt(1, mapn);
                ResultSet rs = pst.executeQuery();
                while(rs.next()){
                    CTNhapKhoDTO cTNhapKhoDTO = new CTNhapKhoDTO();
                    cTNhapKhoDTO.setMaphieunhap(rs.getInt("maphieunhap"));
                    cTNhapKhoDTO.setMasp(rs.getInt("masp"));
                    cTNhapKhoDTO.setSoluong(rs.getInt("soluong"));
                    cTNhapKhoDTO.setDongia(rs.getInt("dongia"));
                    cTNhapKhoDTO.setThanhtien(rs.getInt("thanhtien"));
                    arr.add(cTNhapKhoDTO);
                }
            } catch (Exception e) {
            }
        }
        return arr;
    }
    
    public CTNhapKhoDTO getCTNhapKhompnmsp(int mapn, int masp){
        CTNhapKhoDTO cTNhapKhoDTO = null;
        if(con!=null){
            try {
                String sql = "select * from ctphieunhap where maphieunhap=? and masp=?";
                pst = con.prepareStatement(sql);
                pst.setInt(1, mapn);
                pst.setInt(2, masp);
                ResultSet rs = pst.executeQuery();
                while (rs.next()){
                    cTNhapKhoDTO = new CTNhapKhoDTO();
                    cTNhapKhoDTO.setMaphieunhap(rs.getInt("maphieunhap"));
                    cTNhapKhoDTO.setMasp(rs.getInt("masp"));
                    cTNhapKhoDTO.setSoluong(rs.getInt("soluong"));
                    cTNhapKhoDTO.setDongia(rs.getInt("dongia"));
                    cTNhapKhoDTO.setThanhtien(rs.getInt("thanhtien"));
                }
            } catch (Exception e) {
                System.out.println(e);
            }
        }
        return cTNhapKhoDTO;
    }
    
    public boolean themCTNhapKho(CTNhapKhoDTO cTNhapKhoDTO){
        PreparedStatement pstUpSoLuong, pstThem;
        boolean result = false;
        if(con!=null){
            try {
                String sqlUp = "update sanpham set soluongton = soluongton+? where masp=?";
                pstUpSoLuong = con.prepareStatement(sqlUp);
                pstUpSoLuong.setInt(1, cTNhapKhoDTO.getSoluong());
                pstUpSoLuong.setInt(2, cTNhapKhoDTO.getMasp());
                pstUpSoLuong.executeUpdate();
                
                String sqlthem = "insert into ctphieunhap(maphieunhap, masp, soluong, dongia, thanhtien) values (?,?,?,?,?)";
                pstThem = con.prepareStatement(sqlthem);
                pstThem.setInt(1, cTNhapKhoDTO.getMaphieunhap());
                pstThem.setInt(2, cTNhapKhoDTO.getMasp());
                pstThem.setInt(3, cTNhapKhoDTO.getSoluong());
                pstThem.setInt(4, cTNhapKhoDTO.getDongia());
                pstThem.setInt(5, cTNhapKhoDTO.getThanhtien());
                if(pstThem.executeUpdate()>0) result = true;
            } catch (Exception e) {
                System.out.println(e);
            }
        }
        return result;
    }
}
