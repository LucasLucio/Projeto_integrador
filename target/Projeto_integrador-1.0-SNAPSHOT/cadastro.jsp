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
        
        <script type="text/javascript" src="scripts/jquery.mask.js">
        </script>
        
        
        <script type="text/javascript" >
            $(document).ready(function () {
                $('#Cadastro').validate({
                    rules: {
                        Nome: {
                            required: true
                        },
                        Login: {
                            required: true
                        },
                        Senha: {
                            required: true,
                            rengelength: [8, 16]
                        },
                        Email: {
                            required: true,
                            email: true
                        },
                        Telefone: {
                            required: true,
                        },
                        DataNascimento: {
                            required: true,
                        },
                        Sexo: {
                            required: true
                        },
                        RG: {
                            required: true,
                        },
                        CPF: {
                            required: true,
                        },
                        Cidade: {
                            required: true
                        }
                    },
                    messages: {
                        Nome: {
                            required: "Este campo é obrigatório"
                        },
                        Login: {
                            required: "Este campo é obrigatório"
                        },
                        Senha: {
                            required: "Este campo é obrigatório",
                            rengelength: "Insira uma senha de 8 a 16 caracteres"
                        },
                        Email: {
                            required: "Este campo é obrigatório",
                            email: "Insira um email válido"
                        },
                        Telefone: {
                            required: "Este campo é obrigatório",
                        },
                        DataNascimento: {
                            required: "Este campo é obrigatório",
                        },
                        Sexo: {
                            required: "Este campo é obrigatório"
                        },
                        RG: {
                            required: "Este campo é obrigatório",
                            number: "Este campo é numérico"
                        },
                        CPF: {
                            required: "Este campo é obrigatório",
                        },
                        Cidade: {
                            required: "Este campo é obrigatório"
                        }
                    }
                });
            });

        </script>  
        
        <script type="text/javascript">
            $(document).ready(function () {
                $("#tell").mask("(99)99999-9999");
                $("#nasc").mask("00/00/0000");
                $("#rg").mask("99.999.999-9");
                $("#cpf").mask("999.999.999-99");
            });
        </script> 

        </>

    </head>

    <body>
        <div>
            <form id="Cadastro" name="form" action="ServletCad" method="post">
                <input type="text" name="Nome" placeholder="Ex:Seu nome completo">
                <input type="text" name="Login" placeholder="Ex:SeuLogin">
                <input type="password" name="Senha" placeholder="Mínimo 8 caracteres">
                <input type="text" name="Email" placeholder="Ex:Seuemail@email.com">
                <input type="text" name="Telefone" id="tell" placeholder="Ex:(##)#####-####"><br/>
                <input type="text" name="DataNascimento" id="nasc" placeholder="Ex: ##/##/####"><br/>
                <input type="radio" name="Sexo" value="masc" checked>Masculino<br>
                <input type="radio" name="Sexo" value="fem">Feminino<br>
                <input type="radio" name="Sexo" value="other">Outro<br>
                <input type="text" name="RG" id="rg" placeholder="Ex:##.###.###-#"><br/>
                <input type="text" name="CPF" id="cpf" placeholder="Ex:###.###.###-##"><br/>
                <input type="text" name="Cidade" placeholder="Ex: #"><br/>
                <button id="btCriar" type="submit" name="criar" value="Criar">Cadastrar</button>
            </form>
        </div>

    </body>
</html>
