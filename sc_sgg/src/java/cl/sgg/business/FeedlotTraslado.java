
package cl.sgg.business;

import cl.sgg.dal.Conexion;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

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
    
    public FeedlotTraslado(int idTransporte) throws Exception
    {
        try 
        {
            this.idTransporte = idTransporte;
            CargarForm();
            CargarGrilla();
        } 
        catch (Exception e) 
        {
            throw e;
        }   
    }
    
    public void CargarForm() throws Exception
    {
        try 
        {
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
                fft.setRupDestino(rs.getString("RUP_DESTINO_ID"));
                fft.setRupOrigen(rs.getString("RUP_ORIGEN_ID"));
                fft.setRutTransportista(rs.getString("TRANSPORTISTA_NRUT")+"-"+rs.getString("TRANSPORTISTA_DRUT"));
            }
        } 
        catch (Exception e) 
        {
            throw e;
        }
        
    }
    
    public void CargarGrilla() throws Exception
    {
        listFeedlotTraslado = new ArrayList<GrillaFeedlotTraslado>();
        
        try 
        {
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
        } 
        catch (Exception e) 
        {
            throw e;
        }
    }
    
    public void BuscarTransportista()
    {
        
    }
    
    public void BuscarVehiculo()
    {
        
    }
    
    public void BuscarRUP()
    {
        
    }
    
    public void CargarExcel()
    {
        
    }

    public void GuardarFeedlotTraslado()
    {
        
    }
}