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
        IAQuestionService servicio = new IAQuestionServiceImpl(); // Servicio para manejar las preguntas
%>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Mantenimiento de Preguntas! <%= nombre %></title>
</head>
<body>

<div class="container" style="margin-top:70px;">
    <div class="row mt-5">

        <jsp:include page="master.jsp" />

        <h1>Mantenimiento de Preguntas!</h1>
        <div style="padding: 10px;">
            <button class="btn btn-danger"><a class="nav-link link-light" aria-current="page" href="IAQuestionInsertar.jsp"> Nueva Pregunta</a></button>
        </div>

        <table class="table table-dark table-hover">
            <tr align="center">
                <th>ID</th>
                <th>Pregunta</th>
                <th>Tiempo Límite</th>
                <th>Quiz ID</th>
                <th>Tipo de Pregunta ID</th>
                <th>ACCIONES</th>
            </tr>
            <% for (IAQuestion question : servicio.listar()) { %>
            <tr>
                <td><%= question.getId() %></td>
                <td><%= question.getQuestionText() %></td>
                <td><%= question.getTimeLimit() %></td>
                <td><%= question.getQuizId() %></td>
                <td><%= question.getQuestionTypeId() %></td>
                <td>
                    <a class="btn btn-warning" href="IAQuestionEliminar.jsp?id=<%= question.getId() %>">
                        <i class="fa-solid fa-trash"></i>Borrar</a>
                    <a class="btn btn-danger" href="IAQuestionActualizar.jsp?id=<%= question.getId() %>">
                        <i class="fa-solid fa-pencil"></i>Actualizar</a>
                </td>
            </tr>
            <% } %>
        </table>
    </div>
</div>
</body>
<% } %>
</html>
