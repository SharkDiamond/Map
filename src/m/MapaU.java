/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package m;

import Fuentes.fuente;
import Movimientos.movimiento;
import java.awt.Color;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.PointerInfo;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
 
/**
 *
 * @author gabriel
 */
public class MapaU extends javax.swing.JFrame{
 fuente fuente=new fuente();
 Connection conectar;
    JButton torres;
    private Statement estatuto;
private ResultSet resultado;
   


//CONSTRUCTOR
public MapaU() {
        fuente.ConectorBD();
      
        initComponents();
        this.setTitle("Maker");
        Guardar();
    }

      
   
    //CONSULTAS A EJECUTAR insert into nodos values("Gabriel","192.168.1.10"); / delete from nodos where Nombre="Gabriel";

    /**
     * 
     * @param Nombre
     * @param Ip 
     * 
     * Metodo para insertar datos en la base de datos en la tabla nodos
     */
    
    
public void InsertaBD(String Nombre,String Ip,int tiempo){
  try {
      
      estatuto = fuente.conecta.createStatement();
          String a=Nombre;
          String b=Ip;
          int c=tiempo;
    String Sentencia="insert into Nodos values('"+a+"','"+b+"',"+c+")";
        
            estatuto.executeUpdate(Sentencia);
            JOptionPane.showMessageDialog(this,"NODO REGISTRADO EXITOSAMENTE");
       
        } catch (SQLException ex) {
            
             JOptionPane.showMessageDialog(this,"LOS DATOS NO SE PUDIERON REGISTRAR verique que efectivamente esta ingresando los datos de manera correcta");
            
            Logger.getLogger(MapaU.class.getName()).log(Level.SEVERE, null, ex);
        }      
        

}
    
    /**
     * 
     * @param Nombre 
     * METODO PARA ELIMINAR EN LA TABLA NODOS DE LA BASE DE DATOS
     */
    
public void EliminarBD(String Nombre){
try {
      
      estatuto = fuente.conecta.createStatement();
          String a=Nombre;
      
    String Sentencia="delete from Nodos where Nombre='"+Nombre+"'";
        
            estatuto.executeUpdate(Sentencia);
            
            JOptionPane.showMessageDialog(this,"NODO ELIMINADO EXITOSAMENTE");
       
        } catch (SQLException ex) {
            
             JOptionPane.showMessageDialog(this,"LOS DATOS NO SE PUDIERON REGISTRAR verique que efectivamente esta ingresando los datos de manera correcta");
            
            Logger.getLogger(MapaU.class.getName()).log(Level.SEVERE, null, ex);
        }      
        





}



       public void ntorres(JPanel panel_donde_se_van_a_dibujar_los_botones){
   
 
       //CREANDO LOS BOTONES
       
      //INTRODUCCION DEL NODO Y LA IP ADDRESS A CREAR
          String nombre_del_nodo=JOptionPane.showInputDialog("Por favor introduzca el nombre del nodo "+"=");
          
          if(nombre_del_nodo.equals(JOptionPane.CANCEL_OPTION)){
          
          
          }
          else{
              
              
                     String ip_del_nodo=JOptionPane.showInputDialog("Por favor introduzca la ip del nodo "+"=");

                     
                     if(ip_del_nodo.equals(JOptionPane.CANCEL_OPTION)){
                     
                     
                     }
                     
                     else{
                     
                         
                         
                         //AQUI ES DONDE SE DEBEN INSERTAR LOS DATOS EN BD
                         
                         
                     
                         
                      String opciones[]={"5 Segundos","30 Segundos","1 minuto","5 minutos"};
           
 String t=(String) JOptionPane.showInputDialog(null, "Por favor seleccione su tiempo de hacer ping:", "tiempo de ejecucion", JOptionPane.INFORMATION_MESSAGE, null, opciones, opciones[0]);
   
                         
                         
                         if(t.equals(JOptionPane.CANCEL_OPTION)){
                         
                         }
                         
                         
                         else{
                         
                                 
                      torres = new javax.swing.JButton();
          
           //TAMAÑO DEL NODO
                      

                     
                     
                      
           torres.setSize(200,33);
           torres.setBackground(Color.WHITE);
        
          //Añadiendo el nombre al nodo
     torres.setText(nombre_del_nodo);
     torres.setFocusable(false);

      //DIBUJANDO BOTON EN EL PANEL
         panel_donde_se_van_a_dibujar_los_botones.add(torres);
    
          
//movimiento
         movimiento move=new movimiento(torres);
           
         
         //AÑADIENDOLE EVENTOS A LOS BOTONTES Y PASANDOLE COMO PARAMETRO EL OBJETO DE LA CLASE MOVIMIENTO
       torres.addMouseListener(move);
   
   
    movimientopanel s=new movimientopanel(torres);
    
    
          //AÑADIENDOLE EVENTOS A LOS BOTONTES Y PASANDOLE COMO PARAMETRO EL OBJETO DE LA CLASE MOVIMIENTO
    panel_donde_se_van_a_dibujar_los_botones.addMouseListener(s);
    
    
  
    
    
    //ARREGLO DE OPCIONES DE TIEMPO PARA EL NODO A CREAR EN LA INTERFAZ
       
 //SI SE ELIGE 5 SEGUNDOS
 if(t.equals("5 Segundos")){

 fuente.t(ip_del_nodo, torres,5000);
 
         this.InsertaBD(nombre_del_nodo, ip_del_nodo,5000);
                         
     
 }
 //SI SE ELIGE 30 SEGUNDOS
 if(t.equals("30 Segundos")){
 
 fuente.t(ip_del_nodo, torres,30000);
 
        this.InsertaBD(nombre_del_nodo, ip_del_nodo,30000);
                         
     
     
 }
 
 //SI SE ELIGE 1 MINUTO
 if(t.equals("1 minuto")){

 fuente.t(ip_del_nodo, torres,60000);
 this.InsertaBD(nombre_del_nodo, ip_del_nodo,60000);
                     
     
     
 }
 
 //SI SE ELIGE 5 MINUTOS
 if(t.equals("5 minutos")){

 fuente.t(ip_del_nodo, torres,300000);
 
      this.InsertaBD(nombre_del_nodo, ip_del_nodo,300000);
                     
     
 }
                     
                       
                         }//else
                         
                 
                     
                     
                     }//else
          
          
          
          
          
          
          }//LLAVE DE CIERRE DEL ELSE
          
           
         
 
 
 
 
 
 
   }//LLAVE DE CIERRE DEL METODO DE NTORRES

    
       public void crearnodo(String nombre,String ip,int baja,int tiempo){
       
       
       System.out.println("Nodo="+nombre);
         System.out.println("Ip="+ip);
         
         
         JButton i=new JButton();
     
  i.setText(nombre);
  i.setSize(200,33);
  i.setLocation(20, baja);
  i.setFocusable(false);
         lienzo.add(i);
         lienzo.repaint();
         
         
          movimientopanel p=new movimientopanel(i);
        
      lienzo.addMouseListener(p);
    
    
 fuente.t(ip, i,tiempo);
 
     
       }
       
       
    public void Guardar(){
    
      
           try {
     
            estatuto = fuente.conecta.createStatement();
            resultado = estatuto.executeQuery("SELECT * FROM Nodos");        // TODO add your handling code here:
            String n,ip;
            int tiempo;
            int l=50;
            
              while(resultado.next()){
            n=resultado.getString("Nombre");
            ip=resultado.getString("ip");
            tiempo=resultado.getInt("Tiempo");
            this.crearnodo(n, ip,l,tiempo);
            
            l+=50;
            }
        
            
        }//LLAVE FINAL DEL TRY
           
           catch (SQLException ex) {
            Logger.getLogger(MapaU.class.getName()).log(Level.SEVERE, null, ex);
       
           
           }//LLAVE FINAL DEL CATCH//LLAVE FINAL DEL CATCH
        
       
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lienzo = new javax.swing.JPanel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lienzo.setBackground(new java.awt.Color(0, 51, 102));
        lienzo.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                lienzoMouseMoved(evt);
            }
        });
        lienzo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lienzoMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                lienzoMouseReleased(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lienzoMouseEntered(evt);
            }
        });

        javax.swing.GroupLayout lienzoLayout = new javax.swing.GroupLayout(lienzo);
        lienzo.setLayout(lienzoLayout);
        lienzoLayout.setHorizontalGroup(
            lienzoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 827, Short.MAX_VALUE)
        );
        lienzoLayout.setVerticalGroup(
            lienzoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 412, Short.MAX_VALUE)
        );

        jMenuBar1.setBackground(new java.awt.Color(51, 51, 51));
        jMenuBar1.setBorderPainted(false);

        jMenu1.setForeground(new java.awt.Color(0, 255, 102));
        jMenu1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/herramientas-de-edicion.png"))); // NOI18N
        jMenu1.setText("Crear");
        jMenu1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu1MouseClicked(evt);
            }
        });
        jMenuBar1.add(jMenu1);

        jMenu2.setForeground(new java.awt.Color(0, 255, 102));
        jMenu2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/eliminar.png"))); // NOI18N
        jMenu2.setText("Eliminar");
        jMenu2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu2MouseClicked(evt);
            }
        });
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lienzo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lienzo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenu1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu1MouseClicked
       this.ntorres(lienzo);
    }//GEN-LAST:event_jMenu1MouseClicked

    private void lienzoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lienzoMouseEntered
  
     
        
   
/*
      if(verdad==1){
       

    this.b.setLocation(evt.getX(), evt.getY());
      
      
      }    
        */

        
        
    }//GEN-LAST:event_lienzoMouseEntered

    private void lienzoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lienzoMousePressed

    }//GEN-LAST:event_lienzoMousePressed

    private void lienzoMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lienzoMouseMoved
 
    }//GEN-LAST:event_lienzoMouseMoved

    private void lienzoMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lienzoMouseReleased
       // TODO add your handling code here:
    }//GEN-LAST:event_lienzoMouseReleased

    private void jMenu2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu2MouseClicked
     
        //PARA ELIMINAR LOS DATOS
        
        
        this.EliminarBD("sdsd");
    }//GEN-LAST:event_jMenu2MouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MapaU.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MapaU.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MapaU.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MapaU.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MapaU().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    public javax.swing.JPanel lienzo;
    // End of variables declaration//GEN-END:variables
}
