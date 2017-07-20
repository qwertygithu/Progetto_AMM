<%-- 
    Document   : post
    Created on : 23-mag-2017, 12.26.14
    Author     : Sam
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="style.css" media="screen">
        <link rel="stylesheet" type="text/css" href="style1024.css" media="screen">
        <link rel="stylesheet" type="text/css" href="style480-1024.css" media="screen">
        <link rel="stylesheet" type="text/css" href="style480.css" media="screen">
    </head>
    <body>
       <div class="statoUtenti">
        
            <div class="nomeUtente" >
                <div>
                    <img alt="pic" src="${pTmp.utentePost.urlFotoProfilo}">
                </div>
                <h4>${pTmp.utentePost.nome} ${pTmp.utentePost.cognome}</h4>
            </div>
            
            <div class="testoPost">
                    ${pTmp.text}
            </div>
            
            <c:if test="${pTmp.urlFoto!='' && pTmp.urlFoto!=null}">
                <div class="testoPost" >
                    <img alt="Foto Post" src="${pTmp.urlFoto}" class="pippo">
                </div>
            </c:if>
            
            <c:if test="${pTmp.link!='' && pTmp.link!=null}">
                <div class="testoPost">
                    <a href="${pTmp.link}"> ${pTmp.link}</a>
                </div>
            </c:if>
            
    </div>
    </body>
</html>
