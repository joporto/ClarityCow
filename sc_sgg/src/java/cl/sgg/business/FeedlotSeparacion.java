//v1.0.0
package cl.sgg.business;

import cl.sgg.dal.Conexion;
import cl.sgg.dao.*;
import cl.sgg.edm.*;
import cl.sgg.utils.Respuesta;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class FeedlotSeparacion 
{
    private Establecimiento rup;
    private List<GrillaSeparacion> listSeparacion;
    private List<String> listCorral;
    private List<String> listGrupoPeso;
    
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
    
    //Constructor por defecto
    public FeedlotSeparacion()
    {
        this.rup = new Establecimiento();
        this.listCorral = new ArrayList<String>();
        this.listGrupoPeso = new ArrayList<String>();
        this.listSeparacion = new ArrayList<GrillaSeparacion>();
    }
    
    // Método público que realiza la busqueda de RUP ingresado (búsqueda exacta)
    // ENTRADA: Opcional, Se ingresa valor de codigo RUP a consultar, si no va = ""
    // ENTRADA: Opcional, Se ingresa valor de nombre RUP a consultar, si no va = ""
    // SALIDA: carga en el atributo de la clase "Establecimiento rup" con el resultado
    // SALIDA: carga en el atributo de la clase "List<GrillaSeparacion> listSeparacion" con el resultado
    public Respuesta BuscarRUPCargaGrilla(int rup, String nomRup) throws Exception
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
            if (e.getRupId() != 0) //encontró RUP?
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
                    if(BuscarGrilla().isStatus())
                    {
                        r.setStatus(true);
                        r.setMensaje("RUP y grilla cargado");
                    }
                    else
                    {
                        r.setStatus(false);
                        r.setMensaje("Grilla no cargada");  
                    }    
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

    // Método privado se carga la grilla de corrales-grupos peso
    // ENTRADA: Sin entrada
    // SALIDA: carga en el atributo de la clase "List<GrillaSeparacion> listSeparacion" con el resultado
    private Respuesta BuscarGrilla() throws Exception
    {
        try 
        {
            Respuesta r = new Respuesta();
            r.setMensaje("error al ejecutar la consulta");
            r.setStatus(false);
            Statement stmt = Conexion.get().createStatement();
            String query = "SELECT gp.GRUPOPESO_ID, gp.GRUPOPESO_DS, c.CORRAL_ID, c.CORRAL_DS "
                + "FROM GRUPO_PESO gp "
                + "join GRUPOPESO_CORRAL gpc on gpc.GRUPOPESO_ID = gp.GRUPOPESO_ID "
                + "join CORRAL c on c.CORRAL_ID = gpc.CORRAL_ID "
                + "where c.CORRAL_STATUS = 1 and gp.GRUPOPESO_STATUS = 1 and c.RUP_ID = "+this.rup.getRupId();
            ResultSet rs = stmt.executeQuery(query);
            
            while (rs.next()) 
            {
                GrillaSeparacion gs = new GrillaSeparacion();
                gs.setCorral(rs.getString("CORRAL_DS"));
                gs.setGrupoPeso(rs.getString("GRUPOPESO_DS"));
                this.listSeparacion.add(gs);
            }
            return r;
        } 
        catch (Exception e) 
        {
            throw e;
        }
    }
    
    // Método público carga listado de Corrales según RUP buscado
    // ENTRADA: Sin entrada
    // SALIDA: carga en el atributo de la clase "List<String> listCorral" con el resultado
    public Respuesta CargaCbCorral() throws Exception
    {
        try 
        {
            Respuesta r = new Respuesta();
            r.setMensaje("error al ejecutar la consulta");
            r.setStatus(false);
            Statement stmt = Conexion.get().createStatement();
            String query = "select CORRAL_DS "
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
    }
    
    // Método público carga listado de GrupoPeso según Corral buscado
    // ENTRADA: Sin entrada
    // SALIDA: carga en el atributo de la clase "List<String> listGrupoPeso" con el resultado
    public Respuesta CargaCbGrupoPeso(String Corral_DS) throws Exception
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
    }
    
    public Respuesta GuardaRegistroGrillaSeparación(String corral_DS, String grupoPeso_DS) throws Exception
    {
        try 
        {
           Respuesta r = new Respuesta();
           
           for (GrillaSeparacion arg: listSeparacion)
           {
               if(arg.getCorral() == corral_DS && arg.getGrupoPeso() == corral_DS)
               {
                   
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