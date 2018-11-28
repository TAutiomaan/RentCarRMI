/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package employeerentserver;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Youva
 */
public class Car implements Serializable{
    
    static int numberOfCars=0;
    private int carNumber;
    private String brand;
    private int employeeNum;
    private Date dateOfAvailibity;
    private String state;
    private int note;
    private int somNotes;
    private int numberNotes;
    private boolean availible;

    public Car(String brand) {
        this.brand = brand;
        this.state = state;
        this.carNumber = numberOfCars;
        numberOfCars++ ;
        note=0;
        somNotes = 0;
        numberNotes = 0;
        employeeNum = -1;
        this.availible =true;
    }

    public int getEmployeeNum() {
        return employeeNum;
    }

    public void setEmployeeNum(int employeeNum) {
        this.employeeNum = employeeNum;
    }

    public Date getDateOfAvailibity() {
        return dateOfAvailibity;
    }

    public void setDateOfAvailibity(Date dateOfAvailibity) {
        this.dateOfAvailibity = dateOfAvailibity;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public int getNote() {
        return note;
    }

    public void setNote(int note) {
        this.somNotes =+ note;
        this.numberNotes ++ ;
        this.note = this.somNotes/this.numberNotes;
    }

    public boolean isAvailible() {
        return availible;
    }

    public void setAvailible(boolean availible) {
        this.availible = availible;
    }

    public int getCarNumber() {
        return carNumber;
    }
    
    
}
