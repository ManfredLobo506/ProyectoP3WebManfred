<%@page import="Logica.LNDetallefact"%>
<%@page import="Logica.LNFactura"%>
<%@page import="Logica.LNCliente"%>
<%@page import="Logica.LNProductos"%>
<%@page import="Servlets.Facturar"%>
<%@page import="Servlets.CancelarFactura2"%>
<%@page import="Servlets.EliminarDetalle2"%>

<%@page import="java.util.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="Logica.*"%>
<%@page import="Entidades.*"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <link href="lib/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <link href="lib/boostrap-datapicker/css/boostrap-datapicker3.standalone.min.css" rel="stylesheet" type="text/css"/>
        <link href="lib/fontawesome-free-5.14.0-web/css/all.min.css" rel="stylesheet" type="text/css"/>
        <link href="lib/DataTables/datatables.min.css" rel="stylesheet" type="text/css"/>
        <title>Facturacion</title>
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
                <div class="col-10"><h1>Facturación</h1></div>

            </div>
            <%
                int numFactura = -1;
                double total = 0;
                double Subtotal = 0;
                double Iva = 0;
                double Descuento = 0;
                double Descuento2 = 0;

                Factura entidad_F;
                LNFactura logica_F = new LNFactura();
                LNDetallefact logica_D = new LNDetallefact();
                List<DetalleFactura> DatosDetalle = null;
                if (request.getParameter("txtnumFactura") != null && Integer.parseInt(request.getParameter("txtnumFactura")) != -1) {
                    numFactura = Integer.parseInt(request.getParameter("txtnumFactura"));
                    entidad_F = logica_F.ObtenerRegistroFact("Num_factura = " + numFactura);
                    DatosDetalle = logica_D.ListarRegistros("Num_factura = " + numFactura);
                } else {
                    entidad_F = new Factura();
                    entidad_F.setIdFactura(-1);
                    Date fecha = new Date();
                    java.sql.Date fechasql = new java.sql.Date(fecha.getTime());
                    entidad_F.setFecha(fechasql);
                }
            %>
            <br/>
            <form action="Facturar" method="post">
                <div class="form-group float-right">
                    <div class="input-group">
                        <label for="txtnumFactura" class="form-control">Num. Factura</label>
                        <input type="text" id="txtnumFactura" name="txtnumFactura" value="<%=entidad_F.getIdFactura()%>"
                               readonly class="form-control"/>
                    </div>

                    <div class="input-group">
                        <label for="txtFechaFactura" class="form-control">Fecha</label>
                        <input type="text" id="txtFechaFactura" name="txtFechaFactura" readonly value="<%=entidad_F.getFecha()%>"
                               required class="datepicker form-control"/>
                    </div>
                </div>     
                <br/>
                <div class="form-group">
                    <div class="input-group">
                        <input type="hidden" id="txtIdCliente" name="txtIdCliente" value ="<%=entidad_F.getIdCliente()%>"
                               readonly="" class="form-control"/>
                        <input type="text" id="txtNombreCliente" name="txtNombreCliente" 
                               value ="<%=entidad_F.getNombreCliente()%>" readonly="" class="form-control"
                               placeholder="Seleccione un Cliente"/>&nbsp; &nbsp;

                        <a id="btnbuscar" class="btn btn-success" data-toggle="modal"
                           data-target="#buscarCliente"><i class="fas fa-search"></i></a>
                    </div>
                </div>
                <div class="form-group">
                    <div class="input-group">
                        <input type="hidden" id="txtIdTrabajador" name="txtIdTrabajador" value ="<%=entidad_F.getIdtrabajador()%>"
                               readonly="" class="form-control"/>
                        <input type="text" id="txtNombreTrabajador" name="txtNombreTrabajador" 
                               value ="<%=entidad_F.getNombreTrab()%>" readonly="" class="form-control"
                               placeholder="Seleccione un Trabajador"/>&nbsp; &nbsp;

                        <a id="btnbuscar" class="btn btn-success" data-toggle="modal"
                           data-target="#buscarTrabajadores"><i class="fas fa-search"></i></a>
                    </div>
                </div>
                <hr/>
                <div class="form-group">
                    <div class="input-group">
                        <input type="hidden" id="txtIdProducto" name="txtIdProducto" value="" readonly="" class="form-control"/>
                        <input type="text" id="txtdescripcion" name="txtdescripcion" value="" class="form-control" readonly
                               placeholder="Seleccione un producto"/> &nbsp; &nbsp;

                        <a id="btnBuscarP" class="btn btn-success" data-toggle="modal" data-target="#buscarProducto">
                            <i class="fas fa-search"></i></a> &nbsp; &nbsp;

                        <input type="number" id="txtcantidad" name="txtcantidad" value="" class="form-control"
                               placeholder="Cantidad"/>   &nbsp; &nbsp;
                        <input type="number" id="txtprecio" readonly="true" name="txtprecio" value="" class="form-control"
                               placeholder="Precio"/>   &nbsp; &nbsp;
                        <input type="number" id="txtexistencia" readonly name="txtexistencia" value="" class="form-control"
                               placeholder="Existencia"/>   &nbsp; &nbsp;
                        <input type="number" id="txtDescuento"  name="txtDescuento" value="0" class="form-control"
                               placeholder="Descuento"/>   &nbsp; &nbsp;
                    </div>
                </div>
                <br/>
                <div class="form-group">
                    <input type="submit" name="Guardar" id="btnGuardar" value="Agregar y Guardar" class="btn btn-primary"/>
                </div>
            </form>
            <hr/>
            <h5>Detalle de Factura</h5>
            <table id="DetalleFactura" class="table">
                <thead>
                    <tr>
                        <th>Código</th>
                        <th>Descripción</th>
                        <th>Cantidad</th>
                        <th>Precio</th>
                        <th>SubTotal</th>
                        <th>Eliminar</th>
                    </tr>
                </thead>
                <tbody>
                    <% if (DatosDetalle != null) {
                            for (DetalleFactura registroDetalle : DatosDetalle) {
                    %>
                    <tr>
                        <%
                            int numfactura = registroDetalle.getIdFactura();
                            String codigop = registroDetalle.getIdProducto();
                            String descripcion = new String(registroDetalle.getNombreProducto().getBytes("ISO-8859-1"), "UTF-8");
                            int cantidad = registroDetalle.getCantidad();
                            double precioV = registroDetalle.getPrecio();
                            Subtotal += (cantidad * precioV);
                            Factura fact = new Factura();
                            fact.setIdFactura(registroDetalle.getIdFactura());
                            Descuento2 = Subtotal * (entidad_F.getDescuento() / 100);
                            Iva = (Subtotal * 0.13);
                            total = ((Subtotal + Iva) - Descuento2);
                            LNFactura logica = new LNFactura();
                            logica.ModificarTotalFactura(fact, total);
                        %>
                        <td><%=codigop%></td>
                        <td><%=descripcion%></td>
                        <td><%=cantidad%></td>
                        <td><%=precioV%></td>
                        <td><%=cantidad * precioV%></td>
                        <td>
                            <a href="EliminarDetalle2?idproducto=<%=codigop%>&idfactura=<%=numfactura%>"> 
                                <i class="fas fa-trash-alt"></i></a>
                        </td>
                    </tr>
                    <%
                            } // cierre del for
                        } // cierre del if
                    %> 
                </tbody>
            </table>
            <div class="float-right">
                <p class="text-danger h5">SubTotal = <%=Subtotal%></p>
                <p class="text-danger h5">IVA = <%=Iva%></p>
                <p class="text-danger h5">Total = <%=total%></p>
            </div>
            <br><br>
            <%
                //mensaje generado en servlets facturas
                if (request.getParameter("msgFac") != null) {
                    out.print("<p class='text-danger'>" + new String(request.getParameter("msgFac").getBytes("ISO-8859-1"), "UTF-8") + "</p>");
                }
            %>
            <input type = "button" id="btnCancelar" value = "Realizar Facturación"
                   onclick="location.href = 'CancelarFactura2?txtnumFactura=' + <%=entidad_F.getIdFactura()%>"
                   class="btn btn-success"/> &nbsp; &nbsp;
            <a href="Frm_ListarFacturas.jsp" class="btn btn-secondary">Regresar</a>
        </div> 
        <!-- Modal de Trabajadores -->      
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
                        <table id="tablaClientes">
                            <thead>
                                <tr>
                                    <th>Código</th>
                                    <th>Nombre</th>
                                    <th>Seleccionar</th>
                                </tr>
                            </thead>
                            <tbody>
                                <%
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

        <!-- Modal de Clientes -->
        <div class="modal" id="buscarCliente" tabindex="1" role="dialog" aria-labelledby="tituloVentana">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 id="tituloVentaja">Buscar Cliente</h5>
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
                                    LNCliente logicaCliente = new LNCliente();
                                    List<Cliente> datosClientes;
                                    datosClientes = logicaCliente.ListarRegistros("");
                                    for (Cliente registroC : datosClientes) {
                                %>
                                <tr>
                                    <% String codigoCliente = registroC.getId();
                                        String nombreCliente = registroC.getNombre();%>
                                    <td><%= codigoCliente%></td>
                                    <td><%= nombreCliente%></td>
                                    <td>
                                        <a href="#" data-dismiss="modal"
                                           onclick="SeleccionarCliente('<%=codigoCliente%>', '<%= nombreCliente%>');">Seleccionar</a>
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


        <!-- Modal de Producto -->
        <div class="modal" id="buscarProducto" tabindex="1" role="dialog" aria-labelledby="tituloVentana">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 id="tituloVentana">Buscar Producto</h5>
                        <button class="close" data-dismiss="modal" aria-label="Cerrar" aria-hidden="true" onclick="LimpiarProducto()">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                    <div class="modal-body">
                        <table id="tablaProductos">
                            <thead>
                                <tr>
                                    <th>Código</th>
                                    <th>Descripción</th>
                                    <th>Precio</th>
                                    <th>Seleccionar</th>
                                </tr>
                            </thead>
                            <tbody>
                                <%
                                    LNProductos logicaProducto = new LNProductos();
                                    List<Productos> datosProductos;
                                    datosProductos = logicaProducto.ListarRegistros("");
                                    for (Productos registroP : datosProductos) {
                                %>
                                <tr>
                                    <% String codigoProducto = registroP.getIdProducto();
                                        String nombreProducto = registroP.getDescripcion();
                                        double precio = registroP.getPrecioVenta();
                                        double existencia = registroP.getCantidad();
                                    %>
                                    <td><%= codigoProducto%></td>
                                    <td><%= nombreProducto%></td>
                                    <td><%= precio%></td>
                                    <td>
                                        <a href="#" data-dismiss="modal"
                                           onclick="SeleccionarProducto('<%=codigoProducto%>', '<%= nombreProducto%>', '<%= precio%>', '<%= existencia%>');">Seleccionar</a>
                                    </td>
                                </tr>
                                <%}%>
                            </tbody>
                        </table>
                    </div> 
                    <div class="modal-footer">
                        <button class="btn btn-warning" type="button" data-dismiss="modal" onclick="LimpiarProducto()">
                            Cancelar
                        </button>
                    </div>
                </div> 
            </div> 
        </div> <!-- Modal -->

        <script src="lib/jquery/dist/jquery.min.js" type="text/javascript"></script>
        <script src="lib/bootstrap/dist/js/bootstrap.bundle.min.js" type="text/javascript"></script>
        <script src="lib/bootstrap-datepicker/js/bootstrap-datepicker.min.js" type="text/javascript"></script>
        <script src="lib/bootstrap-datepicker/locales/bootstrap-datepicker.es.min.js" type="text/javascript"></script>
        <script src="lib/DataTables/datatables.min.js" type="text/javascript"></script>
        <script src="lib/DataTables/DataTables-1.10.21/js/dataTables.bootstrap4.min.js" type="text/javascript"></script>
        <script>
                            //cuando el documento este listo
                            //carge las sigueintes funciones
                            $(document).ready(function () {
                                $('.datepicker').datepicker({
                                    format: 'yyyy-mm-dd',
                                    autoclose: true,
                                    lenguage: 'es'
                                });

                                $('#tablaClientes').dataTable({
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

                                $('#tablaProductos').dataTable({
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

                            function SeleccionarCliente(idCliente, nombreCliente) {
                                $("#txtIdCliente").val(idCliente);
                                $("#txtNombreCliente").val(nombreCliente);
                            }
                            function SeleccionarTrab(codigoTrab, nombreCliente) {
                                $("#txtIdTrabajador").val(codigoTrab);
                                $("#txtNombreTrabajador").val(nombreCliente);
                            }
                            function SeleccionarProducto(idProducto, Descripcion, Precio, Existencia) {
                                $("#txtIdProducto").val(idProducto);
                                $("#txtdescripcion").val(Descripcion);
                                $("#txtprecio").val(Precio);
                                $("#txtexistencia").val(Existencia);
                                $("#txtcantidad").focus();
                            }
                            function Limpiar() {
                                $("#txtIdCliente").val("");
                                $("#txtNombreCliente").val("");
                            }
                            function LimpiarProducto() {
                                $("#txtIdProducto").val("");
                                $("#txtdescripcion").val("");
                                $("#txtprecio").val("");
                                $("#txtexistencia").val("");
                            }
        </script>
    </body>
</html>
