/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import Modelos.Producto;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author PC_Daniel
 */
@WebServlet(name = "ControlProducto", urlPatterns = {"/ControlProducto"})
public class ControlProducto extends HttpServlet {
    Producto objProducto = new Producto(); 
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            String accion = request.getParameter("btnAccion"); 
            
            if(accion.equals("Insertar")){
                
                int codigoProducto = Integer.parseInt(request.getParameter("codigoProducto")); 
                String nombreProducto = request.getParameter("nombreProducto"); 
                int cantidadProducto = Integer.parseInt(request.getParameter("cantidadProducto"));
                int precioProducto = Integer.parseInt(request.getParameter("precioProducto"));
                String categoriaProducto = request.getParameter("categoriaProducto"); 
                
                objProducto.setCodigoProducto(codigoProducto);
                objProducto.setNombreProducto(nombreProducto);
                objProducto.setCantidadProducto(cantidadProducto);
                objProducto.setPrecioProducto(precioProducto);
                objProducto.setCategoria(categoriaProducto);
                
                objProducto.crearProducto();
                
                String mensaje = "<html> <body>"+
                                 " <script type='text/javaScript'> "+
                                 "      alert('Producto insertador correctamente!'); "+
                                 "      window.location.href='index.jsp'"+
                                 "</script> </body> </html>"; 
                
                out.println(mensaje);
            }
            else if (accion.equals("Actualizar")){
                
                int codigoProducto = Integer.parseInt(request.getParameter("codigoProducto")); 
                String nombreProducto = request.getParameter("nombreProducto"); 
                int cantidadProducto = Integer.parseInt(request.getParameter("cantidadProducto"));
                int precioProducto = Integer.parseInt(request.getParameter("precioProducto"));
                String categoriaProducto = request.getParameter("categoriaProducto"); 
                
                objProducto.setCodigoProducto(codigoProducto);
                objProducto.setNombreProducto(nombreProducto);
                objProducto.setCantidadProducto(cantidadProducto);
                objProducto.setPrecioProducto(precioProducto);
                objProducto.setCategoria(categoriaProducto);
                
                objProducto.actualizarProducto();
                
                String mensaje = "<html> <body>"+
                                 " <script type='text/javaScript'> "+
                                 "      alert('Producto actualizado correctamente!'); "+
                                 "      window.location.href='index.jsp'"+
                                 "</script> </body> </html>"; 
                
                out.println(mensaje);
            }
            
            else if (accion.equals("Eliminar")){
                
                int codigoProducto = Integer.parseInt(request.getParameter("codigoProducto")); 
                
                objProducto.setCodigoProducto(codigoProducto);
                
                String respuesta = objProducto.eliminarProducto();
                
                if (respuesta == null){
                    String mensaje = "<html> <body>"+
                                 " <script type='text/javaScript'> "+
                                 "      alert('Producto eliminado correctamente!'); "+
                                 "      window.location.href='index.jsp'"+
                                 "</script> </body> </html>"; 
                
                    out.println(mensaje);
                }
                else {
                    String mensaje = "<html> <body>"+
                                 " <script type='text/javaScript'> "+
                                 "      alert('Error en la eliminación'); "+
                                 "      window.location.href='index.jsp'"+
                                 "</script> </body> </html>"; 
                
                    out.println(mensaje);
                }
                
            }
           
        }
        catch(Exception error){
            System.out.println("Error Controlador: "+ error);
        }
    }
    
    public ArrayList listar(){
        try {
            ResultSet consulta = objProducto.listarProducto(); 
            ArrayList<Producto> listaProducto = new ArrayList<>(); 
            
            while(consulta.next()){
                objProducto = new Producto(); 
                objProducto.setCodigoProducto(consulta.getInt(1));
                objProducto.setNombreProducto(consulta.getString(2));
                objProducto.setCantidadProducto(consulta.getInt(3));
                objProducto.setPrecioProducto(consulta.getInt(4));
                objProducto.setCategoria(consulta.getString(5));
                listaProducto.add(objProducto); 
            }
            
            return listaProducto; 
            
        } catch (Exception error) {
            System.out.println("Error Controlador:" + error);
        }
 
        return null;
    }
    
    
    public ArrayList consultar(int codigoProducto){
        try {
            objProducto.setCodigoProducto(codigoProducto);
            ResultSet consulta = objProducto.consultarProducto(); 
            ArrayList<Producto> listaProducto = new ArrayList<>(); 
            
            while(consulta.next()){
                objProducto = new Producto(); 
                objProducto.setCodigoProducto(consulta.getInt(1));
                objProducto.setNombreProducto(consulta.getString(2));
                objProducto.setCantidadProducto(consulta.getInt(3));
                objProducto.setPrecioProducto(consulta.getInt(4));
                objProducto.setCategoria(consulta.getString(5));
                listaProducto.add(objProducto); 
            }
            
            return listaProducto; 
            
        } catch (Exception error) {
            System.out.println("Error Controlador:" + error);
        }
 
        return null;
    }
    

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
