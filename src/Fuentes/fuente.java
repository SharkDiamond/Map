
package Fuentes;


import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.UnknownHostException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import m.saberiponombre;

//import static monitor.map.Obtener_Ip;
//import static monitor.map.local;
//import static monitor.map.privadoo;

//import static monitor.map.registro;
//import static monitor.saberiponombre.dato;


/**
 * Clase Principal donde se tiene gran parte del codigo funcional
 * @author gabriel
 */



public class fuente implements FuncionalidadFuente{
    
  
    public Connection conecta=null;


    boolean condition=true;
    Date f= new Date();
    DateFormat hourdateFormat = new SimpleDateFormat("HH:mm:ss dd/MM/yyyy");
    String fh=hourdateFormat.format(f);
    saberiponombre z=new saberiponombre();

    @Override
    public void ConectorBD() {
       
        try {
            
            
            Class.forName("com.mysql.jdbc.Driver");
            //SE CAMBIO LA DIRECCION
             conecta=DriverManager.getConnection("jdbc:mysql://localhost:3306/Torres","root","iveth2020");
            
             
             
             System.out.println("BASE DE DATOS CONECTADA");
             
        } 
       
        
        catch (ClassNotFoundException ex) {
            
          System.out.println("NO SE PUDO UTILIZAR EL DRIVER");
          
        } catch (SQLException ex) {
            
            JOptionPane.showMessageDialog(null, "Base de datos no conectada o servidor de mysql caido");
            
              Logger.getLogger(fuente.class.getName()).log(Level.SEVERE, null, ex);
          }
        
    }

    @Override
    public void pingazo(String ip, JButton boton, String nombre_del_nodo) {
       
          while(condition){
          
   
          try{
        
              InetAddress a=InetAddress.getByName(ip);
       
              
              // System.out.println(a.isReachable(1000));
              
               //SI es alcanzable la ip en menos de 1000 ms estara en verde 
              if(a.isReachable(1000)==true){
                  
                  System.out.println("es alcanzable");
                   //Dandole color al boton de verde
                  boton.setBackground(Color.GREEN);
          
         
   
          
          
          break; 
         
              }
                //SI no es alcanzable la ip en menos de 1000 ms estara en rojo
             if(a.isReachable(1000)==false){
               //Dandole color al boton de rojo
                      System.out.print(" inalcanzable");
                      boton.setBackground(Color.red);
            
//                 
//                 Mostrando la fecha 
//                 registro.append(System.getProperty("line.separator"));
//               registro.append(nombre_del_nodo+" ("+fh+") ");
//registro.append(System.getProperty("line.separator"));
//            JOptionPane.showMessageDialog(null, "collores Down");
//         
              
        break;
              }
              
              
             
       }//llave del try
       
          
    catch(Exception e)   {
    
    
    }
   
         }//LLAVE DE CIERRE DEL WHILE
  
    
    
    }

    @Override
    public void iplocal() throws UnknownHostException {
     
        //Creando un objeto de la clase inetAdress
        InetAddress a= InetAddress.getByName("");
    try{
        //OBTENIENDO LA IP LOCAL
         a=InetAddress.getLocalHost();
            
           
            
        //MOSTRANDO LA IP LOCAL
//            local.setText(""+a);
           
        
        }
        
        catch(  Exception e){
        //En dado caso que nose pueda mostras la ip
      JOptionPane.showMessageDialog(null, "No se puede encontrar la direccion ip local del equipo");
        
        }
       
       
    }

    @Override
    public void ippublica() throws IOException {
   
    try {

            URL whatismyip = new URL("http://checkip.amazonaws.com");

            BufferedReader in = new BufferedReader(new InputStreamReader(whatismyip.openStream()));     

            String ip = in.readLine();     

      //    privadoo.setText(""+ip);
            
            in.close();

        } 
    
     catch (MalformedURLException ex) {
/*
            Logger.getLogger(Obtener_Ip.class.getName()).log(Level.SEVERE, null, ex);

        } catch (IOException ex) {

            Logger.getLogger(Obtener_Ip.class.getName()).log(Level.SEVERE, null, ex);

        }
        
        */

    }
    }

    @Override
    public void t(String ip, JButton vertice, int tiempo) {
    Timer t=new Timer();

    
    TimerTask s=new TimerTask() {

            @Override
            public void run() {
               
         
        
      while(true){
          
       
          try{
        
              InetAddress a=InetAddress.getByName(ip);
       
              
               System.out.println(a.isReachable(1000));
              
              if(a.isReachable(1000)==true){
                  
                 
                  // JOptionPane.showMessageDialog(null, "collores Up");
                  vertice.setBackground(Color.GREEN);
          
   
          
          break; 
         
              }
              
             if(a.isReachable(1000)==false){
               
                      vertice.setBackground(Color.red);
           
   
  
          //  JOptionPane.showMessageDialog(null, "collores Down");
         
              
        break;
              }
              
              
             
       }//llave del try
       
          
    catch(Exception e)   {
    
    
    }
    
    
      
    }
    
    
         
                
                
            }
        };
 t.schedule(s, 0, tiempo);
    
    
    }

    @Override
    public void NodoAparte(String ip, JButton vertice, int tiempo, JLabel primero, JLabel segundo) {

 
    
    Timer t=new Timer();

    TimerTask s=new TimerTask() {
 int contadorUp=0;
          
         int contadorDown=0;
            @Override
            public void run() {
               
         
        
      while(true){
          
       
          try{
        
              InetAddress a=InetAddress.getByName(ip);
       
              
               System.out.println(a.isReachable(1000));
              
              if(a.isReachable(1000)==true){
                  
                 
                  // JOptionPane.showMessageDialog(null, "collores Up");
                  vertice.setBackground(Color.GREEN);
      contadorUp++;
      
      primero.setText(""+contadorUp);
      
          break; 
         
              }
              
             if(a.isReachable(1000)==false){
               
                      vertice.setBackground(Color.red);
           contadorDown++;
           
           
           segundo.setText(""+contadorDown);
              
        break;
              }
              
              
             
       }//llave del try
       
          
    catch(Exception e)   {
    
    
    }
    
    
      
    }
    
    
         
                
                
            }
        };
 t.schedule(s, 0, tiempo);
    
    
    
    
    
    
    }
    
    
    
}//metodo de la clase fuente...