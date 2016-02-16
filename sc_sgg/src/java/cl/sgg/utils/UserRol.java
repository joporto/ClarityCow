//v1.0.0
package cl.sgg.utils;

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
