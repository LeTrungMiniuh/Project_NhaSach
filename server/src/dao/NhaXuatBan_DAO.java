package dao;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

import dao_interface.NhaXuatBan_DAO_Interface;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

import entity.NhaXuatBan;

public class NhaXuatBan_DAO extends UnicastRemoteObject implements NhaXuatBan_DAO_Interface {
    private EntityManager entityManager;

    public NhaXuatBan_DAO() throws RemoteException {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("mssql");
        entityManager = entityManagerFactory.createEntityManager();
    }

    public List<NhaXuatBan> getalltNhaXuatBan() {
        List<NhaXuatBan> dsNhaXuatBan = new ArrayList<>();
        try {
            String jpql = "SELECT nxb FROM NhaXuatBan nxb";
            TypedQuery<NhaXuatBan> query = entityManager.createQuery(jpql, NhaXuatBan.class);
            dsNhaXuatBan = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dsNhaXuatBan;
    }

    public void closeEntityManager() {
        if (entityManager != null) {
            entityManager.close();
        }
    }
}
