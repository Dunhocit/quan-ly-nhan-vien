package DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class NhanVienDAO implements DAO<NhanVien> {

	@Override
	public boolean add(NhanVien n) {
		// TODO Auto-generated method stub
		Connection con;
		PreparedStatement pstm;
		String sql = "insert into nhanvien(tenNV, gioiTinh, ngaySinh, sDT, eMail, chucVu, Luong) values(?,?,?,?,?,?,?)";
		try {
			con=JDBC.getConnection();
			pstm=con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			pstm.setString(1, n.getTenNV());
			pstm.setString(2, n.getGioiTinh());
			pstm.setDate(3, n.getNgaySinh());
			pstm.setString(4, n.getsDT());
			pstm.setString(5, n.geteMail());
			pstm.setString(6, n.getChucVu());
			pstm.setFloat(7, n.getLuong());
			return pstm.executeUpdate() > 0;
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public NhanVien getBymaNV(int maNV) {
		// TODO Auto-generated method stub
		Connection con;
		PreparedStatement pstm;
		ResultSet rs;
		String sql = "select * from nhanvien where maNV = ?";
		try {
			con=JDBC.getConnection();
			pstm=con.prepareStatement(sql);
			pstm.setInt(1, maNV);
			rs=pstm.executeQuery();
			if(rs.next()) {
				return new NhanVien(rs.getInt("maNV"), rs.getString("tenNV"), rs.getString("gioiTinh"), rs.getDate("ngaySinh"), rs.getString("sDT"), rs.getString("eMail"), rs.getString("chucVu"), rs.getFloat("Luong"));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<NhanVien> getAll() {
		// TODO Auto-generated method stub
		Connection con;
		Statement stm;
		ResultSet rs;
		List<NhanVien> list = new ArrayList<NhanVien>();
		String sql = "select * from nhanvien";
		try {
			con = JDBC.getConnection();
			stm = con.createStatement();
			rs = stm.executeQuery(sql);
			while(rs.next()) {
				NhanVien nv = new NhanVien(rs.getInt("maNV"), rs.getString("tenNV"), rs.getString("gioiTinh"), rs.getDate("ngaySinh"), rs.getString("sDT"), rs.getString("eMail"), rs.getString("chucVu"), rs.getFloat("Luong"));
				list.add(nv);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public boolean update(NhanVien n) {
		// TODO Auto-generated method stub
		Connection con;
		PreparedStatement pstm;
		String sql="update nhanvien set tenNV = ?, gioiTinh=?, ngaySinh=?, sDT=?, eMail=?, chucVu=?, Luong = ? where maNV =?";
		try {
			con=JDBC.getConnection();
			pstm=con.prepareStatement(sql);
			pstm.setString(1, n.getTenNV());
			pstm.setString(2, n.getGioiTinh());
			pstm.setDate(3, n.getNgaySinh());
			pstm.setString(4, n.getsDT());
			pstm.setString(5, n.geteMail());
			pstm.setString(6, n.getChucVu());
			pstm.setFloat(7, n.getLuong());
			pstm.setInt(8, n.getMaNV());
			return pstm.executeUpdate() > 0;
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean delete(int maNV) {
		// TODO Auto-generated method stub
		Connection con;
		PreparedStatement pstm;
		String sql = "delete from nhanvien where maNV = ?";
		try {
			con = JDBC.getConnection();
			pstm = con.prepareStatement(sql);
			pstm.setInt(1, maNV);
			return pstm.executeUpdate() > 0;
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

}
