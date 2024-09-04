package junitTest;

import static org.junit.Assert.*;

import java.rmi.RemoteException;
import java.util.List;

import org.junit.Test;

import dao.LoaiKhachHang_DAO;
import entity.LoaiKhachHang;

public class LoaiKhachHang_DAOTest {
	
	@Test
	public void testGetAllLoaiKhachHang() throws RemoteException {

		LoaiKhachHang_DAO lkDAO = new LoaiKhachHang_DAO();
		List<LoaiKhachHang> loaiKhachHangs = lkDAO.getallLoaiKhachHang();
		assertNotNull(loaiKhachHangs);
		assertTrue(loaiKhachHangs.size() > 0);
	}
}
	
	
