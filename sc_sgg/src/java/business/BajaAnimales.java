package business;

import java.util.Date;
import java.util.List;
import utils.Respuesta;
import edm.Animal;

public class BajaAnimales
{
    private int DIIO;
    private Date fechaBaja;
    private Date fechaRegistro;
    private String cambioEstado;
    private String causa;
    private String MotivoAparente;
    private List<String> listaCb;
    private int idAnimal;
    private edm.Animal animal;

    public Animal getAnimal() {
        return animal;
    }

    public void setAnimal(Animal animal) {
        this.animal = animal;
    }
    
    public int getDIIO() {
        return DIIO;
    }

    public void setDIIO(int DIIO) {
        this.DIIO = DIIO;
    }

    public Date getFechaBaja() {
        return fechaBaja;
    }

    public void setFechaBaja(Date fechaBaja) {
        this.fechaBaja = fechaBaja;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public String getCambioEstado() {
        return cambioEstado;
    }

    public void setCambioEstado(String cambioEstado) {
        this.cambioEstado = cambioEstado;
    }

    public String getCausa() {
        return causa;
    }

    public void setCausa(String causa) {
        this.causa = causa;
    }

    public String getMotivoAparente() {
        return MotivoAparente;
    }

    public void setMotivoAparente(String MotivoAparente) {
        this.MotivoAparente = MotivoAparente;
    }
    
    public List<String> getListaCb() {
        return listaCb;
    }

    public void setListaCb(List<String> listaCb) {
        this.listaCb = listaCb;
    }
    
    public int getIdAnimal() {
        return idAnimal;
    }

    public void setIdAnimal(int idAnimal) {
        this.idAnimal = idAnimal;
    }
 
    public BajaAnimales()
    {
    }
    
    public Respuesta CargarCbMotivoAparente(String motivo) throws Exception
    {
        try 
        {
            List<String> list = null;
            Respuesta r = new Respuesta();
            if ("Muerto".equals(motivo))
            {
                dao.EstadoAnimalDAO eDao = new dao.EstadoAnimalDAO();
                for (edm.EstadoAnimal arg : eDao.getListByTipoEstado(2)) //Tipo estado Muerto
                {   
                    list.add(arg.getEstadoanimalDs());
                }
                r.setStatus(true);
                r.setMensaje("OK");
                return r;
            }
            else if ("Robado".equals(motivo))
            {
                dao.EstadoAnimalDAO eDao = new dao.EstadoAnimalDAO();
                for (edm.EstadoAnimal arg : eDao.getListByTipoEstado(4)) //Tipo estado Robado
                {   
                    list.add(arg.getEstadoanimalDs());
                }
                r.setStatus(true);
                r.setMensaje("OK");
                return r;
            }
            else
            {
                r.setStatus(false);
                r.setMensaje("Error de sistema");
                return r;
            }
        } 
        catch (Exception e) 
        {
            throw e;
        }
    }
    
    public Respuesta BuscarDIIO(int DIIO) throws Exception
    {
        try 
        {
            Respuesta r = new Respuesta();
            dao.AnimalDAO adao = new dao.AnimalDAO();
            animal = adao.getAnimalByDiioActual(DIIO);
            if(animal != null)
            {
                this.DIIO = DIIO;
                CambioEstado("Muerto");
                r.setStatus(true);
                r.setMensaje("OK");
                return r;
            }
            else
            {
                r.setStatus(false);
                r.setMensaje("DIIO no encontrado");
                return r;
            }
        } 
        catch (Exception e) 
        {
            throw e;
        }
    }
    
    public Respuesta GuardarBajaAnimales(int estadoAnimal, Date fechaBaja, int DIIO, String motivo) throws Exception
    {
        try 
        {
            Respuesta r = new Respuesta();
            Date d = new Date();
            edm.Evento ev = new edm.Evento();
            ev.setAnimalId(animal.getAnimalId());
            ev.setCategoriaId(animal.getAnimalCategoriaActual());
            ev.setEstadoanimalId(estadoAnimal);
            ev.setEventoDs("");
            ev.setEventoFechaEvento(d);
            ev.setEventoFechaReg(fechaBaja);
            ev.setEventoValor(null);
            ev.setEventotipoId(7); //Tipo evento "baja no productiva"


            dao.EventoDAO edao = new dao.EventoDAO();
            if (edao.add(ev)) //agrega evento a la db
            {
                dao.AnimalDAO adao = new dao.AnimalDAO();
                animal.setAnimalEstadoActual(estadoAnimal);
                if(adao.update(animal))
                {
                   r.setStatus(true);
                    r.setMensaje("Registro actualizado");
                    return r; 
                }
                else
                {
                    r.setStatus(false);
                    r.setMensaje("Error en el guardado");
                    return r;
                }
            }
            else
            {
                r.setStatus(false);
                r.setMensaje("Error en el guardado");
                return r;
            }
        } 
        catch (Exception e) 
        {
            throw e;
        }
    }
    
    public void CambioEstado(String motivo) throws Exception
    {
        try 
        {
            dao.EstadoAnimalDAO edao = new dao.EstadoAnimalDAO();
            dao.AnimalDAO rdao = new dao.AnimalDAO();
            if ("Muerto".equals(motivo))
            {
                this.cambioEstado =  edao.getEstadoAnimalById(
            rdao.getAnimalByDiioActual(DIIO).
                    getAnimalEstadoActual()).getEstadoanimalDs()
                    + " --> Muerto";
            }
            else if ("Robado".equals(motivo))
            {
                this.cambioEstado =  edao.getEstadoAnimalById(
            rdao.getAnimalByDiioActual(DIIO).
                    getAnimalEstadoActual()).getEstadoanimalDs()
                    + " --> Robado";
            }
        } 
        catch (Exception e) 
        {
            throw e;
        }
    }
}