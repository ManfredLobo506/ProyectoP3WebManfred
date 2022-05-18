<%@page import="Entidades.Trabajadores"%>
<%@page import="Logica.LNTrabajadores"%>
<%@page import="Logica.LNFactura"%>
<%@page import="Entidades.Factura"%>
<%@page import="java.util.List"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="lib/bootstrap-datepicker/css/bootstrap-datepicker3.standalone.min.css" rel="stylesheet" type="text/css"/>
        <link href="lib/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <link href="lib/fontawesome-free-5.14.0-web/css/all.min.css" rel="stylesheet" type="text/css"/>
        <title>Ventas</title>
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

        <div class="container">  <!-- container y card-header son clases de BOOTSTRAP -->
            <div class="card-header">
                <h1>Filtrar Ventas Por Mes</h1>
            </div>
            <br/>


            <form action="FiltrarVentasTrab" method="post">

                <div class="form-groupTrab">
                    <div class="input-group">


                        <select name="mes">
                            <option value=1>Enero</option>
                            <option value=2>Febrero</option>
                            <option value=3>Marzo</option>
                            <option value=4>Abril</option>
                            <option value=5>Mayo</option>
                            <option value=6>Junio</option>
                            <option value=7>Julio</option>
                            <option value=8>Agosto</option>
                            <option value=9>Septiembre</option>
                            <option value=10>Octubre</option>
                            <option value=11>Noviembre</option>
                            <option value=12>Diciembre</option>
                        </select>
                    </div>
                </div>
                <br><br>
                <div class="form-group">
                    <div class="input-group">
                        <input type="text" id="txtIdTrabajador" name="txtIdTrabajador" value ="" placeholder="INGRESE EL ID DEL TRABAJADOR"
                               class="form-control"/>
                        <a id="btnbuscarTrab" class="btn btn-success" data-toggle="modal"
                           data-target="#buscarTrabajadores"><i class="fas fa-search"></i></a>

                    </div>
                </div>
                <br><br>
                <input type="submit" id="btnbuscar" name="btnBuscar" value="Buscar" class="btn btn-primary"/><br><br>
            </form>
            <hr/>


            <tbody>




            <div><p>El total de ventas en el mes fue de :<%=request.getParameter("Total")%></p></div>


        </tbody>
        <br>
        <br><br>
        <a href="index2.html" class="btn btn-primary">Regresar</a>
    </div>
    <script src="lib/bootstrap/dist/js/bootstrap.bundle.min.js" type="text/javascript"></script>


 <!--CREAMOS UN MODAL PARA QUE EL USUARIO TENGA MAS FACILIDAD A LA HORA DE LA SELECCION DEL ID-->
    <div class="modal" id="buscarTrabajadores" tabindex="1" role="dialog" aria-labelledby="tituloVentana">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 id="tituloVentaja">Buscar Trabajador</h5>
                    <button class="close" data-dismiss="modal" aria-label="Cerrar" aria-hidden="true" onclick="Limpiar()">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body">
                    <table id="tablaClientes2">
                        <thead>
                            <tr>
                                <th>Código</th>
                                <th>Nombre</th>
                                <th>Seleccionar</th>
                            </tr>
                        </thead>
                        <tbody>
                            <%
                                //LISTAMOS TODOS LOS TRABAJADORES DISPONIBLES
                                LNTrabajadores logicaTrab = new LNTrabajadores();
                                List<Trabajadores> datostrab;
                                datostrab = logicaTrab.ListarRegistros("");
                                for (Trabajadores registroC : datostrab) {
                            %>
                            <tr>
                                <% String codigoTrab = registroC.getId();
                                        String nombreTrab = registroC.getNombre();%>
                                <td><%= codigoTrab%></td>
                                <td><%= nombreTrab%></td>
                                <td>
                                    <a href="#" data-dismiss="modal"
                                       onclick="SeleccionarTrab('<%=codigoTrab%>', '<%= nombreTrab%>');">Seleccionar</a>
                                </td>
                            </tr>
                            <%}%>
                        </tbody>
                    </table>
                </div> 
                <div class="modal-footer">
                    <button class="btn btn-warning" type="button" data-dismiss="modal" onclick="Limpiar()">
                        Cancelar
                    </button>
                </div>
            </div> 
        </div> 
    </div> 

    <script src="lib/jquery/dist/jquery.min.js" type="text/javascript"></script>
    <script src="lib/bootstrap/dist/js/bootstrap.bundle.min.js" type="text/javascript"></script>
    <script src="lib/bootstrap-datepicker/js/bootstrap-datepicker.min.js" type="text/javascript"></script>
    <script src="lib/bootstrap-datepicker/locales/bootstrap-datepicker.es.min.js" type="text/javascript"></script>
    <script src="lib/DataTables/datatables.min.js" type="text/javascript"></script>
    <script src="lib/DataTables/DataTables-1.10.21/js/dataTables.bootstrap4.min.js" type="text/javascript"></script>

    <script>
     //FUNCIONES UTILIZADAS
        $(document).ready(function () {
            $('.datepicker').datepicker({
                format: 'yyyy-mm-dd',
                autoclose: true,
                lenguage: 'es'
            });

       
            $('#tablaClientes2').dataTable({
                "lenghtMenu": [[5, 15, 15, -1], [5, 10, 15, "All"]],
                "language": {
                    "info": "Pagina _PAGE_ de _PAGES_",
                    "infoEmpty": "No existen Registros disponibles",
                    "zeroRecords": "No se encuentran registros",
                    "search": "Buscar",
                    "infoFiltered": "",
                    "lenghtMenu": "Mostrar _MENU_ Registro",
                    "paginate": {
                        "first": "Primero",
                        "last": "Ultimo",
                        "next": "Siguiente",
                        "previous": "Anterior"
                    }
                }
            });

          
        });//final del function

      
        function SeleccionarTrab(codigoTrab, nombreCliente) {
            $("#txtIdTrabajador").val(codigoTrab);
            $("#txtNombreTrabajador").val(nombreCliente);
        }
      
        function Limpiar() {
            $("#txtIdCliente").val("");
            $("#txtNombreCliente").val("");
        }
       
    </script>

</body>
</html>

