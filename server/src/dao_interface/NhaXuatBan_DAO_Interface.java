package dao_interface;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;
import entity.NhaXuatBan;

public interface NhaXuatBan_DAO_Interface extends Remote {
    
    List<NhaXuatBan> getalltNhaXuatBan() throws RemoteException;
    
    void closeEntityManager() throws RemoteException;
}
