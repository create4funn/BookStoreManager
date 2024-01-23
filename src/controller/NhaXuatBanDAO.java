package controller;

import connect.JDBCUtil;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import model.NhaXuatBan;

/**
 *
 * @author DELL
 */
public class NhaXuatBanDAO implements InterfaceDAO<NhaXuatBan>{

    public static NhaXuatBanDAO getInstance() {
        return new NhaXuatBanDAO();
    }
    
    @Override
    public int insert(NhaXuatBan t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int update(NhaXuatBan t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int delete(NhaXuatBan t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ArrayList<NhaXuatBan> selectAll() {
        ArrayList<NhaXuatBan> ketQua = new ArrayList<NhaXuatBan>();
        try {
            java.sql.Connection con = JDBCUtil.getConnection();
            String sql = "SELECT * FROM nxb";
            PreparedStatement pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                String tennxb = rs.getString("ten_nxb");
                NhaXuatBan nxb = new NhaXuatBan(tennxb);
                ketQua.add(nxb);
            }
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return ketQua;
    }

    @Override
    public NhaXuatBan selectById(int t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
