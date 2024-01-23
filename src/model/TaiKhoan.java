package model;

/**
 *
 * @author DELL
 */
public class TaiKhoan {
    private String fullName;
    private String taiKhoan;
    private String matKhau;
    private String role;
    public TaiKhoan() {
    }

    public TaiKhoan(String fullName, String taiKhoan, String matKhau, String role) {
        this.fullName = fullName;
        this.taiKhoan = taiKhoan;
        this.matKhau = matKhau;
        this.role = role;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getTaiKhoan() {
        return taiKhoan;
    }

    public void setTaiKhoan(String taiKhoan) {
        this.taiKhoan = taiKhoan;
    }

    public String getMatKhau() {
        return matKhau;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    
    
    private boolean checkMK(){
        return matKhau.length() >= 6;
    }
}
