//v1.0.0
package cl.sgg.utils;

import cl.sgg.dao.AnimalDAO;
import cl.sgg.edm.Animal;

public class BusquedaDIIO 
{
    // Constructor publico por defecto
    public BusquedaDIIO()
    {

    }
    
    // Método público que busca un DIIO
    // ENTRADA: Se ingresa valor de DIIO a buscar
    // SALIDA: devuelve objeto animal cargado
    public Animal BuscarDIIO(int DIIO) throws Exception
    {
        try 
        {
            AnimalDAO adao = new AnimalDAO();
            Animal animal = adao.getAnimalByDiioActual(DIIO);
            if(animal != null)
            {
                if(animal.getAnimalEstadoActual()==1 || animal.getAnimalEstadoActual()==2 ||
                        animal.getAnimalEstadoActual()==3 || animal.getAnimalEstadoActual()==4)
                    return animal;
            }
            return null;
        } 
        catch (Exception e) 
        {
            throw e;
        }
    }
}
