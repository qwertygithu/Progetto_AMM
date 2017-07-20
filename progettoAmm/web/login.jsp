
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>

<html>
    <head>
        <title>NerdBook: social per nerd </title>
        
		<link rel="stylesheet" type="text/css" href="style.css" media="screen">
		<link rel="stylesheet" type="text/css" href="style1024.css" media="screen">
		<link rel="stylesheet" type="text/css" href="style480-1024.css" media="screen">
		<link rel="stylesheet" type="text/css" href="style480.css" media="screen">
        <meta charset="UTF-8">
        <meta name="viewport" 
              content="width=device-width,
              initial-scale=1.0">
        <meta name="author"
              content="Samuele Deriu">
        <meta name="keywords"
              content="Nerd social amicizie ">
    </head>
    <body>
		<div id="modulo">
			<div id="headerModulo">
				<div id="imgHeaderLogin">
					<div>
					</div>
				</div>
				<div id="titleLogin">
					<h1>NerdBook</h1>
				</div>
			</div>
			<div id="contmodulo">
				<form action="login.html" method="post">
					<ul id="login">
						<li>
							<label for="nomeLogin">Nome</label>
							<input type="text" name="nomeLogin" id="nomeLogin" value="Inserisci qui il tuo nome">
						</li>
						<li>
							<label for="pswdLogin">Password</label>
							<input type="password" name="pswdLogin" id="pswdLogin" value="oscurato">
						</li>
                                                <c:if test="${invalidData==true }">
                                                    <li>
                                                        <label>Riprova, Username o Password errate.</label>
                                                    </li>
                                                </c:if>
						
					</ul>
					<button type="submit">Accedi</button>
				</form>
			</div>
		</div>
    </body>
</html>
