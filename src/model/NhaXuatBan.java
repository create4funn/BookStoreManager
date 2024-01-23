package model;

/**
 *
 * @author DELL
 */
public class NhaXuatBan {
    private int maNxb;
    private String tenNxb;

    public NhaXuatBan() {
    }

    public NhaXuatBan(String tenNxb) {
        this.tenNxb = tenNxb;
    }

    public NhaXuatBan(int maNxb, String tenNxb) {
        this.maNxb = maNxb;
        this.tenNxb = tenNxb;
    }

    public int getMaNxb() {
        return maNxb;
    }

    public void setMaNxb(int maNxb) {
        this.maNxb = maNxb;
    }

    public String getTenNxb() {
        return tenNxb;
    }

    public void setTenNxb(String tenNxb) {
        this.tenNxb = tenNxb;
    }
    
    
}
