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
            return animal;
        } 
        catch (Exception e) 
        {
            throw e;
        }
    }
}
