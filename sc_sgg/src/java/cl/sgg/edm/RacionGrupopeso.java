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
 * RacionGrupopeso generated by hbm2java
 */
@Entity
@Table(name="RACION_GRUPOPESO"
    ,catalog="CLARITYCOW"
)
public class RacionGrupopeso  implements java.io.Serializable {


     private int raciongrupopesoId;
     private Integer grupopesoId;
     private Integer racionId;
     private Date raciongrupopesoFecha;

    public RacionGrupopeso() {
    }

	
    public RacionGrupopeso(int raciongrupopesoId) {
        this.raciongrupopesoId = raciongrupopesoId;
    }
    public RacionGrupopeso(int raciongrupopesoId, Integer grupopesoId, Integer racionId, Date raciongrupopesoFecha) {
       this.raciongrupopesoId = raciongrupopesoId;
       this.grupopesoId = grupopesoId;
       this.racionId = racionId;
       this.raciongrupopesoFecha = raciongrupopesoFecha;
    }
   
     @Id 

    
    @Column(name="RACIONGRUPOPESO_ID", unique=true, nullable=false)
    public int getRaciongrupopesoId() {
        return this.raciongrupopesoId;
    }
    
    public void setRaciongrupopesoId(int raciongrupopesoId) {
        this.raciongrupopesoId = raciongrupopesoId;
    }

    
    @Column(name="GRUPOPESO_ID")
    public Integer getGrupopesoId() {
        return this.grupopesoId;
    }
    
    public void setGrupopesoId(Integer grupopesoId) {
        this.grupopesoId = grupopesoId;
    }

    
    @Column(name="RACION_ID")
    public Integer getRacionId() {
        return this.racionId;
    }
    
    public void setRacionId(Integer racionId) {
        this.racionId = racionId;
    }

    @Temporal(TemporalType.DATE)
    @Column(name="RACIONGRUPOPESO_FECHA", length=10)
    public Date getRaciongrupopesoFecha() {
        return this.raciongrupopesoFecha;
    }
    
    public void setRaciongrupopesoFecha(Date raciongrupopesoFecha) {
        this.raciongrupopesoFecha = raciongrupopesoFecha;
    }




}


