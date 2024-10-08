<%@ page import="com.tecsup.prj_educacion.modelo.entities.User" %>
<%@ page import="com.tecsup.prj_educacion.services.CursoService" %>
<%@ page import="com.tecsup.prj_educacion.services.impl.CursoServiceImpl" %>
<%@ page import="com.tecsup.prj_educacion.modelo.entities.Curso" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<%
    HttpSession misesion = request.getSession();
    if(misesion.getAttribute("eladministrador")==null){
        response.sendRedirect("error.jsp");
    }else{
        User adm = (User)misesion.getAttribute("eladministrador");
        String nombre = adm.getName();
        String sid= request.getParameter("id");
        CursoService servicio = new CursoServiceImpl();
        Curso curso = servicio.buscar(sid);
%>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Distrito Eliminar - <%=nombre %> </title>
</head>
<body>
<jsp:include page="master.jsp" />

<div class="container p-4" style="margin-top:70px ;">
    <div class="row">
        <div class="col-md-4 mx-auto">
            <div class="card text-center">
                <div class="card-header">
                    <h3 class="text-uppercase">ELIMINAR CLIENTE</h3>
                </div>
                <div class="card-body">
                    <form action="cController">
                        <div class="input-group mt-2">
                            <label class="input-group-text">Còdigo</label>
                            <input class="form-control" type="text" name="txtCodigo"
                                   value="<%=curso.getCodigo() %>" readonly>
                        </div>

                        <div class="input-group mt-2">
                            <label  class="input-group-text">Nombre</label>
                            <input class="form-control" type="text" name="txtNombre"
                                   value="<%=curso.getNombre() %>" readonly>
                        </div>

                        <div class="input-group mt-2">
                            <label class="input-group-text">Credito</label>
                            <input class="form-control" type="text" name="txtCreditos" id="txtCreditos"
                                   value="<%=curso.getCreditos() %>" readonly>
                        </div>

                        <div class="form-group mt-4 d-grid gap-2">
                            <input name="accion" type="hidden" value="eliminar"/><br/>
                            <input class="btn btn-success" type="submit" value="eliminar"/>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
<% } %>

</html>