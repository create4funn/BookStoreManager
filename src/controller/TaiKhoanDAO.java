package controller;

import connect.JDBCUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import model.TaiKhoan;

/**
 *
 * @author DELL
 */
public class TaiKhoanDAO implements InterfaceDAO<TaiKhoan>{

    public static TaiKhoanDAO getInstance() {
        return new TaiKhoanDAO();
    }
     @Override
    public int insert(TaiKhoan t) {
        int ketQua = 0;
        try {
            Connection con = JDBCUtil.getConnection();
            String sql = "INSERT INTO taikhoan (tai_khoan, mat_khau, chu_tai_khoan, vai_tro) VALUES (?,?,?,?)";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, t.getTaiKhoan());
            pst.setString(2, t.getMatKhau());
            pst.setString(3, t.getFullName());
            pst.setString(4, t.getRole());
            //Buoc 4 thuc thi cau lenh sql
            ketQua = pst.executeUpdate();
            //Buoc 5 Xu ly
            //Buoc 6 ngat ket noi den voi co so du lieu
            JDBCUtil.closeConnection(con);
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return ketQua;
    }

    @Override
    public int update(TaiKhoan t) {
        int ketQua = 0;
        try {
            Connection con = JDBCUtil.getConnection();
            String sql = "UPDATE taikhoan SET mat_khau=?, chu_tai_khoan=?, vai_tro=? WHERE tai_khoan=?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, t.getMatKhau());
            pst.setString(2, t.getFullName());
            pst.setString(3, t.getRole());
            pst.setString(4, t.getTaiKhoan());
            ketQua = pst.executeUpdate();
            JDBCUtil.closeConnection(con);
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return ketQua;
    }

    @Override
    public int delete(TaiKhoan t) {
        int ketQua = 0;
        try {
            Connection con = JDBCUtil.getConnection();
            String sql = "DELETE FROM taikhoan WHERE tai_khoan=?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, t.getTaiKhoan());
            ketQua = pst.executeUpdate();
            JDBCUtil.closeConnection(con);

        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return ketQua;
    }

    @Override
    public ArrayList<TaiKhoan> selectAll() {
        ArrayList<TaiKhoan> ketQua = new ArrayList<TaiKhoan>();
        try {
            Connection con = JDBCUtil.getConnection();
            String sql = "SELECT * FROM taikhoan";
            PreparedStatement pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                String tk = rs.getString("tai_khoan");
                String mk = rs.getString("mat_khau");
                String name = rs.getString("chu_tai_khoan");
                String role = rs.getString("vai_tro");
                TaiKhoan taiKhoan = new TaiKhoan(name, tk, mk, role);
                ketQua.add(taiKhoan);
            }
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return ketQua;
    }

 
    public TaiKhoan selectById(String t) {
        TaiKhoan acc = null;
        try {
            Connection con = JDBCUtil.getConnection();
            String sql = "SELECT * FROM taikhoan WHERE tai_khoan=?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, t);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                String fullName = rs.getString("chu_tai_khoan");
                String userName = rs.getString("tai_khoan");
                String password = rs.getString("mat_khau");
                String role = rs.getString("vai_tro");
                acc = new TaiKhoan(fullName, userName, password, role);
            }
            JDBCUtil.closeConnection(con);
        } catch (Exception e) {
            // TODO: handle exception           
        }
        return acc;
    }
    
    public TaiKhoan checkAccount(String username, String pass) {
        TaiKhoan acc = null;
        try {
            Connection con = JDBCUtil.getConnection();
            String sql = "SELECT * FROM taikhoan WHERE tai_khoan=? AND mat_khau=?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, username);
            pst.setString(2, pass);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                String fullName = rs.getString("chu_tai_khoan");
                String userName = rs.getString("tai_khoan");
                String password = rs.getString("mat_khau");
                String role = rs.getString("vai_tro");
                acc = new TaiKhoan(fullName, userName, password, role);
            }
            JDBCUtil.closeConnection(con);
        } catch (Exception e) {
            // TODO: handle exception           
        }
        return acc;
    }
    
    
        public int updatePassword(String taiKhoan, String matKhau) {
        int ketQua = 0;
        try {
            Connection con = JDBCUtil.getConnection();
            String sql = "UPDATE taikhoan SET mat_khau=? WHERE = tai_khoan?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, taiKhoan);
            pst.setString(2, matKhau);
            ketQua = pst.executeUpdate();
            JDBCUtil.closeConnection(con);

        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return ketQua;
    }

    @Override
    public TaiKhoan selectById(int t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
  
    
}
