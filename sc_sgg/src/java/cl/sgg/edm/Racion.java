package cl.sgg.edm;
// Generated 11-feb-2016 0:18:43 by Hibernate Tools 4.3.1


import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Racion generated by hbm2java
 */
@Entity
@Table(name="RACION"
    ,catalog="CLARITYCOW"
)
public class Racion  implements java.io.Serializable {


     private int racionId;
     private String racionDs;
     private Float racionGananciaDiaria;
     private Float racionTeoEmKgMs;
     private Float racionPorcProteina;
     private Date racionFecha;
     private Integer racionStatus;

    public Racion() {
    }

	
    public Racion(int racionId) {
        this.racionId = racionId;
    }
    public Racion(int racionId, String racionDs, Float racionGananciaDiaria, Float racionTeoEmKgMs, Float racionPorcProteina, Date racionFecha, Integer racionStatus) {
       this.racionId = racionId;
       this.racionDs = racionDs;
       this.racionGananciaDiaria = racionGananciaDiaria;
       this.racionTeoEmKgMs = racionTeoEmKgMs;
       this.racionPorcProteina = racionPorcProteina;
       this.racionFecha = racionFecha;
       this.racionStatus = racionStatus;
    }
   
     @Id 

    
    @Column(name="RACION_ID", unique=true, nullable=false)
    public int getRacionId() {
        return this.racionId;
    }
    
    public void setRacionId(int racionId) {
        this.racionId = racionId;
    }

    
    @Column(name="RACION_DS", length=100)
    public String getRacionDs() {
        return this.racionDs;
    }
    
    public void setRacionDs(String racionDs) {
        this.racionDs = racionDs;
    }

    
    @Column(name="RACION_GANANCIA_DIARIA", precision=12, scale=0)
    public Float getRacionGananciaDiaria() {
        return this.racionGananciaDiaria;
    }
    
    public void setRacionGananciaDiaria(Float racionGananciaDiaria) {
        this.racionGananciaDiaria = racionGananciaDiaria;
    }

    
    @Column(name="RACION_TEO_EM_KG_MS", precision=12, scale=0)
    public Float getRacionTeoEmKgMs() {
        return this.racionTeoEmKgMs;
    }
    
    public void setRacionTeoEmKgMs(Float racionTeoEmKgMs) {
        this.racionTeoEmKgMs = racionTeoEmKgMs;
    }

    
    @Column(name="RACION_PORC_PROTEINA", precision=12, scale=0)
    public Float getRacionPorcProteina() {
        return this.racionPorcProteina;
    }
    
    public void setRacionPorcProteina(Float racionPorcProteina) {
        this.racionPorcProteina = racionPorcProteina;
    }

    @Temporal(TemporalType.DATE)
    @Column(name="RACION_FECHA", length=10)
    public Date getRacionFecha() {
        return this.racionFecha;
    }
    
    public void setRacionFecha(Date racionFecha) {
        this.racionFecha = racionFecha;
    }

    
    @Column(name="RACION_STATUS")
    public Integer getRacionStatus() {
        return this.racionStatus;
    }
    
    public void setRacionStatus(Integer racionStatus) {
        this.racionStatus = racionStatus;
    }




}


