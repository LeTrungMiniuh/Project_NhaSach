package dao;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

import dao_interface.LoaiSach_DAO_Interface;
import entity.LoaiSach;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

public class LoaiSach_DAO extends UnicastRemoteObject implements LoaiSach_DAO_Interface {
    private EntityManager entityManager;

    public LoaiSach_DAO() throws RemoteException {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("mssql");
        entityManager = entityManagerFactory.createEntityManager();
    }

    public List<LoaiSach> getallLoaiSach() {
        List<LoaiSach> dsLoaiSach = new ArrayList<>();
        try {
            String jpql = "SELECT ls FROM LoaiSach ls";
            TypedQuery<LoaiSach> query = entityManager.createQuery(jpql, LoaiSach.class);
            dsLoaiSach = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dsLoaiSach;
    }

    public void closeEntityManager() {
        if (entityManager != null) {
            entityManager.close();
        }
    }
}
