package cl.sgg.edm;
// Generated 11-feb-2016 0:18:43 by Hibernate Tools 4.3.1


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * EventoInsumo generated by hbm2java
 */
@Entity
@Table(name="EVENTO_INSUMO"
    ,catalog="CLARITYCOW"
)
public class EventoInsumo  implements java.io.Serializable {


     private int manejoinsumoId;
     private Integer insumoId;
     private Integer eventoId;

    public EventoInsumo() {
    }

	
    public EventoInsumo(int manejoinsumoId) {
        this.manejoinsumoId = manejoinsumoId;
    }
    public EventoInsumo(int manejoinsumoId, Integer insumoId, Integer eventoId) {
       this.manejoinsumoId = manejoinsumoId;
       this.insumoId = insumoId;
       this.eventoId = eventoId;
    }
   
     @Id 

    
    @Column(name="MANEJOINSUMO_ID", unique=true, nullable=false)
    public int getManejoinsumoId() {
        return this.manejoinsumoId;
    }
    
    public void setManejoinsumoId(int manejoinsumoId) {
        this.manejoinsumoId = manejoinsumoId;
    }

    
    @Column(name="INSUMO_ID")
    public Integer getInsumoId() {
        return this.insumoId;
    }
    
    public void setInsumoId(Integer insumoId) {
        this.insumoId = insumoId;
    }

    
    @Column(name="EVENTO_ID")
    public Integer getEventoId() {
        return this.eventoId;
    }
    
    public void setEventoId(Integer eventoId) {
        this.eventoId = eventoId;
    }




}


