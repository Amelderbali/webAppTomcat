<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Accueil</title>
    <link rel="stylesheet" type="text/css" href="style.css">
</head>
<body>
<%@ include file="header.jsp" %>

<div class="container">
    <h1>Bienvenue sur Mon Application</h1>
    <p>Découvrez les dernières annonces et trouvez ce que vous cherchez.</p>

    <!-- Formulaire de recherche -->
    <form action="annonces" method="get" class="search-form">
        <input type="text" name="keywords" placeholder="Rechercher des annonces..." required>
        <button type="submit">Rechercher</button>
    </form>

    <a href="annonces" class="btn">Voir toutes les annonces</a>
</div>

<%@ include file="footer.jsp" %>
</body>
</html>
