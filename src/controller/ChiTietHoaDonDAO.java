package controller;

import connect.JDBCUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.ChiTietHoaDon;

/**
 *
 * @author DELL
 */
public class ChiTietHoaDonDAO implements InterfaceDAO<ChiTietHoaDon>{

    public static ChiTietHoaDonDAO getInstance() {
        return new ChiTietHoaDonDAO();
    }
    @Override
    public int insert(ChiTietHoaDon t) {
        int ketQua = 0;
        try {
            Connection con = JDBCUtil.getConnection();
            String sql = "INSERT INTO chitiethoadon (ma_hoa_don, ma_sach, so_luong, thanh_tien) VALUES (?,?,?,?)";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, t.getMaHoaDon());
            pst.setInt(2, t.getMaSach());
            pst.setInt(3, t.getSoLuong());
            pst.setInt(4, t.getThanhTien());
            
           
            ketQua = pst.executeUpdate();
            JDBCUtil.closeConnection(con);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ketQua;
    }

    @Override
    public int update(ChiTietHoaDon t) {
        int ketQua = 0;
        try {
            Connection con = JDBCUtil.getConnection();
            String sql = "UPDATE chitiethoadon SET ma_hoa_don=?, ma_sach=?, so_luong=?, thanh_tien=? WHERE ma_hoa_don=? ";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, t.getMaHoaDon());
            pst.setInt(2, t.getMaSach());
            pst.setInt(3, t.getSoLuong());
            pst.setInt(4, t.getThanhTien());
            pst.setInt(4, t.getMaHoaDon());
            ketQua = pst.executeUpdate();
            JDBCUtil.closeConnection(con);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ketQua;
    }

    @Override
    public int delete(ChiTietHoaDon t) {
       int ketQua = 0;
        try {
            Connection con = JDBCUtil.getConnection();
            String sql = "DELETE FROM chitiethoadon WHERE ma_hoa_don=? ";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, t.getMaHoaDon());
            ketQua = pst.executeUpdate();
            JDBCUtil.closeConnection(con);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ketQua;
    }

    public ArrayList<ChiTietHoaDon> selectAll(int text) {
        ArrayList<ChiTietHoaDon> ketQua = new ArrayList<ChiTietHoaDon>();
        try {
            Connection con = JDBCUtil.getConnection();
            String sql = "SELECT * FROM chitiethoadon WHERE ma_hoa_don=?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, text);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                int maHd = rs.getInt("ma_hoa_don");
                int maSach = rs.getInt("ma_sach");
                int soLuong = rs.getInt("so_luong");
                int thanhTien = rs.getInt("thanh_tien");
                ChiTietHoaDon cthd = new ChiTietHoaDon(maHd, maSach, soLuong, thanhTien);
                ketQua.add(cthd);
            }
            JDBCUtil.closeConnection(con);
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return ketQua;
    }
    
    @Override
    public ArrayList<ChiTietHoaDon> selectAll() {
        
        ArrayList<ChiTietHoaDon> ketQua = new ArrayList<ChiTietHoaDon>();
//        try {
//            Connection con = JDBCUtil.getConnection();
//            String sql = "SELECT * FROM ChiTietPhieuNhap WHERE maPhieu=?";
//            PreparedStatement pst = con.prepareStatement(sql);
//            pst.setString(1, t);
//            ResultSet rs = pst.executeQuery();
//            while (rs.next()) {
//                String maPhieu = rs.getString("maPhieu");
//                String maMay = rs.getString("maMay");
//                int soLuong = rs.getInt("soLuong");
//                double donGia = rs.getDouble("donGia");
//                ChiTietPhieu ctp = new ChiTietPhieu(maPhieu, maMay, soLuong, donGia);
//                ketQua.add(ctp);
//            }
//            JDBCUtil.closeConnection(con);
//        } catch (Exception e) {
//            // TODO: handle exception
//            e.printStackTrace();
//        }
        return ketQua;
    }

    @Override
    public ChiTietHoaDon selectById(int t) {
         ChiTietHoaDon ketQua = null;
        try {
            Connection con = JDBCUtil.getConnection();
            String sql = "SELECT * FROM chitiethoadon WHERE ma_hoa_don=?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, t);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                int maHoaDon = rs.getInt("ma_hoa_don");
                int maSach = rs.getInt("ma_sach");
                int soLuong = rs.getInt("so_luong");
                int thanhTien = rs.getInt("thanh_tien");
                ketQua = new ChiTietHoaDon(maHoaDon, maSach, soLuong, thanhTien);
            }
            JDBCUtil.closeConnection(con);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ketQua;
    }

//    public ChiTietHoaDon selectById(int t) {
//         ChiTietHoaDon ketQua = null;
//        try {
//            Connection con = JDBCUtil.getConnection();
//            String sql = "SELECT * FROM chitiethoadon WHERE ma_hoa_don=?";
//            PreparedStatement pst = con.prepareStatement(sql);
//            pst.setInt(1, t);
//            ResultSet rs = pst.executeQuery();
//            while (rs.next()) {
//                int maHoaDon = rs.getInt("ma_hoa_don");
//                int maSach = rs.getInt("ma_sach");
//                int soLuong = rs.getInt("so_luong");
//                int thanhTien = rs.getInt("thanh_tien");
//                ketQua = new ChiTietHoaDon(maHoaDon, maSach, soLuong, thanhTien);
//            }
//            JDBCUtil.closeConnection(con);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return ketQua;
//    }
    

}
