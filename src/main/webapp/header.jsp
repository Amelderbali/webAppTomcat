
<header>
    <div class="container">
        <div class="navbar">
            <div class="logo">
                Mon Application
            </div>
            <ul>
                <li><a href="index.jsp">Accueil</a></li>
                <li><a href="annonces">Annonces</a></li>
                <li><a href="contact.jsp">Contact</a></li>
                <li><a href="a-propos.jsp">À propos</a></li>
            </ul>
            <!-- Formulaire de recherche dans le header -->
            <form action="annonces" method="get" class="search-form">
                <input type="text" name="keywords" placeholder="Rechercher..." required>
                <button type="submit">🔍</button>
            </form>
        </div>
    </div>
</header>
