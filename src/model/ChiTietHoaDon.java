package model;

/**
 *
 * @author DELL
 */
public class ChiTietHoaDon {
    private int maHoaDon;
    private int maSach;
    private int soLuong;
    private int thanhTien;

    public ChiTietHoaDon() {
    }

    public ChiTietHoaDon(int maHoaDon, int maSach, int soLuong, int thanhTien) {
        this.maHoaDon = maHoaDon;
        this.maSach = maSach;
        this.soLuong = soLuong;
        this.thanhTien = thanhTien;
    }

    

    public int getMaHoaDon() {
        return maHoaDon;
    }

    public void setMaHoaDon(int maHoaDon) {
        this.maHoaDon = maHoaDon;
    }


    public int getMaSach() {
        return maSach;
    }

    public void setMaSach(int maSach) {
        this.maSach = maSach;
    }

    

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public int getThanhTien() {
        return thanhTien;
    }

    public void setThanhTien(int thanhTien) {
        this.thanhTien = thanhTien;
    }
    
   
    
    
}
