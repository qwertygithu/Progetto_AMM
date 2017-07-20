<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<div id="sideSx">
			<div class="box">
				<div class="boxTitle" >
					<h3>Persone</h3>
				</div>
				<div class="boxCont">
					<ul id="imageListPersone">
                                            <c:forEach var="tmp" items="${listUt}">
                                                <c:set var="pTmp" value="${tmp}" scope="request"></c:set>
                                                <c:if test="${sessionScope.loggedUserID!=tmp.id}">
                                                    <li><h4><a href="bacheca.html?QWERTY=${tmp.id}"> <img alt="pic" src="${tmp.urlFotoProfilo}"> ${tmp.nome} ${tmp.cognome}</a></h4></li>
                                                </c:if>
                                             </c:forEach>
					</ul>
				</div>
			</div>
			<div class="box">
				<div class="boxTitle" id="imgTitleGruppi">
					<h3>Gruppi</h3>
				</div>
				<div class="boxCont">
					<ul id="imageListgruppi">
					    <c:forEach var="tmpG" items="${listaGruppi}">
                                                <c:set var="gTmp" value="${tmpG}" scope="request"></c:set>
                                                
                                                <li><h4><a href="bacheca.html?GRUPPI=${tmpG.id}"> <img alt="pic" src="${tmpG.urlIcona}"> ${tmpG.nome}</a></h4></li>
                                                
                                             </c:forEach>
                                            
                                            
                                            
                                            
                                            
                                            <!--
                                                <li><h4><a href="bacheca.html?GRUPPI=45">Mongolfieristi</a></h4></li>
						<li><h4><a href="bacheca.html?GRUPPI=46"">Ritardatari</a></h4></li>
						<li><h4><a href="bacheca.html?GRUPPI=47"">Musicisti</a></h4></li>
						<li><h4><a href="bacheca.html?GRUPPI=48"">Lettura</a></h4></li>
						-->
					</ul>
				</div>
			</div>
		</div>