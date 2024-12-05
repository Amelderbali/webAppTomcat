package org.example.demo.servlets;

import com.google.gson.Gson;
import org.example.demo.data.Annonce;
import org.example.demo.data.AnnonceDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/api/annonces")
public class AnnonceRestServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String keywords = request.getParameter("keywords"); // Get the keywords

        AnnonceDAO annonceDAO = new AnnonceDAO();

        try {
            List<Annonce> annonces;

            if (keywords != null && !keywords.isEmpty()) {
                annonces = annonceDAO.searchAnnonces(keywords);
            } else {
                annonces = annonceDAO.getAllAnnonces();
            }

            Gson gson = new Gson();
            String json = gson.toJson(annonces);

            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            response.getWriter().write(json);
        } catch (SQLException e) {
            e.printStackTrace();
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Erreur lors de la récupération des annonces.");
        }
    }
}
