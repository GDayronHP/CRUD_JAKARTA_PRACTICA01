<%@ page import="com.tecsup.prj_fastquiz.modelo.entities.User" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<%
    HttpSession misesion = request.getSession();
    if (misesion.getAttribute("eladministrador") == null) {
        response.sendRedirect("error.jsp");
    } else {
        User adm = (User) misesion.getAttribute("eladministrador");
        String nombre = adm.getName();
%>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Nueva Pregunta</title>
</head>
<body>
<jsp:include page="master.jsp" />

<div class="container p-4" style="margin-top:70px;">
    <div class="row">
        <div class="col-md-6 mx-auto">
            <div class="card text-center">
                <div class="card-header">
                    <h3 class="text-uppercase">CREAR PREGUNTA</h3>
                </div>
                <div class="card-body">
                    <form action="iaQuestionController" method="POST">
                        <div class="input-group mt-2">
                            <label class="input-group-text">Texto de la Pregunta:</label>
                            <input class="form-control" type="text" name="txtQuestionText" placeholder="Texto de la Pregunta" required>
                        </div>

                        <div class="input-group mt-2">
                            <label class="input-group-text">Límite de Tiempo:</label>
                            <input class="form-control" type="text" name="txtTimeLimit" placeholder="Límite de Tiempo" required>
                        </div>

                        <div class="input-group mt-2">
                            <label class="input-group-text">ID del Quiz:</label>
                            <input class="form-control" type="text" name="txtQuizId" placeholder="ID del Quiz" required>
                        </div>

                        <div class="input-group mt-2">
                            <label class="input-group-text">ID del Tipo de Pregunta:</label>
                            <input class="form-control" type="text" name="txtQuestionTypeId" placeholder="ID del Tipo de Pregunta" required>
                        </div>

                        <div class="form-group mt-4 d-grid gap-2">
                            <input name="accion" type="hidden" value="insertar"/><br/>
                            <input class="btn btn-success" type="submit" value="Insertar"/>
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
