/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.NhanVienDTO;
import config.MySQLConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class NhanVienDAO {

    public static Object getInstance() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    Connection connection;
    PreparedStatement pst;

    public NhanVienDAO() {
    }

    public ArrayList<NhanVienDTO> getAllNhanVien() {
        ArrayList<NhanVienDTO> listNhanVien = new ArrayList<>();
        connection = MySQLConnection.openConnection();
        String query = "SELECT * FROM nhanvien WHERE trangthai = 1";
        try {
            pst = connection.prepareStatement(query);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                NhanVienDTO nhanVienDTO = new NhanVienDTO();
                nhanVienDTO.setManv(rs.getInt("manv"));
                nhanVienDTO.setHoten(rs.getString("hoten"));
                nhanVienDTO.setSdt(rs.getString("sdt"));
                listNhanVien.add(nhanVienDTO);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Không thể tải dữ liệu nhân viên");
        }
        return listNhanVien;
    }

    public boolean themNhanVien(NhanVienDTO nhanVienDTO) {
        boolean thanhCong = false;
        String query = "INSERT INTO nhanvien (hoten, sdt) VALUES (?, ?)";
        try {
            connection = MySQLConnection.openConnection();
            pst = connection.prepareStatement(query);
            pst.setString(1, nhanVienDTO.getHoten());
            pst.setString(2, nhanVienDTO.getSdt());
            int rowAff = pst.executeUpdate();
            if (rowAff > 0) {
                thanhCong = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Lỗi thêm nhân viên: " + e.getMessage(), "Lỗi", JOptionPane.ERROR_MESSAGE);
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

    public boolean xoaNhanVien(int t) {
        boolean thanhCong = false;
        try {
            connection = MySQLConnection.openConnection();
            String sql = "UPDATE `nhanvien` SET `trangthai`=0 WHERE manv = ?";
            pst = (PreparedStatement) connection.prepareStatement(sql);
            pst.setInt(1, t);
            int rowAff = pst.executeUpdate();
            if (rowAff > 0) {
                thanhCong = true;
            }
            MySQLConnection.closeConnection();
        } catch (SQLException ex) {
            Logger.getLogger(NhanVienDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return thanhCong;
    }

    public boolean suaNhanVien(NhanVienDTO nhanVienDTO) {
        boolean thanhCong = false;
        try {
            connection = MySQLConnection.openConnection();
            String query = "UPDATE nhanvien SET hoten=?, sdt=? WHERE manv=?";
            pst = connection.prepareStatement(query);
            pst.setString(1, nhanVienDTO.getHoten());            
            pst.setString(2, nhanVienDTO.getSdt());
            pst.setInt(3, nhanVienDTO.getManv());

            int rowAff = pst.executeUpdate();
            if (rowAff > 0) {
                thanhCong = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Lỗi sửa khách hàng: " + e.getMessage(), "Lỗi", JOptionPane.ERROR_MESSAGE);
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

    public NhanVienDTO selectById(int makh) {
        NhanVienDTO result = null;
        try {
            connection = MySQLConnection.openConnection();
            String sql = "SELECT * FROM nhanvien WHERE manv=?";
            pst = connection.prepareStatement(sql);
            pst.setInt(1, makh);
            ResultSet rs = (ResultSet) pst.executeQuery();
            while (rs.next()) {
                int ma = rs.getInt("manv");
                String ten = rs.getString("hoten");
                String sdt = rs.getString("sdt");
                result = new NhanVienDTO(ma, ten, sdt);
            }
            MySQLConnection.closeConnection();
        } catch (SQLException e) {
        }
        return result;
    }

}