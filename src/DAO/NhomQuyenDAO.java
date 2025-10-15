/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.NhomQuyenDTO;
import config.MySQLConnection;
import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author PC
 */
public class NhomQuyenDAO {
    
    Connection con = MySQLConnection.openConnection();
    PreparedStatement pst;
    
    public ArrayList<NhomQuyenDTO> getAllNhomQuyen(){
        ArrayList<NhomQuyenDTO> arr = new ArrayList<>();
        if(con!=null){
            try {
                String sql = "select * from nhomquyen";
                pst = con.prepareStatement(sql);
                ResultSet rs = pst.executeQuery();
                while(rs.next()){
                    NhomQuyenDTO nhomQuyenDTO = new NhomQuyenDTO();
                    nhomQuyenDTO.setMaNhomQuyen(rs.getInt("manhomquyen"));
                    nhomQuyenDTO.setTenNhomQuyen(rs.getString("tennhomquyen"));
                    arr.add(nhomQuyenDTO);
                }
            } catch (Exception e) {
                System.out.println(e);
            }
        }
        return arr;
    }
    
    public NhomQuyenDTO getNhomQuyen(int manq){
        NhomQuyenDTO nhomQuyenDTO = null;
        if(con!=null){
            try {
                String sql = "select * from nhomquyen where manhomquyen=?";
                pst = con.prepareStatement(sql);
                pst.setInt(1, manq);
                ResultSet rs = pst.executeQuery();
                while(rs.next()){
                    int manhom = rs.getInt("manhomquyen");
                    String ten = rs.getString("tennhomquyen");
                    nhomQuyenDTO = new NhomQuyenDTO(manhom, ten);
                }
            } catch (Exception e) {
                System.out.println(e);
            }
        }
        return nhomQuyenDTO;
    }
}
