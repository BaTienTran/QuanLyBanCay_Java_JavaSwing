package DAO;

import DTO.NhaCungCapDTO;
import config.MySQLConnection;
import java.util.ArrayList;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class NhaCungCapDAO {
    Connection connection = MySQLConnection.openConnection();
    PreparedStatement pst;
    public ArrayList<NhaCungCapDTO> getAllNhaCungCap(){
        ArrayList<NhaCungCapDTO> arr = new ArrayList<NhaCungCapDTO>();
        if(connection!=null){
            try {
                String sql = "select * from nhacungcap where trangthai = 1";
                pst = connection.prepareStatement(sql);
                ResultSet rs = pst.executeQuery();
                while(rs.next()){
                    NhaCungCapDTO nhaCungCapDTO = new NhaCungCapDTO();
                    nhaCungCapDTO.setMaNhaCungCap(rs.getInt("manhacungcap"));
                    nhaCungCapDTO.setTenNhaCungCap(rs.getString("tennhacungcap"));
                    nhaCungCapDTO.setDiaChi(rs.getString("diachi"));
                    nhaCungCapDTO.setEmail(rs.getString("email"));
                    nhaCungCapDTO.setSdt(rs.getString("sdt"));
                    arr.add(nhaCungCapDTO);
                }
            } catch (Exception e) {
                System.out.println(e);
            }
           }
        return arr;
    }
    
    public boolean addNhaCungCap(NhaCungCapDTO nhaCungCapDTO){
        boolean result = false;
        if(connection!=null){
            try {
                String sql = "insert into nhacungcap (tennhacungcap, diachi, email, sdt) values(?,?,?,?)";
                pst = connection.prepareStatement(sql);
                pst.setString(1, nhaCungCapDTO.getTenNhaCungCap());
                pst.setString(2, nhaCungCapDTO.getDiaChi());
                pst.setString(3, nhaCungCapDTO.getEmail());
                pst.setString(4, nhaCungCapDTO.getSdt());
                if(pst.executeUpdate()>=1){
                    result = true;
                }
            } catch (Exception e) {
                System.out.println(e);
            } 
        }
        return result;
    }
    
    public boolean suaNhaCungCap(NhaCungCapDTO nhaCungCapDTO){
        boolean thanhCong = false;
        try {
            connection = MySQLConnection.openConnection();
            String query = "UPDATE nhacungcap SET tennhacungcap=?, diachi=?, email=? , sdt=? WHERE manhacungcap=?";
            pst = connection.prepareStatement(query);
            pst.setString(1, nhaCungCapDTO.getTenNhaCungCap());
            pst.setString(2, nhaCungCapDTO.getDiaChi());
            pst.setString(4, nhaCungCapDTO.getSdt());
            pst.setString(3, nhaCungCapDTO.getEmail());
            pst.setInt(5, nhaCungCapDTO.getMaNhaCungCap());
            int rowAff = pst.executeUpdate();
            if (rowAff > 0) {
                thanhCong = true;
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return thanhCong;
    }
    
    public boolean xoaNhaCungCap(int t) {
        boolean thanhCong = false;
        try {
            connection = MySQLConnection.openConnection();
            String sql = "UPDATE `nhacungcap` SET `trangthai`=0 WHERE manhacungcap = ?";
            pst = (PreparedStatement) connection.prepareStatement(sql);
            pst.setInt(1, t);
            int rowAff = pst.executeUpdate();
            if (rowAff > 0) {
                thanhCong = true;
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return thanhCong;
    }
    
    public boolean deleteNhaCungCap(int t) {
        boolean thanhCong = false;
        try {
            connection = MySQLConnection.openConnection();
            String sql = "DELETE FROM nhacungcap WHERE manhacungcap = ?";
            pst = connection.prepareStatement(sql);
            pst.setInt(1, t);
            int rowAff = pst.executeUpdate();
            if (rowAff > 0) {
                thanhCong = true;
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return thanhCong;
    }
    
    public NhaCungCapDTO selectById(int manhacungcap) {
        NhaCungCapDTO result = null;
        try {
            connection = MySQLConnection.openConnection();
            String sql = "SELECT * FROM nhacungcap WHERE manhacungcap=?";
            pst = connection.prepareStatement(sql);
            pst.setInt(1, manhacungcap);
            ResultSet rs = (ResultSet) pst.executeQuery();
            while (rs.next()) {
                int ma = rs.getInt("manhacungcap");
                String ten = rs.getString("tennhacungcap");
                String diachi = rs.getString("diachi");
                String email = rs.getString("email");
                String sdt = rs.getString("sdt");
                result = new NhaCungCapDTO(ma, ten, diachi, email, sdt);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return result;
    }
    
    public NhaCungCapDTO selectByIdd(int mancc){
        NhaCungCapDTO nhaCungCapDTO = new NhaCungCapDTO();
        if(connection!=null){
            try {
                String sql = "select * from nhacungcap where manhacungcap=?";
                pst = connection.prepareStatement(sql);
                pst.setInt(1, mancc);
                ResultSet rs = pst.executeQuery();
                while(rs.next()){
                    nhaCungCapDTO.setMaNhaCungCap(rs.getInt("manhacungcap"));
                    nhaCungCapDTO.setTenNhaCungCap(rs.getString("tennhacungcap"));
                    nhaCungCapDTO.setDiaChi(rs.getString("diachi"));
                    nhaCungCapDTO.setEmail(rs.getString("email"));
                    nhaCungCapDTO.setSdt(rs.getString("sdt"));
                }
            } catch (Exception e) {
                System.out.println(e);
            }
        }
        return nhaCungCapDTO;
    }
}
