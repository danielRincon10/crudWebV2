/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author PC_Daniel
 */
public class Producto {
    //ATRIBUTOS 
    private int codigoProducto; 
    private String nombreProducto; 
    private int cantidadProducto; 
    private int precioProducto; 
    private String categoria; 
    
    //CONSTRUCTOR
    public Producto() {
    }

    //ENCAPSULAR 
    public int getCodigoProducto() {
        return codigoProducto;
    }

    public void setCodigoProducto(int codigoProducto) {
        this.codigoProducto = codigoProducto;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public int getCantidadProducto() {
        return cantidadProducto;
    }

    public void setCantidadProducto(int cantidadProducto) {
        this.cantidadProducto = cantidadProducto;
    }

    public int getPrecioProducto() {
        return precioProducto;
    }

    public void setPrecioProducto(int precioProducto) {
        this.precioProducto = precioProducto;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
    
    
    //METODOS 
    public void crearProducto(){
        
        Conexion objConector = new Conexion(); 
        objConector.conectar();
        
        try {
            
            String sql = "INSERT INTO producto VALUES(?,?,?,?,?);";
            PreparedStatement stmt; 
            stmt = objConector.conn.prepareStatement(sql); 
            stmt.setInt(1, this.codigoProducto);
            stmt.setString(2, this.nombreProducto);
            stmt.setInt(3, this.cantidadProducto);
            stmt.setInt(4, this.precioProducto); 
            stmt.setString(5, this.categoria);
            
            stmt.execute(); 
            
            objConector.desconectar();
        } catch (Exception error) {
            System.out.println("Error Modelo: "+error);
        }
    }
    
    public ResultSet consultarProducto(){
        Conexion objConector = new Conexion(); 
        objConector.conectar();
        
        try {
            
            String sql = "SELECT * FROM producto WHERE codigoProducto = ? ; ";
            PreparedStatement stmt; 
            stmt = objConector.conn.prepareStatement(sql); 
            stmt.setInt(1, this.codigoProducto);
            ResultSet consulta = stmt.executeQuery(); 
            objConector.desconectar();
            return consulta; 
            
        } catch (Exception error) {
            System.out.println("Error Modelo: "+error);
        }
 
        return null;
    }
    
    public ResultSet listarProducto(){
        Conexion objConector = new Conexion(); 
        objConector.conectar();
        
        try {
            
            String sql = "SELECT * FROM producto; ";
            PreparedStatement stmt; 
            stmt = objConector.conn.prepareStatement(sql); 
            ResultSet consulta = stmt.executeQuery(); 
            objConector.desconectar();
            return consulta; 
            
        } catch (Exception error) {
            System.out.println("Error Modelo: "+error);
        }
 
        return null;
        
    }
    
    public void actualizarProducto(){
         
        Conexion objConector = new Conexion(); 
        objConector.conectar();
        
        try {
            
            String sql = "UPDATE producto SET "+
                         "nombreProducto = ?, "+
                         "cantidadProducto = ?, "+
                         "precioProducto = ?, "+
                         "categoriaProducto = ? "+
                         "WHERE codigoProducto = ?; "; 
            PreparedStatement stmt; 
            stmt = objConector.conn.prepareStatement(sql); 
            stmt.setInt(5, this.codigoProducto);
            stmt.setString(1, this.nombreProducto);
            stmt.setInt(2, this.cantidadProducto);
            stmt.setInt(3, this.precioProducto); 
            stmt.setString(4, this.categoria);
            
            stmt.execute(); 
            
            objConector.desconectar();
        } catch (Exception error) {
            System.out.println("Error Modelo: "+error);
        }
    }
    
    public String eliminarProducto(){
        Conexion objConector = new Conexion(); 
        objConector.conectar();
        
        try {
            
            String sql = "DELETE FROM producto "+
                         "WHERE codigoProducto = ?; "; 
            PreparedStatement stmt; 
            stmt = objConector.conn.prepareStatement(sql); 
            stmt.setInt(1, this.codigoProducto);
            
            stmt.execute(); 
            
            objConector.desconectar();
        } catch (Exception error) {
            System.out.println("Error Modelo: "+error);
            return error.toString(); 
        }
        return null; 
    }
}
