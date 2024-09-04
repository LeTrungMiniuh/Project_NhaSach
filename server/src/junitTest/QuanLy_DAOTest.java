package junitTest;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import dao.QuanLy_DAO;
import entity.QuanLy;

import java.rmi.RemoteException;
import java.util.List;

public class QuanLy_DAOTest {
    private QuanLy_DAO quanLyDAO;

    @BeforeEach
    public void setUp() throws RemoteException {
        quanLyDAO = new QuanLy_DAO();
    }

    @AfterEach
    public void tearDown() {
        quanLyDAO.closeEntityManager();
    }

    @Test
    public void testGetQuanLyTheoMa() {
        List<QuanLy> result1 = quanLyDAO.getQuanLyTheoMa("QL01");
        assertEquals(0, result1.size());

        List<QuanLy> result2 = quanLyDAO.getQuanLyTheoMa("QL02");
        assertEquals(1, result2.size());
        assertEquals("QL02", result2.get(0).getTenTK());
    }

    @Test
    public void testUpdateMatKhau() {
        QuanLy quanLy = new QuanLy("QL09", "199", "Nguyen Van A");

        assertTrue(quanLyDAO.updateMatKhau(quanLy));

        List<QuanLy> updatedQuanLyList = quanLyDAO.getQuanLyTheoMa("QL09");
        assertEquals(1, updatedQuanLyList.size());
        assertEquals("199", updatedQuanLyList.get(0).getMatKhau());
    }
}

