//V1.0.0
package cl.sgg.business;

public class GrillaSeparacion 
{
    private String corral;
    private String grupoPeso;
    private int status; //0: new registro, 1:

    public String getCorral() {
        return corral;
    }

    public void setCorral(String corral) 
    {
        this.corral = corral;
        if(status == 0)
            status = 1; //Guardado inicial a la grilla sin cambios
        if(status == 1)
            status =2; //guardado con cambios requiere agregar registro
    }

    public String getGrupoPeso() {
        return grupoPeso;
    }

    public void setGrupoPeso(String grupoPeso) {
        this.grupoPeso = grupoPeso;
    }
    
    public GrillaSeparacion()
    {
        this.corral = "";
        this.grupoPeso = "";
        this.status = 0; //sin cambios
    }
}
