package business;

import java.util.Date;
import java.util.List;
import utils.Respuesta;
import edm.Animal;

public class Feedlot
{
    List<edm.Animal> listAnimal;

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
            dao.AnimalDAO adao = new dao.AnimalDAO();
            listAnimal = adao.getList();
        } 
        catch (Exception e) 
        {
            throw e;
        }
        return null;
    }
    
}