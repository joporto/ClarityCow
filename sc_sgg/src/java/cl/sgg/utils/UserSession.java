//v1.0.0
package cl.sgg.utils;

public class UserSession 
{
     private Integer userid;
     private String username;
     private String firstname;
     private String lastname;
     private String userdesc;
     private boolean uservalid;
     private String usermessage;
     private cl.sgg.utils.UserRol userrol;

    
    
    public UserSession(cl.sgg.edm.Usuarios usr, cl.sgg.utils.UserRol rol)
    {
        this.firstname = usr.getFirstname();
        this.lastname = usr.getLastname();
        this.userdesc = usr.getUserdesc();
        this.userid = usr.getUserid();
        this.usermessage = usr.getUsermessage();
        this.username = usr.getUsername();
        this.userrol = rol;
        this.uservalid = usr.isUservalid();
        
    }

    public UserSession(Integer userid, String username, String firstname, String lastname, String userdesc, boolean uservalid, String usermessage, UserRol userrol) {
        this.userid = userid;
        this.username = username;
        
        this.firstname = firstname;
        this.lastname = lastname;
        this.userdesc = userdesc;
        this.uservalid = uservalid;
        this.usermessage = usermessage;
        this.userrol = userrol;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }


    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getUserdesc() {
        return userdesc;
    }

    public void setUserdesc(String userdesc) {
        this.userdesc = userdesc;
    }

    public boolean isUservalid() {
        return uservalid;
    }

    public void setUservalid(boolean uservalid) {
        this.uservalid = uservalid;
    }

    public String getUsermessage() {
        return usermessage;
    }

    public void setUsermessage(String usermessage) {
        this.usermessage = usermessage;
    }

    public cl.sgg.utils.UserRol getUserrol() {
        return userrol;
    }

    public void setUserrol(cl.sgg.utils.UserRol userrol) {
        this.userrol = userrol;
    }

    @Override
    public String toString() {
        return "UserSession{" + "userid=" + userid + ", username=" + username + ", firstname=" + firstname + ", lastname=" + lastname + ", userdesc=" + userdesc + ", uservalid=" + uservalid + ", usermessage=" + usermessage + ", userrol=" + userrol + '}';
    }
    

}
