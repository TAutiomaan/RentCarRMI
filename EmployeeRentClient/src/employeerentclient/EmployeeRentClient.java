/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package employeerentclient;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Youva
 */
public class EmployeeRentClient {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            // TODO code application logic here
            ICarStore carStore =(ICarStore) Naming.lookup("rmi://localhost:1099/carstore");
            
            Scanner reader = new Scanner(System.in);
            while(true){
                System.out.println("Choose the operation you want : ");
                System.out.println("1- Display all cars");
                System.out.println("2- Display your rentals ");
                System.out.println("3- Display your reservations ");
                System.out.println("4- Rent a car ");
                System.out.println("5- Restitute a car ");
                System.out.println("6- Reserve a car ");
                System.out.println("-------------------------------------------- ");
                
                int choice = reader.nextInt();
                int id, carId;
                String pph,start, end;
                DateFormat format = new SimpleDateFormat("MMMM d, yyyy", Locale.ENGLISH);
                switch(choice){
                    case 1 : 
                        ArrayList<Car> carList = new ArrayList<Car>(carStore.displayCarslist());
                        System.out.println(" The vehicul list : ");
                        for(int i = 0; i<carList.size(); i++){
                            System.out.println(" car N° "+carList.get(i).getCarNumber() +" || Avaibility : "+ carList.get(i).isAvailible());
                        }
                    break;
                    case 2:
                        System.out.println(" Enter your ID : ");
                        id = reader.nextInt();
                        System.out.println(" Enter your passphrase : ");
                        pph = reader.nextLine();
                        ArrayList<Reservation> carList1 = new ArrayList<Reservation>(carStore.displayRentals(id, pph));
                        System.out.println(" Your rentals list : ");
                        for(int i = 0; i<carList1.size(); i++){
                            System.out.println(" car N° "+carList1.get(i).getCar() +" || Date: "+ carList1.get(i).getStart() +" --> "+carList1.get(i).getEnd());
                        }
                    break;
                    case 3:
                        System.out.println(" Enter your ID : ");
                        id = reader.nextInt();
                        System.out.println(" Enter your passphrase : ");
                        pph = reader.nextLine();
                        ArrayList<Reservation> carList2 = new ArrayList<Reservation>(carStore.displayReservations(id, pph));
                        System.out.println(" Your reservations list : ");
                        for(int i = 0; i<carList2.size(); i++){
                            System.out.println(" car N° "+carList2.get(i).getCar() +" || Date: "+ carList2.get(i).getStart() +" --> "+carList2.get(i).getEnd());
                        }
                    break;
                    case 4:
                        System.out.println(" Enter your ID : ");
                        id = reader.nextInt();
                        System.out.println(" Enter your passphrase : ");
                        pph = reader.nextLine();
                        System.out.println(" Enter the car ID  : ");
                        carId = reader.nextInt();
                        System.out.println(" Enter the end date (format : MMMM d, yyyy ");
                        end = reader.nextLine();
                        Date date = format.parse(end);
                        carStore.rentCar(id, pph, carId, Calendar.getInstance().getTime(), date);
                    break;
                    case 5:
                        System.out.println(" Enter your ID : ");
                        id = reader.nextInt();
                        System.out.println(" Enter your passphrase : ");
                        pph = reader.nextLine();
                        System.out.println(" Enter the car ID  : ");
                        carId = reader.nextInt();
                        System.out.println(" Rate the car (0-5) ");
                        int note = reader.nextInt();
                        carStore.restituteCar(id, pph, carId, note);
                    break;    
                    case 6:
                        System.out.println(" Enter your ID : ");
                        id = reader.nextInt();
                        System.out.println(" Enter your passphrase : ");
                        pph = reader.nextLine();
                        System.out.println(" Enter the car ID  : ");
                        carId = reader.nextInt();
                        System.out.println(" Enter the start date (format : MMMM d, yyyy ");
                        start = reader.nextLine();
                        System.out.println(" Enter the end date (format : MMMM d, yyyy ");
                        end = reader.nextLine();
                        Date date1 = format.parse(start);
                        Date date2 = format.parse(end);
                        carStore.reserveCar(id, pph, carId, date1, date2);
                    break;
                      
                }
               
                
            }
        } catch (Exception e) {
            System.out.println("Trouble: "+ e);
        }
        
    }
    
}
