//v1.0.1
package cl.sgg.business;

import java.util.Date;
import java.util.List;

public class FormFeedlotTraslado 
{
    private int rupOrigen;
    private int rupDestino;
    private String nomRupOrigen;
    private String nomRupDestino;
    private String comuna;
    private String direccion;
    private int idTransportista;
    private String nomTransportista;
    private String rutTransportista;
    private int idVehiculo;
    private String patenteVehiculo;
    private String patenteAcoplado;
    private Date fechaRegistro;
    private Date fechaTraslado;
    private String FMA;
    private String guiaDespacho;
    private List<GrillaFeedlotTraslado> gft;

    
    public int getRupOrigen() {
        return rupOrigen;
    }

    public void setRupOrigen(int rupOrigen) {
        this.rupOrigen = rupOrigen;
    }

    public int getRupDestino() {
        return rupDestino;
    }

    public void setRupDestino(int rupDestino) {
        this.rupDestino = rupDestino;
    }

    public String getNomRupOrigen() {
        return nomRupOrigen;
    }

    public void setNomRupOrigen(String nomRupOrigen) {
        this.nomRupOrigen = nomRupOrigen;
    }

    public String getNomRupDestino() {
        return nomRupDestino;
    }

    public void setNomRupDestino(String nomRupDestino) {
        this.nomRupDestino = nomRupDestino;
    }

    public String getComuna() {
        return comuna;
    }

    public void setComuna(String comuna) {
        this.comuna = comuna;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    
        public int getIdTransportista() {
        return idTransportista;
    }

    public void setIdTransportista(int idTransportista) {
        this.idTransportista = idTransportista;
    }

    public String getNomTransportista() {
        return nomTransportista;
    }

    public void setNomTransportista(String nomTransportista) {
        this.nomTransportista = nomTransportista;
    }

    public String getRutTransportista() {
        return rutTransportista;
    }

    public void setRutTransportista(String rutTransportista) {
        this.rutTransportista = rutTransportista;
    }

    public int getIdVehiculo() {
        return idVehiculo;
    }

    public void setIdVehiculo(int idVehiculo) {
        this.idVehiculo = idVehiculo;
    }
    
    public String getPatenteVehiculo() {
        return patenteVehiculo;
    }

    public void setPatenteVehiculo(String patenteVehiculo) {
        this.patenteVehiculo = patenteVehiculo;
    }

    public String getPatenteAcoplado() {
        return patenteAcoplado;
    }

    public void setPatenteAcoplado(String patenteAcoplado) {
        this.patenteAcoplado = patenteAcoplado;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public Date getFechaTraslado() {
        return fechaTraslado;
    }

    public void setFechaTraslado(Date fechaTraslado) {
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

    public List<GrillaFeedlotTraslado> getGft() {
        return gft;
    }

    public void setGft(List<GrillaFeedlotTraslado> gft) {
        this.gft = gft;
    }

    public FormFeedlotTraslado() {
    }

    @Override
    public String toString() {
        return "FormFeedlotTraslado{" + "rupOrigen=" + rupOrigen + ", rupDestino=" + rupDestino + ", nomRupOrigen=" + nomRupOrigen + ", nomRupDestino=" + nomRupDestino + ", comuna=" + comuna + ", direccion=" + direccion + ", nomTransportista=" + nomTransportista + ", rutTransportista=" + rutTransportista + ", patenteVehiculo=" + patenteVehiculo + ", patenteAcoplado=" + patenteAcoplado + ", fechaRegistro=" + fechaRegistro + ", fechaTraslado=" + fechaTraslado + ", FMA=" + FMA + ", guiaDespacho=" + guiaDespacho + ", gft=" + gft + '}';
    }
}
