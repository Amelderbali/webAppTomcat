<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Liste des annonces</title>
</head>
<body>
<h1>Liste des annonces</h1>
<ul>
    <c:forEach var="annonce" items="${annonces}">
        <li>
            <a href="detailAnnonce?id=${annonce.id}">
                <strong>${annonce.titre}</strong>
            </a>
        </li>
    </c:forEach>
</ul>
</body>
</html>
