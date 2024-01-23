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
import controller.SachDAO;
import java.awt.Desktop;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import model.ChiTietHoaDon;
import model.HoaDon;
import model.TaiKhoan;
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
public class ThongKeForm extends javax.swing.JInternalFrame {

    private DefaultTableModel tblModel;
    DecimalFormat formatter = new DecimalFormat("#,###");
    SimpleDateFormat formatDate = new SimpleDateFormat("dd/MM/YYYY HH:mm");
    public ThongKeForm(TaiKhoan tk) {
        initComponents();
        BasicInternalFrameUI ui = (BasicInternalFrameUI) this.getUI();
        ui.setNorthPane(null);
        tblThongKe.setDefaultEditor(Object.class, null);
        jDateChooserFrom.setDateFormatString("dd/MM/yyyy");
        jDateChooserTo.setDateFormatString("dd/MM/yyyy");
        initTable();
        loadDataToTable();
        checkRole(tk);
    }
    
public void checkRole(TaiKhoan t) {
        if(t.getRole().equals("Nhân viên")) {
            txtDoanhThu.setVisible(false);
            txtLoiNhuan.setVisible(false);
        } 
    }

  public final void initTable() {
        tblModel = (DefaultTableModel) tblThongKe.getModel();
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment( JLabel.CENTER );
tblThongKe.setDefaultRenderer(String.class, centerRenderer);
        String[] headerTbl = new String[]{"STT","Mã hóa đơn", "Tên khách hàng", "Ngày lập", "Tổng tiền"};
        tblModel.setColumnIdentifiers(headerTbl);
        tblThongKe.getColumnModel().getColumn(0).setPreferredWidth(5);
        tblThongKe.getColumnModel().getColumn(1).setPreferredWidth(5);
        tblThongKe.getColumnModel().getColumn(2).setPreferredWidth(200);
        tblThongKe.getColumnModel().getColumn(3).setPreferredWidth(5);
        tblThongKe.getColumnModel().getColumn(4).setPreferredWidth(5);
       
    }

    public void loadDataToTable() {
        try {
            ArrayList<HoaDon> hoaDon = HoaDonDAO.getInstance().selectAll();
            tinhDoanhThuLoiNhuan(hoaDon);
            tblModel.setRowCount(0);
            for (int i=0; i<hoaDon.size(); i++) {
                tblModel.addRow(new Object[]{
                    i + 1, hoaDon.get(i).getMaHoaDon(),hoaDon.get(i).getTenKhachHang(),formatDate.format(hoaDon.get(i).getNgayLap()),formatter.format(hoaDon.get(i).getTongTien())+"d"
                });
            }
        } catch (Exception e) {
        }
    
    }
    
    private void tinhDoanhThuLoiNhuan(ArrayList<HoaDon> list){
        int doanhThu = 0;
        int loiNhuan = 0;
        int goc = 0;
        for(HoaDon i : list){
            doanhThu += i.getTongTien();
            goc += giaGoc(i.getMaHoaDon());
        }
        txtDoanhThu.setText(formatter.format(doanhThu)+ " Ð");
        loiNhuan = doanhThu - goc;
        txtLoiNhuan.setText(formatter.format(loiNhuan)+ " Ð");
        
    }
    //giá goc trên moi hoa don
    private int giaGoc(int maHd){
        int ketqua = 0;
        ArrayList<ChiTietHoaDon> listCTHD = ChiTietHoaDonDAO.getInstance().selectAll(maHd);
        for(ChiTietHoaDon i: listCTHD){
            ketqua+= i.getSoLuong() * SachDAO.getInstance().searchId(i.getMaSach()).getGiaNhap();
        }
        return ketqua;
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
        jScrollPane1 = new javax.swing.JScrollPane();
        tblThongKe = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jDateChooserFrom = new com.toedter.calendar.JDateChooser();
        jDateChooserTo = new com.toedter.calendar.JDateChooser();
        jLabel1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jButton6 = new javax.swing.JButton();
        txtLoiNhuan = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtDoanhThu = new javax.swing.JLabel();

        setBorder(null);
        setPreferredSize(new java.awt.Dimension(1180, 750));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tblThongKe.setBackground(new java.awt.Color(206, 249, 206));
        tblThongKe.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tblThongKe.setGridColor(new java.awt.Color(51, 255, 51));
        jScrollPane1.setViewportView(tblThongKe);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 130, 922, 370));

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Lọc theo ngày", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 14))); // NOI18N
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jDateChooserFrom.setBackground(new java.awt.Color(255, 255, 255));
        jDateChooserFrom.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jDateChooserFromPropertyChange(evt);
            }
        });
        jDateChooserFrom.addVetoableChangeListener(new java.beans.VetoableChangeListener() {
            public void vetoableChange(java.beans.PropertyChangeEvent evt)throws java.beans.PropertyVetoException {
                jDateChooserFromVetoableChange(evt);
            }
        });
        jPanel4.add(jDateChooserFrom, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 30, 170, -1));

        jDateChooserTo.setBackground(new java.awt.Color(255, 255, 255));
        jDateChooserTo.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jDateChooserToPropertyChange(evt);
            }
        });
        jPanel4.add(jDateChooserTo, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 30, 170, -1));

        jLabel1.setText("Đến");
        jPanel4.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 30, 40, 20));

        jLabel5.setFont(new java.awt.Font("SF Pro Display", 0, 14)); // NOI18N
        jLabel5.setText("Từ");
        jPanel4.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 20, 20));

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 20, 493, 74));

        jButton6.setFont(new java.awt.Font("SF Pro Display", 0, 15)); // NOI18N
        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8_spreadsheet_file_40px.png"))); // NOI18N
        jButton6.setText("Xuất Excel");
        jButton6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton6.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton6.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 30, -1, 61));

        txtLoiNhuan.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        txtLoiNhuan.setForeground(new java.awt.Color(255, 51, 51));
        txtLoiNhuan.setText("T");
        jPanel1.add(txtLoiNhuan, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 570, 250, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel3.setText("TỔNG DOANH THU:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 530, 170, -1));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel4.setText("LỢI NHUẬN:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 570, 180, -1));

        txtDoanhThu.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        txtDoanhThu.setForeground(new java.awt.Color(255, 51, 51));
        txtDoanhThu.setText("T");
        jPanel1.add(txtDoanhThu, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 530, 250, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1055, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 726, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
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
                for (int i = 0; i < tblThongKe.getColumnCount(); i++) {
                    Cell cell = rowCol.createCell(i);
                    cell.setCellValue(tblThongKe.getColumnName(i));
                }

                for (int j = 0; j < tblThongKe.getRowCount(); j++) {
                    Row row = sheet.createRow(j + 1);
                    for (int k = 0; k < tblThongKe.getColumnCount(); k++) {
                        Cell cell = row.createCell(k);
                        if (tblThongKe.getValueAt(j, k) != null) {
                            cell.setCellValue(tblThongKe.getValueAt(j, k).toString());
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
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jDateChooserFromPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jDateChooserFromPropertyChange
        // TODO add your handling code here:
      locThongKe2();
    }//GEN-LAST:event_jDateChooserFromPropertyChange

    private void jDateChooserToPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jDateChooserToPropertyChange
        // TODO add your handling code here:
        locThongKe2();
    }//GEN-LAST:event_jDateChooserToPropertyChange

    private void jDateChooserFromVetoableChange(java.beans.PropertyChangeEvent evt)throws java.beans.PropertyVetoException {//GEN-FIRST:event_jDateChooserFromVetoableChange
        // TODO add your handling code here:
        
    }//GEN-LAST:event_jDateChooserFromVetoableChange

    private void locThongKe2() {
        System.out.println("tét");
           ArrayList<HoaDon> result = new ArrayList<>();
        if (jDateChooserFrom.getDate() != null || jDateChooserTo.getDate() != null) {
            Date from;
            Date to;
            if (jDateChooserFrom.getDate() != null && jDateChooserTo.getDate() == null) {
                try {
                    from = ChangeFrom(jDateChooserFrom.getDate());
                    to = ChangeTo(new Date());
                    result = HoaDonDAO.getInstance().sellectDateRange(from, to);
                } catch (ParseException ex) {
                    Logger.getLogger(ThongKeForm.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else if (jDateChooserTo.getDate() != null && jDateChooserFrom.getDate() == null) {
                try {
                    String sDate1 = "01/01/2002";
                    from = ChangeFrom(new SimpleDateFormat("dd/MM/yyyy").parse(sDate1));
                    to = ChangeTo(jDateChooserTo.getDate());
                    result = HoaDonDAO.getInstance().sellectDateRange(from, to);
                } catch (ParseException ex) {
                    Logger.getLogger(ThongKeForm.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                try {
                    from = ChangeFrom(jDateChooserFrom.getDate());
                    to = ChangeTo(jDateChooserTo.getDate());
                    if (from.getTime() > to.getTime()) {
                        JOptionPane.showMessageDialog(this, "Thời gian không hợp lệ !", "Cảnh báo", JOptionPane.WARNING_MESSAGE);
                        jDateChooserFrom.setCalendar(null);
                        jDateChooserTo.setCalendar(null);
                    } else {
                        result = HoaDonDAO.getInstance().sellectDateRange(from, to);
                    }
                } catch (ParseException ex) {
                    Logger.getLogger(ThongKeForm.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            loadDataToTableArr(result);
        }
        
//    if (from != null && to != null) {
//        ArrayList<HoaDon> result = HoaDonDAO.getInstance().sellectDateRange(from, to);
//        loadDataToTableArr(result);
//    } else {
//        // Xử lý trường hợp không có ngày được chọn
//    }
}
    private void locThongKe(){
        System.out.println("test");
        ArrayList<HoaDon> result = HoaDonDAO.getInstance().selectAll();
        Iterator<HoaDon> itr = result.iterator();
        if (jDateChooserFrom.getDate() != null || jDateChooserTo.getDate() != null) {
            Date from;
            Date to;
            if (jDateChooserFrom.getDate() != null && jDateChooserTo.getDate() == null) {
                try {
                    from = ChangeFrom(jDateChooserFrom.getDate());
                    to = ChangeTo(new Date());
                    while (itr.hasNext()) {
                        HoaDon hd = itr.next();
                        if (!checkDate(hd.getNgayLap(), from, to)) {
                            itr.remove();
                        }
                    }
                } catch (ParseException ex) {
                    Logger.getLogger(ThongKeForm.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else if (jDateChooserTo.getDate() != null && jDateChooserFrom.getDate() == null) {
                try {
                    String sDate1 = "01/01/2002";
                    from = ChangeFrom(new SimpleDateFormat("dd/MM/yyyy").parse(sDate1));
                    to = ChangeTo(jDateChooserTo.getDate());
                    while (itr.hasNext()) {
                        HoaDon hd = itr.next();
                        if (!checkDate(hd.getNgayLap(), from, to)) {
                            itr.remove();
                        }
                    }
                } catch (ParseException ex) {
                    Logger.getLogger(ThongKeForm.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                try {
                    from = ChangeFrom(jDateChooserFrom.getDate());
                    to = ChangeTo(jDateChooserTo.getDate());
                    if (from.getTime() > to.getTime()) {
                        JOptionPane.showMessageDialog(this, "Thời gian không hợp lệ !", "Cảnh báo", JOptionPane.WARNING_MESSAGE);
                        jDateChooserFrom.setCalendar(null);
                        jDateChooserTo.setCalendar(null);
                    } else {
                        while (itr.hasNext()) {
                            HoaDon hd = itr.next();
                            if (!checkDate(hd.getNgayLap(), from, to)) {
                                itr.remove();
                            }
                        }
                    }
                } catch (ParseException ex) {
                    Logger.getLogger(ThongKeForm.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        loadDataToTableArr(result);
    }
    
    
    public boolean checkDate(Date dateTest, Date star, Date end) {
        return dateTest.getTime() >= star.getTime() && dateTest.getTime() <= end.getTime();
    }
    
    public Date ChangeFrom(Date date) throws ParseException {
        SimpleDateFormat fm = new SimpleDateFormat("dd-MM-yyyy 00:00:00");
        String dateText = fm.format(date);
        SimpleDateFormat par = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss");
        Date result = par.parse(dateText);
        return result;
    }

    public Date ChangeTo(Date date) throws ParseException {
        SimpleDateFormat fm = new SimpleDateFormat("dd-MM-yyyy 23:59:59");
        String dateText = fm.format(date);
        SimpleDateFormat par = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss");
        Date result = par.parse(dateText);
        return result;
    }
    
    private void loadDataToTableArr(ArrayList<HoaDon> list) {
        try {
            tblModel.setRowCount(0);
            for (int i = 0; i < list.size(); i++) {
                tblModel.addRow(new Object[]{
                    i + 1, list.get(i).getMaHoaDon(), list.get(i).getTenKhachHang(), formatDate.format(list.get(i).getNgayLap()), formatter.format(list.get(i).getTongTien()) + "đ"
                });
            }
        } catch (Exception e) {
        }
        tinhDoanhThuLoiNhuan(list);
    }



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton6;
    private com.toedter.calendar.JDateChooser jDateChooserFrom;
    private com.toedter.calendar.JDateChooser jDateChooserTo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblThongKe;
    private javax.swing.JLabel txtDoanhThu;
    private javax.swing.JLabel txtLoiNhuan;
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
