<%@page import="Entidades.Trabajadores"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="Logica.LNCliente"%>
<%@page import="Entidades.Cliente"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

        <!-- Agregamos los vínculos a Bootstrap y a nuestro archivo de estilos: -->
        <link href="lib/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <link href="css/estilos.css" rel="stylesheet" type="text/css"/>
        <title>Mantenimiento de Cliente</title>
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
            <div class="row">
                <div class="col-md-8 mx-auto">
                    <div class="card-header">
                        <h1>Mantenimiento de Trabajadores</h1>
                    </div>

                    <%
                        Trabajadores trabajadores;
                        trabajadores = new Trabajadores();
                        trabajadores.setId(request.getParameter("idCrearModificar"));
                    %>
                    <form action="CrearModificarTrabajador" method="post" id="form_AgregarModificar">
                        <div class="form-group">
                            <label for="txtCodigo" class="control-label">Identificacion</label>
                            <input type="txt" id="txtCodigo" name="txtCodigo" value="<%=trabajadores.getId()%>" class="form-control"/><br>
                        </div>
                        <div class="form-group">
                            <label for="txtNombre" class="control-label">Nombre</label>
                            <input type="txt" id="txtNombre" name="txtNombre" value="<%=trabajadores.getNombre()%>" class="form-control"/><br>
                        </div>
                        <div class="form-group">
                            <label for="txtTelefono" class="control-label">Teléfono</label>
                            <input type="txt" id="txtTelefono" name="txtTelefono" value="<%=trabajadores.getNumeroTelefonico()%>" class="form-control" placeholder="00-00-00-00"/><br>
                        </div>
                        <div class="form-group">
                            <label for="txtCorreo" class="control-label">Correo Electronico</label>
                            <input type="txt" id="txtCorreo" name="txtCorreo" value="<%=trabajadores.getCorreoElectronico()%>" class="form-control" placeholder="ejemplo@gmail.com"/><br>
                        </div>                     
                        <div class="form-group">
                            <label for="txtDireccion" class="control-label">Residencia</label>
                            <input type="txt" id="txtDireccion" name="txtDireccion" value="<%=trabajadores.getResidencia()%>" class="form-control"/><br>
                        </div>                      
                        <div class="form-group">
                            <div class="input-group">
                                <input type="submit" id="btnGuardar" value="Guardar" class="btn btn-primary"/> &nbsp;&nbsp;
                                <input type="button" id="btnRegresar" value="Regresar" onclick="location.href = 'FrmListarTrabajadores.jsp'" class="btn btn-secondary"/>
                            </div>
                        </div>
                    </form>
                </div> 
            </div> 
        </div> 

      
        <script src="lib/bootstrap/dist/js/bootstrap.bundle.min.js" type="text/javascript"></script>
        <script src="lib/jquery/dist/jquery.min.js" type="text/javascript"></script>
        <script src="lib/jquery-validation/dist/jquery.validate.min.js" type="text/javascript"></script>

        <script>                         
                                    $(document).ready(function () {
                                        $("#form_AgregarModificar").validate({
                             
                                            rules: {                                             
                                                txtNombre: {required: true, maxlength: 50},
                                                txtTelefono: {required: true, minlength: 8, maxlength: 11},                                          
                                                txtDireccion: {required: true, maxlength: 80}
                                            },                                    
                                            messages: {
                                                txtNombre: "El campo de Nombre es obligatorio (max 50 caracteres)",
                                                txtTelefono: "El campo Teléfono es obligatorio (mínimo 8 caracteres, máximo 11)",
                                                txtDireccion: "El campo Dirección es obligatorio (max 80 caracteres)"
                                            },
                                            errorElement: 'span'                                                
                                        });
                                    });                                
        </script>
    </body>
</html>
