package dao_interface;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;
import entity.QuanLy;

public interface QuanLy_DAO_Interface extends Remote {
    
    List<QuanLy> getQuanLyTheoMa(String tenTK) throws RemoteException;
    
    boolean updateMatKhau(QuanLy quanLy) throws RemoteException;
    
    public QuanLy getQuanLyByCredentials(String username, String password)throws RemoteException;
    
    void closeEntityManager() throws RemoteException;
}
