<%-- 
    Document   : actualizar
    Created on : 29-sep-2021, 20:43:41
    Author     : PC_Daniel
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="Modelos.Producto"%>
<%@page import="Controladores.ControlProducto"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Crud Web MinTic</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="assets/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <link href="assets/estilos/estilos.css" rel="stylesheet" type="text/css"/>
        
    </head>
    <body>
        <header>
            <div class="container bg-success text-center bg-opacity-25 margen" >
                <h1>CRUD WEB Misión TIC 2021 JSP + JAVA + BOOTSTRAP</h1>
            </div>
        </header>
        <%
            String codigoStr = request.getParameter("codigoProducto"); 
            int codigoInt = Integer.parseInt(codigoStr.toString()); 
            ControlProducto ctrProducto = new ControlProducto(); 
            ArrayList<Producto> consultaProducto = new ArrayList<>(); 
            consultaProducto = ctrProducto.consultar(codigoInt); 
        %>
        <section class="container">
            <form method="POST" action="ControlProducto">
                <h3>Actualizar productos</h3>
                <div class="row">
                    <div class="col">
                        <div class="form-floating mb-3">
                            <input type="text" class="form-control" id="floatingInput" placeholder="ejemplo" name="codigoProducto" readonly="" value="<%out.println(consultaProducto.get(0).getCodigoProducto()); %>">
                           <label for="floatingInput">Codigo: </label>
                        </div>
                        <div class="form-floating mb-3">
                            <input type="text" class="form-control" id="floatingInput" placeholder="ejemplo" name="nombreProducto" required="" value="<%out.println(consultaProducto.get(0).getNombreProducto()); %>">
                           <label for="floatingInput">Nombre: </label>
                        </div>
                        <div class="form-floating mb-3">
                            <input type="text" class="form-control" id="floatingInput" placeholder="ejemplo" name="cantidadProducto" required="" value="<%out.println(consultaProducto.get(0).getCantidadProducto()); %>">
                           <label for="floatingInput">Cantidad: </label>
                        </div>
                    </div>
                    <div class="col">
                        <div class="form-floating mb-3">
                            <input type="text" class="form-control" id="floatingInput" placeholder="ejemplo" name="precioProducto" required="" value="<%out.println(consultaProducto.get(0).getPrecioProducto()); %>">
                           <label for="floatingInput">Precio: </label>
                        </div>
                        <label>Categoria: </label>
                        <select class="form-select" multiple aria-label="multiple select example" name="categoriaProducto" required="">
                            <option value="Lacteos">Lacteos</option>
                            <option value="Viveres">Viveres</option>
                            <option value="Abarrotes">Abarrotes</option>
                            <option value="Aseo">Aseo</option>
                            <option value="Carnicos">Carnicos</option>
                         </select>
                    </div>
                </div>
                 <div class="row">
                     <center>
                         <button class="btn btn-success btnSize" name="btnAccion" value="Actualizar">Actualizar Producto</button>
                     </center>
                </div>
            </form>
        </section>
        
        <footer>
            <div class="container bg-success text-center bg-opacity-25 margen" >
                <h5>Grupo X S46, Mision TIC 2021, Todos los derechos reservados</h5>
            </div>
        </footer>
        
        <script src="assets/js/bootstrap.min.js" type="text/javascript"></script>
    </body>
</html>
