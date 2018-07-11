<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" type="text/css" href="/static/css/application.css">
    <link rel="icon" type="image/png" href="/static/favicon.png" />
    <script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
    <script src="/static/js/recherche.js"></script>
    <title>Chargement clients</title>
</head>
<body>
	<header id="header">
		<img alt="Cocktails" src="${pageContext.request.contextPath}/static/cocktails.png" />
		<h1>Spring bar</h1>
	</header>
	<section id="content">
		<h1>Informations client</h1>
		<c:if test="${not empty modification}">
			<p class="success">Le client a été modifié avec succès.</p>
		</c:if>
		<br />
		<strong>Client n<sup>o</sup> ${client.id}</strong>
		<ul>
			<li><label>Titre :</label> ${client.titre.libelle}</li>
			<li><label>Nom :</label> ${client.nom}</li>
			<li><label>Email :</label> ${client.email}</li>
			<li><label>Date de naissance :</label> <fmt:formatDate value="${client.dateNaissance}" pattern="dd MMMM yyyy"/></li>
		</ul>
		<p><a href="<c:url value="/client/modification/${client.id}" />">Modifier client</a></p>
	</section>
	<section id="footer">
		<a href="${pageContext.request.contextPath}/accueil">Accueil</a>
	</section>
</body>
</html>