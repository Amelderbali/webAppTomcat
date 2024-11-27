<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Détail de l'annonce</title>
    <link rel="stylesheet" type="text/css" href="style.css">
</head>
<body>
<%@ include file="header.jsp" %>

<h1>${annonce.titre}</h1>
<div class="container">
<div class="image-container">
    <img src="${annonce.image}" alt="${annonce.titre}" class="detail-image">
</div>

<p>${annonce.description}</p>
<a href="annonces" class="btn">Retour à la liste des annonces</a>
</div>
<%@ include file="footer.jsp" %>

</body>
</html>
