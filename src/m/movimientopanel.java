/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package m;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JButton;

/**
 *
 * @author gabriel
 */
public class movimientopanel implements MouseListener{
//Variables
    JButton boton;
     movimiento w=new movimiento();
     
    
   movimientopanel(JButton boton){
   
   this.boton=boton;
   
   this.boton.addMouseListener(w);
   

   
   }
    

   




    
    @Override
    public void mouseClicked(MouseEvent me) {
      
    }

    @Override
    public void mousePressed(MouseEvent me) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseReleased(MouseEvent me) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseEntered(MouseEvent me) {




if(w.getVerdad()==1){
    
    
    
boton.setLocation(me.getX(), me.getY());



}



    }

    @Override
    public void mouseExited(MouseEvent me) {
    }
    
}
