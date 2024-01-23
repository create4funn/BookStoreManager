package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.Sach;
import connect.JDBCUtil;
import java.sql.SQLException;

/**
 *
 * @author DELL
 */
public class SachDAO implements InterfaceDAO<Sach> {

    public static SachDAO getInstance() {
        return new SachDAO();
    }

    @Override
    public int insert(Sach t) {
        int ketQua = 0;
        try {
            Connection con = JDBCUtil.getConnection();
            String sql = "INSERT INTO sach (ma_sach, ten_sach, tac_gia, the_loai, nxb, gia_nhap, gia_ban, so_luong) VALUES (?,?,?,?,?,?,?,?)";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, t.getMaSach());
            pst.setString(2, t.getTenSach());
            pst.setString(3, t.getTenTG());
            pst.setString(4, t.getTheLoai());
            pst.setString(5, t.getNxb());
            pst.setInt(6, t.getGiaNhap());
            pst.setInt(7, t.getGiaBan());
            pst.setInt(8, t.getSoLuong());
            ketQua = pst.executeUpdate();
            JDBCUtil.closeConnection(con);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Không thêm được " + t.getMaSach(), "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
        return ketQua;
    }

    @Override
    public int update(Sach t) {
        int ketQua = 0;
        try {
            Connection con = JDBCUtil.getConnection();
            String sql = "UPDATE sach SET ma_sach=?, ten_sach=?, tac_gia=?, the_loai=?, nxb=?, gia_nhap=?, gia_ban=?, so_luong=? WHERE ma_sach=? ";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, t.getMaSach());
            pst.setString(2, t.getTenSach());
            pst.setString(3, t.getTenTG());
            pst.setString(4, t.getTheLoai());
            pst.setString(5, t.getNxb());
            pst.setDouble(6, t.getGiaNhap());
            pst.setDouble(7, t.getGiaBan());
            pst.setInt(8, t.getSoLuong());
            pst.setInt(9, t.getMaSach());
            ketQua = pst.executeUpdate();
            JDBCUtil.closeConnection(con);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ketQua;
    }

//    public int updateSoLuong(Sach t) {
//        int ketQua = 0;
//        try {
//            Connection con = JDBCUtil.getConnection();
//            String sql = "UPDATE sach SET so_luong=? WHERE ma_sach=? ";
//            PreparedStatement pst = con.prepareStatement(sql);
//            pst.setInt(1, t.getSoLuong());
//            pst.setInt(2, t.getMaSach());
//            
//            ketQua = pst.executeUpdate();
//            JDBCUtil.closeConnection(con);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return ketQua;
//    }
    
    @Override
    public int delete(Sach t) {
        int ketQua = 0;
        try {
            Connection con = JDBCUtil.getConnection();
            String sql = "DELETE FROM sach WHERE ma_sach=? ";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, t.getMaSach());
            ketQua = pst.executeUpdate();
            JDBCUtil.closeConnection(con);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ketQua;
    }

    @Override
    public ArrayList<Sach> selectAll() {
        ArrayList<Sach> ketQua = new ArrayList<Sach>();
        try {
            Connection con = JDBCUtil.getConnection();
            String sql = "SELECT * FROM sach";
            PreparedStatement pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                int maSach = rs.getInt("ma_sach");
                String tenSach = rs.getString("ten_sach");
                String tacGia = rs.getString("tac_gia");
                String theLoai = rs.getString("the_loai");
                String nhaXuatBan = rs.getString("nxb");
                int giaNhap = rs.getInt("gia_nhap");
                int giaBan = rs.getInt("gia_ban");
                int soLuong = rs.getInt("so_luong");
                Sach sach = new Sach(maSach, tenSach, tacGia, theLoai, nhaXuatBan, giaNhap, giaBan, soLuong);
                ketQua.add(sach);
            }
            JDBCUtil.closeConnection(con);
        } catch (SQLException e) {
        }
        return ketQua;
    }

    @Override
    public Sach selectById(int t) {
        Sach ketQua = null;
        try {
            Connection con = JDBCUtil.getConnection();
            String sql = "SELECT * FROM Sach WHERE ma_sach=?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, t);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                int maSach = rs.getInt("ma_sach");
                String tenSach = rs.getString("ten_sach");
                String tacGia = rs.getString("tac_gia");
                String theLoai = rs.getString("the_loai");
                String nhaXuatBan = rs.getString("nxb");
                int giaNhap = rs.getInt("gia_nhap");
                int giaBan = rs.getInt("gia_ban");
                int soLuong = rs.getInt("so_luong");
                ketQua = new Sach(maSach, tenSach, tacGia, theLoai, nhaXuatBan, giaNhap, giaBan,soLuong);
            }
            JDBCUtil.closeConnection(con);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ketQua;
    }
    
    public ArrayList<Sach> search(String text){
        ArrayList<Sach> result = new ArrayList<>();
        ArrayList<Sach> sachList = this.selectAll();
        for (Sach sach : sachList) {
            String ms = sach.getMaSach()+"";
            String giaNhap = sach.getGiaNhap()+"";
            String giaBan = sach.getGiaBan()+"";
            if (ms.contains(text.toLowerCase())|| giaBan.contains(text.toLowerCase())|| giaNhap.contains(text.toLowerCase())
                    ||sach.getTenTG().toLowerCase().contains(text.toLowerCase())||sach.getNxb().toLowerCase().contains(text.toLowerCase())
                    ||sach.getTheLoai().toLowerCase().contains(text.toLowerCase())||sach.getTenSach().toLowerCase().contains(text.toLowerCase())){
                    result.add(sach);
                }
        }
        return result;
    }
    
    
    public Sach searchId(int id) {
        Sach result = new Sach();
        ArrayList<Sach> sach = SachDAO.getInstance().selectAll();
        for (Sach s : sach) {
//            String ms = s.getMaSach()+"";
            if (s.getMaSach()==id) {
                return s;
            }
        }
        return null;
    }
    
    public Sach searchName(String text) {
        Sach result = new Sach();
        ArrayList<Sach> sach = SachDAO.getInstance().selectAll();
        for (Sach s : sach) {
           
            if (s.getTenSach().toLowerCase().contains(text.toLowerCase())) {
                return s;
            }
        }
        return null;
    }
    
    public int updateSoLuong(int maSach, int soluong) {
        int ketQua = 0;
        try {
            Connection con = JDBCUtil.getConnection();
            //String sql = "INSERT INTO MayTinh (maMay, tenMay, soLuong, tenCpu, ram, cardManHinh, gia, dungLuongPin, dungLuongPin, dungLuongPin, loaiMay, rom) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";
            String sql = "UPDATE sach SET so_luong=? WHERE ma_sach=? ";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, soluong);
            pst.setInt(2, maSach);
            ketQua = pst.executeUpdate();
            JDBCUtil.closeConnection(con);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ketQua;
    }
}
