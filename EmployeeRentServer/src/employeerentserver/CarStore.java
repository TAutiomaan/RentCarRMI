/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package employeerentserver;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Youva
 */
public class CarStore extends UnicastRemoteObject implements ICarStore {
    private HashMap<Integer, Car> cars;
    private HashMap<Integer, Employee> employees;
    private List<Reservation> reservations;
    protected CarStore() throws RemoteException {
		super();
		this.cars = new HashMap<Integer, Car>();
                this.employees = new HashMap<Integer, Employee>();
                this.reservations = new ArrayList<Reservation>();
	}
    
    @Override
    public void rentCar(int employeeNum, String mdp, int carNum, Date start, Date end) throws RemoteException {
        if(this.employees.containsKey(employeeNum))
            if(this.employees.get(employeeNum).getMdp().equals(mdp))
                if(cars.containsKey(carNum) && cars.get(carNum).isAvailible()){
                    cars.get(carNum).setEmployeeNum(employeeNum);
                    cars.get(carNum).setDateOfAvailibity(end);
                    cars.get(carNum).setAvailible(false);
                }
    }

    @Override
    public void restituteCar(int employeeNum, String mdp, int carNum, int note) throws RemoteException {
        if(this.employees.containsKey(employeeNum))
            if(this.employees.get(employeeNum).getMdp().equals(mdp))
                if(cars.containsKey(carNum)){
                    cars.get(carNum).setNote(note);
                    cars.get(carNum).setAvailible(true);
                    for(int i=0; i< this.reservations.size(); i++){
                        if ((this.reservations.get(i).getCar() == carNum)&&(this.reservations.get(i).getEmplyee() == employeeNum)) {
                            this.reservations.remove(i);
                            this.cars.get(carNum).setEmployeeNum(-1);
                            this.cars.get(carNum).setAvailible(true);
                        }
                    }
                }
    }

    @Override
    public void reserveCar(int employeeNum, String mdp, int carNum, Date start, Date end) throws RemoteException {
        if(this.employees.containsKey(employeeNum))
            if(this.employees.get(employeeNum).getMdp().equals(mdp))
                if(cars.containsKey(carNum))
                    this.reservations.add(new Reservation(employeeNum,carNum,start,end));
    }

    @Override
    public ArrayList<Car> displayCarslist() throws RemoteException {
        List<Car> listCar = new ArrayList<Car>(this.cars.values());
        return (ArrayList)listCar;
    }

    @Override
    public ArrayList<Reservation> displayReservations(int employeeNum, String mdp) throws RemoteException {
         List<Reservation> listRes = new ArrayList<Reservation>();
         
         for(int i=0; i<this.reservations.size(); i++){
             if(this.reservations.get(i).getEmplyee() == employeeNum) listRes.add(this.reservations.get(i));
         }
         return (ArrayList)listRes;
    }

    @Override
    public ArrayList <Reservation> displayRentals(int employeeNum, String mdp) throws RemoteException {
        List<Reservation> listRes = new ArrayList<Reservation>();
         
         for(int i=0; i<this.reservations.size(); i++){
             if(this.reservations.get(i).getEmplyee() == employeeNum && this.cars.get(this.reservations.get(i).getCar()).getEmployeeNum() == employeeNum) listRes.add(this.reservations.get(i));
         }
         return (ArrayList)listRes;
    }
    
    public void addCar(String brand){
        Car car = new Car(brand);
        this.cars.put(car.getCarNumber(),car);
    }
    
    public void addEmployee(int num, String mdp){
        Employee e = new Employee(num, mdp);
        this.employees.put(num, e);
    }
}
