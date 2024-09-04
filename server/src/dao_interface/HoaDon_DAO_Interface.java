package dao_interface;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import entity.HoaDon;

public interface HoaDon_DAO_Interface extends Remote {

    List<HoaDon> getallHoaDon() throws RemoteException;
    
    public List<HoaDon> getallHoaDonDaHuy()throws RemoteException;
    
    public List<HoaDon> getallHoaDonTrongTuanGanNhat()throws RemoteException;

    List<HoaDon> getallHoaDonThangNay() throws RemoteException;

    List<HoaDon> getallHoaDonNgayHomNay() throws RemoteException;

    List<HoaDon> getHoaDonTheoMa(String id) throws RemoteException;

    List<HoaDon> getHoaDonDaHuyTheoMa(String id) throws RemoteException;

    List<HoaDon> getGiamGia() throws RemoteException;

    boolean createHoaDonCoKH(HoaDon hd) throws RemoteException;

    boolean createHoaDonKhongCoKH(HoaDon hd) throws RemoteException;

    List<HoaDon> getHoaDonTheoThangVaNam(String month, String year) throws RemoteException;

    List<HoaDon> getTongTienCacHoaDon(String month, String year) throws RemoteException;

    List<HoaDon> getTongSoHoaDonNgayHomNay() throws RemoteException;

    List<HoaDon> getTongSoHoaDonNgayHomQua() throws RemoteException;

    List<HoaDon> getTongSoHoaDonTuanNay() throws RemoteException;

    List<HoaDon> getTongSoHoaDonThangNay() throws RemoteException;

    List<HoaDon> getTongDoanhThuHomNay() throws RemoteException;

    List<HoaDon> getTongDoanhThuHomQua() throws RemoteException;

    List<HoaDon> getTongDoanhThuTuanNay() throws RemoteException;

    List<HoaDon> getTongDoanhThuThangNay() throws RemoteException;

    boolean xoaHD(HoaDon hd) throws RemoteException;
    
    List<Object[]> getHoaDonByCurrentDay() throws RemoteException;
    
    List<Object[]> getHoaDonByMonthAndYear(String month, String year) throws RemoteException;

    void close() throws RemoteException;

}
