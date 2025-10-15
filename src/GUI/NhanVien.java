package GUI;

import BUS.NhanVienBUS;
import DAO.NhanVienDAO;
import DTO.NhanVienDTO;
import GUI.NVien.ChiTietNVien;
import GUI.NVien.SuaNVien;
import GUI.NVien.ThemNVien;
import com.formdev.flatlaf.FlatIntelliJLaf;
import com.formdev.flatlaf.FlatLaf;
import com.formdev.flatlaf.extras.FlatSVGIcon;
import com.formdev.flatlaf.fonts.roboto.FlatRobotoFont;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;


/**
 *
 * @author PC
 */
public class NhanVien extends javax.swing.JPanel {
    
    DefaultTableModel tblModel;
    NhanVienBUS nhanVienBUS = new NhanVienBUS();
    NhanVienDAO nhanVienDAO = new NhanVienDAO();
    ChiTietNVien chiTietNVien;
    SuaNVien suaNVien;
    ThemNVien themNVien;
    ArrayList<NhanVienDTO> listNhanVien = nhanVienBUS.getAllNhanVien();
    
    public NhanVien() {
        initComponents();
        addIcon();
        
        FlatRobotoFont.install();
        FlatLaf.setPreferredFontFamily(FlatRobotoFont.FAMILY);
        FlatLaf.setPreferredLightFontFamily(FlatRobotoFont.FAMILY_LIGHT);
        FlatLaf.setPreferredSemiboldFontFamily(FlatRobotoFont.FAMILY_SEMIBOLD);
        FlatIntelliJLaf.registerCustomDefaultsSource("style");
        FlatIntelliJLaf.setup();
        
        tblNhanVien.setFocusable(false);
        tblNhanVien.setDefaultEditor(Object.class, null); // set ko cho sửa dữ liệu trên table
        tblNhanVien.getColumnModel().getColumn(1).setPreferredWidth(180);
        tblNhanVien.setFocusable(false);
        tblNhanVien.setAutoCreateRowSorter(true);
        
    btnThem.addActionListener(new ActionListener() {
       public void actionPerformed(ActionEvent e) {
        // Thêm xử lý khi nút "Thêm" được nhấn vào đây
        themNVien = new ThemNVien();
        themNVien.setVisible(true);
    }
    });
    
    
    btnSua.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e) {
        // Thêm xử lý khi nút "Sửa" được nhấn vào đây
        if (selectNhanVien()!= null) {
            suaNVien = new SuaNVien(selectNhanVien());
            suaNVien.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(null, "Vui lòng chọn nhân viên");
        }
    }
    });

    btnXoa.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
        // Thêm xử lý khi nút "Xóa" được nhấn vào đây
        xoaNhanVien();
        }
    });
    
    btnTimKiem.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            // Thực hiện tìm kiếm khi nút tìm kiếm được nhấn
            String keyword = txtTimKiem.getText().trim();
            timKiemNhanVien(keyword);
        }
    });

        setLayout(new BorderLayout());
        setPreferredSize(new Dimension(1200, 800));
        this.add(pnlTop, BorderLayout.NORTH);
        this.add(pnlCenter, BorderLayout.CENTER);

        hienThiListNhanVien(listNhanVien);
        
    }
    
    
    
    private void addIcon(){
            btnThem.setIcon(new FlatSVGIcon("./icon/add.svg"));
            btnSua.setIcon(new FlatSVGIcon("./icon/edit.svg"));
            btnXoa.setIcon(new FlatSVGIcon("./icon/delete.svg"));
            btnChiTiet.setIcon(new FlatSVGIcon("./icon/detail.svg"));
    }
    
    //private void timKiemNhanVien(String keyword) {
    //ArrayList<NhanVienDTO> ketQuaTimKiem = new ArrayList<>();
    //DefaultTableModel model = (DefaultTableModel) tblNhanVien.getModel();
    //for (int i = 0; i < model.getRowCount(); i++) {
    //    String tenNhanVien = (String) model.getValueAt(i, 1);
    //    if (tenNhanVien.toLowerCase().contains(keyword.toLowerCase())) {
    //        ketQuaTimKiem.add(nhanVienBUS.selectByID((int) model.getValueAt(i, 0))); 
    //    }
    //    String soDienThoai = (String) model.getValueAt(i, 2);
    //    if (soDienThoai.contains(keyword)) {
    //        ketQuaTimKiem.add(nhanVienBUS.selectByID((int) model.getValueAt(i, 0))); 
    //    }
    //}
    //hienThiListNhanVien(ketQuaTimKiem);
//}
    private void timKiemNhanVien(String keyword) {
    DefaultTableModel model = (DefaultTableModel) tblNhanVien.getModel();
    model.setRowCount(0); // Xóa hết dữ liệu cũ trên bảng

    for (int i = 0; i < listNhanVien.size(); i++) {
        NhanVienDTO nhanVien = listNhanVien.get(i);
        if (String.valueOf(nhanVien.getManv()).contains(keyword) ||
            nhanVien.getHoten().toLowerCase().contains(keyword.toLowerCase()) ) {
            Object[] row = {
                nhanVien.getManv(),
                nhanVien.getHoten(),
                nhanVien.getSdt()
            };
            model.addRow(row); // Thêm dòng mới vào bảng với thông tin tìm kiếm được
        }
    }
}
    
//    private void timKiemNhanVien(String keyword) {
//    ArrayList<NhanVienDTO> ketQuaTimKiem = new ArrayList<>();
//    DefaultTableModel model = (DefaultTableModel) tblNhanVien.getModel();
//    for (int i = 0; i < model.getRowCount(); i++) {
//        String tenNhanVien = (String) model.getValueAt(i, 1);
//        if (tenNhanVien.toLowerCase().contains(keyword.toLowerCase())) {
//            ketQuaTimKiem.add(nhanVienBUS.selectByID((int) model.getValueAt(i, 0))); 
//        }
//        String soDienThoai = (String) model.getValueAt(i, 2);
//        if (soDienThoai.contains(keyword)) {
//            ketQuaTimKiem.add(nhanVienBUS.selectByID((int) model.getValueAt(i, 0))); 
//        }
//        String maNhanVien = (String) model.getValueAt(i, 3);
//        if (maNhanVien.contains(keyword)) {
//            ketQuaTimKiem.add(nhanVienBUS.selectByID((int) model.getValueAt(i, 0)));
//            
//        }
//    }
//    hienThiListNhanVien(ketQuaTimKiem);
//}

    
    
    private void hienThiListNhanVien(ArrayList<NhanVienDTO> listNhanVien) {
        nhanVienBUS = new NhanVienBUS();
        nhanVienDAO = new NhanVienDAO();
        DefaultTableModel model = (DefaultTableModel) tblNhanVien.getModel();
        model.setRowCount(0);
        for (NhanVienDTO nhanVien : listNhanVien) {
            Object[] row = {
                nhanVien.getManv(),
                nhanVien.getHoten(),
                nhanVien.getSdt(),};
            model.addRow(row);
        }

//         Tạo renderer để hiển thị nội dung ở giữa ô
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);

        // Áp dụng renderer cho từng cột trong bảng
        for (int i = 0; i < tblNhanVien.getColumnCount(); i++) {
            tblNhanVien.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
        }
    }
    
    public void hienThiListNhanVien() {
        nhanVienBUS = new NhanVienBUS();
        nhanVienDAO = new NhanVienDAO();
        listNhanVien = nhanVienBUS.getAllNhanVien();
        DefaultTableModel model = (DefaultTableModel) tblNhanVien.getModel();
        model.setRowCount(0);
        for (NhanVienDTO nhanVien : listNhanVien) {
            Object[] row = {
                nhanVien.getManv(),
                nhanVien.getHoten(),
                nhanVien.getSdt(),};
            model.addRow(row);
        }

//         Tạo renderer để hiển thị nội dung ở giữa ô
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);

        // Áp dụng renderer cho từng cột trong bảng
        for (int i = 0; i < tblNhanVien.getColumnCount(); i++) {
            tblNhanVien.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlTop = new javax.swing.JPanel();
        btnThem = new javax.swing.JButton();
        btnSua = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        btnChiTiet = new javax.swing.JButton();
        txtTimKiem = new javax.swing.JTextField();
        btnTimKiem = new javax.swing.JButton();
        btnLamMoi = new javax.swing.JButton();
        pnlCenter = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblNhanVien = new javax.swing.JTable();

        setBackground(new java.awt.Color(255, 255, 255));

        pnlTop.setBackground(new java.awt.Color(255, 255, 255));

        btnThem.setBackground(new java.awt.Color(254, 254, 254));
        btnThem.setText("Thêm");
        btnThem.setFocusPainted(false);
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });
        pnlTop.add(btnThem);

        btnSua.setBackground(new java.awt.Color(254, 254, 254));
        btnSua.setText("Sửa");
        btnSua.setFocusPainted(false);
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });
        pnlTop.add(btnSua);

        btnXoa.setBackground(new java.awt.Color(254, 254, 254));
        btnXoa.setText("Xóa");
        btnXoa.setFocusPainted(false);
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });
        pnlTop.add(btnXoa);

        btnChiTiet.setBackground(new java.awt.Color(254, 254, 254));
        btnChiTiet.setText("Chi tiết");
        btnChiTiet.setFocusPainted(false);
        btnChiTiet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChiTietActionPerformed(evt);
            }
        });
        pnlTop.add(btnChiTiet);

        txtTimKiem.setMinimumSize(new java.awt.Dimension(300, 30));
        txtTimKiem.setPreferredSize(new java.awt.Dimension(200, 22));
        txtTimKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTimKiemActionPerformed(evt);
            }
        });
        pnlTop.add(txtTimKiem);

        btnTimKiem.setBackground(new java.awt.Color(254, 254, 254));
        btnTimKiem.setText("Tìm kiếm");
        btnTimKiem.setFocusPainted(false);
        btnTimKiem.setMaximumSize(new java.awt.Dimension(100, 50));
        btnTimKiem.setMinimumSize(new java.awt.Dimension(100, 50));
        btnTimKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimKiemActionPerformed(evt);
            }
        });
        btnTimKiem.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnTimKiemKeyPressed(evt);
            }
        });
        pnlTop.add(btnTimKiem);

        btnLamMoi.setBackground(new java.awt.Color(254, 254, 254));
        btnLamMoi.setText("Làm mới");
        btnLamMoi.setFocusPainted(false);
        btnLamMoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLamMoiActionPerformed(evt);
            }
        });
        pnlTop.add(btnLamMoi);

        pnlCenter.setBackground(new java.awt.Color(254, 254, 254));

        jScrollPane1.setBackground(new java.awt.Color(254, 254, 254));
        jScrollPane1.setBorder(null);

        tblNhanVien.setBackground(new java.awt.Color(250, 250, 250));
        tblNhanVien.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã nhân viên", "Tên nhân viên", "Số điện thoại"
            }
        ));
        jScrollPane1.setViewportView(tblNhanVien);

        javax.swing.GroupLayout pnlCenterLayout = new javax.swing.GroupLayout(pnlCenter);
        pnlCenter.setLayout(pnlCenterLayout);
        pnlCenterLayout.setHorizontalGroup(
            pnlCenterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
        );
        pnlCenterLayout.setVerticalGroup(
            pnlCenterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 488, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlTop, javax.swing.GroupLayout.DEFAULT_SIZE, 1043, Short.MAX_VALUE)
            .addComponent(pnlCenter, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnlTop, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlCenter, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtTimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTimKiemActionPerformed
        // TODO add your handling code here:
        String keyword = txtTimKiem.getText().trim();
        timKiemNhanVien(keyword);
    }//GEN-LAST:event_txtTimKiemActionPerformed

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        // TODO add your handling code here:
//        themNVien = new ThemNVien();
//        themNVien.setVisible(true);
    }//GEN-LAST:event_btnThemActionPerformed

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        // TODO add your handling code here:
//       if(tblNhanVien.getSelectedRow() != -1){
//        DefaultTableModel model = (DefaultTableModel) tblNhanVien.getModel();
//        int maNhanVien = Integer.parseInt(model.getValueAt(tblNhanVien.getSelectedRow(), 0).toString());
//        String tenNhanVien = model.getValueAt(tblNhanVien.getSelectedRow(), 1).toString();
//        String soDienThoai = model.getValueAt(tblNhanVien.getSelectedRow(), 2).toString();
//        
//        // Tạo đối tượng NhanVienDTO từ thông tin lấy được
//        NhanVienDTO selectedNhanVien = new NhanVienDTO(maNhanVien, tenNhanVien, soDienThoai);
//        
//           suaNVien = new SuaNVien(selectedNhanVien);
//           suaNVien.setVisible(true);
//       } else {
//           JOptionPane.showMessageDialog(null, "Vui lòng chọn nhân viên");
//       }
    }//GEN-LAST:event_btnSuaActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed

    }//GEN-LAST:event_btnXoaActionPerformed

    private void btnChiTietActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChiTietActionPerformed
        // TODO add your handling code here:
        if(tblNhanVien.getSelectedRow() != -1){
        int selectedRow = tblNhanVien.getSelectedRow();
        // Lấy thông tin nhân viên từ model của bảng
        DefaultTableModel model = (DefaultTableModel) tblNhanVien.getModel();
        int maNhanVien = Integer.parseInt(model.getValueAt(selectedRow, 0).toString());
        String tenNhanVien = model.getValueAt(selectedRow, 1).toString();
        String soDienThoai = model.getValueAt(selectedRow, 2).toString();
        
        // Tạo đối tượng NhanVienDTO từ thông tin lấy được
        NhanVienDTO selectedNhanVien = new NhanVienDTO(maNhanVien, tenNhanVien, soDienThoai);
        
        // Hiển thị frame ChiTietNVien với thông tin của nhân viên đã chọn
        
            chiTietNVien = new ChiTietNVien(selectedNhanVien);
            chiTietNVien.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(null, "Vui lòng chọn nhân viên");
        }
    }//GEN-LAST:event_btnChiTietActionPerformed

    private void btnTimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimKiemActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnTimKiemActionPerformed

    private void btnLamMoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLamMoiActionPerformed
        // TODO add your handling code here:
        listNhanVien = nhanVienBUS.getAllNhanVien();
        hienThiListNhanVien(listNhanVien);
        txtTimKiem.setText("");
    }//GEN-LAST:event_btnLamMoiActionPerformed

    private void btnTimKiemKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnTimKiemKeyPressed
        // TODO add your handling code here:
         if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            String keyword = txtTimKiem.getText().trim();
            timKiemNhanVien(keyword);
        }
    }//GEN-LAST:event_btnTimKiemKeyPressed

    private void xoaNhanVien() {
        int selectedRow = tblNhanVien.getSelectedRow();
        if (selectedRow != -1) {
            int maNV = (int) tblNhanVien.getValueAt(selectedRow, 0);
            NhanVienDTO canXoa = nhanVienBUS.selectByID(maNV);
            nhanVienBUS = new NhanVienBUS();
            boolean thanhCong = nhanVienBUS.xoaNhanVien(maNV);
            if (thanhCong) {

                JOptionPane.showMessageDialog(null, "Xóa nhân viên thành công");
                listNhanVien = nhanVienBUS.getAllNhanVien();
                hienThiListNhanVien(listNhanVien);
            } else {
                JOptionPane.showMessageDialog(null, "Xóa nhân viên lỗi");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Vui lòng nhân viên để xóa");
        }
    }

    private NhanVienDTO selectNhanVien() {
        int selectedRow = tblNhanVien.getSelectedRow();
        NhanVienDTO result = null;
        if (selectedRow != -1) {
            int maNV = (int) tblNhanVien.getValueAt(selectedRow, 0);
            nhanVienBUS= new NhanVienBUS();
            result = nhanVienBUS.selectByID(maNV);
        }
        return result;
    }


    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnThem) {
            themNVien = new ThemNVien();
            themNVien.setLocationRelativeTo(null);
            themNVien.setVisible(true);
        } else if (e.getSource() == btnXoa) {
            xoaNhanVien();
        } else if (e.getSource() == btnSua) {
            if (selectNhanVien()!= null) {
                suaNVien = new SuaNVien(selectNhanVien());
                suaNVien.setLocationRelativeTo(null);
                suaNVien.setVisible(true);
            } else {
                JOptionPane.showMessageDialog(null, "Vui lòng chọn nhân viên");
            }
        } 
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnChiTiet;
    private javax.swing.JButton btnLamMoi;
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnTimKiem;
    private javax.swing.JButton btnXoa;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel pnlCenter;
    private javax.swing.JPanel pnlTop;
    private javax.swing.JTable tblNhanVien;
    private javax.swing.JTextField txtTimKiem;
    // End of variables declaration//GEN-END:variables
}
