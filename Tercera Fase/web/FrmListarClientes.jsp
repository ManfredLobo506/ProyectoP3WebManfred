<%@page import="Logica.LNCliente"%>
<%@page import="Entidades.Cliente"%>
<%@page import="java.util.List"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="lib/bootstrap-datepicker/css/bootstrap-datepicker3.standalone.min.css" rel="stylesheet" type="text/css"/>
        <link href="lib/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <link href="lib/fontawesome-free-5.14.0-web/css/all.min.css" rel="stylesheet" type="text/css"/>
        <title>Listado de Clientes</title>
    </head>

    <body>
       <header>
            <nav class="navbar navbar-expand-sm navbar-toggleable-sm navbar-light bg-primary border-bottom box-shadow mb-3">
                <div class="container">
                    <a class="navbar-brand text-light" href="index2.html">Sistema Facturación <i class="fas fa-tasks"></i></a>
                    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target=".navbar-collapse" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                        <span class="navbar-toggler-icon"></span>
                    </button>
                    <div class="navbar-collapse collapse d-sm-inline-flex flex-sm-row-reverse">
                        <ul class="navbar-nav flex-grow-1">
                            <li class="nav-item">
                                <a class="nav-link text-light" href="index2.html">Inicio</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link text-light" href="FrmListarTrabajadores.jsp">Trabajadores</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link text-light" href="FrmListarClientes.jsp">Clientes</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link text-light" href="Frm_ListarFacturas.jsp">Facturación</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link text-light" href="FrmFiltrarVentas.jsp">Filtrar Ventas</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link text-light" href="FrmFiltrarVentasTrab.jsp">Filtrar Ventas Trabajador</a>
                            </li>
                        </ul>
                    </div>
                </div>
            </nav>
        </header>

        <div class="container"> 
            <div class="card-header">
                <h1>Listado de Clientes</h1>
            </div>
            <br/>


            <form action="FrmListarClientes.jsp" method="post">

                <div class="form-group">
                    <div class="input-group">

                        <input type="text" id="txtnombre" name="txtnombre" value="" placeholder="Buscar por nombre..." 
                               class="form-control"/>&nbsp; &nbsp;

                        <input type="submit" id="btnbuscar" name="btnBuscar" value="Buscar" class="btn btn-primary"/><br><br>
                    </div>
                </div>
            </form>
            <hr/>
            <table class="table">
                <thead>
                    <tr id="titulos">
                        <th>Código</th>
                        <th>Nombre</th>
                        <th>Teléfono</th>
                        <th>Correo</th>
                        <th>Residencia</th>
                        <th>Opciones</th>
                    </tr>
                </thead>
                <tbody>

                    <%
                        String nombre = "";//LISTAMOS TODOS LOS CLIENTES EXISTENTES
                        String condicion = "";

                        if (request.getParameter("txtnombre") != null) {
                            nombre = request.getParameter("txtnombre");
                            condicion = "NOMBRE LIKE '%" + nombre + "%'";
                        }
                        LNCliente logica = new LNCliente();
                        List<Cliente> datos;
                        datos = logica.ListarRegistros(condicion);

                        for (Cliente registro : datos) {

                    %>

                    <tr>
                        <%String codigo = registro.getId();%><!--ESTE PROCESO SE REPETIRA DEPENDIENDO DEL NUMERO DE REGISTROS QUE TENGAMOS-->

                        <td><%= codigo%></td> 
                        <td><%= registro.getNombre()%></td>
                        <td><%= registro.getNumeroTelefonico()%></td>
                        <td><%= registro.getCorreoElectronico()%></td>
                        <td><%= registro.getResidencia()%></td>


                        <td>
                            <a href="Frm_Clientes.jsp?idCrearModificar=<%=codigo%>"><i class="fas fa-user-edit"></i></a> |
                            <a href="EliminarCliente?idEliminar=<%=codigo%>"><i class="fas fa-trash-alt"></i></a>
                        </td>
                    </tr>

                    <%}%> 
                </tbody>
            </table>
            <br>

            <%

                /* if(request.getParameter("mensajeServletEliminarCliente")!=null){
                    
                    out.print("<p class='text-danger'>"+ new String (request.getParameter("mensajeServletEliminarCliente").getBytes("ISO-8859-1"),"UTF-8")+"</p>"); */
            %>
            <a href="Frm_Clientes.jsp" class="btn btn-primary">Agregar Nuevo Cliente</a> 
            <a href="FrmListarClientes.jsp" class="btn btn-primary">Actualizar</a>
            <br><br>
          
        </div>
        <script src="lib/bootstrap/dist/js/bootstrap.bundle.min.js" type="text/javascript"></script>
    </body>
</html>





















