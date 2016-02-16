//v1.0.0
package cl.sgg.business;

import cl.sgg.edm.Insumo;


public class GrillaInsumo 
{
    private Insumo insumo;
    private String tipoInsumo;

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
    
    //Constructor por defecto
    public GrillaInsumo ()
    {
        this.insumo = new Insumo();
        this.tipoInsumo = "";
    }
}
