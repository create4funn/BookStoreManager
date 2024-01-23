/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package view;

//import controller.SearchProduct;
//import dao.LaptopDAO;
//import dao.MayTinhDAO;
//import dao.PCDAO;
import controller.ChiTietHoaDonDAO;
import controller.HoaDonDAO;
import java.awt.Desktop;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.table.DefaultTableModel;
import model.ChiTietHoaDon;
import model.HoaDon;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author Robot
 */
public class HoaDonForm extends javax.swing.JInternalFrame {

    private DefaultTableModel tblModel;
    DecimalFormat formatter = new DecimalFormat("#,###");
    SimpleDateFormat formatDate = new SimpleDateFormat("dd/MM/YYYY HH:mm");
    public HoaDonForm() {
        initComponents();
        BasicInternalFrameUI ui = (BasicInternalFrameUI) this.getUI();
        ui.setNorthPane(null);
        tblHoaDon.setDefaultEditor(Object.class, null);
        initTable();
        loadDataToTable();
//        changeTextFind();
    }


public final void initTable() {
        tblModel = (DefaultTableModel) tblHoaDon.getModel();
        
        String[] headerTbl = new String[]{"STT","Mã hóa đơn", "Tên khách hàng", "Ngày lập", "Tổng tiền"};
        tblModel.setColumnIdentifiers(headerTbl);
        tblHoaDon.getColumnModel().getColumn(0).setPreferredWidth(5);
        tblHoaDon.getColumnModel().getColumn(1).setPreferredWidth(5);
        tblHoaDon.getColumnModel().getColumn(2).setPreferredWidth(100);
        tblHoaDon.getColumnModel().getColumn(3).setPreferredWidth(10);
        tblHoaDon.getColumnModel().getColumn(4).setPreferredWidth(10);
    }

    public void loadDataToTable() {
        try {
            ArrayList<HoaDon> hoaDon = HoaDonDAO.getInstance().selectAll();
            tblModel.setRowCount(0);
            for (int i=0; i<hoaDon.size(); i++) {
                tblModel.addRow(new Object[]{
                    i + 1, hoaDon.get(i).getMaHoaDon(),hoaDon.get(i).getTenKhachHang(),formatDate.format(hoaDon.get(i).getNgayLap()),formatter.format(hoaDon.get(i).getTongTien())+"d"
                });
            }
        } catch (Exception e) {
        }
    
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
        jToolBar1 = new javax.swing.JToolBar();
        btnAdd = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JToolBar.Separator();
        jButton2 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jTextFieldSearch = new javax.swing.JTextField();
        jButton7 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblHoaDon = new javax.swing.JTable();

        setBorder(null);
        setPreferredSize(new java.awt.Dimension(1180, 750));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jToolBar1.setBackground(new java.awt.Color(255, 255, 255));
        jToolBar1.setBorder(javax.swing.BorderFactory.createTitledBorder("Chức năng"));
        jToolBar1.setRollover(true);

        btnAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8_add_40px.png"))); // NOI18N
        btnAdd.setText("Thêm");
        btnAdd.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAdd.setFocusable(false);
        btnAdd.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnAdd.setMargin(new java.awt.Insets(2, 15, 2, 15));
        btnAdd.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });
        jToolBar1.add(btnAdd);

        btnEdit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8_edit_40px.png"))); // NOI18N
        btnEdit.setText("Sửa");
        btnEdit.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEdit.setFocusable(false);
        btnEdit.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnEdit.setMargin(new java.awt.Insets(2, 15, 2, 14));
        btnEdit.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });
        jToolBar1.add(btnEdit);

        btnXoa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8_delete_40px.png"))); // NOI18N
        btnXoa.setText("Xóa");
        btnXoa.setFocusable(false);
        btnXoa.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnXoa.setMargin(new java.awt.Insets(2, 15, 2, 14));
        btnXoa.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });
        jToolBar1.add(btnXoa);
        jToolBar1.add(jSeparator1);

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8_spreadsheet_file_40px.png"))); // NOI18N
        jButton2.setText("Xuất excel");
        jButton2.setFocusable(false);
        jButton2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton2.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton2);

        jPanel1.add(jToolBar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 40, 369, -1));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Tìm kiếm"));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTextFieldSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextFieldSearchKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextFieldSearchKeyReleased(evt);
            }
        });
        jPanel3.add(jTextFieldSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 30, 410, 40));

        jButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8_reset_25px_1.png"))); // NOI18N
        jButton7.setText("Làm mới");
        jButton7.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton7.setDefaultCapable(false);
        jButton7.setFocusable(false);
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton7, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 30, 110, 40));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 40, 601, 84));

        tblHoaDon.setBackground(new java.awt.Color(187, 238, 244));
        tblHoaDon.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tblHoaDon.setGridColor(new java.awt.Color(0, 0, 255));
        jScrollPane1.setViewportView(tblHoaDon);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(48, 152, 938, 470));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1065, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 651, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        // TODO add your handling code here:
                if (tblHoaDon.getSelectedRow() == -1) {
                        JOptionPane.showMessageDialog(this, "Vui lòng chọn sản phẩm cần sửa");
                    } else {
                        SuaHoaDon a = new SuaHoaDon(this, (JFrame) javax.swing.SwingUtilities.getWindowAncestor(this), rootPaneCheckingEnabled);
                        a.setVisible(true);
                    }
    }//GEN-LAST:event_btnEditActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed

                TaoHoaDon a = new TaoHoaDon(this, (JFrame) javax.swing.SwingUtilities.getWindowAncestor(this), rootPaneCheckingEnabled);
                a.setVisible(true);
    }//GEN-LAST:event_btnAddActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        try {
            JFileChooser jFileChooser = new JFileChooser();
            jFileChooser.showSaveDialog(this);
            File saveFile = jFileChooser.getSelectedFile();
            if (saveFile != null) {
                saveFile = new File(saveFile.toString() + ".xlsx");
                Workbook wb = new XSSFWorkbook();
                Sheet sheet = wb.createSheet("Product");

                Row rowCol = sheet.createRow(0);
                for (int i = 0; i < tblHoaDon.getColumnCount(); i++) {
                    Cell cell = rowCol.createCell(i);
                    cell.setCellValue(tblHoaDon.getColumnName(i));
                }

                for (int j = 0; j < tblHoaDon.getRowCount(); j++) {
                    Row row = sheet.createRow(j + 1);
                    for (int k = 0; k < tblHoaDon.getColumnCount(); k++) {
                        Cell cell = row.createCell(k);
                        if (tblHoaDon.getValueAt(j, k) != null) {
                            cell.setCellValue(tblHoaDon.getValueAt(j, k).toString());
                        }

                    }
                }
                FileOutputStream out = new FileOutputStream(new File(saveFile.toString()));
                wb.write(out);
                wb.close();
                out.close();
                openFile(saveFile.toString());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
       
        loadDataToTable();
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jTextFieldSearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldSearchKeyReleased
        // TODO add your handling code here:
        //        String luaChon = jComboBoxLuaChon.getSelectedItem().toString();
                String content = jTextFieldSearch.getText();
                ArrayList<HoaDon> result = HoaDonDAO.getInstance().search(content);
                loadDataToTableSearch(result);
    }//GEN-LAST:event_jTextFieldSearchKeyReleased

    private void jTextFieldSearchKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldSearchKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldSearchKeyPressed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        // TODO add your handling code here:
        if (tblHoaDon.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn sản phẩm cần xoá");
        } else {
            xoaHoaDonSelected(getHoaDonSelect());
        }
    }//GEN-LAST:event_btnXoaActionPerformed

     public void xoaHoaDonSelected(HoaDon hd) {
        int result = JOptionPane.showConfirmDialog(this, "Bạn có chắc chắn muốn xoá " + hd.getMaHoaDon(), "Xác nhận xoá", JOptionPane.YES_NO_OPTION);
        if (result == JOptionPane.YES_OPTION) {
            ArrayList<ChiTietHoaDon> cthoadon = ChiTietHoaDonDAO.getInstance().selectAll(hd.getMaHoaDon());
            for (ChiTietHoaDon i : cthoadon) {
                ChiTietHoaDonDAO.getInstance().delete(i);
            }
            HoaDonDAO.getInstance().delete(hd);
            JOptionPane.showMessageDialog(this, "Đã xoá thành công phiếu " + hd.getMaHoaDon());
            loadDataToTable();
        }
    }
    public HoaDon getHoaDonSelect() {
        int i_row = tblHoaDon.getSelectedRow();
        HoaDon hd = HoaDonDAO.getInstance().selectAll().get(i_row);
        return hd;
    }
    
     public void loadDataToTableSearch(ArrayList<HoaDon> result) {
       
            tblModel.setRowCount(0);
            for (int i=0; i<result.size(); i++) {
                tblModel.addRow(new Object[]{
                    i + 1, result.get(i).getMaHoaDon(),result.get(i).getTenKhachHang(),formatDate.format(result.get(i).getNgayLap()),formatter.format(result.get(i).getTongTien())+"d"
                });
            }
        
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnXoa;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JToolBar.Separator jSeparator1;
    private javax.swing.JTextField jTextFieldSearch;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JTable tblHoaDon;
    // End of variables declaration//GEN-END:variables

    private void openFile(String file) {
        try {
            File path = new File(file);
            Desktop.getDesktop().open(path);
        } catch (IOException e) {
            System.out.println(e);
        }
    }
}
