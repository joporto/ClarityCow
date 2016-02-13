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
public class UserRol {
    private int userRolId;
    private String userRolDs;

    public UserRol(int userRolId, String userRolDs) {
        this.userRolId = userRolId;
        this.userRolDs = userRolDs;
    }

    public int getUserRolId() {
        return userRolId;
    }

    public void setUserRolId(int userRolId) {
        this.userRolId = userRolId;
    }

    public String getUserRolDs() {
        return userRolDs;
    }

    public void setUserRolDs(String userRolDs) {
        this.userRolDs = userRolDs;
    }

    @Override
    public String toString() {
        return "UserRol{" + "userRolId=" + userRolId + ", userRolDs=" + userRolDs + '}';
    }
}
