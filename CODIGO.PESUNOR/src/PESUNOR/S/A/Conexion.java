
package PESUNOR.S.A;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class Conexion {
    
    Connection conexion = null;
    String Url = "jdbc:sqlserver://192.168.50.190;databaseName=PESUNOR;user=Msoto_SQL;password=Blaxor4201979;";
    
    
     public static Connection getConexion(){
        Connection con =null;
        try { 
                  
                   
                    String connectionUrl = "jdbc:sqlserver://192.168.50.190;databaseName=PESUNOR;user=Msoto_SQL;password=Blaxor4201979;";
                    con= DriverManager.getConnection(connectionUrl);
                    
                    
               
                    
                    
                    }catch (Exception ex){
                        System.out.println("Error."+ ex.getMessage());
                    } 
        return con;
    }
    
    
    
    public void conectar(){
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conexion = DriverManager.getConnection(Url);
            
        
    }catch(Exception ex){
     System.out.println("Error."+ ex.getMessage()); 
     JOptionPane.showMessageDialog(null,"error al conectar " + ex.getMessage(),ex.getMessage(),JOptionPane.ERROR_MESSAGE);
     
    }}
    
    public int InicioSesion(String rut,String contraseña){
        int resultado = 0;
        try{
            
            Statement ejecutor = conexion.createStatement();
            ResultSet rs = ejecutor.executeQuery("Select * from Administrador Where IDadmin = '"+rut+"' and contrasena = '"+contraseña+"'");
            
            
            if (rs.next()){
                JOptionPane.showMessageDialog(null, "BIENVENIDO A PESUNOR S.A");
                resultado = 1;
            } else {
                JOptionPane.showConfirmDialog(null, "RUT O CONTRASEÑA INCORRECTA");
                resultado = 0;
                
            }
            
            
            
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null,"RUT O CONTRASEÑA INCORRECTA " );
        }
        
        
       return resultado; 
    } 
}
    
    

