<%-- 
    Document   : BemVindo
    Created on : 22/06/2017, 23:49:38
    Author     : lukas
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
</head>
<c:set var="username" scope="session" value="${session}"></c:set>
<c:if test="${sessionScope.username == null}">
    <c:redirect url="index.jsp"></c:redirect>
</c:if>
<body>
    <h1>Bem vindo</h1>
    <c:if test="${sessionScope.username != null}">
        <c:out value="Bem-Vindo ${sessionScope.username}!" />
    </c:if>
    <br>