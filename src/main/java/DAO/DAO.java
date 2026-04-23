package DAO;

import java.util.List;

public interface DAO<N> {
	boolean add(N n);
	N getBymaNV(int maNV);
	List<N> getAll();
	boolean update(N n);
	boolean delete(int maNV);

}
