/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Fuentes;

import java.io.IOException;
import java.net.UnknownHostException;
import javax.swing.JButton;

/**
 *
 * @author gabriel
 */
public interface FuncionalidadFuente {
    
    
    
      
 /**
  * METODO PARA HACER LA CONECCION CON AL BASE DE DATOS
  */
    
 
    public void ConectorBD();
    
      /**
     * Metodo que hace ping
     * @param ip
     * @param boton
     * @param nombre_del_nodo 
     */
    public void pingazo(String ip, JButton boton,String nombre_del_nodo);
    
        /**
     * Metodo que retorna tu ip address local
     * @throws UnknownHostException 
     */
     public void iplocal() throws UnknownHostException;
    
     
     
     public void ippublica() throws IOException;
     
     
        /**
    * Metodo que sirve para un solo nodo cuando se crea es decir le hace ping a ese nodo.
    * @param ip
    * @param vertice
    * @param tiempo 
    */
    
     
       public void t(String ip, JButton vertice, int tiempo);
     
     
     
     
     
     
     
     
     
    
}
