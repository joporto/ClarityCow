package cl.sgg.business;

import java.util.List;
import java.sql.Statement;
import cl.sgg.dal.*;
import cl.sgg.utils.Respuesta;
import java.sql.ResultSet;
import java.util.ArrayList;

public class Feedlot
{
    private List<GrillaFeedlot> listGrilla;
    
    public List<GrillaFeedlot> getListGrilla() {
        return listGrilla;
    }

    public void setListGrilla(List<GrillaFeedlot> listGrilla) {
        this.listGrilla = listGrilla;
    }
    
    // Constructor publico por defecto
    public Feedlot ()
    {
        this.listGrilla = new ArrayList<GrillaFeedlot>();
    }
    
    // Método público que carga grilla de pendientes por confirmar
    // ENTRADA: Sin entrada
    // SALIDA: carga en el atributo de la clase "List<GrillaFeedlot> listGrilla" el resultado
    public Respuesta CargarGrilla() throws Exception
    {
        Respuesta r = new Respuesta();
        try 
        {
            Statement stmt = Conexion.get().createStatement();
            String query = "select t.TRANSPORTE_ID, et.EVENTOTIPO_DS, t.TRANSPORTE_FECHA,t.TRANSPORTE_FMA, t.TRANSPORTE_GUIA_DESPACHO, e2.RUP_NOMBRE as origen, e3.RUP_NOMBRE as destino from EVENTO e "
                    + "join EVENTOTIPO et on et.EVENTOTIPO_ID = e.EVENTOTIPO_ID "
                    + "join EVENTO_TRANSPORTE e1 on e1.EVENTO_ID = e.EVENTO_ID "
                    + "join TRANSPORTE t on t.TRANSPORTE_ID= e1.TRANSPORTE_ID "
                    + "join ESTABLECIMIENTO e2 on e2.RUP_ID= t.TRANSPORTE_RUP_ORIGEN "
                    + "join ESTABLECIMIENTO e3 on e3.RUP_ID= t.TRANSPORTE_RUP_DESTINO "
                    + "where e.EVENTOTIPO_ID = 17 and e.EVENTO_VALOR = 0";
            ResultSet rs = stmt.executeQuery(query);
     
            while (rs.next()) 
            {
                GrillaFeedlot gf = new GrillaFeedlot();
                gf.setIdTransporte(rs.getInt("TRANSPORTE_ID"));
                gf.setFechaTraslado(rs.getString("TRANSPORTE_FECHA"));
                gf.setFundoDestino(rs.getString("destino"));
                gf.setFundoOrigen(rs.getString("origen"));
                gf.setGuiaDespacho(rs.getString("TRANSPORTE_GUIA_DESPACHO"));
                gf.setTipoTraslado(rs.getString("EVENTOTIPO_DS"));
                gf.setStatus("Por Confirmar");
                gf.setFMA(rs.getString("TRANSPORTE_FMA"));

                this.listGrilla.add(gf);    
            }
            r.setMensaje("OK");
            r.setStatus(true);
            
            if(this.listGrilla.size() == 0)
            {
                r.setMensaje("No tiene datos por confirmar");
                r.setStatus(false);
            }
            return r;
        } 
        catch (Exception e) 
        {
            throw e;
        }
    }
}