/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.TaiKhoanDTO;
import config.MySQLConnection;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class TaiKhoanDAO {
    
    public static Object getInstance() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    Connection connection;
    PreparedStatement pst;

    public TaiKhoanDAO() {
    }
    
    public ArrayList<TaiKhoanDTO> getAllTaiKhoan() {
        ArrayList<TaiKhoanDTO> listTaiKhoan = new ArrayList<>();
        connection = MySQLConnection.openConnection();
        String query = "SELECT * FROM taikhoan WHERE trangthai = 1";
        try {
            pst = connection.prepareStatement(query);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                TaiKhoanDTO taiKhoanDTO = new TaiKhoanDTO();
                taiKhoanDTO.setManv(rs.getInt("manv"));
                taiKhoanDTO.setTendangnhap(rs.getString("tendangnhap"));
                taiKhoanDTO.setMatkhau(rs.getString("matkhau"));
                taiKhoanDTO.setManhomquyen(rs.getInt("manhomquyen"));
                listTaiKhoan.add(taiKhoanDTO);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Không thể tải dữ liệu tài khoản");
        }
        return listTaiKhoan;
    }
    
    public boolean themTaiKhoan(TaiKhoanDTO taiKhoanDTO) {
        boolean thanhCong = false;
        String query = "INSERT INTO taikhoan (tendangnhap, matkhau, manhomquyen, manv) VALUES (?, ?, ?, ?)";
        try {
            connection = MySQLConnection.openConnection();
            pst = connection.prepareStatement(query);
            pst.setString(1, taiKhoanDTO.getTendangnhap());
            pst.setString(2, taiKhoanDTO.getMatkhau());
            pst.setInt(3, taiKhoanDTO.getManhomquyen());
            pst.setInt(4, taiKhoanDTO.getManv());
            int rowAff = pst.executeUpdate();
            if (rowAff > 0) {
                thanhCong = true;
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Nhân viên này đã có tài khoản", "Lỗi", JOptionPane.ERROR_MESSAGE);
        } finally {
            try {
                if (pst != null) {
                    pst.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return thanhCong;
    }
    
    public boolean xoaTaiKhoan(int t) {
        boolean thanhCong = false;
        try {
            connection = MySQLConnection.openConnection();
            String sql = "UPDATE `taikhoan` SET `trangthai`=0 WHERE manv = ?";
            pst = (PreparedStatement) connection.prepareStatement(sql);
            pst.setInt(1, t);
            int rowAff = pst.executeUpdate();
            if (rowAff > 0) {
                thanhCong = true;
            }
            MySQLConnection.closeConnection();
        } catch (SQLException ex) {
            //Logger.getLogger(KhachHangDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return thanhCong;
    }
    
    public boolean suaTaiKhoan(TaiKhoanDTO taiKhoanDTO) {
        boolean thanhCong = false;
        try {
            connection = MySQLConnection.openConnection();
            String query = "UPDATE taikhoan SET tendangnhap=?, matkhau=? , manhomquyen=? WHERE manv=?";
            pst = connection.prepareStatement(query);
            pst.setString(1, taiKhoanDTO.getTendangnhap());            
            pst.setString(2, taiKhoanDTO.getMatkhau());
            pst.setInt(3, taiKhoanDTO.getManhomquyen());
            pst.setInt(4, taiKhoanDTO.getManv());

            int rowAff = pst.executeUpdate();
            if (rowAff > 0) {
                thanhCong = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Lỗi sửa tài khoản: " + e.getMessage(), "Lỗi", JOptionPane.ERROR_MESSAGE);
        } finally {
            try {
                if (pst != null) {
                    pst.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return thanhCong;
    }
    
    public TaiKhoanDTO selectById(int manv) {
        TaiKhoanDTO result = null;
        try {
            connection = MySQLConnection.openConnection();
            String sql = "SELECT * FROM taikhoan WHERE manv=?";
            pst = connection.prepareStatement(sql);
            pst.setInt(1, manv);
            ResultSet rs = (ResultSet) pst.executeQuery();
            while (rs.next()) {
                int ma = rs.getInt("manv");
                String tendangnhap = rs.getString("tendangnhap");
                String matkhau = rs.getString("matkhau");
                int manhomquyen = rs.getInt("manhomquyen");
                result = new TaiKhoanDTO(ma, tendangnhap, matkhau, manhomquyen);
            }
            MySQLConnection.closeConnection();
        } catch (SQLException e) {
        }
        return result;
    }
    public TaiKhoanDTO dangnhap(String tendangnhap, String matkhau){
        TaiKhoanDTO taiKhoan = null;
        try {
            connection = MySQLConnection.openConnection();
            String sql = "select * from taikhoan where tendangnhap=? and matkhau=?";
            PreparedStatement pst = connection.prepareStatement(sql);
            pst.setString(1, tendangnhap);
            pst.setString(2, matkhau);
            ResultSet rs = pst.executeQuery();
            if(rs.next()){
                taiKhoan = new TaiKhoanDTO();
                taiKhoan.setManv(rs.getInt(1));
                taiKhoan.setMatkhau(rs.getString(2));
                taiKhoan.setManhomquyen(rs.getInt(3));
                taiKhoan.setTendangnhap(rs.getString(4));
                taiKhoan.setTrangthai(rs.getInt(5));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return taiKhoan;
    }
}