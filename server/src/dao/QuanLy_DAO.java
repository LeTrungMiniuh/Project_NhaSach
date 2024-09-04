package dao;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

import dao_interface.QuanLy_DAO_Interface;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;
import entity.QuanLy;

public class QuanLy_DAO extends UnicastRemoteObject implements QuanLy_DAO_Interface {
    private EntityManager entityManager;

    public QuanLy_DAO() throws RemoteException {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("mssql");
        entityManager = entityManagerFactory.createEntityManager();
    }

    public List<QuanLy> getQuanLyTheoMa(String tenTK) {
        List<QuanLy> dsQuanLy = new ArrayList<>();
        try {
            String jpql = "SELECT ql FROM QuanLy ql WHERE ql.tenTK = :tenTK";
            TypedQuery<QuanLy> query = entityManager.createQuery(jpql, QuanLy.class);
            query.setParameter("tenTK", tenTK);
            dsQuanLy = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dsQuanLy;
    }

    public boolean updateMatKhau(QuanLy quanLy) {
        try {
            entityManager.getTransaction().begin();
            QuanLy managedQuanLy = entityManager.find(QuanLy.class, quanLy.getTenTK());
            if (managedQuanLy != null) {
                managedQuanLy.setMatKhau(quanLy.getMatKhau());
                entityManager.getTransaction().commit();
                return true;
            }
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            e.printStackTrace();
        }
        return false;
    }
    public QuanLy getQuanLyByCredentials(String username, String password) {
    	 
        TypedQuery<QuanLy> query = entityManager.createQuery("SELECT q FROM QuanLy q WHERE q.tenTK = :username AND q.matKhau = :password", QuanLy.class);
        query.setParameter("username", username);
        query.setParameter("password", password);
        QuanLy quanLy = query.getSingleResult();
      //  entityManager.close();
        return quanLy;
    }
    public void closeEntityManager() {
        if (entityManager != null) {
            entityManager.close();
        }
    }
}
