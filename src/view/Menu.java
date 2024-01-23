package view;

import com.formdev.flatlaf.FlatLightLaf;
import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import model.TaiKhoan;

/**
 *
 * @author DELL
 */
public class Menu extends javax.swing.JFrame {

    /**
     * Creates new form Menu
     */
    private TaiKhoan taiKhoan;
    public TaiKhoan getCurrentAcc() {
        return taiKhoan;
    }
    
    public Menu(TaiKhoan tk) {
        initComponents();
//        BasicInternalFrameUI ui = (BasicInternalFrameUI) this.getUI();
//        ui.setNorthPane(null);
        
        UIManager.put("Table.showVerticalLines", true);
        UIManager.put("Table.showHorizontalLines", true);

        this.taiKhoan = tk;
        SachForm nf = new SachForm(this.taiKhoan);
        jPanel3.add(nf).setVisible(true);
        txtTenNguoiDung.setText(taiKhoan.getFullName());
        tabSach.setBackground(Color.WHITE);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        if(this.taiKhoan.getRole().equals("Nhân viên")){
            tabTaiKhoan.setVisible(false);
            tabKho.setVisible(false);
        }
    }

    private Menu() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        txtTenNguoiDung = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        tabSach = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        tabHoaDon = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        tabThongKe = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        tabTaiKhoan = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        tabKho = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        btnDangXuat = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(102, 102, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setFont(new java.awt.Font("Segoe UI", 3, 28)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("MENU");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(53, 16, 93, -1));

        txtTenNguoiDung.setFont(new java.awt.Font("Verdana", 0, 16)); // NOI18N
        txtTenNguoiDung.setForeground(new java.awt.Color(153, 255, 51));
        txtTenNguoiDung.setText("admin123");
        jPanel1.add(txtTenNguoiDung, new org.netbeans.lib.awtextra.AbsoluteConstraints(44, 60, 115, -1));
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(37, 87, 122, 12));

        tabSach.setBackground(new java.awt.Color(204, 204, 255));
        tabSach.setPreferredSize(new java.awt.Dimension(135, 48));
        tabSach.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabSachMouseClicked(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Verdana", 0, 24)); // NOI18N
        jLabel1.setText("Sách");
        jLabel1.setAlignmentY(0.0F);

        javax.swing.GroupLayout tabSachLayout = new javax.swing.GroupLayout(tabSach);
        tabSach.setLayout(tabSachLayout);
        tabSachLayout.setHorizontalGroup(
            tabSachLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tabSachLayout.createSequentialGroup()
                .addGap(64, 64, 64)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(89, Short.MAX_VALUE))
        );
        tabSachLayout.setVerticalGroup(
            tabSachLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, tabSachLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel1)
                .addContainerGap())
        );

        jPanel1.add(tabSach, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 180, 222, -1));

        tabHoaDon.setBackground(new java.awt.Color(204, 204, 255));
        tabHoaDon.setPreferredSize(new java.awt.Dimension(166, 47));
        tabHoaDon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabHoaDonMouseClicked(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Verdana", 0, 24)); // NOI18N
        jLabel2.setText("Hóa đơn");

        javax.swing.GroupLayout tabHoaDonLayout = new javax.swing.GroupLayout(tabHoaDon);
        tabHoaDon.setLayout(tabHoaDonLayout);
        tabHoaDonLayout.setHorizontalGroup(
            tabHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tabHoaDonLayout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        tabHoaDonLayout.setVerticalGroup(
            tabHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tabHoaDonLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.add(tabHoaDon, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 240, 222, -1));

        tabThongKe.setBackground(new java.awt.Color(204, 204, 255));
        tabThongKe.setPreferredSize(new java.awt.Dimension(166, 47));
        tabThongKe.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabThongKeMouseClicked(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Verdana", 0, 24)); // NOI18N
        jLabel3.setText("Thống kê");

        javax.swing.GroupLayout tabThongKeLayout = new javax.swing.GroupLayout(tabThongKe);
        tabThongKe.setLayout(tabThongKeLayout);
        tabThongKeLayout.setHorizontalGroup(
            tabThongKeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tabThongKeLayout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(jLabel3)
                .addContainerGap(61, Short.MAX_VALUE))
        );
        tabThongKeLayout.setVerticalGroup(
            tabThongKeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tabThongKeLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.add(tabThongKe, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 300, 222, -1));

        tabTaiKhoan.setBackground(new java.awt.Color(204, 204, 255));
        tabTaiKhoan.setPreferredSize(new java.awt.Dimension(168, 47));
        tabTaiKhoan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabTaiKhoanMouseClicked(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Verdana", 0, 24)); // NOI18N
        jLabel6.setText("Tài khoản");

        javax.swing.GroupLayout tabTaiKhoanLayout = new javax.swing.GroupLayout(tabTaiKhoan);
        tabTaiKhoan.setLayout(tabTaiKhoanLayout);
        tabTaiKhoanLayout.setHorizontalGroup(
            tabTaiKhoanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tabTaiKhoanLayout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addComponent(jLabel6)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        tabTaiKhoanLayout.setVerticalGroup(
            tabTaiKhoanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tabTaiKhoanLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel6)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.add(tabTaiKhoan, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 420, 222, -1));

        tabKho.setBackground(new java.awt.Color(204, 204, 255));
        tabKho.setPreferredSize(new java.awt.Dimension(122, 47));
        tabKho.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabKhoMouseClicked(evt);
            }
        });

        jLabel17.setFont(new java.awt.Font("Verdana", 0, 24)); // NOI18N
        jLabel17.setText("Kho");

        javax.swing.GroupLayout tabKhoLayout = new javax.swing.GroupLayout(tabKho);
        tabKho.setLayout(tabKhoLayout);
        tabKhoLayout.setHorizontalGroup(
            tabKhoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tabKhoLayout.createSequentialGroup()
                .addGap(69, 69, 69)
                .addComponent(jLabel17)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        tabKhoLayout.setVerticalGroup(
            tabKhoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tabKhoLayout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addComponent(jLabel17)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.add(tabKho, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 360, 222, -1));

        btnDangXuat.setBackground(new java.awt.Color(255, 51, 51));
        btnDangXuat.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnDangXuat.setForeground(new java.awt.Color(255, 255, 255));
        btnDangXuat.setText("Đăng xuất");
        jPanel1.add(btnDangXuat, new org.netbeans.lib.awtextra.AbsoluteConstraints(42, 588, 131, -1));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 817, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 636, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tabSachMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabSachMouseClicked

        SachForm sf = new SachForm(this.taiKhoan);
        jPanel3.removeAll();
        jPanel3.add(sf).setVisible(true);

        tabSach.setBackground(Color.WHITE);
        
        tabHoaDon.setBackground(new Color(204, 204, 255));
        tabThongKe.setBackground(new Color(204, 204, 255));
        tabTaiKhoan.setBackground(new Color(204, 204, 255));
        tabKho.setBackground(new Color(204, 204, 255));
    }//GEN-LAST:event_tabSachMouseClicked

    private void tabHoaDonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabHoaDonMouseClicked


        HoaDonForm hdf = new HoaDonForm();
        jPanel3.removeAll();
        jPanel3.add(hdf).setVisible(true);
//        jPanel3.add(hdf).setVisible(true);
        tabHoaDon.setBackground(Color.WHITE);
        
        tabSach.setBackground(new Color(204, 204, 255));
        tabThongKe.setBackground(new Color(204, 204, 255));
        tabTaiKhoan.setBackground(new Color(204, 204, 255));
        tabKho.setBackground(new Color(204, 204, 255));
    }//GEN-LAST:event_tabHoaDonMouseClicked

    private void tabThongKeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabThongKeMouseClicked

        ThongKeForm tkf = new ThongKeForm(this.taiKhoan);
        jPanel3.removeAll();
        jPanel3.add(tkf).setVisible(true);
        tabThongKe.setBackground(Color.WHITE);
       
        tabHoaDon.setBackground(new Color(204, 204, 255));
        tabSach.setBackground(new Color(204, 204, 255));
        tabTaiKhoan.setBackground(new Color(204, 204, 255));
        tabKho.setBackground(new Color(204, 204, 255));
    }//GEN-LAST:event_tabThongKeMouseClicked

    private void tabTaiKhoanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabTaiKhoanMouseClicked

        
        TaiKhoanForm tkf = new TaiKhoanForm();
        jPanel3.removeAll();
        jPanel3.add(tkf).setVisible(true);
        tabTaiKhoan.setBackground(Color.WHITE);
        
        tabHoaDon.setBackground(new Color(204, 204, 255));
        tabThongKe.setBackground(new Color(204, 204, 255));
        tabSach.setBackground(new Color(204, 204, 255));
        tabKho.setBackground(new Color(204, 204, 255));
    }//GEN-LAST:event_tabTaiKhoanMouseClicked

    private void tabKhoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabKhoMouseClicked
        // TODO add your handling code here:
//                jpSach.setVisible(false);
//                jpBaoCao.setVisible(false);
//                jpHoaDon.setVisible(false);
//                jpThongKe.setVisible(false);
//                jpTaiKhoan.setVisible(false);
//                jpKho.setVisible(true);
        KhoForm sf = new KhoForm();
        jPanel3.removeAll();
        jPanel3.add(sf).setVisible(true);
        tabKho.setBackground(Color.WHITE);
     
        tabHoaDon.setBackground(new Color(204, 204, 255));
        tabThongKe.setBackground(new Color(204, 204, 255));
        tabSach.setBackground(new Color(204, 204, 255));
        tabTaiKhoan.setBackground(new Color(204, 204, 255));
    }//GEN-LAST:event_tabKhoMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        try {
            UIManager.setLookAndFeel(new FlatLightLaf());
        } catch (Exception ex) {
            System.err.println("Failed to initialize LaF");
        }
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Menu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDangXuat;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JPanel tabHoaDon;
    private javax.swing.JPanel tabKho;
    private javax.swing.JPanel tabSach;
    private javax.swing.JPanel tabTaiKhoan;
    private javax.swing.JPanel tabThongKe;
    private javax.swing.JLabel txtTenNguoiDung;
    // End of variables declaration//GEN-END:variables
}
