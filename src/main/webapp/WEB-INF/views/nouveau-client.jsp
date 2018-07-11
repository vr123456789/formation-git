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
		<h1>Nouveau client</h1>
		<c:url value="/client/nouveau" var="url" />
		<form:form action="${url}" modelAttribute="client" method="post" >
			<label>Titre&nbsp;:</label>
			<form:select path="titre" >
				<form:options itemLabel="libelle" />
			</form:select><br/>
			<form:errors cssClass="error" path="titre" /><br/>
		
			<label>Nom&nbsp;:</label>
			<form:input type="text" path="nom" /><br/>
			<form:errors cssClass="error" path="nom" /><br/>
		
			<label>Email&nbsp;:</label>
			<form:input type="text" path="email" /><br/>
			<form:errors cssClass="error" path="email" /><br/>
		
			<label>Date de naissance&nbsp;:</label>
			<form:input type="text" path="dateNaissance" /> <em>jj/mm/aaaa</em><br/>
			<form:errors cssClass="error" path="dateNaissance" /><br/>
		
			<button type="submit">Créer</button>
		</form:form>
	</section>
	<section id="footer">
		<a href="${pageContext.request.contextPath}/accueil">Accueil</a>
	</section>
</body>
</html>