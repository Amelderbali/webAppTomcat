package org.example.demo;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/recherche")
public class RechercheServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String keywords = request.getParameter("keywords");

        AnnonceDAO annonceDAO = new AnnonceDAO();
        List<Annonce> annonces = null;

        try {
            annonces = annonceDAO.searchAnnonces(keywords);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        request.setAttribute("annonces", annonces);
        RequestDispatcher dispatcher = request.getRequestDispatcher("resultatsRecherche.jsp");
        dispatcher.forward(request, response);
    }
}
