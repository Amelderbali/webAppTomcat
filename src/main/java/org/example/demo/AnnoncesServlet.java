package org.example.demo;



import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/annonces")
public class AnnoncesServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        AnnonceDAO annonceDAO = new AnnonceDAO();
        try {
            // Récupérer toutes les annonces
            List<Annonce> annonces = annonceDAO.getAllAnnonces();

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
