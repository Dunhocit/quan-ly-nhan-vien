package DAO;

import java.sql.Date;

public class NhanVien {
	public int maNV;
	public String tenNV;
	public String gioiTinh;
	public Date ngaySinh;
	public String sDT;
	public String eMail;
	public String chucVu;
	public Float Luong;
	public NhanVien() {
		super();
	}
	public NhanVien(String tenNV, String gioiTinh, Date ngaySinh, String sDT, String eMail, String chucVu,
			Float luong) {
		super();
		this.tenNV = tenNV;
		this.gioiTinh = gioiTinh;
		this.ngaySinh = ngaySinh;
		this.sDT = sDT;
		this.eMail = eMail;
		this.chucVu = chucVu;
		Luong = luong;
	}
	public NhanVien(int maNV, String tenNV, String gioiTinh, Date ngaySinh, String sDT, String eMail, String chucVu,
			Float luong) {
		super();
		this.maNV = maNV;
		this.tenNV = tenNV;
		this.gioiTinh = gioiTinh;
		this.ngaySinh = ngaySinh;
		this.sDT = sDT;
		this.eMail = eMail;
		this.chucVu = chucVu;
		Luong = luong;
	}
	public int getMaNV() {
		return maNV;
	}
	public void setMaNV(int maNV) {
		this.maNV = maNV;
	}
	public String getTenNV() {
		return tenNV;
	}
	public void setTenNV(String tenNV) {
		this.tenNV = tenNV;
	}
	public String getGioiTinh() {
		return gioiTinh;
	}
	public void setGioiTinh(String gioiTinh) {
		this.gioiTinh = gioiTinh;
	}
	public Date getNgaySinh() {
		return ngaySinh;
	}
	public void setNgaySinh(Date ngaySinh) {
		this.ngaySinh = ngaySinh;
	}
	public String getsDT() {
		return sDT;
	}
	public void setsDT(String sDT) {
		this.sDT = sDT;
	}
	public String geteMail() {
		return eMail;
	}
	public void seteMail(String eMail) {
		this.eMail = eMail;
	}
	public String getChucVu() {
		return chucVu;
	}
	public void setChucVu(String chucVu) {
		this.chucVu = chucVu;
	}
	public Float getLuong() {
		return Luong;
	}
	public void setLuong(Float luong) {
		Luong = luong;
	}
	@Override
	public String toString() {
		return "NhanVien [maNV=" + maNV + ", tenNV=" + tenNV + ", gioiTinh=" + gioiTinh + ", ngaySinh=" + ngaySinh
				+ ", sDT=" + sDT + ", eMail=" + eMail + ", chucVu=" + chucVu + ", Luong=" + Luong + "]";
	}
	
	
}
