<%-- 
    Document   : newjsp
    Created on : 31/03/2017, 08:43:39
    Author     : lucas
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title> Help Entertainment </title>
        <link rel="stylesheet" type="text/css" href="css/estilo_p1.css" />
        <meta charset="UTF-8">
        <script>

            function parallax() {
                // Declarando as var.
                var layer_log = document.getElementById('divlogin');
                var layer_bs = document.getElementById('divBusca');
                var layer_lt = document.getElementById('layer_lt');
                var layer_lg = document.getElementById('layer_lg');
                var layer_bv = document.getElementById('layer_bv');
                var layer_bl = document.getElementById('layer_bl');


                //Aplicando a posição
                layer_log.style.top = -(window.pageYOffset / 3) + 'px';
                layer_bs.style.top = -(window.pageYOffset / 3) + 'px';
                layer_lt.style.top = -(window.pageYOffset / 3) + 'px';
                layer_lg.style.top = -(window.pageYOffset / 3) + 'px';
                layer_bv.style.top = -(window.pageYOffset / 3) + 'px';
                layer_bl.style.top = -(window.pageYOffset / 3) + 'px';

            }
            window.addEventListener("scroll", parallax, false);

        </script>

    </head>
    <body>

        <h1>Bem-Vindo, Deslize para baixo para mais informaçoes...</h1>
        <section>
            <div id="divlogin" class="img-parallax">
                <a href="ServletListagem"><input id="btnlogin" type=button value="Listar Cadastros"></a>
                <a href="cadastro.jsp"><input id="btnCadastro" type=button value="Cadastrar"></a>
            </div>
            <form method="get" target="ServletBusca" action="index.jsp" autocomplete="off">
                <div id="divBusca" class="img-parallax">
                    <button id="btnBusca" type="submit">Buscar</button>
                    <input name ="busca" type="text" id="txtBusca" placeholder="Buscar Serviço..."/>
                </div>
            </form>
            <div id="layer_lt" class="img-parallax"></div>
            <div id="layer_bv" class="img-parallax"></div>
            <div id="layer_lg" class="img-parallax"></div>
            <div id="layer_bl" class="img-parallax"></div>
        </section>
        <%@include file="imports.jsp"%>
    </body>
</html>

