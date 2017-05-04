<%-- 
    Document   : cadastro
    Created on : 28/04/2017, 00:56:27
    Author     : lukas
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cadastro</title>
        <link rel="stylesheet" type="text/css" href="css/Estilo_cad.css" />
    </head>

    <body>
        <div>
            <form name="form" action="ServletCad" method="post">
                <input type="text" name="Id" placeholder="Insira seu Id"><br/>
                <input type="text" name="RG" placeholder="Insira seu Rg"><br/>
                <input type="text" name="CPF" placeholder="Insira seu Cpf"><br/>
                <input type="text" name="Telefone" placeholder="Insira seu Telefone"><br/>
                <input type="text" name="Email" placeholder="Insira seu Email"><br/>
                <input type="text" name="Idade" placeholder="Insira sua Idade"><br/>
                <input type="text" name="Sexo" placeholder="Isira seu Sexo"><br/>
                <button id="btCriar" type="submit" name="criar" value="Criar">Cadastrar</button>
            </form>
        </div>

    </body>
</html>
