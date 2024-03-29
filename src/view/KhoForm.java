/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package view;

//import controller.SearchProduct;
//import dao.LaptopDAO;
//import dao.MayTinhDAO;
//import dao.PCDAO;
import controller.NhaXuatBanDAO;
import controller.SachDAO;
import java.awt.Desktop;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.table.DefaultTableModel;
import model.NhaXuatBan;
import model.Sach;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
//import model.Account;
//import model.Laptop;
//import model.MayTinh;
//import model.PC;
//import org.apache.poi.ss.usermodel.Cell;
//import org.apache.poi.ss.usermodel.Row;
//import org.apache.poi.ss.usermodel.Sheet;
//import org.apache.poi.ss.usermodel.Workbook;
//import org.apache.poi.xssf.usermodel.XSSFRow;
//import org.apache.poi.xssf.usermodel.XSSFSheet;
//import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author Robot
 */
public class KhoForm extends javax.swing.JInternalFrame {

    private DefaultTableModel tblModel;
    DecimalFormat formatter = new DecimalFormat("#,###");
    
    
    public KhoForm() {
        initComponents();
        BasicInternalFrameUI ui = (BasicInternalFrameUI) this.getUI();
        ui.setNorthPane(null);
//        tblSanPham.setDefaultEditor(Object.class, null);
        initTable();
        loadDataToTable();
//        changeTextFind();
    }

public final void initTable() {
        tblModel = (DefaultTableModel) tblSach.getModel();
        String[] headerTbl = new String[]{"STT","Mã sách", "Tên sách", "Giá nhập", "Giá bán", "Số lượng"};
        tblModel.setColumnIdentifiers(headerTbl);
//        tblSanPham.setModel(tblModel);
        tblSach.getColumnModel().getColumn(0).setPreferredWidth(5);
        tblSach.getColumnModel().getColumn(1).setPreferredWidth(5);
        tblSach.getColumnModel().getColumn(2).setPreferredWidth(200);
        tblSach.getColumnModel().getColumn(3).setPreferredWidth(5);
        tblSach.getColumnModel().getColumn(4).setPreferredWidth(5);
       tblSach.getColumnModel().getColumn(5).setPreferredWidth(5);
    }

    public void loadDataToTable() {

//        SachDAO sach = new SachDAO();
        ArrayList<Sach> listSach = SachDAO.getInstance().selectAll();
        tblModel.setRowCount(0);
        for (int i=0; i<listSach.size(); i++) {

            tblModel.addRow(new Object[]{
                i+1, listSach.get(i).getMaSach(), listSach.get(i).getTenSach(), formatter.format(listSach.get(i).getGiaNhap()) + "đ", formatter.format(listSach.get(i).getGiaBan()) + "d", listSach.get(i).getSoLuong()
            });

        }

    }
    
    public void loadDataToTableSearch(ArrayList<Sach> result) {
       
            tblModel.setRowCount(0);
           for (int i=0; i<result.size(); i++) {

            tblModel.addRow(new Object[]{
                i+1, result.get(i).getMaSach(), result.get(i).getTenSach(), formatter.format(result.get(i).getGiaNhap()) + "đ", formatter.format(result.get(i).getGiaBan()) + "d", result.get(i).getSoLuong()
            });

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

        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblSach = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jTextFieldSearch = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtSoLuong = new javax.swing.JTextField();
        addQuantity = new javax.swing.JButton();

        setBorder(null);
        setPreferredSize(new java.awt.Dimension(1180, 750));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        tblSach.setBackground(new java.awt.Color(255, 204, 204));
        tblSach.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tblSach.setGridColor(new java.awt.Color(255, 153, 153));
        jScrollPane1.setViewportView(tblSach);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Tìm kiếm"));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTextFieldSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldSearchActionPerformed(evt);
            }
        });
        jTextFieldSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextFieldSearchKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextFieldSearchKeyReleased(evt);
            }
        });
        jPanel3.add(jTextFieldSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 340, 40));

        jLabel4.setText("Số lượng");

        txtSoLuong.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtSoLuong.setText("1");

        addQuantity.setBackground(javax.swing.UIManager.getDefaults().getColor("Actions.Green"));
        addQuantity.setForeground(new java.awt.Color(255, 255, 255));
        addQuantity.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8_add_25px_5.png"))); // NOI18N
        addQuantity.setText("Thêm số lượng");
        addQuantity.setBorder(null);
        addQuantity.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        addQuantity.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addQuantityActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(93, 93, 93)
                        .addComponent(jLabel4)
                        .addGap(27, 27, 27)
                        .addComponent(txtSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32)
                        .addComponent(addQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(203, 203, 203)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 381, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 947, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(93, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(65, 65, 65)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4)
                            .addComponent(addQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(52, 52, 52)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(28, 28, 28)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 495, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(56, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextFieldSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldSearchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldSearchActionPerformed

    private void jTextFieldSearchKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldSearchKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldSearchKeyPressed

    private void jTextFieldSearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldSearchKeyReleased
        // TODO add your handling code here:

        String content = jTextFieldSearch.getText();
        ArrayList<Sach> result = SachDAO.getInstance().search(content);
        loadDataToTableSearch(result);
    }//GEN-LAST:event_jTextFieldSearchKeyReleased

    private void addQuantityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addQuantityActionPerformed
        // TODO add your handling code here:
        int i_row = tblSach.getSelectedRow();
        if (i_row == -1) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn sách để thêm số lượng !");
        } else {
            int soluong;
            int maS = 0;
            try {
                soluong = Integer.parseInt(txtSoLuong.getText().trim());
                if (soluong > 0) {
                    maS = Integer.parseInt(tblSach.getValueAt(i_row, 1).toString());
                    Sach s = SachDAO.getInstance().searchId(maS);
                    SachDAO.getInstance().updateSoLuong(maS, s.getSoLuong()+soluong);
                    loadDataToTable();
                    //                    textTongTien.setText(formatter.format(tinhTongTien()) + "đ");
                } else {
                    JOptionPane.showMessageDialog(this, "Vui lòng nhập số lượng > 0 và không lớn hơn số lượng hiện có");
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Vui lòng nhập số lượng ở dạng số nguyên!");
                e.printStackTrace();
            }
        }
    }//GEN-LAST:event_addQuantityActionPerformed

//    public void xoaSachSelected() {
//        
//        int luaChon = JOptionPane.showConfirmDialog(this, "Bạn có muốn xoá quyển sách này?", "Xoá sách",
//                JOptionPane.YES_NO_OPTION);
//        if (luaChon == JOptionPane.YES_OPTION) {
//            
//            SachDAO.getInstance().delete(getSelected());
//            
//        }
//        loadDataToTable();
//    }
//    
//     public Sach getSelected() {
//        int i_row = tblSach.getSelectedRow();
//        int maS = Integer.parseInt(tblSach.getValueAt(i_row, 0).toString());
//        Sach s = SachDAO.getInstance().selectById(maS);
//        return s;
//    }
     
//      public void loadDataToTableSearch(ArrayList<Sach> result) {
//       
//            tblModel.setRowCount(0);
//            for (Sach i : result) {
//                
//                tblModel.addRow(new Object[]{
//                i.getMaSach(), i.getTenSach(), i.getTenTG(),i.getTheLoai(),i.getNxb(), formatter.format(i.getGiaNhap()) + "đ", formatter.format(i.getGiaBan()) + "d", i.getSoLuong()
//            });
//            }
//        
//    }

   


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addQuantity;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextFieldSearch;
    private javax.swing.JTable tblSach;
    private javax.swing.JTextField txtSoLuong;
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
