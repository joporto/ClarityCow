/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import cl.sgg.business.Feedlot;
import cl.sgg.business.GrillaFeedlot;
import cl.sgg.utils.Respuesta;

/**
 *
 * @author felipefarinaf
 */
public class testSQL {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        try 
        {
            Feedlot f = new Feedlot();
            
            f.CargarGrilla();
            
            System.out.println(f.getListGrilla().size());
            for (GrillaFeedlot arg : f.getListGrilla()) {
                
                System.out.println(arg.toString());
                
            }
            
        } 
        catch (Exception e) 
        {
            System.out.println(e.getMessage());
        }
        
       
    }
    
}
