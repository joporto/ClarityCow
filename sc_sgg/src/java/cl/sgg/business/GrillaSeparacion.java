//V1.0.0
package cl.sgg.business;

public class GrillaSeparacion 
{
    private String corral;
    private String grupoPeso;

    public String getCorral() {
        return corral;
    }

    public void setCorral(String corral) {
        this.corral = corral;
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
    }
}
