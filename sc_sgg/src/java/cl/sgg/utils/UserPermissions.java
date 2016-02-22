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
public class UserPermissions {
    
    private UserSession user;
    private boolean userPermissions;
    private String url;

    public UserPermissions(UserSession user, boolean userPermissions, String url) {
        this.user = user;
        this.userPermissions = userPermissions;
        this.url = url;
    }

    public UserPermissions() {
    }

    public UserSession getUser() {
        return user;
    }

    public void setUser(UserSession user) {
        this.user = user;
    }

    public boolean isUserPermissions() {
        return userPermissions;
    }

    public void setUserPermissions(boolean userPermissions) {
        this.userPermissions = userPermissions;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "UserPermissions{" + "user=" + user + ", userPermissions=" + userPermissions + ", url=" + url + '}';
    }
    
    
    
}
