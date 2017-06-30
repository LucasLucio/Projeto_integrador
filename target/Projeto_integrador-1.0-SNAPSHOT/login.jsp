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
        
        <script type="text/javascript" src="http://ajax.aspnetcdn.com/ajax/jQuery/jquery-3.2.1.min.js">
        </script>    
        <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.16.0/jquery.validate.min.js">
        </script>
        <script type="text/javascript">
            $(document).ready(function (){
                $('#Log').validate({
                 rules:{
                     Login:{
                         required: true
                     },
                     Senha:{
                         required: true
                     }
                 },
                 messages:{
                     Login:{
                         required: "Este campo não pode ficar vazio"
                     },
                     Senha:{
                         required: "Este campo não pode ficar vazio"
                     }
                 }
                });
            });
                    
        </script>  
        
    </head>

    <body>
        <div>
            <form id="Log" name="form" action="ServletLogin" method="post">
                <input type="text" name="Login" placeholder="Ex: SeuLogin"><br/>
                <input type="password" name="Senha"><br/>
                <button id="btEntrar" type="submit" name="entrar" value="Entrar">Entrar</button>
            </form>
        </div>

    </body>
</html>
