package controller;

import connect.JDBCUtil;
import java.sql.Timestamp;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;
import model.ChiTietHoaDon;
import model.HoaDon;

/**
 *
 * @author DELL
 */
public class HoaDonDAO implements InterfaceDAO<HoaDon> {

    public static HoaDonDAO getInstance() {
        return new HoaDonDAO();
    }

    @Override
    public int insert(HoaDon t) {
        int ketQua = 0;
        try {
            Connection con = JDBCUtil.getConnection();
            String sql = "INSERT INTO hoadon (ma_hoa_don, ten_nguoi_mua, ngay_lap, tong_tien) VALUES (?,?,?,?)";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, t.getMaHoaDon());
            pst.setString(2, t.getTenKhachHang());
            pst.setTimestamp(3, t.getNgayLap());
            pst.setInt(4, t.getTongTien());

            ketQua = pst.executeUpdate();
            JDBCUtil.closeConnection(con);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Không thêm được ");
        }
        return ketQua;
    }

    @Override
    public int update(HoaDon t) {
        int ketQua = 0;
        try {
            Connection con = JDBCUtil.getConnection();
            String sql = "UPDATE hoadon SET ma_hoa_don=?, ten_nguoi_mua=?, ngay_lap=?, tong_tien=? WHERE ma_hoa_don=? ";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, t.getMaHoaDon());
            pst.setString(2, t.getTenKhachHang());
            pst.setTimestamp(3, t.getNgayLap());
            pst.setInt(4, t.getTongTien());
            pst.setInt(5, t.getMaHoaDon());
            ketQua = pst.executeUpdate();
            JDBCUtil.closeConnection(con);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ketQua;
    }

    @Override
    public int delete(HoaDon t) {
        int ketQua = 0;
        try {
            Connection con = JDBCUtil.getConnection();
            String sql = "DELETE FROM hoadon WHERE ma_hoa_don=? ";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, t.getMaHoaDon());
            ketQua = pst.executeUpdate();
            JDBCUtil.closeConnection(con);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ketQua;
    }

    @Override
    public ArrayList<HoaDon> selectAll() {
        ArrayList<HoaDon> ketQua = new ArrayList<HoaDon>();
        try {
            Connection con = JDBCUtil.getConnection();
            String sql = "SELECT * FROM hoadon";
            PreparedStatement pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                int maHoaDon = rs.getInt("ma_hoa_don");
                String tenKH = rs.getString("ten_nguoi_mua");
                Timestamp tacGia = rs.getTimestamp("ngay_lap");
                int tongTien = rs.getInt("tong_tien");
                ArrayList<ChiTietHoaDon> cthd = new ArrayList<>();
                cthd = ChiTietHoaDonDAO.getInstance().selectAll(maHoaDon);
                HoaDon hd = new HoaDon(maHoaDon, tenKH, tacGia, tongTien, cthd);
                ketQua.add(hd);
            }
            JDBCUtil.closeConnection(con);
        } catch (SQLException e) {
        }
        return ketQua;
    }

    @Override
    public HoaDon selectById(int t) {
        HoaDon ketQua = null;
        try {
            Connection con = JDBCUtil.getConnection();
            String sql = "SELECT * FROM hoadon WHERE ma_hoa_don=?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, t);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                int maHoaDon = rs.getInt("ma_hoa_don");
                String tenKH = rs.getString("ten_nguoi_mua");
                Timestamp tacGia = rs.getTimestamp("ngay_lap");
                int tongTien = rs.getInt("tong_tien");
                ketQua = new HoaDon(maHoaDon, tenKH, tacGia, tongTien, ChiTietHoaDonDAO.getInstance().selectAll(maHoaDon));
            }
            JDBCUtil.closeConnection(con);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ketQua;
    }

    public ArrayList<HoaDon> search(String text) {
        ArrayList<HoaDon> result = new ArrayList<>();
        ArrayList<HoaDon> hdList = this.selectAll();
        for (HoaDon sach : hdList) {
            String mhd = sach.getMaHoaDon() + "";
            String tongTien = sach.getTongTien() + "";

            if (mhd.contains(text) || tongTien.contains(text)
                    || sach.getTenKhachHang().toLowerCase().contains(text.toLowerCase())) {
                result.add(sach);
            }
        }
        return result;
    }

     public ArrayList<HoaDon> sellectDateRange(Date fromDate, Date toDate) {
        ArrayList<HoaDon> ketQua = new ArrayList<HoaDon>();
        try {
            Connection con = JDBCUtil.getConnection();
            String sql = "SELECT * FROM hoadon WHERE ngay_lap >= ? AND ngay_lap <= ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setTimestamp(1, new Timestamp(fromDate.getTime()));
            pst.setTimestamp(2, new Timestamp(toDate.getTime()));
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                int maHoaDon = rs.getInt("ma_hoa_don");
                String tenKH = rs.getString("ten_nguoi_mua");
                Timestamp tacGia = rs.getTimestamp("ngay_lap");
                int tongTien = rs.getInt("tong_tien");
                HoaDon hd = new HoaDon(maHoaDon, tenKH, tacGia, tongTien);
                ketQua.add(hd);
            }
            JDBCUtil.closeConnection(con);
        } catch (SQLException e) {
        }
        return ketQua;
    }
    
}
