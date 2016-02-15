
package cl.sgg.business;

class GrillaFeedlotTraslado 
{
    private int DIIO;
    private float peso;
    private String status;

    public int getDIIO() {
        return DIIO;
    }

    public void setDIIO(int DIIO) {
        this.DIIO = DIIO;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
        public float getPeso() {
        return peso;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }

    public GrillaFeedlotTraslado() 
    {
        this.DIIO = 0;
        this.peso = 0;
        this.status = "";
    }
}