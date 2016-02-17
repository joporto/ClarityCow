/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import cl.sgg.business.*;
import cl.sgg.dao.*;
import cl.sgg.edm.*;
import java.util.Date;
/**
 *
 * @author javierOporto
 */
public class testQueryItem {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try 
        {
            /*
           dao.AnimalDAO rdao = new dao.AnimalDAO();
           dao.EstadoAnimalDAO edao = new dao.EstadoAnimalDAO();
           
            System.out.println(
           edao.getEstadoAnimalById(
            rdao.getAnimalByDiioActual(111111).
                    getAnimalEstadoActual()).getEstadoanimalDs());
            
            
            dao.EventoTipoDAO evDao = new dao.EventoTipoDAO();
            
            for (edm.Eventotipo arg : evDao.getList()) {
                
                System.out.println(arg.getEventotipoDs());
            }
            
            dao.TipoEstadoDAO tdao = new dao.TipoEstadoDAO();
            for (edm.TipoEstado arg : tdao.getList()) {
                
                System.out.println(arg.getTipoestadoDs());
            }
                    */
            

            
            /*
         
            dao.EstadoAnimalDAO eDao = new dao.EstadoAnimalDAO();
>>>>>>> Stashed changes
            
            for (cl.sgg.edm.EstadoAnimal arg : eDao.getListByTipoEstado(2)) {
                
                System.out.println(arg.getEstadoanimalDs());
            }

            */
            
            /*
            //////Prueba Class BajaAnimales
            cl.sgg.utils.Respuesta r = new cl.sgg.utils.Respuesta();
            cl.sgg.business.BajaAnimales ba = new cl.sgg.business.BajaAnimales();
            r = ba.BuscarDIIO(111111);
            System.out.println(r.getMensaje());
            Date d = new Date();
            r = ba.GuardarBajaAnimales(d, "Sin Motivo Aparente","Muerto");
            System.out.println(r.getMensaje());
            
            
            //Prueba Class Feedlot
            cl.sgg.business.Feedlot fl = new cl.sgg.business.Feedlot();
            fl.CargarGrilla();
            */
            
            RazaDAO rdao = new RazaDAO();
            Raza r  = new Raza();
            r.setRazaAbrev("AA");
            r.setRazaNombre("razaTest");
            r.setRazaStatus(0);
            int aux = rdao.add(r);
            System.out.println(aux);
            
            r.setRazaId(aux);
            if(rdao.delete(r))
                System.out.println("true");
            else
                System.out.println("false");
            
                
                    
            
           
 
        } catch (Exception e) {
            
            System.out.println(e.getMessage());
        }
        
    }
    
}
