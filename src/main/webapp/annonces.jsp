<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Liste des annonces</title>
    <link rel="stylesheet" type="text/css" href="style.css">
</head>
<body>
<%@ include file="header.jsp" %>
<div class="container">

    <c:choose>
        <c:when test="${not empty searchQuery}">
            <h1>Résultats de recherche pour "${searchQuery}"</h1>
        </c:when>
        <c:otherwise>
            <h1>Liste des annonces</h1>
        </c:otherwise>
    </c:choose>

    <c:if test="${empty annonces}">
        <p>Aucune annonce trouvée.</p>
    </c:if>

    <ul class="ad-list">
        <c:forEach var="annonce" items="${annonces}">
            <li>
                <h2>${annonce.titre}</h2>
                <p>${annonce.description}</p>
                <a href="detailAnnonce?id=${annonce.id}" class="btn">
                    <strong>Voir les détails</strong>
                </a>
            </li>
        </c:forEach>
    </ul>

    <a href="index.jsp" class="btn">Nouvelle recherche</a>
</div>
<%@ include file="footer.jsp" %>
</body>
</html>
