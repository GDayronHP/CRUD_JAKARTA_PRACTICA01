<%@ page import="com.tecsup.prj_fastquiz.modelo.entities.User" %>
<%@ page import="com.tecsup.prj_fastquiz.services.IAAnswersService" %>
<%@ page import="com.tecsup.prj_fastquiz.services.impl.IAAnswersServiceImpl" %>
<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<%
    HttpSession misesion = request.getSession();
    if (misesion.getAttribute("eladministrador") == null) {
        response.sendRedirect("error.jsp");
    } else {
        User adm = (User) misesion.getAttribute("eladministrador");
        IAAnswersService servicio = new IAAnswersServiceImpl(); // Servicio para manejar las respuestas
%>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Insertar Nueva Respuesta</title>
</head>
<body>

<div class="container" style="margin-top:70px;">
    <div class="row mt-5">
        <jsp:include page="master.jsp" />

        <h1>Insertar Nueva Respuesta</h1>
        <form action="iaAnswerController" method="POST">
            <div class="input-group mt-2">
                <label class="input-group-text">Texto de Respuesta:</label>
                <input class="form-control" type="text" name="txtAnswerText" required>
            </div>
            <div class="input-group mt-2">
                <label class="input-group-text">¿Es Correcta?</label>
                <select class="form-control" name="chkIsCorrect">
                    <option value="true">Sí</option>
                    <option value="false">No</option>
                </select>
            </div>
            <div class="input-group mt-2">
                <label class="input-group-text">ID de Pregunta:</label>
                <input class="form-control" type="number" name="txtQuestionId" required>
            </div>
            <div class="form-group mt-4 d-grid gap-2">
                <input name="accion" type="hidden" value="insertar">
                <input class="btn btn-success" type="submit" value="Insertar">
            </div>
        </form>
    </div>
</div>
</body>
<% } %>
</html>
