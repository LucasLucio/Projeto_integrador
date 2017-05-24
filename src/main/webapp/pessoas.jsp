<%-- 
    Document   : pessoas
    Created on : 23/05/2017, 13:06:46
    Author     : lukas
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Pessoas já cadastradas</title>
    </head>
    
    <body>
            <table style="width:100%">
        <tr>
            <th>ID_Pessoa</th>
            <th>rg</th> 
            <th>cpf</th>
            <th>telefone</th>
            <th>email</th>
            <th>idade</th>
            <th>sexo</th>
        </tr>
        <c:forEach var="usuario" items="${Usuario}" >
            <tr>
                <th>${usuario.idPessoa}</th>
                <th>${usuario.rg}</th> 
                <th>${usuario.cpf}</th>
                <th>${usuario.telefone}</th>
                <th>${usuario.email}</th>
                <th>${usuario.idade}</th>
                <th>${usuario.sexo}</th>
            </tr>
        </c:forEach>
    </body>
</html>
