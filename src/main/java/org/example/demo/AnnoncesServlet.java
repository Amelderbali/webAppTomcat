package org.example.demo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/annonces")
public class AnnoncesServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String keywords = request.getParameter("keywords");

        AnnonceDAO annonceDAO = new AnnonceDAO();
        List<Annonce> annonces = null;

        try {
            if (keywords != null && !keywords.trim().isEmpty()) {
                // Recherche avec mots-clés
                annonces = annonceDAO.searchAnnonces(keywords);
                request.setAttribute("searchQuery", keywords);
            } else {
                // Récupérer toutes les annonces
                annonces = annonceDAO.getAllAnnonces();
            }

            // Ajouter les annonces comme attribut pour la JSP
            request.setAttribute("annonces", annonces);

            // Transférer à annonces.jsp
            request.getRequestDispatcher("annonces.jsp").forward(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Erreur lors du chargement des annonces.");
        }
    }
}
