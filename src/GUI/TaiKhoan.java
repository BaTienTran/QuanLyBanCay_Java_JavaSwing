package GUI;

//import GUI.KHang.ChiTietKHang;
//import GUI.KHang.SuaKHang;
//import GUI.KHang.ThemKHang;
import BUS.NhomQuyenBUS;
import BUS.TaiKhoanBUS;
import DAO.TaiKhoanDAO;
import DTO.NhomQuyenDTO;
import DTO.TaiKhoanDTO;
import GUI.TKhoan.ChiTietTKhoan;
import GUI.TKhoan.SuaTKhoan;
import GUI.TKhoan.ThemTKhoan;
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
public class TaiKhoan extends javax.swing.JPanel implements ActionListener{
    
    //ChiTietKHang chiTietKHang;
    //SuaKHang suaKHang;
    //ThemKHang themKHang;
    DefaultTableModel tblModel;
    TaiKhoanBUS taiKhoanBUS = new TaiKhoanBUS();
    TaiKhoanDAO taiKhoanDAO = new TaiKhoanDAO();
    ThemTKhoan themTK;
    SuaTKhoan suaTK;
    ChiTietTKhoan chiTietTKhoan;
    ArrayList<TaiKhoanDTO> listTaiKhoan = taiKhoanBUS.getAllTaiKhoan();
    
    public TaiKhoan() {
        initComponents();
        addIcon();
        
        FlatRobotoFont.install();
        FlatLaf.setPreferredFontFamily(FlatRobotoFont.FAMILY);
        FlatLaf.setPreferredLightFontFamily(FlatRobotoFont.FAMILY_LIGHT);
        FlatLaf.setPreferredSemiboldFontFamily(FlatRobotoFont.FAMILY_SEMIBOLD);
        FlatIntelliJLaf.registerCustomDefaultsSource("style");
        FlatIntelliJLaf.setup();
        
        tblTaiKhoan.setFocusable(false);
        tblTaiKhoan.setDefaultEditor(Object.class, null); // set ko cho sửa dữ liệu trên table
        tblTaiKhoan.getColumnModel().getColumn(1).setPreferredWidth(180);
        tblTaiKhoan.setFocusable(false);
        tblTaiKhoan.setAutoCreateRowSorter(true);
        
        btnThemTK.addActionListener(this);
        btnSuaTK.addActionListener(this);
        btnXoaTK.addActionListener(this);
        
        setLayout(new BorderLayout());
        setPreferredSize(new Dimension(1200, 800));
        this.add(pnlTop, BorderLayout.NORTH);
        this.add(pnlCenter, BorderLayout.CENTER);

        hienThiListTaiKhoan(listTaiKhoan);
    }

    private void addIcon(){
            btnThemTK.setIcon(new FlatSVGIcon("./icon/add.svg"));
            btnSuaTK.setIcon(new FlatSVGIcon("./icon/edit.svg"));
            btnXoaTK.setIcon(new FlatSVGIcon("./icon/delete.svg"));
            btnChiTietTK.setIcon(new FlatSVGIcon("./icon/detail.svg"));
    }
    
//    private void timkiemTaiKhoan(String keyword) {
//    ArrayList<TaiKhoanDTO> ketQuaTimKiem = new ArrayList<>();
//    DefaultTableModel model = (DefaultTableModel) tblTaiKhoan.getModel();
//    for (int i = 0; i < model.getRowCount(); i++) {
//        String tendangnhap = (String) model.getValueAt(i, 1);
//        if (tendangnhap.toLowerCase().contains(keyword.toLowerCase())) {
//            ketQuaTimKiem.add(taiKhoanBUS.selectByID((int) model.getValueAt(i, 0))); // Thêm khách hàng vào danh sách kết quả
//        }
//    }
//    hienThiListTaiKhoan(ketQuaTimKiem);
//}
    
    private void timKiemTaiKhoan(String keyword) {
    DefaultTableModel model = (DefaultTableModel) tblTaiKhoan.getModel();
    model.setRowCount(0); // Xóa hết dữ liệu cũ trên bảng

    for (int i = 0; i < listTaiKhoan.size(); i++) {
        TaiKhoanDTO taiKhoan = listTaiKhoan.get(i);
        if (taiKhoan.getTendangnhap().toLowerCase().contains(keyword.toLowerCase()) ||
            String.valueOf(taiKhoan.getManv()).contains(keyword)) {
            NhomQuyenBUS nhomQuyenBUS = new NhomQuyenBUS();
            NhomQuyenDTO nhomQuyenDTO = nhomQuyenBUS.getNhomQuyen(taiKhoan.getManhomquyen());
            Object[] row = {
                taiKhoan.getManv(),
                taiKhoan.getTendangnhap(),
                taiKhoan.getMatkhau(),
                nhomQuyenDTO.getTenNhomQuyen(),
            };
            model.addRow(row); // Thêm dòng mới vào bảng với thông tin tìm kiếm được
        }
    }
}

    
    private void hienThiListTaiKhoan(ArrayList<TaiKhoanDTO> listTaiKhoan) {
        taiKhoanDAO = new TaiKhoanDAO();
        taiKhoanBUS = new TaiKhoanBUS();
        DefaultTableModel model = (DefaultTableModel) tblTaiKhoan.getModel();
        model.setRowCount(0);
        for (TaiKhoanDTO taiKhoan : listTaiKhoan) {
            NhomQuyenBUS nhomQuyenBUS = new NhomQuyenBUS();
            NhomQuyenDTO nhomQuyenDTO = nhomQuyenBUS.getNhomQuyen(taiKhoan.getManhomquyen());
            Object[] row = {
                taiKhoan.getManv(),
                taiKhoan.getTendangnhap(),
                taiKhoan.getMatkhau(),
                nhomQuyenDTO.getTenNhomQuyen(),
                };
            model.addRow(row);
        }
 
    //         Tạo renderer để hiển thị nội dung ở giữa ô
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);

        // Áp dụng renderer cho từng cột trong bảng
        for (int i = 0; i < tblTaiKhoan.getColumnCount(); i++) {
            tblTaiKhoan.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
        }
    }
    
    private void xoaTaiKhoan() {
        int selectedRow = tblTaiKhoan.getSelectedRow();
        if (selectedRow != -1) {
            int maTK = (int) tblTaiKhoan.getValueAt(selectedRow, 0);
            TaiKhoanDTO canXoa = taiKhoanBUS.selectByID(maTK);
            taiKhoanBUS = new TaiKhoanBUS();
            boolean thanhCong = taiKhoanBUS.xoaTaiKhoan(maTK);
            if (thanhCong) {

                JOptionPane.showMessageDialog(null, "Xóa tài khoản thành công");
                listTaiKhoan = taiKhoanBUS.getAllTaiKhoan();
                hienThiListTaiKhoan(listTaiKhoan);
            } else {
                JOptionPane.showMessageDialog(null, "Xóa tài khoản lỗi");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Vui lòng chọn tài khoản để xóa");
        }
    }
    
    private TaiKhoanDTO selectTaiKhoan() {
        int selectedRow = tblTaiKhoan.getSelectedRow();
        TaiKhoanDTO result = null;
        if (selectedRow != -1) {
            int maTK = (int) tblTaiKhoan.getValueAt(selectedRow, 0);
            taiKhoanBUS = new TaiKhoanBUS();
            result = taiKhoanBUS.selectByID(maTK);
        }
        return result;
    }
        
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlTop = new javax.swing.JPanel();
        btnThemTK = new javax.swing.JButton();
        btnSuaTK = new javax.swing.JButton();
        btnXoaTK = new javax.swing.JButton();
        btnChiTietTK = new javax.swing.JButton();
        txtTimKiem = new javax.swing.JTextField();
        btnTimKiem = new javax.swing.JButton();
        btnLamMoi = new javax.swing.JButton();
        pnlCenter = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblTaiKhoan = new javax.swing.JTable();

        setBackground(new java.awt.Color(255, 255, 255));

        pnlTop.setBackground(new java.awt.Color(255, 255, 255));

        btnThemTK.setBackground(new java.awt.Color(254, 254, 254));
        btnThemTK.setText("Thêm");
        btnThemTK.setFocusPainted(false);
        btnThemTK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemTKActionPerformed(evt);
            }
        });
        pnlTop.add(btnThemTK);

        btnSuaTK.setBackground(new java.awt.Color(254, 254, 254));
        btnSuaTK.setText("Sửa");
        btnSuaTK.setFocusPainted(false);
        btnSuaTK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaTKActionPerformed(evt);
            }
        });
        pnlTop.add(btnSuaTK);

        btnXoaTK.setBackground(new java.awt.Color(254, 254, 254));
        btnXoaTK.setText("Xóa");
        btnXoaTK.setFocusPainted(false);
        btnXoaTK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaTKActionPerformed(evt);
            }
        });
        pnlTop.add(btnXoaTK);

        btnChiTietTK.setBackground(new java.awt.Color(254, 254, 254));
        btnChiTietTK.setText("Chi tiết");
        btnChiTietTK.setFocusPainted(false);
        btnChiTietTK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChiTietTKActionPerformed(evt);
            }
        });
        pnlTop.add(btnChiTietTK);

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

        tblTaiKhoan.setBackground(new java.awt.Color(250, 250, 250));
        tblTaiKhoan.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã nhân viên", "Tên đăng nhập", "Mật khẩu", "Mã nhóm quyền"
            }
        ));
        jScrollPane1.setViewportView(tblTaiKhoan);

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
        timKiemTaiKhoan(keyword);
    }//GEN-LAST:event_txtTimKiemActionPerformed

    private void btnThemTKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemTKActionPerformed
        // TODO add your handling code here:
        //themKHang = new ThemKHang();
        //themKHang.setVisible(true);
    }//GEN-LAST:event_btnThemTKActionPerformed

    private void btnSuaTKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaTKActionPerformed

    }//GEN-LAST:event_btnSuaTKActionPerformed

    private void btnXoaTKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaTKActionPerformed

    }//GEN-LAST:event_btnXoaTKActionPerformed

    private void btnChiTietTKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChiTietTKActionPerformed
        if(tblTaiKhoan.getSelectedRow() != -1){
            int row = tblTaiKhoan.getSelectedRow();
            TableModel model = tblTaiKhoan.getModel();
            int maNCC = Integer.parseInt(model.getValueAt(row, 0).toString());
            chiTietTKhoan = new ChiTietTKhoan(maNCC);
            chiTietTKhoan.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(null, "Vui lòng chọn sản phẩm");
        }
    }//GEN-LAST:event_btnChiTietTKActionPerformed

    private void btnTimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimKiemActionPerformed
        // TODO add your handling code here:
        String keyword = txtTimKiem.getText().trim();
        timKiemTaiKhoan(keyword);
        txtTimKiem.setText("");
    }//GEN-LAST:event_btnTimKiemActionPerformed

    private void btnLamMoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLamMoiActionPerformed
        // TODO add your handling code here:
        listTaiKhoan = taiKhoanBUS.getAllTaiKhoan();
        hienThiListTaiKhoan(listTaiKhoan);
    }//GEN-LAST:event_btnLamMoiActionPerformed

    private void btnTimKiemKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnTimKiemKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            String keyword = txtTimKiem.getText().trim();
            timKiemTaiKhoan(keyword);
        }
    }//GEN-LAST:event_btnTimKiemKeyPressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnChiTietTK;
    private javax.swing.JButton btnLamMoi;
    private javax.swing.JButton btnSuaTK;
    private javax.swing.JButton btnThemTK;
    private javax.swing.JButton btnTimKiem;
    private javax.swing.JButton btnXoaTK;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel pnlCenter;
    private javax.swing.JPanel pnlTop;
    private javax.swing.JTable tblTaiKhoan;
    private javax.swing.JTextField txtTimKiem;
    // End of variables declaration//GEN-END:variables
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnThemTK) {
            themTK = new ThemTKhoan();
            themTK.setLocationRelativeTo(null);
            themTK.setVisible(true);
        } else if (e.getSource() == btnXoaTK) {
            xoaTaiKhoan();
        } else if (e.getSource() == btnSuaTK) {
            if (selectTaiKhoan()!= null) {
                suaTK = new SuaTKhoan(selectTaiKhoan());
                suaTK.setLocationRelativeTo(null);
                suaTK.setVisible(true);
            } else {
                JOptionPane.showMessageDialog(null, "Vui lòng chọn tài khoản");
            }
        } 
    }
}

