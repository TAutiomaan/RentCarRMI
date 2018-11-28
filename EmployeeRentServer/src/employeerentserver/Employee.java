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
public class Employee implements Serializable {
    
    private int num;
    private String mdp;
    

    public Employee(int num, String mdp) {
        this.num = num;
        this.mdp = mdp;
        
    }

    public String getMdp() {
        return mdp;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }
    
    
}
