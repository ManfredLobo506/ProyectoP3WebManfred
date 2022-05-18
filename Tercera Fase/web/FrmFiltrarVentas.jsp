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

        <div class="container">
            <div class="card-header">
                <h1>Filtrar Ventas Por Mes</h1>
            </div>
            <br/>


            <form action="FiltrarVentas" method="post">

                <div class="form-group">
                    <div class="input-group">
                        <select name="mes"><!--SE MUESTRA EL MES Y CADA UNO DE ESTOS TENDRA UN VALOR PARA FILTRAR LAS VENTAS-->
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
                        <input type="submit" id="btnbuscar" name="btnBuscar" value="Buscar" class="btn btn-primary"/><br><br>
                    </div>
                </div>
            </form>
            <hr/>
            <tbody>
            <div><p>El total de ventas en el mes fue de :<%=request.getParameter("Total")%></p></div><!--AQUI MOSTRAMOS EL VALOR DEL RESULTADO DE LA FILTRACION -->


        </tbody>
        <br>
        <br><br>
        <a href="index2.html" class="btn btn-primary">Regresar</a>
    </div>
    <script src="lib/bootstrap/dist/js/bootstrap.bundle.min.js" type="text/javascript"></script>
</body>
</html>

