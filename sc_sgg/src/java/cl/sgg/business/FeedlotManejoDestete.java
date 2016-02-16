//v1.0.0
package cl.sgg.business;

import cl.sgg.dao.*;
import cl.sgg.edm.*;
import cl.sgg.utils.BusquedaDIIO;
import cl.sgg.utils.Respuesta;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class FeedlotManejoDestete 
{
    private List<Animal> listAnimal;
    private List<GrillaInsumo> listGrillaInsumo;
    private List<InsumoTipo> listInsumoTipo;

    public List<InsumoTipo> getListInsumoTipo() {
        return listInsumoTipo;
    }

    public void setListInsumoTipo(List<InsumoTipo> listInsumoTipo) {
        this.listInsumoTipo = listInsumoTipo;
    }
    
    public List<Animal> getListAnimal() {
        return listAnimal;
    }

    public void setListAnimal(List<Animal> listAnimal) {
        this.listAnimal = listAnimal;
    }

    public List<GrillaInsumo> getListGrillaInsumo() {
        return listGrillaInsumo;
    }

    public void setListGrillaInsumo(List<GrillaInsumo> listGrillaInsumo) {
        this.listGrillaInsumo = listGrillaInsumo;
    }
    
    // Constructor público por defecto
    public FeedlotManejoDestete ()
    {
        this.listAnimal = new ArrayList<Animal>();
        this.listGrillaInsumo = new ArrayList<GrillaInsumo>();
        this.listInsumoTipo = new ArrayList<InsumoTipo>();
    }
    
    // Método público que invoca la carga de DIIO a manejar
    // ENTRADA: Se ingresa valor de DIIO a trasladar
    // SALIDA: carga en el atributo de la clase "List<Animal> listAnimal" con el resultado
    public Respuesta CargarDIIOAManejar(int DIIO) throws Exception
    {
        try 
        {
            Respuesta r = new Respuesta();
            BusquedaDIIO buscaDiio = new BusquedaDIIO();
            Animal animal = buscaDiio.BuscarDIIO(DIIO);
            if(animal.getAnimalId() != 0)
            {
                listAnimal.add(animal);
                r.setStatus(true);
                r.setMensaje("DIIO agregado a grilla");
            }
            else
            {
                r.setStatus(false);
                r.setMensaje("DIIO no encontrado");
            }
            return r;
        }
        catch (Exception e) 
        {
            throw e;
        }
    }
    
    // Método público carga lista de tipo Insumo en atributo de la clase
    // ENTRADA: Sin entrada
    // SALIDA: carga en el atributo de la clase "List<InsumoTipo> listInsumoTipo" con el resultado
    public Respuesta CargarTipoInsumo() throws Exception
    {
        Respuesta r = new Respuesta();
        try 
        {
            InsumoTipoDAO itdao = new InsumoTipoDAO();
            this.listInsumoTipo = itdao.getList();
            if(this.listInsumoTipo.size()>0)
            {
                r.setMensaje("Lista Tipo insumo cargada");
                r.setStatus(true);
            }
            else
            {
                r.setMensaje("Lista Tipo insumo no cargada");
                r.setStatus(false);
            }
            return r;
        } 
        catch (Exception e) 
        {
            throw e;
        }
    }
    
    public Respuesta GuardarForm(Date fechaManejo) throws Exception
    {
        try 
        {  
            Respuesta r = new Respuesta();
            for (Animal arg : listAnimal)
            {
                Date d = new Date();
                Evento ev = new Evento();
                ev.setAnimalId(arg.getAnimalId());
                ev.setCategoriaId(arg.getAnimalCategoriaActual());
                ev.setEstadoanimalId(arg.getAnimalEstadoActual());
                ev.setEventoDs("Manejo destete");
                ev.setEventoFechaEvento(d);
                ev.setEventoFechaReg(fechaManejo);
                ev.setEventoValor(null);
                ev.setEventotipoId(17); //Tipo evento "Feedlot Destete"

                EventoDAO edao = new EventoDAO();
                
                if (edao.add(ev)) //agrega evento a la db
                {
                    
                   
                }
                else
                {
                    r.setStatus(false);
                    r.setMensaje("Error en el guardado");
                    return r;
                }
            }
            return r;
        } 
        catch (Exception e) 
        {
            throw e;
        }
    }
}