package edm;
// Generated 11-feb-2016 0:18:43 by Hibernate Tools 4.3.1


import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * GrupopesoCorral generated by hbm2java
 */
@Entity
@Table(name="GRUPOPESO_CORRAL"
    ,catalog="CLARITYCOW"
)
public class GrupopesoCorral  implements java.io.Serializable {


     private int corralgrupopesoId;
     private Integer corralId;
     private Integer grupopesoId;
     private Date corralgrupopesoFecha;

    public GrupopesoCorral() {
    }

	
    public GrupopesoCorral(int corralgrupopesoId, Date corralgrupopesoFecha) {
        this.corralgrupopesoId = corralgrupopesoId;
        this.corralgrupopesoFecha = corralgrupopesoFecha;
    }
    public GrupopesoCorral(int corralgrupopesoId, Integer corralId, Integer grupopesoId, Date corralgrupopesoFecha) {
       this.corralgrupopesoId = corralgrupopesoId;
       this.corralId = corralId;
       this.grupopesoId = grupopesoId;
       this.corralgrupopesoFecha = corralgrupopesoFecha;
    }
   
     @Id 

    
    @Column(name="CORRALGRUPOPESO_ID", unique=true, nullable=false)
    public int getCorralgrupopesoId() {
        return this.corralgrupopesoId;
    }
    
    public void setCorralgrupopesoId(int corralgrupopesoId) {
        this.corralgrupopesoId = corralgrupopesoId;
    }

    
    @Column(name="CORRAL_ID")
    public Integer getCorralId() {
        return this.corralId;
    }
    
    public void setCorralId(Integer corralId) {
        this.corralId = corralId;
    }

    
    @Column(name="GRUPOPESO_ID")
    public Integer getGrupopesoId() {
        return this.grupopesoId;
    }
    
    public void setGrupopesoId(Integer grupopesoId) {
        this.grupopesoId = grupopesoId;
    }

    @Temporal(TemporalType.DATE)
    @Column(name="CORRALGRUPOPESO_FECHA", nullable=false, length=10)
    public Date getCorralgrupopesoFecha() {
        return this.corralgrupopesoFecha;
    }
    
    public void setCorralgrupopesoFecha(Date corralgrupopesoFecha) {
        this.corralgrupopesoFecha = corralgrupopesoFecha;
    }




}


