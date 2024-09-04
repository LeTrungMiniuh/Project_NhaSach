package junitTest;

import java.rmi.RemoteException;
import java.util.List;

import org.junit.Test;

import static org.junit.Assert.*;
import dao.LoaiNhanVien_DAO;
import entity.LoaiNhanVien;

public class LoaiNhanVien_DAOTest {
	@Test
	public void testGetAllLoaiNhanVien() throws RemoteException {
		LoaiNhanVien_DAO lnvDAO = new LoaiNhanVien_DAO();
		List<LoaiNhanVien> loaiNhanViens = lnvDAO.getallLoaiNhanVien();
		assertNotNull(loaiNhanViens);
		assertTrue(loaiNhanViens.size() > 0);
	}
	
}
