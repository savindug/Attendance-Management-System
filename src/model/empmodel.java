/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Nuwanga
 */
public class empmodel {

   
    
    private String branchname;
    private String username;
    private String password;    
    private String newpassword;

   
     public empmodel() {
    }
    
    public empmodel(String branchname, String username, String password, String newpassword) {
        this.branchname = branchname;
        this.username = username;
        this.password = password;
        this.newpassword = newpassword;
    }
    
    public String getNewpassword() {
        return newpassword;
    }

    public void setNewpassword(String newpassword) {
        this.newpassword = newpassword;
    }
     public String getBranchname() {
        return branchname;
    }

    public void setBranchname(String branchname) {
        this.branchname = branchname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    
    
}
