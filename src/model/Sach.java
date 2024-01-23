package model;

/**
 *
 * @author DELL
 */
public class Sach {
    private int maSach;
    private String tenSach;
    private String tenTG;
    private String theLoai;
    private String nxb;
    private int giaNhap;
    private int giaBan;
    private int soLuong;

    public Sach() {
    }

    public Sach(int maSach, String tenSach, String tenTG, String theLoai, String nxb, int giaNhap, int giaBan, int soLuong) {
        this.maSach = maSach;
        this.tenSach = tenSach;
        this.tenTG = tenTG;
        this.theLoai = theLoai;
        this.nxb = nxb;
        this.giaNhap = giaNhap;
        this.giaBan = giaBan;
        this.soLuong = soLuong;
    }

    public Sach(int maSach, String tenSach, int giaBan, int soLuong) {
        this.maSach = maSach;
        this.tenSach = tenSach;
        this.giaBan = giaBan;
        this.soLuong = soLuong;
    }

    
    
    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    

    public int getMaSach() {
        return maSach;
    }

    public void setMaSach(int maSach) {
        this.maSach = maSach;
    }

    public String getTenSach() {
        return tenSach;
    }

    public void setTenSach(String tenSach) {
        this.tenSach = tenSach;
    }

    public String getTenTG() {
        return tenTG;
    }

    public void setTenTG(String tenTG) {
        this.tenTG = tenTG;
    }

    public String getTheLoai() {
        return theLoai;
    }

    public void setTheLoai(String theLoai) {
        this.theLoai = theLoai;
    }

    public String getNxb() {
        return nxb;
    }

    public void setNxb(String nxb) {
        this.nxb = nxb;
    }

    public int getGiaNhap() {
        return giaNhap;
    }

    public void setGiaNhap(int giaNhap) {
        this.giaNhap = giaNhap;
    }

    public int getGiaBan() {
        return giaBan;
    }

    public void setGiaBan(int giaBan) {
        this.giaBan = giaBan;
    }

  
    
    
    
}
