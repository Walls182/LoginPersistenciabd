<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="ISO-8859-1">
        <meta charset="utf-8">
        <title>Entrar </title>
        <link rel="stylesheet" href="loginAdmin.css" />



    </head>
    <body>
        <h1>Por favor ingresa el usuario y contraseña</h1>
        <div class="con">
            <div class="img">
                <img  src="https://avalos.sv/wp-content/uploads/283-personalizar-imagen-wp-login.png"  style="width:20%"  >
            </div>


            <div class="search">
                <form action="LoginServlet" method="post">

                    <input  type="text" placeholder="Nombre de usuario" name="username" class="username" required><br>
                    <input  type="password" placeholder="Contraseña" name="password" class="password" required><br>
                    <input class="searchbtn" id="btn" type="submit" value="Ingresar">
                </form>
            </div>
        </div>
    </body>
</html>
