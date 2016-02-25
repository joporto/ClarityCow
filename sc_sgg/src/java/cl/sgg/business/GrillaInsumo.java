//v1.0.2
package cl.sgg.business;

// <editor-fold defaultstate="collapsed" desc="Imports">
import cl.sgg.edm.Insumo;
//</editor-fold>

public class GrillaInsumo 
{
    // <editor-fold defaultstate="collapsed" desc="Atributos">
    private Insumo insumo;
    private String tipoInsumo;
    //</editor-fold>

    // <editor-fold defaultstate="collapsed" desc="GET & SET">
    public Insumo getInsumo() {
        return insumo;
    }

    public void setInsumo(Insumo insumo) {
        this.insumo = insumo;
    }

    public String getTipoInsumo() {
        return tipoInsumo;
    }

    public void setTipoInsumo(String tipoInsumo) {
        this.tipoInsumo = tipoInsumo;
    }
    //</editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Constructores">
    //Constructor por defecto
    public GrillaInsumo ()
    {
        this.insumo = new Insumo();
        this.tipoInsumo = "";
    }
    //</editor-fold>
}