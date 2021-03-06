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
 * CategoriaValorFeria generated by hbm2java
 */
@Entity
@Table(name="CATEGORIA_VALOR_FERIA"
    ,catalog="CLARITYCOW"
)
public class CategoriaValorFeria  implements java.io.Serializable {


     private int categoriavalorId;
     private int categoriavalorValor;
     private Date categoriavalorFecha;
     private Integer categoriavalorStatus;

    public CategoriaValorFeria() {
    }

	
    public CategoriaValorFeria(int categoriavalorId, int categoriavalorValor, Date categoriavalorFecha) {
        this.categoriavalorId = categoriavalorId;
        this.categoriavalorValor = categoriavalorValor;
        this.categoriavalorFecha = categoriavalorFecha;
    }
    public CategoriaValorFeria(int categoriavalorId, int categoriavalorValor, Date categoriavalorFecha, Integer categoriavalorStatus) {
       this.categoriavalorId = categoriavalorId;
       this.categoriavalorValor = categoriavalorValor;
       this.categoriavalorFecha = categoriavalorFecha;
       this.categoriavalorStatus = categoriavalorStatus;
    }
   
     @Id 

    
    @Column(name="CATEGORIAVALOR_ID", unique=true, nullable=false)
    public int getCategoriavalorId() {
        return this.categoriavalorId;
    }
    
    public void setCategoriavalorId(int categoriavalorId) {
        this.categoriavalorId = categoriavalorId;
    }

    
    @Column(name="CATEGORIAVALOR_VALOR", nullable=false)
    public int getCategoriavalorValor() {
        return this.categoriavalorValor;
    }
    
    public void setCategoriavalorValor(int categoriavalorValor) {
        this.categoriavalorValor = categoriavalorValor;
    }

    @Temporal(TemporalType.DATE)
    @Column(name="CATEGORIAVALOR_FECHA", nullable=false, length=10)
    public Date getCategoriavalorFecha() {
        return this.categoriavalorFecha;
    }
    
    public void setCategoriavalorFecha(Date categoriavalorFecha) {
        this.categoriavalorFecha = categoriavalorFecha;
    }

    
    @Column(name="CATEGORIAVALOR_STATUS")
    public Integer getCategoriavalorStatus() {
        return this.categoriavalorStatus;
    }
    
    public void setCategoriavalorStatus(Integer categoriavalorStatus) {
        this.categoriavalorStatus = categoriavalorStatus;
    }




}


