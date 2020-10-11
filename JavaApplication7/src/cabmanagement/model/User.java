/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cabmanagement.model;

import java.util.Date;

/**
 *
 * @author rajeshkumar.yadav
 */
public class User extends CabManagementEntity{
    
    String id;
    String displayName;
    String userName;
    String password;
    Date dateOfBirth;

    public User(String id, String displayName, String userName, String password, Date dateOfBirth) {
        this.id = id;
        this.displayName = displayName;
        this.userName = userName;
        this.password = password;
        this.dateOfBirth = dateOfBirth;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
 
}
