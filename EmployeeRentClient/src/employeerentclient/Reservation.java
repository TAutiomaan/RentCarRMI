/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package employeerentclient;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author Youva
 */
public class Reservation implements Serializable{
    private int emplyee;
    private int car;
    private Date start;
    private Date end;

    public Reservation(int emplyee, int car, Date start, Date end) {
        this.emplyee = emplyee;
        this.car = car;
        this.start = start;
        this.end = end;
    }

    public int getEmplyee() {
        return emplyee;
    }

    public void setEmplyee(int emplyee) {
        this.emplyee = emplyee;
    }

    public int getCar() {
        return car;
    }

    public void setCar(int car) {
        this.car = car;
    }

    public Date getStart() {
        return start;
    }

    public void setStart(Date start) {
        this.start = start;
    }

    public Date getEnd() {
        return end;
    }

    public void setEnd(Date end) {
        this.end = end;
    }
    
    
}
