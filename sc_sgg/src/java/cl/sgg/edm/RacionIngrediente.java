package cl.sgg.edm;
// Generated 11-feb-2016 0:18:43 by Hibernate Tools 4.3.1


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * RacionIngrediente generated by hbm2java
 */
@Entity
@Table(name="RACION_INGREDIENTE"
    ,catalog="CLARITYCOW"
)
public class RacionIngrediente  implements java.io.Serializable {


     private int racioningId;
     private Integer racionId;
     private Integer ingredienteId;
     private Integer racioningKilosFrescos;
     private Float racioningCostoKg;
     private Float racioningPorcMs;
     private Float racioningEMentKgMs;
     private Float racioningProtKgMs;
     private Integer racioningStatus;

    public RacionIngrediente() {
    }

	
    public RacionIngrediente(int racioningId) {
        this.racioningId = racioningId;
    }
    public RacionIngrediente(int racioningId, Integer racionId, Integer ingredienteId, Integer racioningKilosFrescos, Float racioningCostoKg, Float racioningPorcMs, Float racioningEMentKgMs, Float racioningProtKgMs, Integer racioningStatus) {
       this.racioningId = racioningId;
       this.racionId = racionId;
       this.ingredienteId = ingredienteId;
       this.racioningKilosFrescos = racioningKilosFrescos;
       this.racioningCostoKg = racioningCostoKg;
       this.racioningPorcMs = racioningPorcMs;
       this.racioningEMentKgMs = racioningEMentKgMs;
       this.racioningProtKgMs = racioningProtKgMs;
       this.racioningStatus = racioningStatus;
    }
   
     @Id 

    
    @Column(name="RACIONING_ID", unique=true, nullable=false)
    public int getRacioningId() {
        return this.racioningId;
    }
    
    public void setRacioningId(int racioningId) {
        this.racioningId = racioningId;
    }

    
    @Column(name="RACION_ID")
    public Integer getRacionId() {
        return this.racionId;
    }
    
    public void setRacionId(Integer racionId) {
        this.racionId = racionId;
    }

    
    @Column(name="INGREDIENTE_ID")
    public Integer getIngredienteId() {
        return this.ingredienteId;
    }
    
    public void setIngredienteId(Integer ingredienteId) {
        this.ingredienteId = ingredienteId;
    }

    
    @Column(name="RACIONING_KILOS_FRESCOS")
    public Integer getRacioningKilosFrescos() {
        return this.racioningKilosFrescos;
    }
    
    public void setRacioningKilosFrescos(Integer racioningKilosFrescos) {
        this.racioningKilosFrescos = racioningKilosFrescos;
    }

    
    @Column(name="RACIONING_COSTO_KG", precision=12, scale=0)
    public Float getRacioningCostoKg() {
        return this.racioningCostoKg;
    }
    
    public void setRacioningCostoKg(Float racioningCostoKg) {
        this.racioningCostoKg = racioningCostoKg;
    }

    
    @Column(name="RACIONING_PORC_MS", precision=12, scale=0)
    public Float getRacioningPorcMs() {
        return this.racioningPorcMs;
    }
    
    public void setRacioningPorcMs(Float racioningPorcMs) {
        this.racioningPorcMs = racioningPorcMs;
    }

    
    @Column(name="RACIONING_E_MENT_KG_MS", precision=12, scale=0)
    public Float getRacioningEMentKgMs() {
        return this.racioningEMentKgMs;
    }
    
    public void setRacioningEMentKgMs(Float racioningEMentKgMs) {
        this.racioningEMentKgMs = racioningEMentKgMs;
    }

    
    @Column(name="RACIONING_PROT_KG_MS", precision=12, scale=0)
    public Float getRacioningProtKgMs() {
        return this.racioningProtKgMs;
    }
    
    public void setRacioningProtKgMs(Float racioningProtKgMs) {
        this.racioningProtKgMs = racioningProtKgMs;
    }

    
    @Column(name="RACIONING_STATUS")
    public Integer getRacioningStatus() {
        return this.racioningStatus;
    }
    
    public void setRacioningStatus(Integer racioningStatus) {
        this.racioningStatus = racioningStatus;
    }




}


