package dao_interface;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import entity.LoaiSach;

public interface LoaiSach_DAO_Interface extends Remote {
    
    List<LoaiSach> getallLoaiSach() throws RemoteException;
    
    void closeEntityManager() throws RemoteException;
}
