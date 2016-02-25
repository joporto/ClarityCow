//V1.1.1
package cl.sgg.business;

public class GrillaSeparacion 
{
    // <editor-fold defaultstate="collapsed" desc="Atributos">
    private String id;
    private String corral;
    private int idCorral;
    private String grupoPeso;
    private int idGrupoPeso;
    //</editor-fold>

    // <editor-fold defaultstate="collapsed" desc="GET & SET">
    public String getId() 
    {
        return corral+grupoPeso;
    }
    
    public String getCorral() {
        return corral;
    }

    public int getIdCorral() {
        return idCorral;
    }

    public void setIdCorral(int idCorral) {
        this.idCorral = idCorral;
    }

    public int getIdGrupoPeso() {
        return idGrupoPeso;
    }

    public void setIdGrupoPeso(int idGrupoPeso) {
        this.idGrupoPeso = idGrupoPeso;
    }

    public void setCorral(String corral) 
    {
        this.corral = corral;
    }

    public String getGrupoPeso() {
        return grupoPeso;
    }

    public void setGrupoPeso(String grupoPeso) {
        this.grupoPeso = grupoPeso;
    }
    //</editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Constructores">
    public GrillaSeparacion()
    {
        this.corral = "";
        this.grupoPeso = "";
        this.id = this.corral+this.grupoPeso;
    }
    //</editor-fold>
}