//v1.0.0
package cl.sgg.utils;

public class Respuesta 
{
    private boolean status;
    private String mensaje;

    
    /**
     * @return the status
     */
    public boolean isStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(boolean status) {
        this.status = status;
    }

    /**
     * @return the mensaje
     */
    public String getMensaje() {
        return mensaje;
    }

    /**
     * @param mensaje the mensaje to set
     */
    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
    
    public Respuesta() 
    {
       this.mensaje = "NO OK";
       this.status = false;
    }
}