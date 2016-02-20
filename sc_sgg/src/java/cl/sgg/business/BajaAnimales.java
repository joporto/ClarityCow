//v1.0.3
package cl.sgg.business;

import java.util.Date;
import java.util.List;
import cl.sgg.utils.*;
import cl.sgg.edm.*;
import cl.sgg.dao.*;

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
    private Animal animal;

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
 
    // Constructor publico por defecto
    public BajaAnimales()
    {
    }
    
    // Método público que carga lista desplegable de motivo aparente 
    // ENTRADA: Se ingresan valores de motivo ("Muerto", "Robo")
    // SALIDA: carga en el atributo de la clase "List<String> listaCb" el resultado
    public  Respuesta CargarCbMotivoAparente(String motivo) throws Exception
    {
        try 
        {
            List<String> list = null;
            Respuesta r = new Respuesta();
            if ("Muerto".equals(motivo))
            {
                EstadoAnimalDAO eDao = new EstadoAnimalDAO();
                for (EstadoAnimal arg : eDao.getListByTipoEstado(2)) //Tipo estado Muerto
                {   
                    list.add(arg.getEstadoanimalDs());
                }
                listaCb = list;
                r.setStatus(true);
                r.setMensaje("OK");
            }
            else if ("Robado".equals(motivo))
            {
                EstadoAnimalDAO eDao = new EstadoAnimalDAO();
                for (EstadoAnimal arg : eDao.getListByTipoEstado(4)) //Tipo estado Robado
                {   
                    list.add(arg.getEstadoanimalDs());
                }
                listaCb = list;
                r.setStatus(true);
                r.setMensaje("OK");
            }
            else
            {
                r.setStatus(false);
                r.setMensaje("Error de sistema");
            }
            return r;
        } 
        catch (Exception e) 
        {
            throw e;
        }
    }
    
    // Método público que busca DIIO ingresado (búsqueda exacta)
    // ENTRADA: Se ingresa valor de DIIO a consultar
    // SALIDA: carga en el atributo de la clase "int DIIO" el DIIO confirmado como correcto
    // SALIDA: carga en el atributo de la calse "Animal animal" todos los datos asociados al DIIO encontrado
    public Respuesta BuscarDIIO(int DIIO) throws Exception
    {
        try 
        {
            Respuesta r = new Respuesta();
            BusquedaDIIO buscaDiio = new BusquedaDIIO();
            
            animal = buscaDiio.BuscarDIIO(DIIO);
            if(animal != null)
            {
                this.DIIO = DIIO;
                CambioEstado("Muerto");
                r.setMensaje("DIIO Encontrado");
                r.setStatus(true);
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
    
    // Método público que guarda los cambios ingresado en el formulario
    // ENTRADA: Se ingresa fecha de baja animal
    // ENTRADA: Se ingrsa motivo ("Muerto", "Robo")
    // ENTRADA: Se ingresa valor de lista desplegable motivoAparente
    // SALIDA: Se agrega registro de "evento" a base de datos
    // SALIDA: Se actualiza estado en "animal" en base de datos
    public Respuesta GuardarBajaAnimales(Date fechaBaja, String motivo, String motivoAparente) throws Exception
    {
        try 
        {  
            int estadoAnimalId;
            cl.sgg.dao.EstadoAnimalDAO ea = new EstadoAnimalDAO();
            estadoAnimalId = ea.getEstadoAnimalByNombre(motivoAparente).getEstadoanimalId();
            Respuesta r = new Respuesta();
            if (estadoAnimalId == 0)
            {
                r.setStatus(false);
                r.setMensaje("Error en el guardado, estado animal no encontrado");
                return r;
            }
            
            Date d = new Date();
            Evento ev = new Evento();
            ev.setAnimalId(animal.getAnimalId());
            ev.setCategoriaId(animal.getAnimalCategoriaActual());
            ev.setEstadoanimalId(estadoAnimalId);
            ev.setEventoDs(motivo);
            ev.setEventoFechaEvento(d);
            ev.setEventoFechaReg(fechaBaja);
            ev.setEventoValor(0f);
            ev.setEventotipoId(7); //Tipo evento "baja no productiva"

            EventoDAO edao = new EventoDAO();
            int idEvento = edao.add(ev); //agrega evento a la db
            if (idEvento != 0) 
            {
                AnimalDAO adao = new AnimalDAO();
                animal.setAnimalEstadoActual(estadoAnimalId);
                if(adao.update(animal))
                {
                    r.setStatus(true);
                    r.setMensaje("Registro animal actualizado y evento creado");
                }
                else
                {
                    ev.setEventoId(idEvento);
                    edao.delete(ev);
                    r.setStatus(false);
                    r.setMensaje("Error en update animal");
                }
            }
            else
            {
                r.setStatus(false);
                r.setMensaje("Error en el guardado de evento");
            }
            return r;
        } 
        catch (Exception e) 
        {
            throw e;
        }
    }
    
    // Método público que actualiza el cambio estado animal a mostrar en pantalla
    // ENTRADA: Se ingresa motivo ("Muerto", "Robo")
    // SALIDA: carga en el atributo de la clase "String cambioEstado" el cambio de estado una vez se guarde el registro
    public Respuesta CambioEstado(String motivo) throws Exception
    {
        try 
        {
            Respuesta r = new Respuesta();
            EstadoAnimalDAO edao = new EstadoAnimalDAO();
            AnimalDAO rdao = new AnimalDAO();
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
            r.setMensaje("OK");
            r.setStatus(true);
            return r;
        } 
        catch (Exception e) 
        {
            throw e;
        }
    }
}