package edm;
// Generated 11-feb-2016 0:18:43 by Hibernate Tools 4.3.1


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Proveedor generated by hbm2java
 */
@Entity
@Table(name="PROVEEDOR"
    ,catalog="CLARITYCOW"
)
public class Proveedor  implements java.io.Serializable {


     private int proveedorId;
     private String proveedorNombre;
     private String proveedorNrut;
     private String proveedorDrut;
     private Integer proveedorStatus;

    public Proveedor() {
    }

	
    public Proveedor(int proveedorId, String proveedorNombre, String proveedorNrut, String proveedorDrut) {
        this.proveedorId = proveedorId;
        this.proveedorNombre = proveedorNombre;
        this.proveedorNrut = proveedorNrut;
        this.proveedorDrut = proveedorDrut;
    }
    public Proveedor(int proveedorId, String proveedorNombre, String proveedorNrut, String proveedorDrut, Integer proveedorStatus) {
       this.proveedorId = proveedorId;
       this.proveedorNombre = proveedorNombre;
       this.proveedorNrut = proveedorNrut;
       this.proveedorDrut = proveedorDrut;
       this.proveedorStatus = proveedorStatus;
    }
   
     @Id 

    
    @Column(name="PROVEEDOR_ID", unique=true, nullable=false)
    public int getProveedorId() {
        return this.proveedorId;
    }
    
    public void setProveedorId(int proveedorId) {
        this.proveedorId = proveedorId;
    }

    
    @Column(name="PROVEEDOR_NOMBRE", nullable=false, length=50)
    public String getProveedorNombre() {
        return this.proveedorNombre;
    }
    
    public void setProveedorNombre(String proveedorNombre) {
        this.proveedorNombre = proveedorNombre;
    }

    
    @Column(name="PROVEEDOR_NRUT", nullable=false, length=25)
    public String getProveedorNrut() {
        return this.proveedorNrut;
    }
    
    public void setProveedorNrut(String proveedorNrut) {
        this.proveedorNrut = proveedorNrut;
    }

    
    @Column(name="PROVEEDOR_DRUT", nullable=false, length=1)
    public String getProveedorDrut() {
        return this.proveedorDrut;
    }
    
    public void setProveedorDrut(String proveedorDrut) {
        this.proveedorDrut = proveedorDrut;
    }

    
    @Column(name="PROVEEDOR_STATUS")
    public Integer getProveedorStatus() {
        return this.proveedorStatus;
    }
    
    public void setProveedorStatus(Integer proveedorStatus) {
        this.proveedorStatus = proveedorStatus;
    }




}


