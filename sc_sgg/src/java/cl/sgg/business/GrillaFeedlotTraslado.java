//v1.0.2
package cl.sgg.business;

// <editor-fold defaultstate="collapsed" desc="Imports">
import cl.sgg.edm.Animal;
//</editor-fold>

public class GrillaFeedlotTraslado 
{
    // <editor-fold defaultstate="collapsed" desc="Atributos">
    private Animal animal;
    private float peso;
    private String status;
    //</editor-fold>

    // <editor-fold defaultstate="collapsed" desc="GET & SET">
    public Animal getAnimal() {
        return animal;
    }

    public void setAnimal(Animal animal) {
        this.animal = animal;
    }
    
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
        public float getPeso() {
        return peso;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }
    //</editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Constructores">
    public GrillaFeedlotTraslado() 
    {
        this.animal = new Animal();
        this.peso = 0;
        this.status = "";
    }
    //</editor-fold>
}