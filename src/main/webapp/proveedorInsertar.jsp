<%@ page import="com.tecsup.prj_fastquiz.modelo.entities.Administrador" %>
<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<%
    HttpSession misesion = request.getSession();
    if(misesion.getAttribute("eladministrador") == null){
        response.sendRedirect("error.jsp");
    } else {
        Administrador adm = (Administrador) misesion.getAttribute("eladministrador");
        String nombre = adm.getNombres() + " " + adm.getApellidos();
%>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Nuevo Proveedor</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
</head>
<body>
<jsp:include page="master.jsp" />

<div class="container p-4" style="margin-top:70px;">
    <div class="row">
        <div class="col-md-8 mx-auto">
            <div class="card text-center">
                <div class="card-header">
                    <h3 class="text-uppercase">Crear Proveedor</h3>
                </div>
                <div class="card-body">
                    <form action="pController" method="post">
                        <div class="input-group mt-2">
                            <label class="input-group-text">Código:</label>
                            <input class="form-control" type="text" name="txtCodigo" placeholder="Código"
                                   autofocus required>
                        </div>

                        <div class="input-group mt-2">
                            <label class="input-group-text">Razón Social:</label>
                            <input class="form-control" type="text" name="txtRazonSocial" placeholder="Razón Social"
                                   required>
                        </div>

                        <div class="input-group mt-2">
                            <label class="input-group-text">Dirección:</label>
                            <input class="form-control" type="text" name="txtDireccion" placeholder="Dirección"
                                   required>
                        </div>

                        <div class="input-group mt-2">
                            <label class="input-group-text">Teléfono:</label>
                            <input class="form-control" type="number" name="txtTelefono" placeholder="Teléfono"
                                   required>
                        </div>

                        <div class="input-group mt-2">
                            <label class="input-group-text">Código Distrito:</label>
                            <input class="form-control" type="text" name="txtCodigoDistrito" placeholder="Código Distrito"
                                   required>
                        </div>

                        <div class="input-group mt-2">
                            <label class="input-group-text">Representante:</label>
                            <input class="form-control" type="text" name="txtRepresentante" placeholder="Representante"
                                   required>
                        </div>

                        <div class="form-group mt-4 d-grid gap-2">
                            <!-- Se incluye un campo oculto para especificar la acción -->
                            <input name="accion" type="hidden" value="insertar"/>
                            <input class="btn btn-success" type="submit" value="Insertar"/>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
<% } %>