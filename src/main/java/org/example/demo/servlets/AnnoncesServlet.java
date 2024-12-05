package org.example.demo.servlets;



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

@WebServlet("/annonces")
public class AnnoncesServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        AnnonceDAO annonceDAO = new AnnonceDAO();

        try {
            List<Annonce> annonces = annonceDAO.getAllAnnonces();

            request.setAttribute("annonces", annonces);

            request.getRequestDispatcher("annonces.jsp").forward(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Error loading ads.");
        }
    }
}
