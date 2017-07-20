
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<div id="header">
            <div id="title">
                <h1>NerdBook</h1>
            </div>
			<nav class="menuNav">
				<ul>
					<li><a href="profilo.html">Profilo</a></li>
                                        <li><a href="bacheca.html">Bacheca</a></li>
                                        <!--<li><a href="descrizione.html">Descrizione</a></li> -->
				</ul>
			</nav>
			<div id="login">
				<ul>
                                    <li><h4>${utente.nome}</h4></li>
					<li><a href="logout.html">Logout</a></li>
				</ul>
			</div>
        </div>