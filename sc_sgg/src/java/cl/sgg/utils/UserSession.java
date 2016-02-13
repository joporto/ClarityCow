/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.sgg.utils;

/**
 *
 * @author javierOporto
 */
public class UserSession 
{
    private String userName; 
    private UserRol userR;
    private boolean valid;
    private String message;

    public UserSession(String userName, UserRol userR, boolean valid, String message) {
        this.userName = userName;
        this.userR = userR;
        this.valid = valid;
        this.message = message;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public UserRol getUserR() {
        return userR;
    }

    public void setUserR(UserRol userR) {
        this.userR = userR;
    }

    public boolean isValid() {
        return valid;
    }

    public void setValid(boolean valid) {
        this.valid = valid;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "UserSession{" + "userName=" + userName + ", userR=" + userR + ", valid=" + valid + ", message=" + message + '}';
    }
}
