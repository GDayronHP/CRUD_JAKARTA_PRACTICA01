<%@ page import="com.tecsup.prj_educacion.modelo.entities.User" %>
<%@ page import="com.tecsup.prj_educacion.services.IAQuestionService" %>
<%@ page import="com.tecsup.prj_educacion.services.impl.IAQuestionServiceImpl" %>
<%@ page import="com.tecsup.prj_educacion.modelo.entities.IAQuestion" %>
<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<%
    HttpSession misesion = request.getSession();
    if (misesion.getAttribute("eladministrador") == null) {
        response.sendRedirect("error.jsp");
    } else {
        User adm = (User) misesion.getAttribute("eladministrador");
        String nombre = adm.getName();

        String sid = request.getParameter("id"); // Obtener el ID de la pregunta a eliminar
        IAQuestionService servicio = new IAQuestionServiceImpl();
        IAQuestion question = servicio.buscar(Integer.parseInt(sid)); // Obtener la pregunta para mostrar detalles
%>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Eliminar Pregunta</title>
</head>
<body>
<jsp:include page="master.jsp" />

<div class="container p-4" style="margin-top:70px;">
    <div class="row">
        <div class="col-md-6 mx-auto">
            <div class="card text-center">
                <div class="card-header">
                    <h3 class="text-uppercase">ELIMINAR PREGUNTA</h3>
                </div>
                <div class="card-body">
                    <form action="iaQuestionController" method="POST">
                        <div class="alert alert-warning">
                            <strong>Advertencia!</strong> ¿Estás seguro de que deseas eliminar la pregunta con ID: <%= sid %> y texto: "<%= question.getQuestionText() %>"?
                        </div>

                        <input type="hidden" name="txtId" value="<%= sid %>"/>

                        <div class="form-group mt-4 d-grid gap-2">
                            <input name="accion" type="hidden" value="eliminar"/><br/>
                            <input class="btn btn-danger" type="submit" value="Eliminar"/>
                        </div>
                        <div class="form-group mt-2 d-grid gap-2">
                            <a href="IAQuestionMan.jsp" class="btn btn-secondary">Cancelar</a>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
<% } %>
</body>
</html>
