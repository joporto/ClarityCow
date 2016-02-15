package cl.sgg.business;

import cl.sgg.dal.Conexion;
import cl.sgg.dao.*;
import cl.sgg.edm.*;
import cl.sgg.utils.Respuesta;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.*;

public class FeedlotTraslado 
{
    private int idTransporte;
    private FormFeedlotTraslado fft;
    private List<GrillaFeedlotTraslado> listFeedlotTraslado;

    public int getIdTransporte() {
        return idTransporte;
    }

    public void setIdTransporte(int idTransporte) {
        this.idTransporte = idTransporte;
    }

    public FormFeedlotTraslado getFft() {
        return fft;
    }

    public void setFft(FormFeedlotTraslado fft) {
        this.fft = fft;
    }

    public List<GrillaFeedlotTraslado> getListFeedlotTraslado() {
        return listFeedlotTraslado;
    }

    public void setListFeedlotTraslado(List<GrillaFeedlotTraslado> listFeedlotTraslado) {
        this.listFeedlotTraslado = listFeedlotTraslado;
    }
    
    // Constructor público por defecto
    public FeedlotTraslado()
    {
        this.idTransporte = 0;
    }
    
   // Constructor público sobrecargado que agrega valor de idTransporte a atributo clase "int idTransporte"
    public FeedlotTraslado(int idTransporte)
    { 
        this.idTransporte = idTransporte;
    }
    
    // Método público que carga valores de formulario al cargar pendiente por confirmar de Feedlot
    // ENTRADA: Sin entradas (Usar antes Constructor sobrecargado ya que requiere valor de idTransporte)
    // SALIDA: carga en el atributo de la clase "FormFeedlotTraslado fft" el resultado
    public Respuesta CargarForm() throws Exception //idTransporte recuperado de listado en main Feedlot
    {
        try 
        {
            Respuesta r = new Respuesta();
            if (this.idTransporte == 0)
            {
                r.setStatus(false);
                r.setMensaje("sin idTransporte");
                return r;
            }
            
            Statement stmt = Conexion.get().createStatement();
            String query = "select et.EVENTOTIPO_DS, t.TRANSPORTE_FECHA,t.TRANSPORTE_FMA, t.TRANSPORTE_GUIA_DESPACHO, "
                    + "e2.RUP_NOMBRE as RUP_ORIGEN_NOM, e2.RUP_ID as RUP_ORIGEN_ID, "
                    + "e3.RUP_NOMBRE as RUP_DESTINO_NOM, e3.RUP_ID as RUP_DESTINO_ID, e3.RUP_COMUNA, e3.RUP_DIRECCION, "
                    + "tt.TRANSPORTISTA_NRUT, tt.TRANSPORTISTA_DRUT, tt.TRANSPORTISTA_NOMBRE, "
                    + "v.VEHICULO_PATENTE, t.TRANSPORTE_PATENTE_ACOPLADO, "
                    + "e.CATEGORIA_ID, c.CATEGORIA_DS, "
                    + "e.EVENTO_FECHA_REG, e.EVENTO_FECHA_EVENTO "
                    + "from EVENTO e "
                    + "join CATEGORIA c on c.CATEGORIA_ID = e.CATEGORIA_ID "
                    + "join EVENTOTIPO et on et.EVENTOTIPO_ID = e.EVENTOTIPO_ID "
                    + "join EVENTO_TRANSPORTE e1 on e1.EVENTO_ID = e.EVENTO_ID "
                    + "join TRANSPORTE t on t.TRANSPORTE_ID= e1.TRANSPORTE_ID "
                    + "join VEHICULO v on v.VEHICULO_ID = t.VEHICULO_ID "
                    + "join TRANSPORTISTA tt on tt.TRANSPORTISTA_ID = t.TRANSPORTISTA_ID "
                    + "join ESTABLECIMIENTO e2 on e2.RUP_ID= t.TRANSPORTE_RUP_ORIGEN "
                    + "join ESTABLECIMIENTO e3 on e3.RUP_ID= t.TRANSPORTE_RUP_DESTINO "
                    + "where et.EVENTOTIPO_ID = 17 and t.TRANSPORTE_ID = " +this.idTransporte;
       
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) 
            {
                fft = new FormFeedlotTraslado();
                fft.setComuna(rs.getString("RUP_COMUNA"));
                fft.setDireccion(rs.getString("RUP_DIRECCION"));
                fft.setFMA(rs.getString("TRANSPORTE_FMA"));
                fft.setFechaRegistro(rs.getDate("EVENTO_FECHA_REG"));
                fft.setFechaTraslado(rs.getDate("EVENTO_FECHA_EVENTO"));
                fft.setGuiaDespacho(rs.getString("RUP_COMUNA"));
                fft.setNomRupDestino(rs.getString("RUP_DESTINO_NOM"));
                fft.setNomRupOrigen(rs.getString("RUP_ORIGEN_NOM"));
                fft.setNomTransportista(rs.getString("TRANSPORTISTA_NOMBRE"));
                fft.setPatenteAcoplado(rs.getString("TRANSPORTE_PATENTE_ACOPLADO"));
                fft.setPatenteVehiculo(rs.getString("VEHICULO_PATENTE"));
                fft.setRupDestino(rs.getInt("RUP_DESTINO_ID")); 
                fft.setRupOrigen(rs.getInt("RUP_ORIGEN_ID"));
                fft.setRutTransportista(rs.getString("TRANSPORTISTA_NRUT")+"-"+rs.getString("TRANSPORTISTA_DRUT"));
                r.setMensaje("OK");
                r.setStatus(true);
                return r;
            }
            r.setMensaje("Sin datos");
            r.setStatus(false);
            return r;
        } 
        catch (Exception e) 
        {
            throw e;
        }
    }
    
    // Método público que carga valores de grilla DIIOS y status
    // ENTRADA: Sin entradas (Usar antes Constructor sobrecargado ya que requiere valor de idTransporte)
    // SALIDA: carga en el atributo de la clase "List<GrillaFeedlotTraslado> listFeedlotTraslado" el resultado
    public Respuesta CargarGrilla() throws Exception
    {
        try 
        {
            Respuesta r = new Respuesta();
            if (this.idTransporte == 0)
            {
                r.setStatus(false);
                r.setMensaje("sin idTransporte");
                return r;
            }
            listFeedlotTraslado = new ArrayList<GrillaFeedlotTraslado>();
            Statement stmt = Conexion.get().createStatement();
            String query = "select a.ANIMAL_DIIO_ACTUAL, a.ANIMAL_PESO_ACTUAL, e.EVENTO_VALOR "
                + "from EVENTO e "
                + "join ANIMAL a on a.ANIMAL_ID = e.ANIMAL_ID "
                + "join EVENTO_TRANSPORTE et on et.EVENTO_ID = e.EVENTO_ID "
                + "join TRANSPORTE t on t.TRANSPORTE_ID = et.TRANSPORTE_ID "
                + "where t.TRANSPORTE_ID = " + this.idTransporte;
            ResultSet rs = stmt.executeQuery(query);
            
            while (rs.next()) 
            {
                GrillaFeedlotTraslado gft = new GrillaFeedlotTraslado();
                gft.setDIIO(rs.getInt("ANIMAL_DIIO_ACTUAL"));
                gft.setPeso(rs.getString("ANIMAL_PESO_ACTUAL"));
                if(rs.getInt("EVENTO_VALOR")== 0)
                {
                    gft.setStatus("Por confirmar");
                }
                else if (rs.getInt("EVENTO_VALOR")== 1)
                {
                    gft.setStatus("Confirmado");
                }
                this.listFeedlotTraslado.add(gft);
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
    
    // Método público que busca Transportista ingresado (búsqueda exacta)
    // ENTRADA: Opcional, Se ingresa valor de rut transportista a consultar sin digito verificador ni puntos, si no va = ""
    // ENTRADA: Opcional, Se ingresa valor de nombre transportista a consultar, si no va = ""
    // SALIDA: carga en el atributo de la clase "FormFeedlotTraslado fft" con el resultado
    public Respuesta BuscarTransportista(String rutTransportista, String nomTransportista) throws Exception
    {
        try 
        {
            Respuesta r = new Respuesta();
            TransportistaDAO tdao = new TransportistaDAO();
            Transportista t = new Transportista();
            if (!"".equals(rutTransportista))
            {
                t = tdao.getTransportistaByRut(rutTransportista);
            }
            else if (!"".equals(nomTransportista))
            {
                t = tdao.getTransportistaByNombre(nomTransportista);
            }
            if (t.getTransportistaId() != 0) //encontró transportista?
            {
                if (t.getTransportistaStatus() == 0) //transportista desactivado
                {
                    r.setMensaje("Transportista desactivado");
                    r.setStatus(false);
                    return r;
                }
                else
                {
                    fft.setRutTransportista(t.getTransportistaNrut()+"-"+t.getTransportistaDrut());
                    fft.setNomTransportista(t.getTransportistaNombre());
                    fft.setIdTransportista(t.getTransportistaId());
                    r.setStatus(true);
                    r.setMensaje("Transportista cargado");
                }
            }
            else
            {
                r.setStatus(false);
                r.setMensaje("Transportista no encontrado");
            }
            return r;
        } 
        catch (Exception e) 
        {
            throw e;
        }
    }

    // Método público que busca vehículo ingresado (búsqueda exacta)
    // ENTRADA: Se ingresa valor de patente a consultar
    // SALIDA: carga en el atributo de la clase "FormFeedlotTraslado fft" con el resultado
    public Respuesta BuscarVehiculo(String patente)
    {
        try 
        {
            Respuesta r = new Respuesta();
            VehiculoDAO vdao = new VehiculoDAO();
            Vehiculo v = new Vehiculo();
            if (!"".equals(patente))
            {
                v = vdao.getVehiculoByPatente(patente);
            }
            
            if (v.getVehiculoId() != 0) //encontró vehiculo?
            {
                if (v.getVehiculoStatus() == 0) //vehiculo desactivado
                {
                    r.setMensaje("Vehículo desactivado");
                    r.setStatus(false);
                    return r;
                }
                else
                {
                    fft.setPatenteVehiculo(v.getVehiculoPatente());
                    fft.setIdVehiculo(v.getVehiculoId());          
                    r.setStatus(true);
                    r.setMensaje("Vehículo cargado");
                }
            }
            else
            {
                r.setStatus(false);
                r.setMensaje("Vehículo no encontrado");
            }
            return r;
        } 
        catch (Exception e) 
        {
            throw e;
        }
    }
    
    // Método público que invoca la busqueda de RUP Origen ingresado (búsqueda exacta)
    // ENTRADA: Opcional, Se ingresa valor de codigo RUP a consultar, si no va = ""
    // ENTRADA: Opcional, Se ingresa valor de nombre RUP a consultar, si no va = ""
    // SALIDA: carga en el atributo de la clase "FormFeedlotTraslado fft" con el resultado
    public Respuesta BuscarRUPOrigen(int rupOrigen, String nomRupOrigen) throws Exception
    {
        try 
        {
            Respuesta r = new Respuesta();
            r = BuscarRUP(rupOrigen, nomRupOrigen,1); //origen
            return r;
        } 
        catch (Exception e) 
        {
            throw e;
        }
    }
    
    // Método público que invoca la busqueda de RUP Destino ingresado (búsqueda exacta)
    // ENTRADA: Opcional, Se ingresa valor de codigo RUP a consultar, si no va = ""
    // ENTRADA: Opcional, Se ingresa valor de nombre RUP a consultar, si no va = ""
    // SALIDA: carga en el atributo de la clase "FormFeedlotTraslado fft" con el resultado
    public Respuesta BuscarRUPDestino(int rupOrigen, String nomRupOrigen) throws Exception
    {
        try 
        {
            Respuesta r = new Respuesta();
            r = BuscarRUP(rupOrigen, nomRupOrigen,2); //destino
            return r;
        } 
        catch (Exception e) 
        {
            throw e;
        }
    }
    
    // Método privado que realiza la busqueda de RUP ingresado (búsqueda exacta)
    // ENTRADA: Opcional, Se ingresa valor de codigo RUP a consultar, si no va = ""
    // ENTRADA: Opcional, Se ingresa valor de nombre RUP a consultar, si no va = ""
    // ENTRADA: Se ingresa valor tipoRUP (1= Origen, 2= Destino)
    // SALIDA: carga en el atributo de la clase "FormFeedlotTraslado fft" con el resultado
    private Respuesta BuscarRUP(int rupOrigen, String nomRupOrigen, int tipoRUP) throws Exception
    {
        try 
        {
            Respuesta r = new Respuesta();
            EstablecimientoDAO edao = new EstablecimientoDAO();
            Establecimiento e = new Establecimiento();
            if (!"".equals(rupOrigen))
            {
                e = edao.getEstablecimientoByRup(tipoRUP);
            }
            else if (!"".equals(nomRupOrigen))
            {
                e = edao.getEstablecimientoByNombre(nomRupOrigen);
            }
            if (e.getRupId() != 0) //encontró transportista?
            {
                if (e.getRupStatus() == 0) //transportista desactivado
                {
                    r.setMensaje("RUP desactivado");
                    r.setStatus(false);
                    return r;
                }
                else
                {
                    r.setStatus(false);
                    r.setMensaje("Transportista no cargado, tipoRUP no valido");
                    if(tipoRUP == 1) //origen
                    {
                        fft.setRupOrigen(e.getRupId());
                        fft.setNomRupOrigen(e.getRupNombre());
                        r.setStatus(true);
                        r.setMensaje("RUP Origen cargado");
                    }
                    else if (tipoRUP == 2) //destino
                    {
                        fft.setComuna(e.getRupComuna());
                        fft.setDireccion(e.getRupDireccion());
                        fft.setRupDestino(e.getRupId());
                        fft.setNomRupDestino(e.getRupNombre());
                        r.setStatus(true);
                        r.setMensaje("RUP Destino cargado");
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
    
    
    public void CargarExcel()
    {
        
    }

    public void GuardarFeedlotTraslado()
    {
        
    }
}