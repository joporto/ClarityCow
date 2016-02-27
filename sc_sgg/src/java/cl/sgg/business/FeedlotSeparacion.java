//v1.1.2
package cl.sgg.business;

// <editor-fold defaultstate="collapsed" desc="Imports">
import cl.sgg.dal.Conexion;
import cl.sgg.dao.*;
import cl.sgg.edm.*;
import cl.sgg.utils.Respuesta;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
//</editor-fold>

public class FeedlotSeparacion 
{
    //// <editor-fold defaultstate="collapsed" desc="Atributos">
    private Establecimiento rup;
    private List<GrillaSeparacion> listSeparacion;
    private List<String> listCorral;
    private List<String> listGrupoPeso;
    //</editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="GET & SET">
    public List<String> getListCorral() {
        return listCorral;
    }

    public void setListCorral(List<String> listCorral) {
        this.listCorral = listCorral;
    }

    public List<String> getListGrupoPeso() {
        return listGrupoPeso;
    }

    public void setListGrupoPeso(List<String> listGrupoPeso) {
        this.listGrupoPeso = listGrupoPeso;
    }
    
    public Establecimiento getRup() {
        return rup;
    }

    public void setRup(Establecimiento rup) {
        this.rup = rup;
    }
    
    public List<GrillaSeparacion> getListSeparacion() {
        return listSeparacion;
    }

    public void setListSeparacion(List<GrillaSeparacion> listSeparacion) {
        this.listSeparacion = listSeparacion;
    }
    //</editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Constructores">
    //Constructor por defecto
    public FeedlotSeparacion()
    {
        this.rup = new Establecimiento();
        this.listCorral = new ArrayList<String>();
        this.listGrupoPeso = new ArrayList<String>();
        this.listSeparacion = new ArrayList<GrillaSeparacion>();
    }
    //</editor-fold>
    
    // Método público que realiza la busqueda de RUP ingresado (búsqueda exacta)
    // ENTRADA: Opcional, Se ingresa valor de codigo RUP a consultar, si no va = ""
    // ENTRADA: Opcional, Se ingresa valor de nombre RUP a consultar, si no va = ""
    // SALIDA: carga en el atributo de la clase "Establecimiento rup" con el resultado
    public Respuesta BuscarRUP(int rup, String nomRup) throws Exception
    // <editor-fold defaultstate="collapsed" desc="Código">
    {
        try 
        {
            Respuesta r = new Respuesta();
            EstablecimientoDAO edao = new EstablecimientoDAO();
            Establecimiento e = new Establecimiento();
            if (!"".equals(rup))
            {
                e = edao.getEstablecimientoByRup(rup);
            }
            else if (!"".equals(nomRup))
            {
                e = edao.getEstablecimientoByNombre(nomRup);
            }
            if (e != null && e.getRupId() != 0) //encontró RUP?
            {
                if (e.getRupStatus() == 0) //RUP desactivado
                {
                    r.setMensaje("RUP desactivado");
                    r.setStatus(false);
                    return r;
                }
                else
                {
                    this.rup = e;
                    r.setStatus(true);
                    r.setMensaje("RUP encontrado");
                }
            }
            else
            {
                r.setStatus(false);
                r.setMensaje("RUP no encontrado");
            }
            return r;
        } 
        catch (Exception e) 
        {
            throw e;
        }
    }
    //</editor-fold>

    // Método público que carga la grilla de corrales-grupos peso
    // ENTRADA: Sin entrada
    // SALIDA: carga en el atributo de la clase "List<GrillaSeparacion> listSeparacion" con el resultado
    public Respuesta BuscarGrilla() throws Exception
    // <editor-fold defaultstate="collapsed" desc="Código">
    {
        try 
        {
            Respuesta r = new Respuesta();
            r.setMensaje("error al ejecutar la consulta");
            r.setStatus(false);
            Statement stmt = Conexion.get().createStatement();
            String query = "SELECT gp.GRUPOPESO_ID, gp.GRUPOPESO_DS, c.CORRAL_ID, c.CORRAL_DS, gpc.CORRALGRUPOPESO_ID "
                + "FROM GRUPO_PESO gp "
                + "join GRUPOPESO_CORRAL gpc on gpc.GRUPOPESO_ID = gp.GRUPOPESO_ID "
                + "join CORRAL c on c.CORRAL_ID = gpc.CORRAL_ID "
                + "where c.CORRAL_STATUS = 1 and gp.GRUPOPESO_STATUS = 1 and c.RUP_ID = "+this.rup.getRupId();
            ResultSet rs = stmt.executeQuery(query);
            
            while (rs.next()) 
            {
                GrillaSeparacion gs = new GrillaSeparacion();
                gs.setCorral(rs.getString("CORRAL_DS"));
                gs.setIdCorral(rs.getInt("CORRAL_ID"));
                gs.setGrupoPeso(rs.getString("GRUPOPESO_DS"));
                gs.setIdGrupoPeso(rs.getInt("GRUPOPESO_ID"));
                this.listSeparacion.add(gs);
            }
            return r;
        } 
        catch (Exception e) 
        {
            throw e;
        }
        finally
        {
            if(!Conexion.get().isClosed())
                Conexion.get().close();
        }
    }
    //</editor-fold>
    
    // Método público carga listado de Corrales según RUP buscado
    // ENTRADA: Sin entrada
    // SALIDA: carga en el atributo de la clase "List<String> listCorral" con el resultado
    public Respuesta CargaCbCorral() throws Exception
    // <editor-fold defaultstate="collapsed" desc="Código">
    {
        try 
        {
            Respuesta r = new Respuesta();
            r.setMensaje("error al ejecutar la consulta");
            r.setStatus(false);
            Statement stmt = Conexion.get().createStatement();
            String query = "select CORRAL_DS, CORRAL_ID "
                + "from CORRAL "
                + "where CORRAL_STATUS = 1 and RUP_ID =" + this.rup.getRupId();
            ResultSet rs = stmt.executeQuery(query);
            
            while (rs.next()) 
            {
                this.listCorral.add(rs.getString("CORRAL_DS"));
            }
            r.setMensaje("Listado cargado");
            r.setStatus(true);
            return r;
        } 
        catch (Exception e) 
        {
            throw e;
        }
        finally
        {
            if(!Conexion.get().isClosed())
                Conexion.get().close();
        }
    }
    //</editor-fold>
    
    // Método público carga listado de GrupoPeso según Corral buscado
    // ENTRADA: Sin entrada
    // SALIDA: carga en el atributo de la clase "List<String> listGrupoPeso" con el resultado
    public Respuesta CargaCbGrupoPeso(String Corral_DS) throws Exception
    // <editor-fold defaultstate="collapsed" desc="Código">
    {
        try 
        {
            Respuesta r = new Respuesta();
            r.setMensaje("error al ejecutar la consulta");
            r.setStatus(false);
            Statement stmt = Conexion.get().createStatement();
            String query = "select gp.GRUPOPESO_DS "
                + "from GRUPOPESO_CORRAL gpc "
                + "join GRUPO_PESO gp on gp.GRUPOPESO_ID = gpc.GRUPOPESO_ID "
                + "where gp.GRUPOPESO_STATUS = 1 and gpc.CORRAL_ID = " + Corral_DS;
            ResultSet rs = stmt.executeQuery(query);
            
            while (rs.next()) 
            {
                this.listGrupoPeso.add(rs.getString("GRUPOPESO_DS"));
            }
            r.setMensaje("Listado cargado");
            r.setStatus(true);
            return r;
        } 
        catch (Exception e) 
        {
            throw e;
        }
        finally
        {
            if(!Conexion.get().isClosed())
                Conexion.get().close();
        }
    }
    //</editor-fold>
    
    // Método público guarda nuevo registro ingresado en la grilla
    // ENTRADA: descripción del corral a ingresar
    // ENTRADA: descripción del Grupo Peso a ingresar
    // SALIDA: guarda registro en tabla GrupopesoCorral
    public Respuesta AgregarGrillaSeparacion(String corral_DS, String grupoPeso_DS) throws Exception
    // <editor-fold defaultstate="collapsed" desc="Código">
    {
        try 
        {
           Respuesta r = new Respuesta();
           int aux = 0;
           for(GrillaSeparacion arg: listSeparacion)
           {
               if(arg.getCorral().equals(corral_DS) && arg.getGrupoPeso().equals(grupoPeso_DS))
               {
                   aux++;
               }
           }
           if(aux > 0)
           {
               r.setMensaje("Registro ya existe");
               r.setStatus(false);
           }
           else
           {
               CorralDAO cdao = new CorralDAO();
               Corral c = cdao.getCorralByDS(corral_DS);
               if (c != null)
               {
                  GrupopesoDAO gpdao = new GrupopesoDAO();
                  GrupoPeso gp = gpdao.getGrupoPesoByDS(corral_DS);
                  if(gp != null)
                  {
                      GrupopesoCorralDAO gpcdao = new GrupopesoCorralDAO();
                      GrupopesoCorral gpc = new GrupopesoCorral();
                      Date d = new Date();
                      gpc.setCorralId(c.getCorralId());
                      gpc.setGrupopesoId(gp.getGrupopesoId());
                      gpc.setCorralgrupopesoFecha(d);
                      int idGrupopesoCorral = gpcdao.add(gpc);
                      if(idGrupopesoCorral != 0)
                      {
                          r.setMensaje("Registro guardado");
                          r.setStatus(true);
                      }
                      else
                      {
                          r.setMensaje("Registro no guardado");
                          r.setStatus(false);
                      }
                  }
               }
               else
               {
                   r.setMensaje("Corral no encontrado");
                   r.setStatus(false);
               }
           }
           return r; 
        } 
        catch (Exception e) 
        {
           throw e; 
        }
    }
    //</editor-fold>
    
    // Método público guarda actualización de registro de grilla separación
    // ENTRADA: id del listado grilla separación
    // ENTRADA: descripción del corral a ingresar
    // ENTRADA: descripción del Grupo Peso a ingresar
    // SALIDA: guarda registro actualizado en tabla GrupopesoCorral
    public Respuesta ModificarGrillaSeparacion(String id, String corral_DS, String grupoPeso_DS) throws Exception
    // <editor-fold defaultstate="collapsed" desc="Código">
    {
        try 
        {
           Respuesta r = new Respuesta();
           for(GrillaSeparacion arg: listSeparacion)
           {
               if((arg.getCorral()+arg.getGrupoPeso()).equals(id))
               {
                   GrupopesoCorralDAO gpcdao = new GrupopesoCorralDAO();
                   GrupopesoCorral gpc = gpcdao.getGrupopesoCorralByIdCorralAndIdGrupoPeso(arg.getIdGrupoPeso(), arg.getIdCorral());
                   gpc.setCorralId(arg.getIdCorral());
                   gpc.setGrupopesoId(arg.getIdGrupoPeso());
                   Date d = new Date();
                   gpc.setCorralgrupopesoFecha(d);
                   gpcdao = new GrupopesoCorralDAO();
                   if (gpcdao.update(gpc))
                   {
                       r.setMensaje("Registro modificado");
                       r.setStatus(true);
                   }
                   else
                   {
                       r.setMensaje("Registro no modificado");
                       r.setStatus(false);
                   }  
               }
           }
           return r; 
        } 
        catch (Exception e) 
        {
           throw e; 
        }
    }
    //</editor-fold>
    
    // Método público elimina  registro de grilla separación
    // ENTRADA: descripción del corral a ingresar
    // ENTRADA: descripción del Grupo Peso a ingresar
    // SALIDA: elimina registro en tabla GrupopesoCorral
    public Respuesta BorrarGrillaSeparacion(String corral_DS, String grupoPeso_DS) throws Exception
    // <editor-fold defaultstate="collapsed" desc="Código">
    {
        try 
        {
           Respuesta r = new Respuesta();
           for(GrillaSeparacion arg: listSeparacion)
           {
                GrupopesoCorralDAO gpcdao = new GrupopesoCorralDAO();
                GrupopesoCorral gpc = gpcdao.getGrupopesoCorralByIdCorralAndIdGrupoPeso(arg.getIdGrupoPeso(), arg.getIdCorral());
                if (gpc != null)
                {
                    if (gpcdao.delete(gpc))
                    {
                        r.setMensaje("Registro borrado");
                        r.setStatus(true);
                    }
                    else
                    {
                        r.setMensaje("Registro no borrado");
                        r.setStatus(false);
                    }  
                }
                else
                {
                    r.setMensaje("Registro no borrado");
                    r.setStatus(false);
                }     
           }
           return r; 
        } 
        catch (Exception e) 
        {
           throw e; 
        }
    }
    //</editor-fold>
}