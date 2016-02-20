//v1.0.1
package cl.sgg.business;

public class GrillaFeedlot 
{
    private int idTransporte;
    private String tipoTraslado;
    private String fechaTraslado;
    private String FMA;
    private String guiaDespacho;
    private String fundoOrigen;
    private String fundoDestino;
    private String status;

    public int getIdTransporte() {
        return idTransporte;
    }

    public void setIdTransporte(int idTransporte) {
        this.idTransporte = idTransporte;
    }

    public String getTipoTraslado() {
        return tipoTraslado;
    }

    public void setTipoTraslado(String tipoTraslado) {
        this.tipoTraslado = tipoTraslado;
    }

    public String getFechaTraslado() {
        return fechaTraslado;
    }

    public void setFechaTraslado(String fechaTraslado) {
        this.fechaTraslado = fechaTraslado;
    }

    public String getFMA() {
        return FMA;
    }

    public void setFMA(String FMA) {
        this.FMA = FMA;
    }

    public String getGuiaDespacho() {
        return guiaDespacho;
    }

    public void setGuiaDespacho(String guiaDespacho) {
        this.guiaDespacho = guiaDespacho;
    }

    public String getFundoOrigen() {
        return fundoOrigen;
    }

    public void setFundoOrigen(String fundoOrigen) {
        this.fundoOrigen = fundoOrigen;
    }

    public String getFundoDestino() {
        return fundoDestino;
    }

    public void setFundoDestino(String fundoDestino) {
        this.fundoDestino = fundoDestino;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
    public GrillaFeedlot()
    {
        
    }
    
    public GrillaFeedlot(int idTransporte, String tipoTraslado, String fechaTraslado, String FMA, String guiaDespacho, String fundoOrigen, String fundoDestino, String status) {
        this.idTransporte = idTransporte;
        this.tipoTraslado = tipoTraslado;
        this.fechaTraslado = fechaTraslado;
        this.FMA = FMA;
        this.guiaDespacho = guiaDespacho;
        this.fundoOrigen = fundoOrigen;
        this.fundoDestino = fundoDestino;
        this.status = status;
    }

    @Override
    public String toString() 
    {
        return "GrillaFeedlot{" + "idTransporte=" + idTransporte + ", tipoTraslado=" + tipoTraslado + ", fechaTraslado=" + fechaTraslado + ", FMA=" + FMA + ", guiaDespacho=" + guiaDespacho + ", fundoOrigen=" + fundoOrigen + ", fundoDestino=" + fundoDestino + ", status=" + status + '}';
    }
}
