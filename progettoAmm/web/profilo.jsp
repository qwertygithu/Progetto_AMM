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
        <c:if test="${sessionScope.loggedIn==true}">
            <jsp:include page="menu.jsp"></jsp:include>
                <jsp:include page="sideSx.jsp"></jsp:include>


                    <div id="cont">
                            <div id="pic"> 
                                    <img alt="pic profilo" src="${utente.urlFotoProfilo}">
                            </div>
                                    <form action="profilo.html" method="post">
                                        <fieldset>
                                            <ul id="profilo">
                                                <li><label for="nomeLogin">Nome</label></li>
                                                <li><input type="text" name="nomeLogin" id="nomeLogin" value="${utente.nome}"></li>
                                                <li><label for="cognomeLogin">Cognome</label>
                                                <li><input type="text" name="cognomeLogin" id="cognomeLogin" value="${utente.cognome}">
                                                <li><label for="bday">Date</label></li>
                                                <li><input name="bday" type="date" value="${utente.data}"></li>
                                                <li><label for="corto">Frase di presentazione</label>
                                                <li><input type="text" name="corto" id="corto" value="${utente.frase}" /></li>
                                                <li><label for="pswdLogin">Password</label>
                                                <li><input type="password" name="pswdLogin" id="pswdLogin" value="${utente.password}"></li>
                                                <li><label for="pswdLogin">Conferma Password</label></li>
                                                <li><input type="password" name="pswdLogin" id="pswdLoginConfirm" value="${utente.password}"></li>
                                            </ul>
                                            <button type="submit">Invia</button>
                                        </fieldset>

                                    </form>
                    </div>
        </c:if>
            <c:if test="${sessionScope.loggedIn==false || sessionScope.loggedIn==null}">
            <div id="nonLog">
                Non sei loggato<br>
                vai a <a href="login.html">Login</a>
            </div>
            </c:if>
    </body>
</html>