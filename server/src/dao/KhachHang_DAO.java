package dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import dao_interface.KhachHang_DAO_Interface;
import entity.KhachHang;

public class KhachHang_DAO extends UnicastRemoteObject implements KhachHang_DAO_Interface{

	 private EntityManager entityManager;

	    public KhachHang_DAO() throws RemoteException{
	        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("mssql");
	        entityManager = entityManagerFactory.createEntityManager();
	    }
	    
	    public List<KhachHang> getallKhachHang() {
	        TypedQuery<KhachHang> query = entityManager.createQuery("SELECT kh FROM KhachHang kh", KhachHang.class);
	        List<KhachHang> khachHangList = query.getResultList();
	        return khachHangList;
	    }
	    
	    public List<KhachHang> getallKhachHangTangDanTheoTen() {
	        TypedQuery<KhachHang> query = entityManager.createQuery("SELECT kh FROM KhachHang kh ORDER BY kh.tenKH ASC", KhachHang.class);
	        List<KhachHang> khachHangList = query.getResultList();
	        return khachHangList;
	    }
	    
	    public List<KhachHang> getallKhachHangGiamDanTheoTen() {
	        TypedQuery<KhachHang> query = entityManager.createQuery("SELECT kh FROM KhachHang kh ORDER BY kh.tenKH DESC", KhachHang.class);
	        List<KhachHang> khachHangList = query.getResultList();
	        return khachHangList;
	    }
	    
	    public KhachHang getKhachHangTheoMa(String id) {
	        KhachHang khachHang = entityManager.find(KhachHang.class, id);
	        return khachHang;
	    }
	    
	/*    public List<KhachHang> getKhachHangTheoTen(String name) {
	        TypedQuery<KhachHang> query = entityManager.createQuery("SELECT kh FROM KhachHang kh WHERE kh.tenKH = :name", KhachHang.class);
	        query.setParameter("name", name);
	        List<KhachHang> khachHangList = query.getResultList();
	        return khachHangList;
	    }*/
	    public List<KhachHang> getKhachHangTheoTen(String name) {
	        TypedQuery<KhachHang> query = entityManager.createQuery("SELECT kh FROM KhachHang kh WHERE kh.tenKH = :name", KhachHang.class);
	        query.setParameter("name", name);
	        List<KhachHang> khachHangList = query.getResultList();
	        
	        if (khachHangList.isEmpty()) {
	            System.out.println("Không tìm thấy khách hàng có tên " + name);
	        }
	        
	        return khachHangList;
	    }


	    public boolean createKH(KhachHang kh) {
	    	  try {
	    	        entityManager.getTransaction().begin();
	    	        entityManager.persist(kh);
	    	        entityManager.getTransaction().commit();
	    	        return true; 
	    	    } catch (Exception e) {
	    	        if (entityManager.getTransaction().isActive()) {
	    	            entityManager.getTransaction().rollback();
	    	        }
	    	        e.printStackTrace();
	    	        return false; 
	    	    } finally {
	    	        entityManager.close();
	    	    }
	    	}

	    public boolean deleteKH(Object khachHang) {
	    	try {
	            KhachHang kh = entityManager.find(KhachHang.class, khachHang);
	            if (kh != null) {
	                entityManager.getTransaction().begin();
	                entityManager.remove(kh);
	                entityManager.getTransaction().commit();
	                return true; 
	            } else {
	                return false; 
	            }
	        } catch (Exception e) {
	            if (entityManager.getTransaction().isActive()) {
	                entityManager.getTransaction().rollback();
	            }
	            e.printStackTrace();
	            return false; 
	        } finally {
	            entityManager.close();
	        }
	    }

	    public boolean updateKH(KhachHang kh) {
	        entityManager.getTransaction().begin();
	        entityManager.merge(kh);
	        entityManager.getTransaction().commit();
			return false;
	    }

		@Override
		public boolean deleteKH(String id) throws RemoteException {
			// TODO Auto-generated method stub
			return false;
		}
}
