package junitTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.rmi.RemoteException;
import java.util.ArrayList;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;


import entity.LoaiSach;

@TestInstance(Lifecycle.PER_CLASS)
public class LoaiSach_DAO_Test {
	dao.LoaiSach_DAO loaiSach_DAO;

	@BeforeAll
	public void setUp() {
		try {
			loaiSach_DAO = new dao.LoaiSach_DAO();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void testGetAllLoaiSach() {
		ArrayList<LoaiSach> dsLoaiSach = (ArrayList<LoaiSach>) loaiSach_DAO.getallLoaiSach();
		assertNotNull(dsLoaiSach);
		// Sửa đổi giá trị dưới đây để phù hợp với kết quả mong đợi
		assertEquals(10, dsLoaiSach.size());
	}

	@AfterAll
	public void tearDown() {
		loaiSach_DAO = null;
	}

}
