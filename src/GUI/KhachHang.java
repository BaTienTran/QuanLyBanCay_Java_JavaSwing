package GUI;

import BUS.KhachHangBUS;
import DAO.KhachHangDAO;
import DTO.KhachHangDTO;
import GUI.KHang.ChiTietKHang;
import GUI.KHang.SuaKHang;
import GUI.KHang.ThemKHang;
import com.formdev.flatlaf.FlatIntelliJLaf;
import com.formdev.flatlaf.FlatLaf;
import com.formdev.flatlaf.extras.FlatSVGIcon;
import com.formdev.flatlaf.fonts.roboto.FlatRobotoFont;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author PC
 */
public class KhachHang extends javax.swing.JPanel {
    
    ChiTietKHang chiTietKHang;
    SuaKHang suaKHang;
    ThemKHang themKHang;
    KhachHangBUS khachHangBUS = new KhachHangBUS();
    KhachHangDAO khachHangDAO = new KhachHangDAO();
    ArrayList<KhachHangDTO> listKhachHang = khachHangBUS.getAllKhachHang();
    
    public KhachHang() {
        initComponents();
        addIcon();
        
        FlatRobotoFont.install();
        FlatLaf.setPreferredFontFamily(FlatRobotoFont.FAMILY);
        FlatLaf.setPreferredLightFontFamily(FlatRobotoFont.FAMILY_LIGHT);
        FlatLaf.setPreferredSemiboldFontFamily(FlatRobotoFont.FAMILY_SEMIBOLD);
        FlatIntelliJLaf.registerCustomDefaultsSource("style");
        FlatIntelliJLaf.setup();
        
        tblKhachHang.setFocusable(false);
        tblKhachHang.setDefaultEditor(Object.class, null); // set ko cho sửa dữ liệu trên table
        tblKhachHang.getColumnModel().getColumn(1).setPreferredWidth(180);
        tblKhachHang.setFocusable(false);
        tblKhachHang.setAutoCreateRowSorter(true);
        
        btnTimKiem.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            // Thực hiện tìm kiếm khi nút tìm kiếm được nhấn
            String keyword = txtTimKiem.getText().trim();
            timKiemKhachHang(keyword);
        }
    });
        
        setLayout(new BorderLayout());
        setPreferredSize(new Dimension(1200, 800));
        this.add(pnlTop, BorderLayout.NORTH);
        this.add(pnlCenter, BorderLayout.CENTER);

        hienThiListKhachHang(listKhachHang);
    }

    private void addIcon(){
            btnThem.setIcon(new FlatSVGIcon("./icon/add.svg"));
            btnSua.setIcon(new FlatSVGIcon("./icon/edit.svg"));
            btnXoa.setIcon(new FlatSVGIcon("./icon/delete.svg"));
            btnChiTiet.setIcon(new FlatSVGIcon("./icon/detail.svg"));
        }
    
     private void timKiemKhachHang(String keyword) {
    DefaultTableModel model = (DefaultTableModel) tblKhachHang.getModel();
    model.setRowCount(0); // Xóa hết dữ liệu cũ trên bảng

    for (int i = 0; i < listKhachHang.size(); i++) {
        KhachHangDTO khachHang = listKhachHang.get(i);
        if (String.valueOf(khachHang.getMaKhachHang()).contains(keyword) ||
            khachHang.getTenKhachHang().toLowerCase().contains(keyword.toLowerCase()) ) {
            Object[] row = {
                khachHang.getMaKhachHang(),
                khachHang.getTenKhachHang(),
                khachHang.getDiachi(),
                khachHang.getsDT(),
            };
            model.addRow(row); // Thêm dòng mới vào bảng với thông tin tìm kiếm được
        }
    }
}
    
    public void hienThiListKhachHang(ArrayList<KhachHangDTO> listKhachHang){
        khachHangBUS = new KhachHangBUS();
        khachHangDAO = new KhachHangDAO();
        DefaultTableModel dtm = (DefaultTableModel) tblKhachHang.getModel();
        dtm.setRowCount(0);
        for(KhachHangDTO khachHangDTO : listKhachHang){
            Object[] row = {
                khachHangDTO.getMaKhachHang(),
                khachHangDTO.getTenKhachHang(),
                khachHangDTO.getDiachi(),
                khachHangDTO.getsDT(),
            };
            dtm.addRow(row);
        }
        
        //         Tạo renderer để hiển thị nội dung ở giữa ô
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);

        // Áp dụng renderer cho từng cột trong bảng
        for (int i = 0; i < tblKhachHang.getColumnCount(); i++) {
            tblKhachHang.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
        }
    }
    
//Lấy dữ liệu từ database    
    public void hienThiListKhachHang() {
        khachHangBUS = new KhachHangBUS();
        khachHangDAO = new KhachHangDAO();
        listKhachHang = khachHangBUS.getAllKhachHang();
        DefaultTableModel model = (DefaultTableModel) tblKhachHang.getModel();
        model.setRowCount(0);
        for (KhachHangDTO khachHang : listKhachHang) {
            Object[] row = {
                khachHang.getMaKhachHang(),
                khachHang.getTenKhachHang(),
                khachHang.getDiachi(),
                khachHang.getsDT(),
            };
            model.addRow(row);
        }

//         Tạo renderer để hiển thị nội dung ở giữa ô
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);

        // Áp dụng renderer cho từng cột trong bảng
        for (int i = 0; i < tblKhachHang.getColumnCount(); i++) {
            tblKhachHang.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
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
        tblKhachHang = new javax.swing.JTable();

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

        tblKhachHang.setBackground(new java.awt.Color(250, 250, 250));
        tblKhachHang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã khách hàng", "Tên khách hàng", "Địa chỉ", "Số điện thoại"
            }
        ));
        jScrollPane1.setViewportView(tblKhachHang);

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
        timKiemKhachHang(keyword);
    }//GEN-LAST:event_txtTimKiemActionPerformed

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        // TODO add your handling code here:
        themKHang = new ThemKHang();
        themKHang.setVisible(true);
    }//GEN-LAST:event_btnThemActionPerformed

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        // TODO add your handling code here:
       if(tblKhachHang.getSelectedRow() != -1){
           int row = tblKhachHang.getSelectedRow();
           TableModel model = tblKhachHang.getModel();
           int maNCC = Integer.parseInt(model.getValueAt(row, 0).toString());
           suaKHang = new SuaKHang(maNCC);
           suaKHang.setVisible(true);
       } else {
           JOptionPane.showMessageDialog(null, "Vui lòng chọn khách hàng");
       }
    }//GEN-LAST:event_btnSuaActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        // TODO add your handling code here:
        if(tblKhachHang.getSelectedRow() != -1){
            int row = tblKhachHang.getSelectedRow();
            TableModel model = tblKhachHang.getModel();
            int maNCC = Integer.parseInt(model.getValueAt(row, 0).toString());
            khachHangBUS = new KhachHangBUS();
            boolean thanhCong = khachHangBUS.xoaKhachHang(maNCC);
            if (thanhCong) {
                JOptionPane.showMessageDialog(null, "Xóa khách hàng thành công");
                listKhachHang = khachHangBUS.getAllKhachHang();
                hienThiListKhachHang(listKhachHang);
            } else {
                JOptionPane.showMessageDialog(null, "Xóa khách hàng lỗi");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Vui lòng chọn khách hàng");
        }
    }//GEN-LAST:event_btnXoaActionPerformed

    private void btnChiTietActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChiTietActionPerformed
        // TODO add your handling code here:
        if(tblKhachHang.getSelectedRow() != -1){
            int row = tblKhachHang.getSelectedRow();
            TableModel model = tblKhachHang.getModel();
            int maNCC = Integer.parseInt(model.getValueAt(row, 0).toString());
            chiTietKHang = new ChiTietKHang(maNCC);
            chiTietKHang.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(null, "Vui lòng chọn khách hàng");
        }
    }//GEN-LAST:event_btnChiTietActionPerformed

    private void btnTimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimKiemActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_btnTimKiemActionPerformed

    private void btnLamMoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLamMoiActionPerformed
        // TODO add your handling code here:
        khachHangBUS = new KhachHangBUS();
        listKhachHang = khachHangBUS.getAllKhachHang();
        hienThiListKhachHang(listKhachHang);
        txtTimKiem.setText("");
    }//GEN-LAST:event_btnLamMoiActionPerformed

    private void btnTimKiemKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnTimKiemKeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            String keyword = txtTimKiem.getText().trim();
            timKiemKhachHang(keyword);
        }
    }//GEN-LAST:event_btnTimKiemKeyPressed


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
    private javax.swing.JTable tblKhachHang;
    private javax.swing.JTextField txtTimKiem;
    // End of variables declaration//GEN-END:variables
}
