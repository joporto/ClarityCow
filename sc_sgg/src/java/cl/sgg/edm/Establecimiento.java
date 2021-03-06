package cl.sgg.edm;
// Generated 11-feb-2016 0:18:43 by Hibernate Tools 4.3.1


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Establecimiento generated by hbm2java
 */
@Entity
@Table(name="ESTABLECIMIENTO"
    ,catalog="CLARITYCOW"
)
public class Establecimiento  implements java.io.Serializable {


     private int rupId;
     private Integer tiporupId;
     private String rupNombre;
     private String rupComuna;
     private String rupDireccion;
     private Integer rupSuperficie;
     private Integer rupCargasugerida;
     private Integer rupKgMsHa;
     private Integer rupStatus;

    public Establecimiento() {
    }

	
    public Establecimiento(int rupId) {
        this.rupId = rupId;
    }
    public Establecimiento(int rupId, Integer tiporupId, String rupNombre, String rupComuna, String rupDireccion, Integer rupSuperficie, Integer rupCargasugerida, Integer rupKgMsHa, Integer rupStatus) {
       this.rupId = rupId;
       this.tiporupId = tiporupId;
       this.rupNombre = rupNombre;
       this.rupComuna = rupComuna;
       this.rupDireccion = rupDireccion;
       this.rupSuperficie = rupSuperficie;
       this.rupCargasugerida = rupCargasugerida;
       this.rupKgMsHa = rupKgMsHa;
       this.rupStatus = rupStatus;
    }
   
     @Id 

    
    @Column(name="RUP_ID", unique=true, nullable=false)
    public int getRupId() {
        return this.rupId;
    }
    
    public void setRupId(int rupId) {
        this.rupId = rupId;
    }

    
    @Column(name="TIPORUP_ID")
    public Integer getTiporupId() {
        return this.tiporupId;
    }
    
    public void setTiporupId(Integer tiporupId) {
        this.tiporupId = tiporupId;
    }

    
    @Column(name="RUP_NOMBRE", length=50)
    public String getRupNombre() {
        return this.rupNombre;
    }
    
    public void setRupNombre(String rupNombre) {
        this.rupNombre = rupNombre;
    }

    
    @Column(name="RUP_COMUNA", length=50)
    public String getRupComuna() {
        return this.rupComuna;
    }
    
    public void setRupComuna(String rupComuna) {
        this.rupComuna = rupComuna;
    }

    
    @Column(name="RUP_DIRECCION", length=100)
    public String getRupDireccion() {
        return this.rupDireccion;
    }
    
    public void setRupDireccion(String rupDireccion) {
        this.rupDireccion = rupDireccion;
    }

    
    @Column(name="RUP_SUPERFICIE")
    public Integer getRupSuperficie() {
        return this.rupSuperficie;
    }
    
    public void setRupSuperficie(Integer rupSuperficie) {
        this.rupSuperficie = rupSuperficie;
    }

    
    @Column(name="RUP_CARGASUGERIDA")
    public Integer getRupCargasugerida() {
        return this.rupCargasugerida;
    }
    
    public void setRupCargasugerida(Integer rupCargasugerida) {
        this.rupCargasugerida = rupCargasugerida;
    }

    
    @Column(name="RUP_KG_MS_HA")
    public Integer getRupKgMsHa() {
        return this.rupKgMsHa;
    }
    
    public void setRupKgMsHa(Integer rupKgMsHa) {
        this.rupKgMsHa = rupKgMsHa;
    }

    
    @Column(name="RUP_STATUS")
    public Integer getRupStatus() {
        return this.rupStatus;
    }
    
    public void setRupStatus(Integer rupStatus) {
        this.rupStatus = rupStatus;
    }




}


