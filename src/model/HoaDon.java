package model;

import java.sql.Timestamp;
import java.util.ArrayList;

/**
 *
 * @author DELL
 */
public class HoaDon {
    private int maHoaDon;
    private String tenKhachHang;
    private Timestamp ngayLap;
    private int tongTien;
    private ArrayList<ChiTietHoaDon> cthd;
    
    public HoaDon() {
    }

    public HoaDon(int maHoaDon, String tenKhachHang, Timestamp ngayLap, int tongTien, ArrayList<ChiTietHoaDon> cthd) {
        this.maHoaDon = maHoaDon;
        this.tenKhachHang = tenKhachHang;
        this.ngayLap = ngayLap;
        this.tongTien = tongTien;
        this.cthd = cthd;
    }

    public HoaDon(int maHoaDon, String tenKhachHang, Timestamp ngayLap, int tongTien) {
        this.maHoaDon = maHoaDon;
        this.tenKhachHang = tenKhachHang;
        this.ngayLap = ngayLap;
        this.tongTien = tongTien;
    }

    
    public ArrayList<ChiTietHoaDon> getCthd() {
        return cthd;
    }

    public void setCthd(ArrayList<ChiTietHoaDon> cthd) {
        this.cthd = cthd;
    }

    

    public int getMaHoaDon() {
        return maHoaDon;
    }

    public void setMaHoaDon(int maHoaDon) {
        this.maHoaDon = maHoaDon;
    }

    public String getTenKhachHang() {
        return tenKhachHang;
    }

    public void setTenKhachHang(String tenKhachHang) {
        this.tenKhachHang = tenKhachHang;
    }

    public Timestamp getNgayLap() {
        return ngayLap;
    }

    public void setNgayLap(Timestamp ngayLap) {
        this.ngayLap = ngayLap;
    }

    public int getTongTien() {
        return tongTien;
    }

    public void setTongTien(int tongTien) {
        this.tongTien = tongTien;
    }

    
    
}
