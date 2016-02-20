//v1.0.5
package cl.sgg.business;

import cl.sgg.dal.Conexion;
import cl.sgg.dao.*;
import cl.sgg.edm.*;
import cl.sgg.utils.BusquedaDIIO;
import cl.sgg.utils.Respuesta;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class FeedlotManejoDestete 
{
    private List<Animal> listAnimal;
    private List<GrillaInsumo> listGrillaInsumo;
    private List<InsumoTipo> listInsumoTipo;
    private List<Insumo> listInsumo;

    public List<Insumo> getListInsumo() {
        return listInsumo;
    }

    public void setListInsumo(List<Insumo> listInsumo) {
        this.listInsumo = listInsumo;
    }
    
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
        this.listInsumo = new ArrayList<Insumo>();
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
            if(animal != null)
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
            Statement stmt = Conexion.get().createStatement();
            String query = "SELECT INSUMOTIPO_ID, INSUMOTIPO_DS, INSUMOTIPO_STATUS " +
                "FROM INSUMO_TIPO WHERE INSUMOTIPO_ID <> 4 AND INSUMOTIPO_STATUS = 1";
            ResultSet rs = stmt.executeQuery(query);
     
            this.listInsumoTipo = new ArrayList<InsumoTipo>();
            while (rs.next()) 
            {
                InsumoTipo it = new InsumoTipo();
                it.setInsumotipoDs(rs.getString("INSUMOTIPO_DS"));
                it.setInsumotipoId(rs.getInt("INSUMOTIPO_ID"));
                it.setInsumotipoStatus(rs.getInt("INSUMOTIPO_STATUS"));
                this.listInsumoTipo.add(it);
            }
            
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
    
    // Método público carga lista de Insumo en atributo de la clase
    // ENTRADA: Sin entrada
    // SALIDA: carga en el atributo de la clase "List<Insumoo> listInsumo" con el resultado
    public Respuesta CargarInsumo() throws Exception
    {
        Respuesta r = new Respuesta();
        try 
        {
            Statement stmt = Conexion.get().createStatement();
            String query = "SELECT INSUMO_ID, TIPOINSUMO_ID, INSUMO_CODIGO_SAP, INSUMO_NOMBRE, INSUMO_DS, "
                    + "INSUMO_UNIDAD_MEDIDA, INSUMO_STATUS, INSUMO_CANTIDAD "
                    + "FROM INSUMO WHERE TIPOINSUMO_ID <> 4 AND INSUMO_STATUS = 1";
            ResultSet rs = stmt.executeQuery(query);
     
            this.listInsumo = new ArrayList<Insumo>();
            while (rs.next()) 
            {
                Insumo i = new Insumo();
                i.setInsumoCantidad(rs.getInt("INSUMO_CANTIDAD"));
                i.setInsumoCodigoSap(rs.getInt("INSUMO_CODIGO_SAP"));
                i.setInsumoId(rs.getInt("INSUMO_ID"));
                i.setInsumoNombre(rs.getString("INSUMO_NOMBRE"));
                i.setInsumoStatus(rs.getInt("INSUMO_STATUS"));
                i.setInsumoUnidadMedida(rs.getString("INSUMO_UNIDAD_MEDIDA"));
                i.setTipoinsumoId(rs.getInt("TIPOINSUMO_ID"));
                this.listInsumo.add(i);
            }
            
            if(this.listInsumo.size()>0)
            {
                r.setMensaje("Lista Insumo cargada");
                r.setStatus(true);
            }
            else
            {
                r.setMensaje("Lista Insumo no cargada");
                r.setStatus(false);
            }
            return r;
        } 
        catch (Exception e) 
        {
            throw e;
        }
    }
    
    // Método público guarda registro en grilla Insumo
    // ENTRADA: Sin entrada
    // SALIDA: carga en el atributo de la clase "List<Insumoo> listInsumo" con el resultado
    public Respuesta GuardarInsumoGrilla() throws Exception
    {
        try 
        {
            Respuesta r = new Respuesta();
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
            r.setMensaje("Se debe agregar un DIIO");
            r.setStatus(false);
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
                ev.setEventoValor(0f);
                ev.setEventotipoId(17); //Tipo evento "Feedlot Destete"

                EventoDAO edao = new EventoDAO();
                int idEvento = edao.add(ev); //agrega evento a la db
                if (idEvento != 0) 
                {
                    int contadorAdd = 0;
                    for(Insumo arg1: listInsumo)
                    {
                        EventoInsumo ei = new EventoInsumo();
                        ei.setEventoId(idEvento);
                        ei.setInsumoId(arg1.getInsumoId());
                        EventoInsumoDAO eidao = new EventoInsumoDAO();
                        int idEventoInsumo = eidao.add(ei);
                        if(idEventoInsumo != 0)
                        {
                            contadorAdd++;
                        }
                        else
                        {
                            r.setStatus(false);
                            r.setMensaje("Error al registrar Evento_Insumo");
                            return r;
                        }
                    }
                    r.setMensaje("Se agrega registro de evento y "+contadorAdd+" Eventos_insumo");
                    r.setStatus(true);
                }
                else
                {
                    r.setStatus(false);
                    r.setMensaje("Error en el guardado de evento");
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