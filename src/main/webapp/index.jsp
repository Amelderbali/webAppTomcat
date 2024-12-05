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
    <h1>Configurer une recherche personnalisée</h1>
    <p>Saisissez vos préférences pour trouver les annonces qui vous intéressent.</p>

    <!-- Formulaire pour configurer une recherche -->
    <form action="recherche" method="get" class="detail-content">
        <!-- Saisie des mots-clés -->
        <label for="motsCles">Mots-clés :</label>
        <input type="text" id="motsCles" name="motsCles" placeholder="Entrez des mots-clés (ex: voiture, maison...)" required>

        <!-- Sélection des sites -->
        <label for="sites">Sites à analyser :</label>
        <div class="checkbox-group">
            <label><input type="checkbox" name="sites" value="leboncoin"> Leboncoin</label>
            <label><input type="checkbox" name="sites" value="monboncoin"> MonBonCoin</label>
            <label><input type="checkbox" name="sites" value="site3"> Site3</label>
        </div>

        <!-- Saisie de la fréquence -->
        <label for="frequence">Fréquence de mise à jour (en minutes) :</label>
        <input type="number" id="frequence" name="frequence" placeholder="10" value="10" min="1" required>

        <!-- Bouton pour soumettre le formulaire -->
        <button type="submit" class="btn">Lancer la recherche</button>
    </form>
</div>

<%@ include file="footer.jsp" %>
</body>
</html>
