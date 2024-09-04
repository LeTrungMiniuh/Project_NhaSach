package dao;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.query.Query;

import dao_interface.NhanVien_DAO_Interface;
import entity.LoaiNhanVien;
import entity.NhanVien;
import entity.QuanLy;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

public class NhanVien_DAO extends UnicastRemoteObject implements NhanVien_DAO_Interface {
	 private EntityManager entityManager;

	    public NhanVien_DAO() throws RemoteException {
	        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("mssql");
	        entityManager = entityManagerFactory.createEntityManager();
	    }
	    public List<NhanVien> getallNhanVien() {
	        try {
	            String jpql = "SELECT nv FROM NhanVien nv";
	            TypedQuery<NhanVien> query = entityManager.createQuery(jpql, NhanVien.class);
	            return query.getResultList();
	        } finally {
	           // entityManager.close();
	        }
	    }
	  /*  public List<NhanVien> getallNhanVienTangDanTheoTen() {
	        List<NhanVien> dsNV = new ArrayList<>();
	        try {
	            String jpql = "SELECT nv FROM NhanVien nv ORDER BY nv.tenNV ASC";
	            TypedQuery<NhanVien> query = entityManager.createQuery(jpql, NhanVien.class);
	            dsNV = query.getResultList();
	        } catch (Exception e) {
	            e.printStackTrace();
	        } finally {
	            entityManager.close();
	        }
	        return dsNV;
	    }
	public List<NhanVien> getallNhanVienGiamDanTheoTen(){
		 List<NhanVien> dsNV = new ArrayList<>();
	        try {
	            String jpql = "SELECT nv FROM NhanVien nv ORDER BY nv.tenNV DESC";
	            TypedQuery<NhanVien> query = entityManager.createQuery(jpql, NhanVien.class);
	            dsNV = query.getResultList();
	        } catch (Exception e) {
	            e.printStackTrace();
	        } finally {
	            entityManager.close();
	        }
	        return dsNV;
	    }*/
	    public List<NhanVien> getallNhanVienTangDanTheoTen() {
	        List<NhanVien> dsNV = new ArrayList<>();
	        try {
	            String jpql = "SELECT nv FROM NhanVien nv ORDER BY nv.tenNV ASC";
	            TypedQuery<NhanVien> query = entityManager.createQuery(jpql, NhanVien.class);
	            dsNV = query.getResultList();
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        return dsNV;
	    }

	    public List<NhanVien> getallNhanVienGiamDanTheoTen(){
	        List<NhanVien> dsNV = new ArrayList<>();
	        try {
	            String jpql = "SELECT nv FROM NhanVien nv ORDER BY nv.tenNV DESC";
	            TypedQuery<NhanVien> query = entityManager.createQuery(jpql, NhanVien.class);
	            dsNV = query.getResultList();
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        return dsNV;
	    }
	public boolean createNV(NhanVien nv)
	{
		 EntityTransaction transaction = entityManager.getTransaction();
	        try {
	            transaction.begin();
	            entityManager.persist(nv);
	            transaction.commit();
	            return true;
	        } catch (Exception e) {
	            if (transaction.isActive()) {
	                transaction.rollback();
	            }
	            e.printStackTrace();
	            return false;
	        } finally {
	           // entityManager.close();
	        }
	    }
	public boolean updateNV(NhanVien nv)
	{
		   EntityTransaction transaction = entityManager.getTransaction();
	        try {
	            transaction.begin();
	            entityManager.merge(nv);
	            transaction.commit();
	            return true;
	        } catch (Exception e) {
	            if (transaction.isActive()) {
	                transaction.rollback();
	            }
	            e.printStackTrace();
	            return false;
	        } finally {
	           // entityManager.close();
	        }
	    }
	  public List<NhanVien> getNhanVienTheoMa(String id) {
	        List<NhanVien> dsNV = new ArrayList<>();
	        try {
	            String jpql = "SELECT nv FROM NhanVien nv WHERE nv.maNV = :id";
	            TypedQuery<NhanVien> query = entityManager.createQuery(jpql, NhanVien.class);
	            query.setParameter("id", id);
	            dsNV = query.getResultList();
	        } catch (Exception e) {
	            e.printStackTrace();
	        } finally {
	           // entityManager.close();
	        }
	        return dsNV;
	    }
	  public List<NhanVien> getNhanVienTheoTen(String tenNV) {
		    List<NhanVien> dsNV = new ArrayList<>();
		    try {
		    	String jpql = "SELECT nv FROM NhanVien nv WHERE nv.tenNV = :tenNV";
		        TypedQuery<NhanVien> query = entityManager.createQuery(jpql, NhanVien.class);
		        query.setParameter("tenNV", tenNV);
		        dsNV = query.getResultList();

		    } catch (Exception e) {
		        e.printStackTrace();
		    } 
		    return dsNV;
		}
	 /* public List<NhanVien> getNhanVienTheoTen(String tenNV) {
		    List<NhanVien> dsNV = new ArrayList<>();
		    try {
		        String sql = "SELECT * FROM NhanVien WHERE maNV = ?";
		        Query query = (Query) entityManager.createNativeQuery(sql, NhanVien.class);
		        query.setParameter(1, tenNV);
		        dsNV = query.getResultList();

		    } catch (Exception e) {
		        e.printStackTrace();
		        // Xử lý ngoại lệ ở đây nếu cần thiết
		    } 
		    return dsNV;
		}*/


	public boolean updateTrangThaiNV(NhanVien nv)
	{
		EntityTransaction transaction = null;
        try {
            transaction = entityManager.getTransaction();
            transaction.begin();

            NhanVien updatedNV = entityManager.find(NhanVien.class, nv.getMaNV());
            if (updatedNV != null) {
                updatedNV.setTrangThai(false);
            }

            transaction.commit();
            return true;
        } catch (Exception e) {
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }
            e.printStackTrace();
            return false;
        } finally {
            //entityManager.close();
        }
    }
	public boolean updateMatKhau(NhanVien nv)
	{
		 EntityTransaction transaction = null;
	        try {
	            transaction = entityManager.getTransaction();
	            transaction.begin();

	            NhanVien updatedNV = entityManager.find(NhanVien.class, nv.getMaNV());
	            if (updatedNV != null) {
	                updatedNV.setMatKhau(nv.getMatKhau());
	            }

	            transaction.commit();
	            return true;
	        } catch (Exception e) {
	            if (transaction != null && transaction.isActive()) {
	                transaction.rollback();
	            }
	            e.printStackTrace();
	            return false;
	        } finally {
	            //entityManager.close();
	        }
	    }
	
	public NhanVien getNhanVienByCredentials(String username, String password) {
	       // EntityManager em = emf.createEntityManager();
	        TypedQuery<NhanVien> query = entityManager.createQuery("SELECT nv FROM NhanVien nv WHERE nv.maNV = :username AND nv.matKhau = :password", NhanVien.class);
	        query.setParameter("username", username);
	        query.setParameter("password", password);
	        NhanVien nhanVien = query.getSingleResult();
	      //  entityManager.close();
	        return nhanVien;
	    }
}
