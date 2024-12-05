<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>${annonce.titre}</title>
    <link rel="stylesheet" type="text/css" href="style.css">
</head>
<body>
<jsp:include page="header.jsp" />

<div class="container">
    <h1>${annonce.titre}</h1>
    <div class="image-container">
        <img src="${annonce.image}" alt="${annonce.titre}" class="detail-image">
    </div>
    <p>${annonce.description}</p>
    <a href="annonces" class="btn">Retour au annonces</a>
</div>

<jsp:include page="footer.jsp" />
</body>
</html>
