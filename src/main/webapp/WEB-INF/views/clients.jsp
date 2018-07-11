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
		<h1>Liste des clients</h1>
		<c:if test="${not empty nouveauClient}">
			<p class="success">Le client <c:out value="${nouveauClient.email}" /> a été créé avec succès.</p>
		</c:if>
		<c:if test="${not empty message}">
			<p class="success"><c:out value="${message}" /></p>
		</c:if>
		<table>
		<tr>
			<th>Id</th>
			<th>Nom</th>
		</tr>
		<c:forEach items="${clients}" var="client">
			<c:url var="url" value="client/${client.id}" />
			<tr>
				<td><a href="${url}">${client.nom}</a></td>
				<td>${client.email}</td>
			</tr>
		</c:forEach>
		</table>
		<ul>
			<li><a href="<c:url value="/client/nouveau" />">Nouveau client</a></li>
			<li><a href="<c:url value="/clients/chargement" />">Liste de clients</a></li>
		</ul>
	</section>
	<section id="footer">
		<a href="${pageContext.request.contextPath}/accueil">Accueil</a>
	</section>
</body>
</html>