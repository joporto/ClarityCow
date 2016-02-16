//v1.0.0
package cl.sgg.business;

import cl.sgg.edm.Animal;

class GrillaFeedlotTraslado 
{
    private Animal animal;
    private float peso;
    private String status;

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

    public GrillaFeedlotTraslado() 
    {
        this.animal = new Animal();
        this.peso = 0;
        this.status = "";
    }
}