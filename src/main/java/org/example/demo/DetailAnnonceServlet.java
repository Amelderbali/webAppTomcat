package org.example.demo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/detailAnnonce")
public class DetailAnnonceServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String idParam = request.getParameter("id"); // Récupérer l'ID de l'annonce
        if (idParam == null || idParam.isEmpty()) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "ID de l'annonce manquant.");
            return;
        }

        int id = Integer.parseInt(idParam);
        AnnonceDAO annonceDAO = new AnnonceDAO();

        try {
            // Récupérer les détails de l'annonce
            Annonce annonce = annonceDAO.getAnnonceById(id);
            if (annonce == null) {
                response.sendError(HttpServletResponse.SC_NOT_FOUND, "Annonce introuvable.");
                return;
            }

            // Ajouter les détails de l'annonce comme attribut
            request.setAttribute("annonce", annonce);

            // Transférer à la JSP
            request.getRequestDispatcher("detailAnnonce.jsp").forward(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Erreur lors du chargement de l'annonce.");
        }
    }
}
