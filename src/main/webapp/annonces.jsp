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

    <h1>Liste des annonces</h1>
    <ul>
        <c:forEach var="annonce" items="${annonces}">
            <li>
                <h2>${annonce.titre}</h2>
                <a href="detailAnnonce?id=${annonce.id}" class="btn">
                    <strong>View Details</strong>
                </a>
            </li>
        </c:forEach>
    </ul>
</div>
<%@ include file="footer.jsp" %>
</body>
</html>
