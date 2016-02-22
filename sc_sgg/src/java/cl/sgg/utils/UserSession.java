//v1.0.0
package cl.sgg.utils;

public class UserSession 
{
    private int userId;
    private String userName;
    private String name;
    private String apellido;
    private String descripcion;
    
    private UserRol userR;
    private boolean valid;
    private String message;

    
    public UserSession(int userId, String userName, String name, String apellido, String descripcion, UserRol userR, boolean valid, String message) {
        this.userId = userId;
        this.userName = userName;
        this.name = name;
        this.apellido = apellido;
        this.descripcion = descripcion;
        this.userR = userR;
        this.valid = valid;
        this.message = message;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
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
        return "UserSession{" + "userId=" + userId + ", userName=" + userName + ", name=" + name + ", apellido=" + apellido + ", descripcion=" + descripcion + ", userR=" + userR + ", valid=" + valid + ", message=" + message + '}';
    }

}
