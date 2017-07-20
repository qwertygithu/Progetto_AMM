<%-- 
    Document   : bacheca
    Created on : 16-mag-2017, 13.55.46
    Author     : Sam
--%>

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
                        <!--modulo di inserimento Post-->
                        <div id="inserPost">
                            <c:choose>
                                <c:when test="${empty newpost}">
                                    <form action="bacheca.html" method="post">
                                        <ul>
                                            <!--picPost-->
                                            <div id="imgNewPost">
                                                <img alt="pic" src="${utente.urlFotoProfilo}">
                                            </div>
                                            <!--testoPost-->
                                            <li>
                                                <input type="text" name="testoPost" id="testoPost" value="Testo nuovo post">
                                            </li>
                                            <!--linkPost che sara un immagine -->
                                            <li>    
                                                <input type="text" name="urlPost" id="urlPost" value="URL allegato">
                                            </li>
                                            <li>
                                                <label for="radImg">Immagine</label><input type="radio" id="radImg" name="tipoPost" value="imm">
                                                <label for="radLink">Link</label><input type="radio" id="radLink" name="tipoPost" value="link" checked="checked">
                                            </li>
                                        </ul>
                                            
                                            <c:if test="${requestScope.QWERTY!=null}">
                                                <input type="hidden" name="QWERTY" value="${requestScope.QWERTY}">
                                            </c:if>
                                            <c:if test="${requestScope.QWERTY==null}">
                                                <input type="hidden" name="QWERTY" value="${sessionScope.loggedUserID}">
                                            </c:if> 
                                           <!-- -->
                                            <button type="submit" name="thereIsPost" value="needConfirm">Crea post</button>
                                    </form>
                                </c:when>
                                <c:otherwise>
                                    <form action="bacheca.html" method="post">
                                        <label>Hai inserito il post nella bacheca di ${utenteBachecaAttuale.nome}</label>
                                        <c:if test="${requestScope.QWERTY!=null}">
                                            <input type="hidden" name="QWERTY" value="${requestScope.QWERTY}">
                                        </c:if>
                                        <c:if test="${requestScope.QWERTY==null}">
                                            <input type="hidden" name="QWERTY" value="${sessionScope.loggedUserID}">
                                        </c:if> 
                                        <button type="submit" name="thereIsPost" value="Confirmed">Ok</button>
                                    </form>
                                </c:otherwise>
                            </c:choose>
                        </div>
                        
                        <!--stampa i post nella bacheca-->
                        <c:forEach var="tmp" items="${l}"  >
                            <c:set var="pTmp" value="${tmp}" scope="request"></c:set>
                            <c:if test="${QWERTY==tmp.idAutore}">
                                <jsp:include page="post.jsp"></jsp:include>
                            </c:if>
                        </c:forEach>
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