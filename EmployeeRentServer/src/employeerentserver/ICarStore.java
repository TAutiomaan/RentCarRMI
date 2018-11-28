/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package employeerentserver;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author Youva
 */
public interface ICarStore extends Remote {
    public void rentCar(int employeeNum, String mdp, int carNum, Date start, Date end) throws RemoteException;
    public void restituteCar(int employeeNum, String mdp, int carNum, int note) throws RemoteException;
    public void reserveCar(int employeeNum, String mdp, int carNum, Date start, Date end) throws RemoteException;
    public ArrayList<Car> displayCarslist()throws RemoteException;
    public ArrayList<Reservation> displayReservations(int employeeNum, String mdp)throws RemoteException;
    public ArrayList<Reservation> displayRentals(int employeeNum, String mdp)throws RemoteException;
}
