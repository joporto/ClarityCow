package business;

import java.util.Date;
import java.util.List;
import cl.sgg.utils.Respuesta;
import cl.sgg.edm.*;
import cl.sgg.dao.*;

public class Feedlot
{
    List<Animal> listAnimal;

    public List<Animal> getListAnimal() {
        return listAnimal;
    }

    public void setListAnimal(List<Animal> listAnimal) {
        this.listAnimal = listAnimal;
    }
    
    
    public Feedlot ()
    {
        
    }
    
    public Respuesta CargarGrilla() throws Exception
    {
        try 
        {
            AnimalDAO adao = new AnimalDAO();
            listAnimal = adao.getList();
        } 
        catch (Exception e) 
        {
            throw e;
        }
        return null;
    }
    
}