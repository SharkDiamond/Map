/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Movimientos;

import Fuentes.fuente;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JButton;



/**
 *
 * @author gabriel
 */
import java.awt.Window;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import m.MapaU;

/**
 * CLASE DE MOVIMIENTO DE LOS BOTONES
 * @author gabriel
 */

public class movimiento  implements MouseListener {

  //VARIABLES
    
     fuente fuente=new fuente();
 Connection conectar;
    JButton torres;
    private Statement estatuto;
private ResultSet resultado;
    
     private JButton i;
     
     JPanel panel;
   
  
  int cv;
    
  /**
   * CONSTRUCTOR DE LA CLASE MOVIMIENTO TIENE COMO PARAMETRO EL BOTON AL CUAL SE LE VAN A ASIGNAR DICHOS EVENTOS
   * @param u 
   */
   public movimiento(JButton u){
    
this.i=u;
    
    }
    
   public movimiento(){
    

    
    }
    
    
private  int verdad;


/**
 * METODO QUE BUSTA A TRAVES DEL NOMBRE LA IP QUE LE PERTENECE A DICHO NODO
 * @param Nombrenodo
 * @return 
 */

public String IpnodoNombre(String Nombrenodo){
    
      try {
     fuente.ConectorBD();
            estatuto = fuente.conecta.createStatement();
            resultado = estatuto.executeQuery("SELECT * FROM Nodos");  // TODO add your handling code here:
            String ip;
         
   
            
              while(resultado.next()){
           String nm=resultado.getString("Nombre");
            ip=resultado.getString("Ip");
            
          if(nm.equals(Nombrenodo)){
      
              
        return ip;
           
          
          }
            
  

            }
        
            
        }//LLAVE FINAL DEL TRY
           
           catch (SQLException ex) {
            Logger.getLogger(MapaU.class.getName()).log(Level.SEVERE, null, ex);
       
           
           }//LLAVE FINAL DEL CATCH
        
    return "No retorna nada";

}


    @Override
    public void mouseClicked(MouseEvent me) {
     
        String Nombre_Componente=me.getComponent().getName();
        
        String mensaje="La ip es:"+ this.IpnodoNombre(Nombre_Componente);
    
JOptionPane.showMessageDialog(null, mensaje);       
        
        
    }

    @Override
    public void mousePressed(MouseEvent me) {
   
        
     this.setVerdad(1);
       // cv=1;
      
    }

    @Override
    public void mouseReleased(MouseEvent me) {
  // cv=60;
  
   this.setVerdad(0);
    
    }
    
    

    public int getVerdad() {
        return verdad;
    }

    public void setVerdad(int verdad) {
        this.verdad = verdad;
    }
    
  
  
  
    @Override
    public void mouseExited(MouseEvent me) {

    
    
    
    
    }

    @Override
    public void mouseEntered(MouseEvent me) {
        
     
                  if(cv==1){
          
         
         i.setLocation(me.getX(), me.getY()); 
        
          }
        
    
    }

    public JButton getI() {
        return i;
    }

    public void setI(JButton i) {
        this.i = i;
    }

    public int getCv() {
        return cv;
    }

    public void setCv(int cv) {
        this.cv = cv;
    }
    
    
    
    
    
    
    
}
