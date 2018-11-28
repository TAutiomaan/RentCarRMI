/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package employeerentserver;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

/**
 *
 * @author Youva
 */
public class EmployeeRentServer {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        try {
            LocateRegistry.createRegistry(1099);
            CarStore carStore = new CarStore();
            carStore.addCar("Toyota");
            carStore.addCar("Hunday");
            carStore.addCar("Ford");
            carStore.addCar("Nisan");
            carStore.addCar("Mitsubishi");
            carStore.addCar("Pegeot");
            carStore.addCar("Renault");
            carStore.addCar("Volkswagen");
            carStore.addCar("Audi");
            carStore.addCar("Honda");
            
            carStore.addEmployee(1, "aaa");
            carStore.addEmployee(2, "bbb");
            carStore.addEmployee(3, "ccc");
            carStore.addEmployee(4, "ddd");
            carStore.addEmployee(5, "eee");
            carStore.addEmployee(6, "fff");
            carStore.addEmployee(7, "ggg");
            carStore.addEmployee(8, "hhh");
            carStore.addEmployee(9, "iii");
            carStore.addEmployee(10, "jjj");
            carStore.addEmployee(11, "kkk");
            carStore.addEmployee(12, "lll");
            
            Naming.rebind("rmi://localhost:1099/carstore", carStore);
        } catch (Exception e) {
            System.out.println("Trouble: "+ e);
        }
    }
    
}
